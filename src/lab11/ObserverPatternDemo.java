package lab11;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

    // Observer interface
    interface Observer {
        void update(String message);
    }

    // Concrete observer representing a student
    static class Student implements Observer {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(
                    name + " received announcement: " + message
            );
        }
    }

    // Subject class responsible for notifications
    static class UniversityAnnouncement {

        private List<Observer> observers = new ArrayList<>();

        // Subscribe an observer
        public void subscribe(Observer observer) {
            observers.add(observer);
        }

        // Unsubscribe an observer
        public void unsubscribe(Observer observer) {
            observers.remove(observer);
        }

        // Notify all subscribed observers
        public void notifyObservers(String message) {

            for (Observer observer : observers) {
                observer.update(message);
            }
        }

        // Publish an announcement
        public void publishAnnouncement(String message) {

            System.out.println("New University Announcement:");
            System.out.println(message);
            System.out.println();

            notifyObservers(message);
        }
    }

    public static void main(String[] args) {

        UniversityAnnouncement university =
                new UniversityAnnouncement();

        // Create students
        Student student1 = new Student("Precious");
        Student student2 = new Student("Tendai");
        Student student3 = new Student("Rudo");

        // Subscribe students
        university.subscribe(student1);
        university.subscribe(student2);
        university.subscribe(student3);

        // Publish first announcement
        university.publishAnnouncement(
                "OOP practical assignment is due on Friday."
        );

        // Unsubscribe one student
        university.unsubscribe(student2);

        System.out.println("\nAfter Tendai unsubscribes:\n");

        // Publish second announcement
        university.publishAnnouncement(
                "Lab sessions will begin at 8 AM."
        );
    }
}

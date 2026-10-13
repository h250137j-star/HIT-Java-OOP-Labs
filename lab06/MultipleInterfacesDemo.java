package lab06;

public class MultipleInterfacesDemo {

    // First interface
    interface Camera {
        void takePhoto();
    }

    // Second interface
    interface MusicPlayer {
        void playMusic();
    }

    // Smartphone implements both interfaces
    static class Smartphone implements Camera, MusicPlayer {

        @Override
        public void takePhoto() {
            System.out.println("Smartphone is taking a photo.");
        }

        @Override
        public void playMusic() {
            System.out.println("Smartphone is playing music.");
        }

        public void makeCall() {
            System.out.println("Smartphone is making a call.");
        }
    }

    public static void main(String[] args) {

        Smartphone phone = new Smartphone();

        // Methods from the two interfaces
        phone.takePhoto();
        phone.playMusic();

        // Method belonging to Smartphone
        phone.makeCall();

        // Interface references
        Camera camera = phone;
        MusicPlayer player = phone;

        System.out.println("\nUsing interface references:");
        camera.takePhoto();
        player.playMusic();
    }
}


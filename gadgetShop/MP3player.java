public class MP3player extends Gadget {
    //attribute
    private int availableMemory;

    //constructor method
    public MP3player(String model, double price, int weight, String size, int availableMemory) {
        //calling parent class constructor to initialize inherited attributes
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    //method to download music
    public void downloadMusic(int musicSize) {
        if (availableMemory >= musicSize) {
            availableMemory -= musicSize;
            System.out.println("Music downloaded. Available memory: "+ availableMemory +" MB");
        } else {
            throw new IllegalStateException("Insufficient memory to download music.");
        }
    }
    
    //method to delete music
    public void deleteMusic(int musicSize) {
        availableMemory += musicSize;
        System.out.println("Music deleted. Available memory: " + availableMemory + " MB");
    }
}

import javax.swing.JOptionPane;

public class MP3player extends Gadget {
    private int availableMemory;

    public MP3player(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public void downloadMusic(int musicSize) {
        if (availableMemory >= musicSize) {
            availableMemory -= musicSize;
            JOptionPane.showMessageDialog(null, "Music downloaded. Available memory: "+ availableMemory +" MB", "Download Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient memory to download music.", "Memory Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteMusic(int musicSize) {
        availableMemory += musicSize;
        JOptionPane.showMessageDialog(null, "Music deleted. Available memory: " + availableMemory + " MB", "Deletion Information", JOptionPane.INFORMATION_MESSAGE);
    }
}

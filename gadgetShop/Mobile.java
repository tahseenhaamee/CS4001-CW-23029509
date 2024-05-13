import javax.swing.JOptionPane;

public class Mobile extends Gadget {
    private int callCredit;

    public Mobile(String model, double price, int weight, String size, int callCredit) {
        super(model, price, weight, size);
        this.callCredit = callCredit;
    }

    public void addCredit(int credit) {
        if (credit > 0) {
            callCredit += credit;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a positive amount for calling credit.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void makeCall(String phoneNumber, int duration) {
        if (callCredit >= duration) {
            JOptionPane.showMessageDialog(null, "Making call to " + phoneNumber + " for " + duration + " minutes.", "Call Information", JOptionPane.INFORMATION_MESSAGE);
            callCredit -= duration;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient calling credit to make the call.", "Credit Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

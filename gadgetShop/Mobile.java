public class Mobile extends Gadget {
    //attribute
    private int callCredit;

    //constructor method
    public Mobile(String model, double price, int weight, String size, int callCredit) {
        //calling parent class constructor to initialize inherited attributes
        super(model, price, weight, size);
        this.callCredit = callCredit;
    }

    //method to add credit
    public void addCredit(int credit) throws IllegalArgumentException {
        if (credit > 0) {
            callCredit += credit;
        } else {
            throw new IllegalArgumentException("Please enter a positive amount for calling credit.");
        }
    }

    //method to make a call
    public void makeCall(String phoneNumber, int duration) throws IllegalStateException {
        if (callCredit >= duration) {
            System.out.println("Making call to " + phoneNumber + " for " + duration + " minutes.");
            callCredit -= duration;
        } else {
            throw new IllegalStateException("Insufficient calling credit to make the call.");
        }
    }
}

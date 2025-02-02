public class Motorcycle extends Vehicle {

    private static final int NUM_OF_WHEELS = 2;

    public Motorcycle(String model) {
        super(model);
    }

    @Override
    public double getFixTime() {
        return 3.0;
    }

    @Override
    public void fixed() {
        System.out.println("MotorCycle (" + getModel() + ") is fixed - " + NUM_OF_WHEELS + " wheels");
    }

    public static Motorcycle build(String model) {
        return new Motorcycle(model);
    }
}

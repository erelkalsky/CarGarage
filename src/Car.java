public class Car extends Vehicle {
    private static final int NUM_OF_WHEELS = 4;
    public Car(String model) {
        super(model);
    }

    @Override
    public double getFixTime() {
        return 5.0;
    }

    @Override
    public void fixed() {
        System.out.println("Car (" + getModel() + ") is fixed - " + NUM_OF_WHEELS + " wheels");
    }

    public static Car build(String model) {
        return new Car(model);
    }
}

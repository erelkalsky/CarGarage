public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    public double getFixTime() {
        return 5.0;
    }

    @Override
    public void fixed() {
        System.out.println("The steering wheel has been repaired");
    }
}

public class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }

    @Override
    public double getFixTime() {
        return 10.0;
    }

    @Override
    public void fixed() {
        System.out.println("The engine has been repaired");
    }
}

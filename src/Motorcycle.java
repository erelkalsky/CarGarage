public class Motorcycle extends Vehicle {
    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public double getFixTime() {
        return 3.0;
    }

    @Override
    public void fixed() {
        System.out.println("Both wheels has been repaired.");
    }
}

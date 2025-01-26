public abstract class Vehicle implements Fixable {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public abstract double getFixTime();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

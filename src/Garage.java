import java.util.ArrayList;

public class Garage implements ProtocolGarage {
    ArrayList<Vehicle> vehicles;

    public Garage(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void fixed() {
        for (Vehicle vehicle : vehicles) {
            try {
                System.out.println("Repairing: " + vehicle.getName());
                Thread.sleep((long) (vehicle.getFixTime() * 1000));
                vehicle.fixed();
            } catch (InterruptedException e) {
                System.out.println("Error during fixing " + vehicle.getName());
            }

            try {
                Thread.sleep((long) (0.5 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All vehicles have been repaired.");
    }
}

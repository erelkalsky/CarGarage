import java.util.ArrayList;

public abstract class DB {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static boolean addVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle))
            return false;

        vehicles.add(vehicle);
        return true;
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }



}

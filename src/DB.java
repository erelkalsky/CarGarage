import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class DB {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    private static final HashMap<Integer, Queue<Vehicle>> vehiclesMap = new HashMap<>() {{
        put(1, new LinkedList<>());
        put(2, new LinkedList<>());
        put(3, new LinkedList<>());
    }};

    public static boolean addVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle))
            return false;

        vehicles.add(vehicle);
        return true;
    }

    public static void addVehicle(int type, String model) {
        switch (type) {
            case 1:
                vehiclesMap.get(type).add(Motorcycle.build(model));
                break;
            case 2:
                vehiclesMap.get(type).add(Car.build(model));
                break;
            case 3:
                vehiclesMap.get(type).add(Truck.build(model));
                break;
        }
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static HashMap<Integer, Queue<Vehicle>> getVehiclesMap() {
        return vehiclesMap;
    }
}

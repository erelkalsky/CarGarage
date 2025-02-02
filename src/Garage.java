import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {
    private ProtocolGarage protocolGarage;
    private ArrayList<Vehicle> vehicles;
    private boolean isGarageOpen = true;
    private int currentVehicle = 0;
    private int hour = 0;

    public Garage(ProtocolGarage protocolGarage) {
        this.protocolGarage = protocolGarage;
    }

    public void startWork(HashMap<Integer, Queue<Vehicle>> vehiclesMap) {
        // convert the map to array
        convertVehicles(vehiclesMap);

        Runnable helloRunnable = new Runnable() {
            @Override
            public void run() {
                tick();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    }

    private void tick() {
        if (!isGarageOpen) {
            return;
        }

        hour++;
        System.out.println("dubug. hour = " + hour);
        Vehicle v = vehicles.get(currentVehicle);

        if (v.getFixTime() == hour) {
            // vehicle fixed

            v.fixed();
            protocolGarage.fixed();
            hour = 0;
            currentVehicle++;
        }

        if (currentVehicle == vehicles.size()) {
            isGarageOpen = false;
            System.out.println("All fixed = day off!!");
        }
    }

    private void convertVehicles(HashMap<Integer, Queue<Vehicle>> vehiclesMap) {
        ArrayList<Vehicle> mergedList = new ArrayList<>();

        for (Queue<Vehicle> queue : vehiclesMap.values()) {
            mergedList.addAll(queue);
        }

        vehicles = mergedList;
    }
}
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {

    private ProtocolGarage protocol;
    private ArrayList<Vehicle> vehicles;
    private int currentIndex = 0;
    private double remainingFixTime = 0;
    private ScheduledExecutorService executor;

    public Garage(ProtocolGarage protocolGarage, ArrayList<Vehicle> vehicles) {
        this.protocol = protocolGarage;
        this.vehicles = vehicles;
    }

    public void start() {
        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> tick(), 0, 1, TimeUnit.SECONDS);
    }

    private void tick() {
        if (currentIndex < vehicles.size()) {
            Vehicle currentVehicle = vehicles.get(currentIndex);

            if (remainingFixTime == 0) {
                remainingFixTime = currentVehicle.getFixTime();
                System.out.println("Fixing: " + currentVehicle.getName());
            }

            remainingFixTime--;

            if (remainingFixTime == 0) {
                if (currentVehicle instanceof Fixable) {
                    ((Fixable) currentVehicle).fixed();
                }
                currentIndex++;
            }
        } else {
            protocol.fixed();
            stop();
        }
    }

    private void stop() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
            System.out.println("The garage stopped working.");
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initVehicles();
    }

    public static void initVehicles() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 for Motorcycle, 2 for Car, 3 for Truck, 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            System.out.println("Enter vehicle model:");
            String model = scanner.nextLine();

            build(choice, model);
        }

        Garage garage = new Garage(protocolGarage);
        garage.startWork(DB.getVehiclesMap());
    }

    private static ProtocolGarage protocolGarage = new ProtocolGarage() {
        @Override
        public void fixed() {
            System.out.println("Another vehicle fixed.");
        }
    };

    public static void build(int type, String model) {
        DB.addVehicle(type, model);
    }
}
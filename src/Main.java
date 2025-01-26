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

            System.out.println("Enter vehicle name:");
            String name = scanner.nextLine();

            Vehicle vehicle;
            switch (choice) {
                case 1:
                    vehicle = new Motorcycle(name);
                    break;
                case 2:
                    vehicle = new Car(name);
                    break;
                case 3:
                    vehicle = new Truck(name);
                    break;
                default:
                    System.out.println("Invalid option, try again.");
                    continue;
            }

            DB.addVehicle(vehicle);
        }

        Garage garage = new Garage(DB.getVehicles());
        garage.fixed();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class TravelLog {

    private static final ArrayList<Travel> trips = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("================================");
        System.out.println("        Welcome to TravelLog");
        System.out.println("================================");

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTrip();
                    break;
                case "2":
                    viewTrips();
                    break;
                case "3":
                    searchDestination();
                    break;
                case "4":
                    deleteTrip();
                    break;
                case "5":
                    running = false;
                    System.out.println("Thank you for using TravelLog!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Add Trip");
        System.out.println("2. View Trips");
        System.out.println("3. Search Destination");
        System.out.println("4. Delete Trip");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTrip() {
        System.out.println("\n--- Add Trip ---");

        System.out.print("Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Travel date: ");
        String date = scanner.nextLine();

        System.out.print("Notes: ");
        String notes = scanner.nextLine();

        Travel trip = new Travel(nextId++, destination, date, notes);
        trips.add(trip);

        System.out.println("Trip added successfully!");
    }

    private static void viewTrips() {
        System.out.println("\n--- My Trips ---");

        if (trips.isEmpty()) {
            System.out.println("No trips found.");
            return;
        }

        for (Travel trip : trips) {
            System.out.println(trip);
        }
    }

    private static void searchDestination() {
        System.out.println("\n--- Search Destination ---");
        System.out.print("Enter destination: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Travel trip : trips) {
            if (trip.getDestination().toLowerCase().contains(keyword)) {
                System.out.println(trip);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching trips found.");
        }
    }

    private static void deleteTrip() {
        System.out.println("\n--- Delete Trip ---");

        if (trips.isEmpty()) {
            System.out.println("No trips to delete.");
            return;
        }

        viewTrips();
        System.out.print("Enter trip ID to delete: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            boolean removed = trips.removeIf(trip -> trip.getId() == id);

            if (removed) {
                System.out.println("Trip deleted successfully!");
            } else {
                System.out.println("Trip ID not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}

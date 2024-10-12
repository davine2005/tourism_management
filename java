import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    String name;
    String gender;
    int age;

    public Passenger(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

class Tour {
    String type;
    String place;
    String date;
    int amount;
    ArrayList<Passenger> passengers = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void displayReceipt() {
        System.out.println("\n\t\t\t\t**Take Screenshot for Further Use**\n");
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println("\t\t\t\tPassenger " + (i + 1) + " Name: " + passengers.get(i).name);
            System.out.println("\t\t\t\tPassenger " + (i + 1) + " Gender: " + passengers.get(i).gender);
            System.out.println("\t\t\t\tPassenger " + (i + 1) + " Age: " + passengers.get(i).age + "\n");
        }
        System.out.println("\t\t\t\tSelected Type: " + type);
        System.out.println("\t\t\t\tPackage: " + place);
        System.out.println("\t\t\t\tDate: " + date);
        System.out.println("\t\t\t\tTotal Amount: " + (amount * passengers.size()));
        System.out.println("\n\t\t\t\t**Thank You For Registration**");
    }
}

public class TourManagementSystem {

    static Tour tour = new Tour();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        heading();
        System.out.println("\t\t\t\t1. International Tour Packages\n");
        System.out.println("\t\t\t\t2. India Tour Packages\n");
        System.out.print("\t\t\t\tEnter Choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                inter();
                break;
            case 2:
                india();
                break;
            default:
                System.out.println("Enter Right Choice...");
                return;
        }

        details();
        tour.displayReceipt();
    }

    // Method to handle India tour packages
    public static void india() {
        clearScreen();
        heading();
        tour.type = "India Tour Package";
        System.out.println("\t\t\t\t1. Shimla Tour Packages 6 Days 7 Nights (18880/-)");
        System.out.println("\t\t\t\t2. Kashmir Tour Packages 5 Days 4 Nights (35500/-)");
        System.out.println("\t\t\t\t3. Kolkata Tour Packages 11 Days 10 Nights (10000/-)");
        System.out.print("\t\t\t\tEnter Choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                tour.place = "Shimla Tour";
                tour.amount = 18880;
                break;
            case 2:
                tour.place = "Kashmir Tour";
                tour.amount = 35500;
                break;
            case 3:
                tour.place = "Kolkata Tour";
                tour.amount = 10000;
                break;
            default:
                System.out.println("Enter Correct Choice...");
        }
    }

    // Method to handle International tour packages
    public static void inter() {
        clearScreen();
        heading();
        tour.type = "International Tour Package";
        System.out.println("\t\t\t\t1. England Tour Packages 6 Days 7 Nights (28880/-)");
        System.out.println("\t\t\t\t2. Thailand Tour Packages 5 Days 4 Nights (15500/-)");
        System.out.println("\t\t\t\t3. New York Tour Packages 11 Days 10 Nights (567800/-)");
        System.out.print("\t\t\t\tEnter Choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                tour.place = "England Tour";
                tour.amount = 28880;
                break;
            case 2:
                tour.place = "Thailand Tour";
                tour.amount = 15500;
                break;
            case 3:
                tour.place = "New York Tour";
                tour.amount = 567800;
                break;
            default:
                System.out.println("Enter Correct Choice...");
        }
    }

    // Method to take passenger details
    public static void details() {
        clearScreen();
        heading();
        System.out.print("\t\t\t\tEnter Number Of Passengers: ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("\t\t\t\tEnter Date (DD/MM/YY): ");
        tour.date = scanner.nextLine();

        for (int i = 0; i < numPassengers; i++) {
            clearScreen();
            heading();
            System.out.print("\t\t\t\tEnter The " + (i + 1) + "th Passenger Name: ");
            String name = scanner.nextLine();
            System.out.print("\t\t\t\tEnter The " + (i + 1) + "th Passenger Gender: ");
            String gender = scanner.nextLine();
            System.out.print("\t\t\t\tEnter The " + (i + 1) + "th Passenger Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Passenger passenger = new Passenger(name, gender, age);
            tour.addPassenger(passenger);
        }
    }

    // Helper method for heading
    public static void heading() {
        System.out.println("\t\t\t\t***Tourism Package Management System***");
        System.out.println("\t\t\t***Vaccination Certificate Is Necessary For Travel Purpose***\n\n");
    }

    // Helper method to clear the screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

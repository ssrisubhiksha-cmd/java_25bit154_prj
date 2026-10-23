
import java.util.ArrayList;
import java.util.Scanner;

class Complaint {
    int id;
    String name, description, status;

    Complaint(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = "Pending";
    }

    void display() {
        System.out.println("\nComplaint ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }
}

public class ComplaintManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Complaint> complaints = new ArrayList<>();
        int choice, id = 1;

        do {
            System.out.println("\n--- Complaint Management System ---");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Track Complaint");
            System.out.println("4. Update Complaint Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter complaint description: ");
                    String desc = sc.nextLine();

                    complaints.add(new Complaint(id, name, desc));
                    System.out.println("Complaint registered successfully!");
                    System.out.println("Your Complaint ID is: " + id);
                    id++;
                    break;

                case 2:
                    if (complaints.isEmpty()) {
                        System.out.println("No complaints found.");
                    } else {
                        for (Complaint c : complaints) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Complaint ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Complaint c : complaints) {
                        if (c.id == searchId) {
                            c.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Complaint not found.");
                    break;

                case 4:
                    System.out.print("Enter Complaint ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    found = false;

                    for (Complaint c : complaints) {
                        if (c.id == updateId) {
                            System.out.print(
                                "Enter status (Pending/In Progress/Resolved): ");
                            c.status = sc.nextLine();
                            System.out.println("Status updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Complaint not found.");
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

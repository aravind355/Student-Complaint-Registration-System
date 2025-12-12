import java.util.Scanner;
import java.util.UUID;
import java.io.Serializable;

public class Student extends User implements Serializable {
    public Student(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public void displayMenu(Scanner scanner, ComplaintManager manager) {
        int choice = -1;
        while (choice != 3) {
            try {
                System.out.println("\n--- Student Menu ---");
                System.out.println("1. Submit Complaint");
                System.out.println("2. View My Complaints");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();
                        manager.addComplaint(new Complaint(UUID.randomUUID().toString(), title, desc, this));
                        break;
                    case 2:
                        manager.viewComplaintsByUser(this);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

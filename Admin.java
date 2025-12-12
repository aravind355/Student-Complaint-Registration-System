import java.util.Scanner;
import java.io.Serializable;

public class Admin extends User implements Serializable{
    public Admin(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public void displayMenu(Scanner scanner, ComplaintManager manager) {
        int choice = -1;
        while (choice != 3) {
            try {
                System.out.println("\n--- Admin Menu ---");
                System.out.println("1. Review Complaints");
                System.out.println("2. Assign Complaint to Faculty");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        manager.viewAllComplaints();
                        break;
                    case 2:
                        System.out.print("Enter Complaint ID: ");
                        String cid = scanner.nextLine();
                        System.out.print("Enter Faculty ID: ");
                        String fid = scanner.nextLine();
                        manager.assignComplaint(cid, fid);
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

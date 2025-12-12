import java.util.Scanner;
import java.io.Serializable;

public class Faculty extends User implements Serializable {
    public Faculty(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public void displayMenu(Scanner scanner, ComplaintManager manager) {
        int choice = -1;
        while (choice != 3) {
            try {
                System.out.println("\n--- Faculty Menu ---");
                System.out.println("1. View Assigned Complaints");
                System.out.println("2. Resolve Complaint");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        manager.viewComplaintsByAssignee(this);
                        break;
                    case 2:
                        System.out.print("Enter Complaint ID to resolve: ");
                        String cid = scanner.nextLine();
                        System.out.print("Enter Resolution: ");
                        String resolution = scanner.nextLine();
                        manager.resolveComplaint(cid, resolution);
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

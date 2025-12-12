import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Student> studentMap = new HashMap<>();
        Map<String, Faculty> facultyMap = new HashMap<>();
        List<User> users = new ArrayList<>();

        Student s1 = new Student("23mcce11", "23MCCE11", "23MCCE11@uoh.in", "1234");
        Student s2 = new Student("23mcce111", "23MCCE111", "23MCCE111@uoh.in", "1234");
        Admin admin = new Admin("admin", "Admin", "admin@uoh.in", "1234");
        Faculty f1 = new Faculty("fac01", "fac01", "fac01@uoh.in", "1234");
        Faculty f2 = new Faculty("fac02", "fac02", "fac02@uoh.in", "1234");
        studentMap.put(s1.getUserId(), s1);
        studentMap.put(s2.getUserId(), s2);
        facultyMap.put(f1.getUserId(), f1);
        facultyMap.put(f2.getUserId(), f2);
        
        System.out.println("\n--- Given are USer ID's and passwords to test ---");
        System.out.println("For student ->User ID : 23mcce11 , Pwd : 1234");
        System.out.println("For Another student ->User ID : 23mcce111 , Pwd : 1234");
        System.out.println("For Faculty ->User ID : fac01 , Pwd : 1234");
        System.out.println("For Another Faculty ->User ID : fac02 , Pwd : 1234");
        System.out.println("For Admin ->User ID : admin , Pwd : 1234");
        
        users.add(s1);
        users.add(s2);
        users.add(admin);
        users.add(f1);
        users.add(f2);

        ComplaintManager manager = new ComplaintManager(facultyMap, studentMap);

        while (true) {
            System.out.println("\n===== SCIS Complaint System Login =====");
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            boolean loggedIn = false;
            for (User u : users) {
                if (u.getUserId().equals(userId) && u.getPassword().equals(password)) {
                    u.displayMenu(scanner, manager);
                    loggedIn = true;
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }
}
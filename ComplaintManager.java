import java.io.*;
import java.util.*;

public class ComplaintManager {
    private List<Complaint> complaints = new ArrayList<>();
    private Map<String, Faculty> facultyMap;
    private Map<String, Student> studentMap;
    private static final String FILE_NAME = "complaints.ser";


    public ComplaintManager(Map<String, Faculty> facultyMap, Map<String, Student> studentMap) {
        this.facultyMap = facultyMap;
        this.studentMap = studentMap;
        loadComplaintsFromFile();
    }


    public void addComplaint(Complaint c) {
        complaints.add(c);
        saveComplaintsToFile();
        System.out.println("Complaint submitted successfully.");
    }

    public void viewAllComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
        } else {
            complaints.forEach(System.out::println);
        }
    }

    public void viewComplaintsByUser(Student s) {
        boolean found = false;
        for (Complaint c : complaints) {
            if (c.submittedBy.equals(s)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No complaints found for user.");
    }

    public void viewComplaintsByAssignee(Faculty f) {
        boolean found = false;
        for (Complaint c : complaints) {
            if (f.equals(c.assignedTo)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No complaints assigned to you.");
    }

    public void assignComplaint(String cid, String fid) {
        for (Complaint c : complaints) {
            if (c.id.equals(cid)) {
                Faculty f = facultyMap.get(fid);
                if (f != null) {
                    c.assignTo(f);
                    saveComplaintsToFile();
                    System.out.println("Complaint assigned to " + f.getName());
                } else {
                    System.out.println("Faculty ID not found.");
                }
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }

    public void resolveComplaint(String cid, String resolution) {
        for (Complaint c : complaints) {
            if (c.id.equals(cid)) {
                c.resolve(resolution);
                saveComplaintsToFile();
                System.out.println("Complaint resolved.");
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }

    private void saveComplaintsToFile() {
        try {
            File dir = new File("data");
            if (!dir.exists()) dir.mkdir();
    
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/complaints.ser"));
            out.writeObject(complaints);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving complaints: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadComplaintsFromFile() {
        File file = new File("data/complaints.ser");
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                complaints = (List<Complaint>) in.readObject();
    
                for (Complaint c : complaints) {
                    if (c.assignedTo != null) {
                        Faculty matchedFac = facultyMap.get(c.assignedTo.getUserId());
                        if (matchedFac != null) c.assignedTo = matchedFac;
                    }
                    if (c.submittedBy != null) {
                        Student matchedStu = studentMap.get(c.submittedBy.getUserId());
                        if (matchedStu != null) c.submittedBy = matchedStu;
                    }
                }
    
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading complaints: " + e.getMessage());
            }
        }
    }
}
import java.io.Serializable;

public class Complaint implements Serializable {
    String id, title, description, resolution;
    Status status;
    Student submittedBy;
    Faculty assignedTo;

    public Complaint(String id, String title, String description, Student submittedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.submittedBy = submittedBy;
        this.status = Status.NEW;
        this.resolution = "";
    }

    public void assignTo(Faculty f) {
        this.assignedTo = f;
        this.status = Status.ASSIGNED;
    }

    public void resolve(String resolution) {
        this.resolution = resolution;
        this.status = Status.RESOLVED;
    }

    public String toString() {
        return String.format("ID: %s | Title: %s | Status: %s | Student: %s | Faculty: %s | Resolution: %s",
                id, title, status,
                submittedBy.getName(),
                (assignedTo != null ? assignedTo.getName() : "Unassigned"),
                resolution);
    }
}
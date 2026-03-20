import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class Tracker {
    ArrayList<Application> list = new ArrayList<>();
    int idCounter = 1;

    String[] validStatus = {"Applied", "Interview", "Rejected", "Offer"};

    boolean isValidStatus(String status) {
        for (String s : validStatus) {
            if (s.equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

    void addApplication(String company, String role, String status) {
        if (company.isEmpty() || role.isEmpty()) {
            System.out.println("Company and Role cannot be empty!");
            return;
        }

        if (!isValidStatus(status)) {
            System.out.println("Invalid status!");
            return;
        }

        list.add(new Application(idCounter++, company, role, capitalize(status)));
        System.out.println("Application Added Successfully!");
    }

    void viewAll() {
        if (list.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Application a : list) {
            System.out.println(a.id + " | " + a.company + " | " + a.role + " | " + a.status);
        }
    }

    void search(String company) {
        boolean found = false;

        for (Application a : list) {
            if (a.company.equalsIgnoreCase(company)) {
                System.out.println(a.id + " | " + a.company + " | " + a.role + " | " + a.status);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching application found.");
        }
    }

    void updateStatus(int id, String newStatus) {
        if (!isValidStatus(newStatus)) {
            System.out.println("Invalid status!");
            return;
        }

        for (Application a : list) {
            if (a.id == id) {
                a.status = capitalize(newStatus);
                System.out.println("Status Updated Successfully!");
                return;
            }
        }

        System.out.println("ID not found.");
    }

    void delete(int id) {
        boolean removed = list.removeIf(a -> a.id == id);

        if (removed) {
            System.out.println("Application Deleted Successfully!");
        } else {
            System.out.println("ID not found.");
        }
    }

    String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    // 🔥 NEW METHOD: Generate HTML
    void generateHTML() {
        try {
            FileWriter fw = new FileWriter("output.html");

            fw.write("<html><head><title>Applications</title></head><body>");
            fw.write("<h2>Job Applications</h2>");
            fw.write("<table border='1' cellpadding='10'>");
            fw.write("<tr><th>ID</th><th>Company</th><th>Role</th><th>Status</th></tr>");

            for (Application a : list) {
                fw.write("<tr>");
                fw.write("<td>" + a.id + "</td>");
                fw.write("<td>" + a.company + "</td>");
                fw.write("<td>" + a.role + "</td>");
                fw.write("<td>" + a.status + "</td>");
                fw.write("</tr>");
            }

            fw.write("</table></body></html>");
            fw.close();

            System.out.println("HTML file generated: output.html");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}
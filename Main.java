import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tracker tracker = new Tracker();

        while (true) {
            System.out.println("\n==== JOB APPLICATION TRACKER ====");
            System.out.println("1. Add Application");
            System.out.println("2. View Applications");
            System.out.println("3. Search Application");
            System.out.println("4. Update Status");
            System.out.println("5. Delete Application");
            System.out.println("6. View in Browser");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Company: ");
                    String company = sc.nextLine();

                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    tracker.addApplication(company, role, status);
                    break;

                case 2:
                    tracker.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Company to search: ");
                    String searchCompany = sc.nextLine();
                    tracker.search(searchCompany);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Status: ");
                    String newStatus = sc.nextLine();

                    tracker.updateStatus(id, newStatus);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int deleteId = sc.nextInt();
                    tracker.delete(deleteId);
                    break;

                case 6:
                    tracker.generateHTML();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
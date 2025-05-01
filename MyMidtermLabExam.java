import java.util.Scanner;

public class MyMidtermLabExam {
    static final int MAX_TICKETS = 5;
    static String[] issues = new String[MAX_TICKETS];
    static String[] urgencies = new String[MAX_TICKETS];
    static String[] statuses = new String[MAX_TICKETS];
    static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== IT Ticket Processing System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                System.out.print("Enter your choice: ");
                scanner.next(); // consume invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    addTicket(scanner);
                    break;
                case 2:
                    updateTicketStatus(scanner);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you for using the IT Ticket Processing System!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid menu option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method 1: Add Ticket
    public static void addTicket(Scanner scanner) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Ticket limit reached. Cannot add more tickets.");
            return;
        }

        System.out.print("Enter issue description: ");
        String issue = scanner.nextLine();

        System.out.print("Enter urgency level (Low, Medium, High): ");
        String urgency = scanner.nextLine();

        // Save to arrays
        issues[ticketCount] = issue;
        urgencies[ticketCount] = urgency;
        statuses[ticketCount] = "Pending";

        ticketCount++;

        System.out.println("Ticket added successfully!");
    }

    // Method 2: Update Ticket Status
    public static void updateTicketStatus(Scanner scanner) {
        if (ticketCount == 0) {
            System.out.println("No tickets to update.");
            return;
        }

        showTickets();
        System.out.print("Enter ticket number to update (1 to " + ticketCount + "): ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear invalid input
            return;
        }

        int ticketNum = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        if (ticketNum < 1 || ticketNum > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        if (statuses[ticketNum - 1].equals("Resolved")) {
            System.out.println("Cannot update a resolved ticket.");
            return;
        }

        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = scanner.nextLine();

        if (newStatus.equalsIgnoreCase("In Progress") || newStatus.equalsIgnoreCase("Resolved")) {
            statuses[ticketNum - 1] = newStatus;
            System.out.println("Ticket status updated successfully!");
        } else {
            System.out.println("Invalid status entered. Only 'In Progress' or 'Resolved' are allowed.");
        }
    }

    // Method 3: Show Tickets
    public static void showTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("\n--- All Tickets ---");
        for (int i = 0; i < ticketCount; i++) {
            System.out.println((i + 1) + ". Issue: " + issues[i] + " | Urgency: " + urgencies[i] + " | Status: " + statuses[i]);
        }
    }

    // Method 4: Generate Report
    public static void generateReport() {
        int pendingOrInProgress = 0;
        int resolved = 0;

        for (int i = 0; i < ticketCount; i++) {
            if (statuses[i].equalsIgnoreCase("Pending") || statuses[i].equalsIgnoreCase("In Progress")) {
                pendingOrInProgress++;
            } else if (statuses[i].equalsIgnoreCase("Resolved")) {
                resolved++;
            }
        }

        System.out.println("\n--- Ticket Report ---");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending/In Progress Tickets: " + pendingOrInProgress);
        System.out.println("Resolved Tickets: " + resolved);
    }
}

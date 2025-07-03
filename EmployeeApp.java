import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Employee Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> dao.addEmployee();
                case 2 -> dao.viewEmployees();
                case 3 -> dao.updateEmployee();
                case 4 -> dao.deleteEmployee();
                case 5 -> {
                    running = false;
                    System.out.println("App Closed.");
                }
                default -> System.out.println("Invalid input.");
            }
        }
        sc.close();
    }
}

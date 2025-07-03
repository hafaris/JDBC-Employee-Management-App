import java.sql.*;
import java.util.Scanner;

public class EmployeeDAO {
    private final Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Role: ");
        String role = sc.nextLine();
        System.out.print("Salary: ");
        double salary = sc.nextDouble(); sc.nextLine();

        String sql = "INSERT INTO employees (name, role, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Role: %s | Salary: %.2f%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("role"), rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();
        System.out.print("New Role: ");
        String role = sc.nextLine();
        System.out.print("New Salary: ");
        double salary = sc.nextDouble(); sc.nextLine();

        String sql = "UPDATE employees SET name=?, role=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) System.out.println("Employee updated.");
            else System.out.println("Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt(); sc.nextLine();

        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) System.out.println("Employee deleted.");
            else System.out.println("Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

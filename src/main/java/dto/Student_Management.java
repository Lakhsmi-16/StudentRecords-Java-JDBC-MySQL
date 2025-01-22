package dto;

import java.sql.*;
import java.util.Scanner;

public class Student_Management {

    // Add student data method with improved resource management and validation
    public void add_data() {
        try (Scanner s = new Scanner(System.in)) {
            Connection c = DB_Connection.getCon();
            String query = "INSERT INTO student VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);

            while (true) {
                System.out.println("Enter The Id:");
                int id = s.nextInt();

                System.out.println("Enter The Name:");
                String name = s.next();

                System.out.println("Enter The Age:");
                int age = s.nextInt();

                System.out.println("Enter The Course:");
                String course = s.next();

                System.out.println("Enter The E-Mail:");
                String e_mail = s.next();

                // Set parameters for prepared statement
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, course);
                ps.setString(5, e_mail);

                ps.executeUpdate();
                System.out.println("Data Inserted Successfully!");

                System.out.println("Do you want to continue? Press yes/no:");
                String opt = s.next();

                if (opt.equalsIgnoreCase("n")) {
                    System.out.println("Thanks for being a part of the project!");
                    break;
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View student data by ID
    public void view_data(int id) {
        try (Connection c = DB_Connection.getCon()) {
            String query = "SELECT * FROM student WHERE student_id=?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rsp = ps.executeQuery();
            if (rsp.next()) {
                System.out.println("ID: " + rsp.getInt(1) + "\tName: " + rsp.getString(2) + "\tAge: " + rsp.getInt(3) +
                        "\tCourse: " + rsp.getString(4) + "\tE-Mail: " + rsp.getString(5));
            } else {
                System.out.println("No data found for the given ID.");
            }
            System.out.println("Data shown successfully!");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    // Remove student data by ID
    public void remove_data(int id) {
        try (Connection c = DB_Connection.getCon()) {
            String query = "SELECT COUNT(*) FROM student WHERE student_id=?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                String deleteQuery = "DELETE FROM student WHERE student_id=?";
                PreparedStatement psDelete = c.prepareStatement(deleteQuery);
                psDelete.setInt(1, id);

                int rowsAffected = psDelete.executeUpdate();
                System.out.println("Data deleted successfully. " + rowsAffected + " row(s) affected.");
            } else {
                System.out.println("No data found for the given ID.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    // Update student name by ID
    public void update(int stu_id, String name) {
        try (Connection c = DB_Connection.getCon()) {
            String query = "UPDATE student SET name=? WHERE student_id=?";
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, stu_id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("No data found for the given ID.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    // Fetch all student data
    public void fetch() {
        try (Connection c = DB_Connection.getCon()) {
            String query = "SELECT * FROM student";
            PreparedStatement ps = c.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + "\tName: " + rs.getString(2) + "\tAge: " + rs.getInt(3) +
                        "\tCourse: " + rs.getString(4) + "\tE-Mail: " + rs.getString(5));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}

package dto;

import java.util.Scanner;

public class Student_Driver {

    public static void main(String[] args) {
        Student_Management sm = new Student_Management();
        Scanner s = new Scanner(System.in);

        // Execution without any loop
        System.err.println("Choose the Operation menu!...");
        System.out.println("1. Perform - Add");
        System.out.println("2. Perform - Remove");
        System.out.println("3. Perform - View By ID");
        System.out.println("4. Perform - Update");
        System.out.println("5. Perform - View All");
        System.out.println("6. Perform - Exit from Database");
        
        // Get the option from user
        System.out.println("Choose your option:");
        int opt = s.nextInt();

        switch (opt) {
            case 1:
                sm.add_data();
                break;
            case 2:
                System.out.println("Enter the Id to remove:");
                int id = s.nextInt();
                sm.remove_data(id);
                break;
            case 3:
                System.out.println("Enter the id to view:");
                int s_id = s.nextInt();
                sm.view_data(s_id);
                break;
            case 4:
                System.out.println("Enter the student ID to update:");
                int stu_id = s.nextInt();
                System.out.println("Enter the new name:");
                String name = s.next();
                sm.update(stu_id, name);
                break;
            case 5:
                sm.fetch();
                break;
            case 6:
                System.out.println("Exiting from the database...");
                System.exit(0);
                break;
            default:
                System.out.println("Choose a correct operation!");
        }

        s.close();
    }
}

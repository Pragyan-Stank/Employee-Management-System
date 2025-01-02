package com.company.employeemanagement; // Package declaration must come first

import java.util.Scanner; // Import statement comes after the package declaration

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        int choice;

        System.out.print("Initialize attendance for employees? (1: Yes, 0: No): ");
        int initOption = scanner.nextInt();
        if (initOption == 1) {
            emp.initializeAttendance();
        }

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Update Employee Performance Rating");
            System.out.println("5. Fire Employee");
            System.out.println("6. Hire Employee");
            System.out.println("7. Calculate Company Net Expense");
            System.out.println("8. Record Attendance");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    emp.inputEmployeeData();
                    break;
                case 2:
                    System.out.print("Enter Employee ID to view: ");
                    int searchId = scanner.nextInt();
                    emp.viewEmployeeById(searchId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    emp.updateEmployeeDetails(updateId);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to update performance rating: ");
                    int ratingId = scanner.nextInt();
                    emp.updateEmployeePerformanceRating(ratingId);
                    break;
                case 5:
                    System.out.print("Enter Employee ID to fire: ");
                    int fireId = scanner.nextInt();
                    emp.fireEmployee(fireId);
                    break;
                case 6:
                    System.out.print("Enter Employee ID to hire: ");
                    int hireId = scanner.nextInt();
                    emp.hireEmployee(hireId);
                    break;
                case 7:
                    emp.calculateCompanyNetExpense();
                    break;
                case 8:
                    System.out.print("Enter Employee ID to record attendance: ");
                    int attendanceId = scanner.nextInt();
                    emp.recordAttendance(attendanceId);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        } while (choice != 9);
    }
}
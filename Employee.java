package com.company.employeemanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Make sure this import is here

class Employee {
    private Map<Integer, EmployeeDetails> employees = new HashMap<>();
    private Map<Integer, String> attendance = new HashMap<>();

    static class EmployeeDetails {
        String name;
        String position;
        double salary;
        int performanceRating;
        boolean isEmployed;

        EmployeeDetails(String name, String position, double salary) {
            this.name = name;
            this.position = position;
            this.salary = salary;
            this.performanceRating = 0;
            this.isEmployed = true;
        }
    }

    public void initializeAttendance() {
        attendance.clear();
        System.out.println("Attendance system initialized.");
    }

    public void inputEmployeeData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Position: ");
        String position = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        EmployeeDetails emp = new EmployeeDetails(name, position, salary);
        employees.put(id, emp);
        System.out.println("Employee added.");
    }

    public void viewEmployeeById(int id) {
        if (employees.containsKey(id)) {
            EmployeeDetails emp = employees.get(id);
            System.out.println("ID: " + id);
            System.out.println("Name: " + emp.name);
            System.out.println("Position: " + emp.position);
            System.out.println("Salary: " + emp.salary);
            System.out.println("Performance Rating: " + emp.performanceRating);
            System.out.println("Status: " + (emp.isEmployed ? "Employed" : "Fired"));
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployeeDetails(int id) {
        Scanner scanner = new Scanner(System.in);

        if (employees.containsKey(id)) {
            EmployeeDetails emp = employees.get(id);

            System.out.println("Updating details for ID " + id);
            System.out.print("New name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                emp.name = name;
            }

            System.out.print("New position (leave blank to keep current): ");
            String position = scanner.nextLine();
            if (!position.isEmpty()) {
                emp.position = position;
            }

            System.out.print("New salary (leave blank to keep current): ");
            String salaryInput = scanner.nextLine();
            if (!salaryInput.isEmpty()) {
                emp.salary = Double.parseDouble(salaryInput);
            }

            System.out.println("Details updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployeePerformanceRating(int id) {
        Scanner scanner = new Scanner(System.in);

        if (employees.containsKey(id)) {
            EmployeeDetails emp = employees.get(id);

            System.out.print("Enter performance rating (1-5): ");
            int rating = scanner.nextInt();
            if (rating >= 1 && rating <= 5) {
                emp.performanceRating = rating;
                System.out.println("Rating updated.");
            } else {
                System.out.println("Invalid rating.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void fireEmployee(int id) {
        if (employees.containsKey(id)) {
            EmployeeDetails emp = employees.get(id);
            emp.isEmployed = false;
            System.out.println("Employee fired.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void hireEmployee(int id) {
        if (employees.containsKey(id)) {
            EmployeeDetails emp = employees.get(id);
            if (!emp.isEmployed) {
                emp.isEmployed = true;
                System.out.println("Employee rehired.");
            } else {
                System.out.println("Employee is already employed.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void calculateCompanyNetExpense() {
        double totalExpense = 0;
        for (EmployeeDetails emp : employees.values()) {
            if (emp.isEmployed) {
                totalExpense += emp.salary;
            }
        }
        System.out.println("Total Expense: " + totalExpense);
    }

    public void recordAttendance(int id) {
        Scanner scanner = new Scanner(System.in);

        if (employees.containsKey(id)) {
            System.out.print("Enter attendance (P for present, A for absent): ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("P") || status.equalsIgnoreCase("A")) {
                attendance.put(id, status);
                System.out.println("Attendance recorded.");
            } else {
                System.out.println("Invalid status.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }
}
package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;



public class Main {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 25),
                new Employee("Charlie", 35)
        );

        // Using a Consumer to print employee details
        Consumer<Employee> printEmployeeDetails = employee ->
                System.out.println("Employee details: " + employee);

        // Using a Consumer to send a notification to employees
        Consumer<Employee> sendNotification = employee ->
                System.out.println("Notification sent to: " + employee.getName());

        // Process employees: print details and send notifications
        processEmployees(employees, printEmployeeDetails.andThen(sendNotification));
    }

    public static void processEmployees(List<Employee> employees, Consumer<Employee> employeeConsumer) {
        for (Employee employee : employees) {
            employeeConsumer.accept(employee);
        }
    }
}

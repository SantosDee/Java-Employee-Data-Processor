import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeProcessor {
    public static void main(String[] args) {
        // Step 1: Initialize Employee datasetpublic class EmployeeProcessor {
        List<Employee> employees = Arrays.asList(
                new Employee("James", 37, "Engineering", 85000),
                new Employee("sam", 25, "Marketing", 51000),
                new Employee("tim", 42, "Engineering", 95000),
                new Employee("dave", 31, "Finance", 66000)
        );

        // Step 2: Function to concatenate name and department
        Function<Employee, String> nameDeptFunction = emp -> emp.getName() + " (" + emp.getDepartment() + ")";
        List<String> nameDeptList = employees.stream()
                .map(nameDeptFunction)
                .collect(Collectors.toList());

        // Step 3: Calculate average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        // Step 4: Filter employees by age threshold (>30)
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .collect(Collectors.toList());

        // Output
        System.out.println("Concatenated Name and Department:");
        nameDeptList.forEach(System.out::println);

        System.out.println("\nAverage Salary: " + averageSalary);

        System.out.println("\nEmployees aged above 30:");
        filteredEmployees.forEach(emp -> System.out.println(emp.getName()));
    }
}

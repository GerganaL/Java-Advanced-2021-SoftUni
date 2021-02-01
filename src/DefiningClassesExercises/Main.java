package DefiningClassesExercises;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String department = info[3];
            Employee employee = new Employee(name, salary, position, department);
            if (info.length == 5) {
                if (info[4].contains("@")) {
                    employee.setEmail(info[4]);
                } else {
                    employee.setAge(Integer.parseInt(info[4]));
                }
            } else if (info.length == 6) {
                employee.setEmail(info[4]);
                employee.setAge(Integer.parseInt(info[5]));
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = departments.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());

        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> {
                    System.out.println(employee.toString());
                });


    }
}

 /* PERSON
       Map<String,Person> people = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name,age);
            people.putIfAbsent(person.getName(), person);
        }
        people.entrySet().stream().filter(a -> a.getValue().getAge() > 30)
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " - " + entry.getValue().getAge());
                });*/

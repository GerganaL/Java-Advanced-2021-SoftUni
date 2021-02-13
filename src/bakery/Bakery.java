package bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bakery {
    List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        int oldest = 0;
        /*Employee employee = null;
        for (Employee value : employees) {
            if (value.getAge() > oldest) {
                employee = value;
                oldest = value.getAge();
            }
        }*/

        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
        //return employee;
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Employees working at Bakery ");
        sb.append(getName()).append(":");
        for (Employee employee : employees) {
            sb.append(System.lineSeparator());
            sb.append(employee.toString());
        }
        return sb.toString();
    }
}

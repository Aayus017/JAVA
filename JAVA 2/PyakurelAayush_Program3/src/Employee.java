import java.io.*;

public class Employee implements Comparable<Employee>, Serializable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return String.format("%s -- salary %.2f", name, salary);
    }

    public int compareTo(Employee other) {
        // (compare two Employees based on their salary)
        if (this.salary > other.salary)
            return 1;
        else if (this.salary == other.salary)
            return 0;
        else
            return -1;
    }
}

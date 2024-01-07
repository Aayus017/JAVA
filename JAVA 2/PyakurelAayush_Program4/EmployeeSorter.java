import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class EmployeeSorter {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            ArrayList<Employee> employees = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String fName = parts[0];
                String lName = parts[1];
                Double salary = Double.parseDouble(parts[2]);
                employees.add(new Employee(fName, lName, salary));
            }

            PriorityQueue<Employee> employeeNameLenPQ = new PriorityQueue<>(new NameLengthComparator());
            PriorityQueue<Employee> employeeSalaryPQ = new PriorityQueue<>(new SalaryComparator());

            employeeNameLenPQ.addAll(employees);
            employeeSalaryPQ.addAll(employees);

            System.out.println("--------- Name comparator -----------");
            removeAndPrintQueue(employeeNameLenPQ);

            System.out.println("--------- Salary comparator -----------");
            removeAndPrintQueue(employeeSalaryPQ);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeAndPrintQueue(PriorityQueue<Employee> pq) {
        while (!pq.isEmpty()) {
            Employee employee = pq.poll();
            System.out.println(employee.getFirstName() + " " + employee.getLastName() + "\t" + employee.getSalary());
        }
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private Double salary;

    public Employee(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }
}

class NameLengthComparator implements java.util.Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int len1 = (e1.getFirstName() + e1.getLastName()).length();
        int len2 = (e2.getFirstName() + e2.getLastName()).length();
        return Integer.compare(len1, len2);
    }
}

class SalaryComparator implements java.util.Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

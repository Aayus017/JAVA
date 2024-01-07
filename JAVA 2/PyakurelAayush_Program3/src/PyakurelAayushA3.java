import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class PyakurelAayushA3 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Reading File 1: serialEmp1.dat");
        readAndAddEmployees("serialEmp1.dat", employees);

        System.out.println("\nReading File 2: serialEmp2.dat");
        readAndAddEmployees("serialEmp2.dat", employees);

        Collections.sort(employees);

        System.out.println("\nEmployees in order:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        writeEmployeesToFile("serialEmpSorted.dat", employees);
    }

    private static void readAndAddEmployees(String fileName, ArrayList<Employee> employees) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Employee employee = (Employee) ois.readObject();
                employees.add(employee);
                System.out.println(employee);
            }
        } catch (EOFException e) {
            // File ended
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeEmployeesToFile(String fileName, ArrayList<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Employee employee : employees) {
                oos.writeObject(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

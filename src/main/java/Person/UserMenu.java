package Person;




import java.io.*;
import java.util.*;

public class UserMenu {
    private int numberOfEmployees;
    private Scanner scanner = new Scanner(System.in);
    private List<Person> employeeList = new ArrayList<>();
    private SortType type;
    private final int error = -1;

    public UserMenu() {
        askForEmployee();
    }

    private void askForEmployee() {
        boolean flag = false;
        while (!flag) {
                scanner = new Scanner(System.in);
                System.out.println("Type number of employees");
                numberOfEmployees = userIntChoice();
            if (numberOfEmployees != error) {
                addPerson();
                flag = true;
            }
        }
        sortEmployersByLastName();
        print();
        saveToFile();
        scanner.close();
    }

    private void addPerson() {
        int counter = 0;
        String firstName;
        String lastName;
        int age;
        while (counter < numberOfEmployees) {
            System.out.println("Type firstName");
            scanner.nextLine();
            firstName = userStringChoice();
            System.out.println("Type secondName");
            lastName = userStringChoice();
                System.out.println("Type age");
                age = userIntChoice();
            if (age != error) {
                employeeList.add(new Person(firstName, lastName, age));
                counter++;
            }
        }
    }


    private int userIntChoice() {
        int result;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("YOU MUST TYPE A NUMBER!!! \n");
            return error;
        }
        return result;
    }

    private String userStringChoice() {
        return scanner.nextLine();
    }

    private void sortEmployersByLastName() {

        int choose = error;
        while (choose < 0 || choose > 2) {
            sortChooseMenu();
            choose = userIntChoice();
        }
        scanner.close();
        switch (choose) {
            case 0:
                type = SortType.FIRSTNAME;
            case 1:
                type = SortType.LASTNAME;
            case 2:
                type = SortType.AGE;
        }
        employeeList.sort(new SortAlgorithm(type));
    }

    private void print() {
        for (Person p : employeeList) {
            System.out.println(p.toString());
        }
    }

    private void sortChooseMenu() {
        System.out.println("Choose sort type");
        System.out.println("0 - FirstName");
        System.out.println("1 - LastName");
        System.out.println("2 - Age");
    }

    private void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("baza.csv"));
            for (Person p : employeeList)
                pw.println(p.toString());
            pw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

package Person;


import java.io.*;
import java.util.*;

public class UserMenu {
    private int numberOfEmployees;
    private Scanner scanner = new Scanner(System.in);
    private List<Person> employeeList = new ArrayList<>();
    private SortType type;

    public UserMenu() {
        askForEmployee();
    }
    private void askForEmployee(){
        boolean flag = false;
            while (!flag) {
                try {
                    scanner = new Scanner(System.in);
                    System.out.println("Type number of employees");
                    numberOfEmployees = scanner.nextInt();
                }
             catch(InputMismatchException e){
                    System.out.println("YOU MUST TYPE A NUMBER!!! \n");
                    numberOfEmployees = -1;
                }
                if (numberOfEmployees != -1) {
                    addPerson();
                    sortEmployersByLastName();
                    print();
                    saveToFile();
                    flag = true;
                }
            }
        }
    private void addPerson(){
        int counter = 0;
        String firstName;
        String lastName;
        int age;
        while (counter<numberOfEmployees){
                System.out.println("Type firstName");
                scanner.nextLine();
                firstName = scanner.nextLine();
                System.out.println("Type secondName");
                lastName = scanner.nextLine();
            try {
                System.out.println("Type age");
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("YOU MUST TYPE A NUMBER!!! \n");
                age=-1;
            }

            if (age!=-1) {
                employeeList.add(new Person(firstName, lastName, age));
                counter++;
            }
        }
    }

    private void sortEmployersByLastName(){

        int choose=-1;
        while (choose<0 || choose>2) {
            sortChooseMenu();
            choose = scanner.nextInt();
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
    private void print(){
        for (Person p: employeeList) {
            System.out.println(p.toString());
        }
    }
    private void sortChooseMenu() {
        System.out.println("Choose sort type");
        System.out.println("0 - FirstName");
        System.out.println("1 - LastName");
        System.out.println("2 - Age");
    }

    private void saveToFile(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("baza.csv"));
            for (Person p : employeeList)
                pw.println(p.toString());
            pw.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}

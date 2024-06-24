package JavaDevelomentKitLesson4.HandBook;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
               HandBook handBook = new HandBook();
                Scanner scanner = new Scanner(System.in);

                boolean running = true;
                while (running) {
                    System.out.println("1. Добавить нового сотрудника");
                    System.out.println("2. Поиск сотрудника по опыту");
                    System.out.println("3. Найти номер телефона по имени");
                    System.out.println("4. Поиск сотрудника по идентификатору сотрудника");
                    System.out.println("5.Выход");
                    System.out.print("Выберите опцию: ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (option) {
                        case 1:
                            System.out.print("Введите идентификатор сотрудника: ");
                            int employeeId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Введите номер телефона: ");
                            String phoneNumber = scanner.nextLine();
                            System.out.print("Введите имя: ");
                            String name = scanner.nextLine();
                            System.out.print("Введите опыт: ");
                            int experience = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            Employee employee = new Employee(employeeId, phoneNumber, name, experience);
                            handBook.addEmployee(employee);
                            System.out.println("Сотрудник успешно добавлен");
                            break;
                        case 2:
                            System.out.print("Введите опыт для поиска: ");
                            int exp = scanner.nextInt();
                            List<Employee> employeesByExperience = handBook.searchByExperience(exp);
                            for (Employee emp : employeesByExperience) {
                                System.out.println(emp.getName());
                            }
                            break;
                        case 3:
                            System.out.print("Введите имя для поиска: ");
                            String employeeName = scanner.nextLine();
                            String phoneNumberByName = handBook.findPhoneNumberByName(employeeName);
                            System.out.println("Phone number: " + phoneNumberByName);
                            break;
                        case 4:
                            System.out.print("Введите идентификатор сотрудника для поиска: ");
                            int empId = scanner.nextInt();
                            Employee foundEmployee = handBook.searchByEmployeeId(empId);
                            if (foundEmployee != null) {
                                System.out.println("Employee found - " + foundEmployee.getName() + ", Phone number: " + foundEmployee.getPhoneNumber());
                            } else {
                                System.out.println("Сотрудник не найден");
                            }
                            break;
                        case 5:
                            running = false;
                            break;
                        default:
                            System.out.println("Неверный параметр, пожалуйста, повторите попытку");
                    }
                }
            }
        }





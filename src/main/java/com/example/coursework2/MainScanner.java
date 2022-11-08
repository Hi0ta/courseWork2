package com.example.coursework2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainScanner {

    public static void main(String[] args) {

        Planner planner = new Planner();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Выберите пункт меню: ");
                printMenu();
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(scanner, planner);
                            break;
                        case 2:
                            deleteTask(scanner, planner);
                            break;
                        case 3:
                            printTasksForTheDate(scanner, planner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }

    }
    private static void printMenu() {
        System.out.println("1 Добавить задачу \n" +
                "2 Удалить задачу \n" +
                "3 Получить задачу на указанный день \n" +
                "0 Выход " );

    }
    private static void addTask(Scanner scanner, Planner planner) {

        System.out.print("Что произойдет? ");
        String heading = scanner.next().concat(scanner.nextLine());

        System.out.print("Подробности: ");
        String description = scanner.nextLine();

        System.out.print("Когда? (введите в формате ГГГГ-ММ-ДД) ");
        LocalDate date = LocalDate.parse(scanner.next());

        System.out.print("Во сколько? (введите в формате ЧЧ:ММ) ");
        LocalTime time = LocalTime.parse(scanner.next());

        System.out.println("1 личное \n" + "2 рабочее ");
            int type = scanner.nextInt();
            TypeEvent typeEvent = type == 1? TypeEvent.PERSONAL : TypeEvent.WORKER;

        System.out.println("Повторять? \n" + "1 Нет \n" + "2 Ежедневно \n" + "3 Еженедельно \n" + "4 Ежемесячно \n" + "5 Ежегодно ");
        if (scanner.hasNextInt()) {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    planner.addEvent(new Event(heading, description, date, time, typeEvent));
                    break;
                case 2:
                    planner.addEvent(new DailyEvent(heading, description, date, time, typeEvent));
                    break;
                case 3:
                    planner.addEvent(new WeeklyEvent(heading, description, date, time, typeEvent));
                    break;
                case 4:
                    planner.addEvent(new MonthlyEvent(heading, description, date, time, typeEvent));
                    break;
                case 5:
                    planner.addEvent(new AnnuallyEvent(heading, description, date, time, typeEvent));
                    break;
                default:
                    throw new IllegalArgumentException("Нет такого типа повторяемости");
            }
        }

    }
    private static void deleteTask(Scanner scanner, Planner planner){
        System.out.print("Для удаления введите номер эвента ");
        Integer Key = scanner.nextInt();
        planner.deleteEvent(Key);
    }
    private static void printTasksForTheDate(Scanner scanner, Planner planner){
        System.out.print("На какую дату желаете посмотреть полный список эвентов? (введите в формате ГГГГ-ММ-ДД) ");
        LocalDate date = LocalDate.parse(scanner.next());
        System.out.println();
        System.out.println("На дату: "+ date + " у вас запланировано: ");
        planner.printPlannerForTheDate(date);
        System.out.println();
    }
}

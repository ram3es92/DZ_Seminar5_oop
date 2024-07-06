package view;

import controller.StudentController;
import controller.StudyGroupController;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.DB.DataBase;
import model.impl.Student;
import model.impl.StudyGroup;

public class MainView {
    private final StudentController studentController = new StudentController();
    private final StudyGroupController studyGroupController = new StudyGroupController();

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать студента");
            System.out.println("2 - найти студента по id");
            System.out.println("3 - распечатать информацию о всех студентах");
            System.out.println("4 - создать учебную группу");
            System.out.println("5 - показать все учебные группы");
            System.out.println("6 - выход");

            int choice = getIntInput(scanner);
            switch (choice) {
                case 1 -> createStudent(scanner);
                case 2 -> getById(scanner);
                case 3 -> getAllStudents();
                case 4 -> createStudyGroup(scanner);
                case 5 -> getAllStudyGroups();
                case 6 -> System.exit(0); // выход из приложения
                default -> System.out.println("Операция не поддерживается");
            }
        }
    }

    private Student createStudent(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите фамилию:");
        String lastName = scanner.next();
        System.out.println("Введите номер группы:");
        int groupId = getIntInput(scanner);
        Student student = studentController.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
    }

    private Student getById(Scanner scanner) {
        System.out.println("Введите id пользователя: ");
        int id = getIntInput(scanner);
        Student student = studentController.getById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Студент с id " + id + " не найден.");
        }
        return student;
    }

    private List<Student> getAllStudents() {
        List<Student> students = studentController.getAllStudents();
        students.forEach(System.out::println);
        return students;
    }

    private void createStudyGroup(Scanner scanner) {
        System.out.println("Введите id преподавателя: ");
        int teacherId = getIntInput(scanner);
        System.out.println("Введите id студентов через запятую: ");
        scanner.nextLine(); // consume the newline
        String studentIdsString = scanner.nextLine();
        List<Integer> studentIds = Stream.of(studentIdsString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        StudyGroup studyGroup = studyGroupController.createStudyGroup(teacherId, studentIds);
        System.out.println(studyGroupController.studyGroupToString(studyGroup));
    }

    private void getAllStudyGroups() {
        List<StudyGroup> studyGroups = studyGroupController.getAllStudyGroups();
        studyGroups.forEach(System.out::println);
    }

    private int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите корректное число:");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }
}

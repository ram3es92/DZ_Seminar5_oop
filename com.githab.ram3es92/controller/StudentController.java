package controller;

import java.util.List;
import model.impl.Student;
import service.StudentService;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public Student createStudent(String name, String lastName, int groupId) {
        return studentService.createStudent(name, lastName, groupId);
    }

    public Student getById(int id) {
        Student student = null;
        try {
            student = studentService.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
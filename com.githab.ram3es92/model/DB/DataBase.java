package model.DB;

import java.util.ArrayList;
import java.util.List;
import model.impl.Student;
import model.impl.StudyGroup;
import model.impl.Teacher;
//симулирует базу данных
public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();

    public static final List<Teacher> teachersDB = new ArrayList<>();

    public static final List<StudyGroup> studyGroupsDB = new ArrayList<>();

    public static void fillDB(){
        Teacher teacher = new Teacher(1, "Мария", "Ивановна");
        teachersDB.add(teacher);
        Teacher teacher2 = new Teacher(2, "Фёдр", "Петрович");
        teachersDB.add(teacher2);
        Student s1 = new Student(1, "Рикон", "Старк", 1);
        Student s2 = new Student(2, "Джофри", "Ланистер", 1);
        Student s3 = new Student(3, "Семен", "Петров", 2);
        Student s4 = new Student(4, "Вася", "Черешнев", 2);
        studentsDB.add(s1);
        studentsDB.add(s2);
        studentsDB.add(s3);
        studentsDB.add(s4);
    }
}

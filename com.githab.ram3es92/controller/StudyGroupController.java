package controller;

import java.util.List;
import model.impl.Student;
import model.impl.Teacher;
import model.impl.StudyGroup;
import service.StudyGroupService;
import service.TeacherService;
import service.StudentService;

public class StudyGroupController {

    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final TeacherService teacherService = new TeacherService();
    private final StudentService studentService = new StudentService();

    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds) {
        Teacher teacher = teacherService.getById(teacherId);
        List<Student> students = studentService.getByIds(studentIds);
        return studyGroupService.createStudyGroup(teacher, students);
    }

    public Teacher getTeacher(StudyGroup studyGroup) {
        return studyGroupService.getTeacher(studyGroup);
    }

    public void setTeacher(StudyGroup studyGroup, Teacher teacher) {
        studyGroupService.setTeacher(studyGroup, teacher);
    }

    public List<Student> getStudents(StudyGroup studyGroup) {
        return studyGroupService.getStudents(studyGroup);
    }

    public void setStudents(StudyGroup studyGroup, List<Student> students) {
        studyGroupService.setStudents(studyGroup, students);
    }

    public String studyGroupToString(StudyGroup studyGroup) {
        return studyGroupService.toString(studyGroup);
    }

    public List<StudyGroup> getAllStudyGroups() {
        return studyGroupService.getAllStudyGroups();
    }
}
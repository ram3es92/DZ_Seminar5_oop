package service;

import java.util.List;
import model.DB.DataBase;
import model.impl.Student;
import model.impl.StudyGroup;
import model.impl.Teacher;

public class StudyGroupService {

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        StudyGroup studyGroup = new StudyGroup(teacher, students);
        DataBase.studyGroupsDB.add(studyGroup);
        return studyGroup;
    }

    public Teacher getTeacher(StudyGroup studyGroup) {
        return studyGroup.getTeacher();
    }

    public void setTeacher(StudyGroup studyGroup, Teacher teacher) {
        studyGroup.setTeacher(teacher);
    }

    public List<Student> getStudents(StudyGroup studyGroup) {
        return studyGroup.getStudents();
    }

    public void setStudents(StudyGroup studyGroup, List<Student> students) {
        studyGroup.setStudents(students);
    }

    public String toString(StudyGroup studyGroup) {
        return studyGroup.toString();
    }

    public List<StudyGroup> getAllStudyGroups() {
        return DataBase.studyGroupsDB;
    }
}
package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements InterfaceStudentService {
    private static ArrayList<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Hung", "C0620K1"));
        students.add(new Student(2, "Tuan", "C0620K1"));
        students.add(new Student(3, "Nghia", "C0620K1"));
        students.add(new Student(4, "Dung", "C0620K1"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return;
            }
        }
    }

    @Override
    public void updateStudent(int id, Student student) {
        for (Student student1 : students) {
            if (student1.getId() == id) {
                student1.setName(student.getName());
                student1.setGrade(student.getGrade());
                return;
            }
        }
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

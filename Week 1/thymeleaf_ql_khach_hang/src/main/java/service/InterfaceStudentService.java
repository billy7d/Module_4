package service;

import model.Student;

import java.util.List;

public interface InterfaceStudentService {
    List<Student> findAll();

    public void addStudent(Student student);

    public void removeStudent(int id);

    public void updateStudent(int id, Student student);

    public Student findById(int id);

}

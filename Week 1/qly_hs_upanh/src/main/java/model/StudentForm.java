package model;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private int id;
    private String name;
    private String grade;
    private MultipartFile image;

    public StudentForm(){}

    public StudentForm(String name, String grade, MultipartFile image) {
        this.name = name;
        this.grade = grade;
        this.image = image;
    }

    public StudentForm(int id,String name, String grade, MultipartFile image) {
        this.id =id;
        this.name = name;
        this.grade = grade;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}

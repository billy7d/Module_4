package controller;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService = new StudentService();

    @GetMapping("/")
    public String index(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students",studentList);
        return "index";
    }

    @GetMapping("/student/create")
    public String create(Model model){
        Student student = new Student();
        student.setName("Dungx");
        model.addAttribute("student",student);
        return "create";
    }

    @GetMapping("/student/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "delete";
    }

    @GetMapping("/student/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "view";
    }

    @PostMapping("/student/create")
    public String create(@ModelAttribute("student") Student student, Model model){
        student.setId((int)(Math.random()*10000));
        studentService.addStudent(student);
        model.addAttribute("student",student);
        return "redirect:/";
    }

    @PostMapping("/student/delete")
    public String delete(Student student){
        studentService.removeStudent(student.getId());
        return "delete";
    }



}


package ra.sonnguyen.md3_sesion19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ra.sonnguyen.md3_sesion19.entity.Student;
import ra.sonnguyen.md3_sesion19.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller

public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"/"})
    public String home(Model model) {
        List<Student> list =  studentService.findAll();
        model.addAttribute("list", list);
        return "home";
    }

    @RequestMapping("/AllStudent")
    public String AllStudent(Model model) {
        return "all_student";
    }

    @RequestMapping("/initInsertStudent")
    public String allStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "insertStudent";
    }

    @RequestMapping("/insertStudent")
    public String insertStudent(@Valid @ModelAttribute("student")Student student, BindingResult result, @RequestParam("avatarFile") MultipartFile file, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "insertStudent";
        } else {
            //upload avatar:
            String urlAvatar = uploadFile.uploadLocal(file);
            student.setAvatar(urlAvatar);
            boolean bl = studentService.save(s);
            if(bl){
                return "redirect:/listStudents";
            }else{
                model.addAttribute("s",s);
                model.addAttribute("error","Insert failed!");
                return "insertStudent";
            }
    }

}

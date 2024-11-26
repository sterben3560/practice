package com.example.CRUDWITHMONGODB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDWITHMONGODB.Entity.StudentEntity;
import com.example.CRUDWITHMONGODB.Repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/get")
    public List<StudentEntity> getData() {
        try {
            return studentRepository.findAll();

        } catch (Exception e) {
            System.out.println("error");
            List<StudentEntity> temp = null;
            return temp;
        }
    }
    @PutMapping("/update/{id}")
    public String updateData(@PathVariable int id, @RequestBody StudentEntity student) {
        try {
            int sid = student.getStudentId();
            student.setStudentId(id);
            studentRepository.deleteById(sid);;
            studentRepository.save(student);
            return "success";
        }
        catch(Exception e) {
            return "error";
        }
    }
    @PostMapping("/post")
    public String saveData(@RequestBody StudentEntity student) {
        try {
            studentRepository.save(student);
            return "success";
        }
        catch(Exception e) {
            return "error";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id ) {
        try {
            studentRepository.deleteById(id);            
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}

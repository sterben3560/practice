package com.example.CRUDWITHMYSQL.Controller;

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

import com.example.CRUDWITHMYSQL.Entity.Student;
import com.example.CRUDWITHMYSQL.Repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/get")
    public List<Student> getData() {
        try {
            return studentRepository.findAll();

        } catch (Exception e) {
            List<Student> temp = null;
            return temp;
        }
    }
    @PutMapping("/update/{id}")
    public String updateData(@PathVariable int id, @RequestBody Student student) {
        try {
            student.setStudentId(id);
            studentRepository.save(student);
            return "success";
        }
        catch(Exception e) {
            return "error";
        }
    }
    @PostMapping("/post")
    public String saveData(@RequestBody Student student) {
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

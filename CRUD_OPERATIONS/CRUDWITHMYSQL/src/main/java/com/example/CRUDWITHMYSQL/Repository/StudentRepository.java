package com.example.CRUDWITHMYSQL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDWITHMYSQL.Entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

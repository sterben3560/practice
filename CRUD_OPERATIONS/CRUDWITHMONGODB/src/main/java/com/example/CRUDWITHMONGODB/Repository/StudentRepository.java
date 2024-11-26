package com.example.CRUDWITHMONGODB.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDWITHMONGODB.Entity.StudentEntity;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, Integer>{

} 

package com.example.LibraryTask;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository <Bill,String> {
}

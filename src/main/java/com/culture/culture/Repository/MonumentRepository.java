package com.culture.culture.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culture.culture.Model.Monument;




public interface MonumentRepository extends MongoRepository<Monument,String> {

}

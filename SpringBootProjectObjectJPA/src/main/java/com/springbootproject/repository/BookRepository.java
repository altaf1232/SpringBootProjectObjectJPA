package com.springbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springbootproject.entity.BookEntityObject;

@Repository
public interface BookRepository extends CrudRepository<BookEntityObject, Integer> {

}

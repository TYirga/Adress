package com.example.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudeRepository automatically store, modify and create data.
public interface adressBookRepository extends CrudRepository <adressBook, Long>{
    List<adressBook> findadressBookByEmail(String email);
}

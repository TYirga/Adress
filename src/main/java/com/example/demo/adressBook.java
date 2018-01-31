package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //tells your application that a table should be created
public class adressBook{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    @NotNull
    @Size(min=3)
    String Name;
    @NotNull
    @Size(min=10)
    private String homePhone;
    @NotNull
    @Size(min=9)
    private String cellPhone;
    @NotNull
    @Size(min=5)
    private String email;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
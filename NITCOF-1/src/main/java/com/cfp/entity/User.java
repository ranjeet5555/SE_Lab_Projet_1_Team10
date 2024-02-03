package com.cfp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Author")
public class User {
    private String name;
    @Id
    private String username;
    private String email;
    private String phone;
    private String password;
    private String cpassword;

}

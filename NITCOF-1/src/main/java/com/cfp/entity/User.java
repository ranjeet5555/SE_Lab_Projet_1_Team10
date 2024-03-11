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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getCpassword() {
        return cpassword;
    }

    private String name;
    @Id
    private String username;
    private String email;
    private String phone;
    private String password;
    private String cpassword;

}

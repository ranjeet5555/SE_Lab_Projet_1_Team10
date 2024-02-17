package com.cfp.repository;

import com.cfp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByUsername(String username);

    @Modifying
    @Query("UPDATE User SET name=:name,email=:email,phone=:phone where username=:username")
    void updateuser(@Param("username") String username, @Param("name") String name, @Param("phone") String phone, @Param("email") String email);
}


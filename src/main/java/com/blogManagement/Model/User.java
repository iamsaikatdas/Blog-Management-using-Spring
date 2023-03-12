package com.blogManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_name")
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    private int age;

    @Column(unique = true)
    private String email;

    private String address;

    // new
    private String about;
    private String password;


    // parent of blog class
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    List<Blog> blogList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comments> commentsList = new ArrayList<>();
}

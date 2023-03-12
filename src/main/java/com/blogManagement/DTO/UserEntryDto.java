package com.blogManagement.DTO;

import com.blogManagement.Model.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryDto {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
    private String about;
    private String password;
}

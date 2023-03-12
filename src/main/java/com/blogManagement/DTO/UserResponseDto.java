package com.blogManagement.DTO;

import com.blogManagement.Model.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
    List<BlogResponseDto> blogResponseDtoList = new ArrayList<>();
}

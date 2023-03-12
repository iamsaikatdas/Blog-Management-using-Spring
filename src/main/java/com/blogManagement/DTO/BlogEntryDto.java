package com.blogManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryDto {
    private String title;
    private String description;
    private String keyWord;
    private int userId;

}

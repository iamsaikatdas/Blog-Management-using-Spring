package com.blogManagement.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogResponseDto2 {
    private String title;
    private String description;
    private String keyWord;
    private int blogId;
    private List<ImageResponseDto> imageResponseDtoList = new ArrayList<>();
}

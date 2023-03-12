package com.blogManagement.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Blog> blogCategoryList = new ArrayList<>();
}

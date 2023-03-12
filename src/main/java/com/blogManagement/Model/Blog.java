package com.blogManagement.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String keyWord;

    @CreationTimestamp
    Date createdOn;


    // child in user class
    @ManyToOne
    @JoinColumn
    User userEntity;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();


    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Comments> commentsList = new ArrayList<>();


    @ManyToOne
    @JoinColumn
    private Category category;
}

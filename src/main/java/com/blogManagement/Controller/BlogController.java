package com.blogManagement.Controller;

import com.blogManagement.DTO.*;
import com.blogManagement.Model.Blog;
import com.blogManagement.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/add")
    public String addBlog(@RequestBody BlogEntryDto blogEntryDto){
        return blogService.addBlog(blogEntryDto);
    }

    @GetMapping("/getBlogById/{id}")
    public BlogResponseDto2 getBlogById(@PathVariable("id") int id){
        return blogService.getBlogById(id);
    }

    @PutMapping("/updateDescription/{id}")
    public String updateBlogDescription(@PathVariable("id") int id, @RequestBody BlogDescUpdateDto blogDescUpdateDto){
        return blogService.updateBlogDescription(id, blogDescUpdateDto);
    }
    @PutMapping("/updateTitle/{id}")
    public String updateBlogTitle(@PathVariable("id") int id, @RequestBody BlogTitleUpdateDto blogDescUpdateDto){
        return blogService.updateBlogTitle(id, blogDescUpdateDto);
    }
    @PutMapping("/updateKeyword/{id}")
    public String updateBlogKeyword(@PathVariable("id") int id, @RequestBody BlogKeywordUpdateDto blogKeywordUpdateDto){
        return blogService.updateBlogKeyword(id, blogKeywordUpdateDto);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") int id){
        return blogService.deleteBlog(id);
    }

    @GetMapping("/getAllBlog")
    public List<BlogResponseDto2> getAllBlogs(){
        return blogService.getAllBlogs();
    }
}

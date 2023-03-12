package com.blogManagement.Service;

import com.blogManagement.DTO.*;
import com.blogManagement.Model.Blog;
import com.blogManagement.Model.Image;
import com.blogManagement.Model.User;
import com.blogManagement.Repository.BlogRepository;
import com.blogManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    public String addBlog(BlogEntryDto blogEntryDto){
        Blog blog = new Blog();

        blog.setTitle(blogEntryDto.getTitle());
        blog.setDescription(blogEntryDto.getDescription());
        blog.setKeyWord(blogEntryDto.getKeyWord());

        int userId = blogEntryDto.getUserId();
        User user;
        try {
           user = userRepository.findById(userId).get();
        } catch (Exception e){
            return "User details not found.";
        }
        blog.setUserEntity(user);


        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);

        userRepository.save(user);

        return blogEntryDto.getTitle() + " : blog added successfully.";
    }
    public BlogResponseDto2 getBlogById(int id){

        Blog blog = blogRepository.findById(id).get();

        List<Image> imageList = blog.getImageList();
        List<ImageResponseDto> imageResponseDtoList = new ArrayList<>();

        for (Image i : imageList){
            ImageResponseDto imageResponseDto = new ImageResponseDto();
            imageResponseDto.setDimension(i.getDimension());
            imageResponseDto.setDescription(i.getDescription());
            imageResponseDto.setImage_id(i.getId());
            imageResponseDtoList.add(imageResponseDto);
        }

        BlogResponseDto2 blogResponseDto1 = BlogResponseDto2.builder()
                .description(blog.getDescription())
                .title(blog.getTitle())
                .keyWord(blog.getKeyWord())
                .imageResponseDtoList(imageResponseDtoList)
                .build();

        return blogResponseDto1;
    }

    public String updateBlogDescription(int id, BlogDescUpdateDto blogDescUpdateDto){
        Blog blog = blogRepository.findById(id).get();

        blog.setDescription(blogDescUpdateDto.getDescription());
        blogRepository.save(blog);
        return "Your Blog description update successfully.";
    }
    public String updateBlogTitle(int id, BlogTitleUpdateDto blogTitleUpdateDto){
        Blog blog = blogRepository.findById(id).get();

        blog.setTitle(blogTitleUpdateDto.getTitle());
        blogRepository.save(blog);
        return "Your Blog title update successfully.";
    }
    public String updateBlogKeyword(int id, BlogKeywordUpdateDto blogKeywordUpdateDto){
        Blog blog = blogRepository.findById(id).get();

        blog.setKeyWord(blogKeywordUpdateDto.getKeyword());
        blogRepository.save(blog);
        return "Your Blog keyword update successfully.";
    }

    public String deleteBlog(int id){
        try {
            blogRepository.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }

        return "Blog Deleted Successfully.";
    }

    public List<BlogResponseDto2> getAllBlogs(){
        List<Blog> blogList = blogRepository.findAll();

        List<BlogResponseDto2> blogResponseDto2List = new ArrayList<>();

        for (Blog blog : blogList){

            // get the image list
            List<Image> imageList = blog.getImageList();
            List<ImageResponseDto> imageResponseDtoList = new ArrayList<>();
            for (Image image : imageList){
                ImageResponseDto imageResponseDto = ImageResponseDto.builder()
                        .image_id(image.getId())
                        .dimension(image.getDimension())
                        .description(image.getDescription())
                        .build();

                imageResponseDtoList.add(imageResponseDto);
            }
            // set the blog details
            BlogResponseDto2 blogResponseDto2 = BlogResponseDto2.builder()
                    .blogId(blog.getId())
                    .description(blog.getDescription())
                    .title(blog.getTitle())
                    .keyWord(blog.getKeyWord())
                    .imageResponseDtoList(imageResponseDtoList)
                    .build();

            blogResponseDto2List.add(blogResponseDto2);
        }
        return blogResponseDto2List;
    }
}

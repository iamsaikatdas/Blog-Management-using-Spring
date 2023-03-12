package com.blogManagement.Service;

import com.blogManagement.DTO.*;
import com.blogManagement.Model.Blog;
import com.blogManagement.Model.Image;
import com.blogManagement.Model.User;
import com.blogManagement.Repository.BlogRepository;
import com.blogManagement.Repository.ImageRepository;
import com.blogManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageRepository imageRepository;

    public String addUser(UserEntryDto userEntryDto){
        User user = new User();

        user.setAddress(userEntryDto.getAddress());
        user.setAge(userEntryDto.getAge());
        user.setEmail(userEntryDto.getEmail());
        user.setFirstName(userEntryDto.getFirstName());
        user.setLastName(userEntryDto.getLastName());

        userRepository.save(user);
        return "User Added Successfully.";
    }
    public UserResponseDto getUserDetails(int id) throws Exception{

        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e){
            throw new Exception("Invalid user id.");
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        Blog blog = new Blog();

        // get blog list
        List<Blog> blogList = user.getBlogList();
        List<BlogResponseDto>blogResponseDtos = new ArrayList<>();


        for (Blog b : blogList){
            BlogResponseDto blogResponseDto = new BlogResponseDto();
            blogResponseDto.setDescription(b.getDescription());
            blogResponseDto.setTitle(b.getTitle());
            blogResponseDto.setKeyWord(b.getKeyWord());
            blogResponseDto.setBlogId(b.getId());
            blogResponseDtos.add(blogResponseDto);
        }

        userResponseDto.setBlogResponseDtoList(blogResponseDtos);
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setFirstName(user.getFirstName());

        return userResponseDto;
    }

    public String updateUserAge(int id, UserAgeUpdateRequestDto userAgeUpdateRequestDto) throws Exception{

        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e){
            throw new Exception("Invalid user id.");
        }

        user.setAge(userAgeUpdateRequestDto.getAge());
        userRepository.save(user);
        return user.getFirstName() + " " + user.getLastName() + " : age has been update successfully.";
    }

    public String updateUserName(int id, UserNameUpdateRequestDto userNameUpdateRequestDto) throws Exception{

        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e){
            throw new Exception("Invalid user id.");
        }

        user.setFirstName(userNameUpdateRequestDto.getFirstName());
        user.setLastName(userNameUpdateRequestDto.getLastName());

        userRepository.save(user);
        return user.getFirstName() + " " + user.getLastName() + " : Name has been update successfully.";
    }
    public String updateUserAddress(int id, UserAddressUpdateRequestDto userAddressUpdateRequestDto) throws Exception{

        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception e){
            throw new Exception("Invalid user id.");
        }

        user.setAddress(userAddressUpdateRequestDto.getAddress());
        userRepository.save(user);

        return user.getFirstName() + " " + user.getLastName() + " : Address has been update successfully.";
    }

    public String deleteUser(int id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            return "User id does not exist!.";
        }

        return "User Deleted Successfully.";
    }

    public List<UserResponseDto> getAllUser(){
        List<User> userList = userRepository.findAll().stream().toList();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for (User user : userList){
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setAge(user.getAge());
            userResponseDto.setAddress(user.getAddress());
            userResponseDto.setLastName(user.getLastName());
            userResponseDto.setFirstName(user.getFirstName());

            int userId = user.getId();
            User user1 = userRepository.findById(userId).get();
            List<Blog> blogList = user1.getBlogList();
            List<BlogResponseDto> blogResponseDtoList = new ArrayList<>();

            for (Blog blog : blogList){
                BlogResponseDto blogResponseDto = new BlogResponseDto();
                blogResponseDto.setKeyWord(blog.getKeyWord());
                blogResponseDto.setDescription(blog.getDescription());
                blogResponseDto.setBlogId(blog.getId());
                blogResponseDto.setTitle(blog.getTitle());

                blogResponseDtoList.add(blogResponseDto);
            }

            userResponseDto.setBlogResponseDtoList(blogResponseDtoList);

            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
    }
}

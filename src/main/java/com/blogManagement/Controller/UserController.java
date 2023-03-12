package com.blogManagement.Controller;

import com.blogManagement.DTO.*;
import com.blogManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUserDetails(@RequestBody UserEntryDto userEntryDto){
        return userService.addUser(userEntryDto);
    }

    @GetMapping("/getUserDetails/{id}")
    public UserResponseDto getUserDetails(@PathVariable("id") int id) throws Exception{
        return userService.getUserDetails(id);
    }

    @PutMapping("/updateAge/{id}")
    public String updateUserAge(@PathVariable("id") int id, @RequestBody UserAgeUpdateRequestDto userAgeUpdateRequestDto) throws Exception{
        return userService.updateUserAge(id, userAgeUpdateRequestDto);
    }
    @PutMapping("/updateName/{id}")
    public String updateUserName(@PathVariable("id") int id, @RequestBody UserNameUpdateRequestDto userNameUpdateRequestDto) throws Exception{
        return userService.updateUserName(id, userNameUpdateRequestDto);
    }
    @PutMapping("/updateAddress/{id}")
    public String updateUserAddress(@PathVariable("id") int id, @RequestBody UserAddressUpdateRequestDto userAddressUpdateRequestDto) throws Exception{
        return userService.updateUserAddress(id, userAddressUpdateRequestDto);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getAllUser")
    public List<UserResponseDto> getAllUser(){
        return userService.getAllUser();
    }
}

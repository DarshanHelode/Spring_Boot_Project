package net.javaguides.springboot.controller;

import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    //Build Create User RestApi
    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user)
    {
       User savedUser= userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //build Get User By Id restApi
    @GetMapping("{id}")
    public ResponseEntity<User>getUserById(@PathVariable("id") Long userId)
    {
        User user=userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //Build Get all User Api
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User>users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //Update
    @PutMapping("{id}")
    public ResponseEntity<User>updatedUser(@PathVariable("id")Long userId, @RequestBody User user)
    {   user.setId(userId);//70 vdo
        User updatedUser= userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteUser(@PathVariable("id") Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted",HttpStatus.OK);
    }
}

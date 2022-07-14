package com.example.pedagogico_backend.controller;

import com.example.pedagogico_backend.domain.User;
import com.example.pedagogico_backend.repositories.UserRepository;
import com.example.pedagogico_backend.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/uniquecare")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {
    private final IUserService userService;
    private final UserRepository userRepository;


    @GetMapping("/user")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @PutMapping("/user/edit")
    public User updateUser (@RequestBody @Valid User user){
        userRepository.findById(user.getId()).orElseThrow(RuntimeException::new);
        return userService.updateUser(user);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}

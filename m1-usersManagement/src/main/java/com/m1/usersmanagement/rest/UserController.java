package com.m1.usersmanagement.rest;

import com.m1.usersmanagement.DTO.ResponseDTO;
import com.m1.usersmanagement.models.User;
import com.m1.usersmanagement.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(new ResponseDTO("User created successfully", userService.createUser(user), "success"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(new ResponseDTO("User updated successfully", userService.updateUser(user), "success"));
    }
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllUsers() {
        return ResponseEntity.ok(new ResponseDTO("Users fetched successfully", userService.getAllUsers(), "success"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDTO("User fetched successfully", userService.getUser(id), "success"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ResponseDTO("User deleted successfully", null, "success"));
    }
}

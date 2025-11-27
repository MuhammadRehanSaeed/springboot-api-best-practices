package com.rehancode.phase5concepts.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rehancode.phase5concepts.DTO.UserRequestDTO;
import com.rehancode.phase5concepts.DTO.Userv1DTO;
import com.rehancode.phase5concepts.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.rehancode.phase5concepts.Exception.ApiResponse;



@RestController
@RequestMapping("/api/v1/users")
public class UserControllerv1 {

    private final UserService userService;

    public UserControllerv1(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Userv1DTO>> addUser(@Valid @RequestBody UserRequestDTO dto) {
        ApiResponse<Userv1DTO> response = userService.saveUser(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Userv1DTO>>> getAllUsers() {
        ApiResponse<List<Userv1DTO>> response = userService.getAllUser();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}

    


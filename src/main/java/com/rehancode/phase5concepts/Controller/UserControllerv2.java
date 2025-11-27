package com.rehancode.phase5concepts.Controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rehancode.phase5concepts.DTO.UserRequestDTO;
import com.rehancode.phase5concepts.DTO.Userv2DTO;
import com.rehancode.phase5concepts.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.rehancode.phase5concepts.Exception.ApiResponse;


@RestController
@RequestMapping("/api/v2/users")
public class UserControllerv2 {

    private final UserService userService;

    public UserControllerv2(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Userv2DTO>> addUser(@Valid @RequestBody UserRequestDTO dto) {
        ApiResponse<Userv2DTO> response = userService.saveUserv2(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Userv2DTO>>> getAllUsers() {
        ApiResponse<List<Userv2DTO>> response = userService.getAllUserv2();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}

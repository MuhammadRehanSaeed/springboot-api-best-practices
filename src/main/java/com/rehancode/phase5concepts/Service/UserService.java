package com.rehancode.phase5concepts.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rehancode.phase5concepts.DTO.UserRequestDTO;
import com.rehancode.phase5concepts.DTO.Userv1DTO;
import com.rehancode.phase5concepts.DTO.Userv2DTO;
import com.rehancode.phase5concepts.Entity.User;
import com.rehancode.phase5concepts.Exception.ApiResponse;
import com.rehancode.phase5concepts.Exception.BadRequestException;
import com.rehancode.phase5concepts.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Convert to DTO v1
    public Userv1DTO convertToDTOv1(User user){
        Userv1DTO dto = new Userv1DTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }

    // Convert to DTO v2
    public Userv2DTO convertToDTOv2(User user){
        Userv2DTO dto = new Userv2DTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    // Convert request DTO to entity
    public User convertToEntity(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    // Save user and return ApiResponse v1
    public ApiResponse<Userv1DTO> saveUser(UserRequestDTO dto){
        if (dto.getName() == null || dto.getEmail() == null) {
            throw new BadRequestException("Name and email cannot be null");
        }
        User savedUser = userRepository.save(convertToEntity(dto));
        return new ApiResponse<>(201, true, "User saved successfully", convertToDTOv1(savedUser));
    }

    // Save user and return ApiResponse v2
    public ApiResponse<Userv2DTO> saveUserv2(UserRequestDTO dto){
        if (dto.getName() == null || dto.getEmail() == null) {
            throw new BadRequestException("Name and email cannot be null");
        }
        User savedUser = userRepository.save(convertToEntity(dto));
        return new ApiResponse<>(201, true, "User saved successfully", convertToDTOv2(savedUser));
    }

    // Get all users v1
    public ApiResponse<List<Userv1DTO>> getAllUser(){
        List<Userv1DTO> list = userRepository.findAll()
                .stream()
                .map(this::convertToDTOv1)
                .collect(Collectors.toList());
        return new ApiResponse<>(200, true, "Users fetched successfully", list);
    }

    // Get all users v2
    public ApiResponse<List<Userv2DTO>> getAllUserv2(){
        List<Userv2DTO> list = userRepository.findAll()
                .stream()
                .map(this::convertToDTOv2)
                .collect(Collectors.toList());
        return new ApiResponse<>(200, true, "Users fetched successfully", list);
    }
}

package com.example.entryassignment.domain.controller;

import com.example.entryassignment.domain.dto.request.SignUpUserRequest;
import com.example.entryassignment.domain.dto.response.MessageResponse;
import com.example.entryassignment.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponse signUp(@Validated @RequestBody SignUpUserRequest request) {
        return userService.create(request);
    }
}

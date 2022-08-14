package com.example.entryassignment.domain.service;

import com.example.entryassignment.domain.dto.request.SignUpUserRequest;
import com.example.entryassignment.domain.dto.response.MessageResponse;
import com.example.entryassignment.domain.entity.user.User;
import com.example.entryassignment.domain.entity.user.UserRepository;
import com.example.entryassignment.domain.exception.UsernameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public MessageResponse create(SignUpUserRequest request) {
        boolean isAlreadyExists = userRepository.existsByUsername(request.getAccountId());
        if (isAlreadyExists) {
            throw new UsernameAlreadyExistsException();
        }

        User user = request.toEntity();
        userRepository.save(user);
        return MessageResponse.builder()
                .message("회원가입에 성공했습니다.")
                .build();
    }
}

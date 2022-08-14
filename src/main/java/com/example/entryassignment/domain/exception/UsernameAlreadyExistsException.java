package com.example.entryassignment.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "이미 존재하는 사용자입니다.")
public class UsernameAlreadyExistsException extends RuntimeException{
}

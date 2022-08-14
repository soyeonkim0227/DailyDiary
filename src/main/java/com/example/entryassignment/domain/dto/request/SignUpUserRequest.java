package com.example.entryassignment.domain.dto.request;

import com.example.entryassignment.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpUserRequest {

    @NotEmpty
    private String accountId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    public User toEntity() {
        return User.builder()
                .username(accountId)
                .password(password)
                .name(name)
                .build();
    }

}

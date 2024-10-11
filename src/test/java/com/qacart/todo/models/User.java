package com.qacart.todo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(setterPrefix = "set")
@AllArgsConstructor
@Getter
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}

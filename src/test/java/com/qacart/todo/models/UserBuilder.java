package com.qacart.todo.models;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public User build() {
        return new User(firstName, lastName, email, password, confirmPassword);
    }
}

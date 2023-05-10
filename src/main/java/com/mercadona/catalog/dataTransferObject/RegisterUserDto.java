package com.mercadona.catalog.dataTransferObject;

import jakarta.validation.constraints.NotEmpty;

public class RegisterUserDto {

    private Long userId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    // Constructeurs de ce DTO:
    public RegisterUserDto() {
    }

    public RegisterUserDto(Long userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    //Getters/Setters de UserId:
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    //Getters/Setters de UserName:
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    //Getters/Setters de Email:
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //Getters/Setters de Password:
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}

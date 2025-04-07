package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserDto {
    @Id
    @Column (name = "user_name")
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
    public UserDto(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}

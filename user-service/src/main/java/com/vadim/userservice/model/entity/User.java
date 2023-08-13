package com.vadim.userservice.model.entity;

import com.vadim.userservice.model.enums.UserRole;
import com.vadim.userservice.model.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private String email;

    @CreatedDate
    @Column(name = "created_date")
    private String createdDate;
    private UserStatus status;
    private UserRole role;
}

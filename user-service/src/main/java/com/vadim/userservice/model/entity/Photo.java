package com.vadim.userservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String url;

    @Column(name = "is_avatar")
    private boolean isAvatar;
}

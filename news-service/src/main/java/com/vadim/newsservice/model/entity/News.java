package com.vadim.newsservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreatedDate
    private LocalDateTime time = LocalDateTime.now();

    private String title;
    private String text;

    private String username;

    @OneToMany(mappedBy = "news", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;
}

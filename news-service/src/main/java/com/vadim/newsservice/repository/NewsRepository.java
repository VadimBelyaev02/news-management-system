package com.vadim.newsservice.repository;

import com.vadim.newsservice.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsRepository extends JpaRepository<News, UUID> {
}

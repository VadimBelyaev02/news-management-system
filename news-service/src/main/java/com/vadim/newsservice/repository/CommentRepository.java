package com.vadim.newsservice.repository;

import com.vadim.newsservice.model.entity.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID>{
}

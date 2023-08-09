package com.vadim.newsservice.model.dto.response;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Value
@Builder
public class PageResponse<T> {

    Integer number;

    Integer size;

    Integer elementsAmount;

    List<T> content;

    public static <T> PageResponse<T> response(final Pageable pageable, final List<T> content) {
        return PageResponse.<T>builder()
                .size(pageable.getPageSize())
                .number(pageable.getPageNumber())
                .elementsAmount(content.size())
                .content(content)
                .build();
    }
}
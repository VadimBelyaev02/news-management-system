package com.vadim.newsservice.model.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PageResponse<T> {

    Integer number;

    Integer size;

    Integer elementsAmount;

    List<T> content;
}
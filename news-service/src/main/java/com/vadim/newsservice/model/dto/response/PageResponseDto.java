package com.vadim.newsservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PageResponseDto<T> {

    Integer number;

    Integer size;

    Integer numberOfElements;

    List<T> content;
}
package com.vadim.newsservice.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsCriteria {
    private String title;
    private String text;
    private Integer page;
    private Integer size;
}

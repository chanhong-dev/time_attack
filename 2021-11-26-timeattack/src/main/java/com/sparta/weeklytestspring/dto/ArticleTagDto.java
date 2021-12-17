package com.sparta.weeklytestspring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleTagDto {
    private Long idx;
    private String[] tags;
}

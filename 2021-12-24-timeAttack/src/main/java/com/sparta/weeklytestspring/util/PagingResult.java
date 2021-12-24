package com.sparta.weeklytestspring.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PagingResult<T> {
    private T data;
    private int count;
}


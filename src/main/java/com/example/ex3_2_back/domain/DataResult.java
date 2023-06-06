package com.example.ex3_2_back.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DataResult<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
    public final List<Object> errors = new ArrayList<>();
    public final List<Object> devMessages = new ArrayList<>();

    public static DataResult success() {
        return DataResult.builder().success(true).build();
    }

    public static DataResult success(Object data) {
        return DataResult.builder().success(true).data(data).build();
    }

    public static DataResult error(String message) {
        return DataResult.builder().success(false).message(message).build();
    }

    public DataResult addErrors(Object error) {
        errors.add(error);
        return this;
    }

    public DataResult addDevMessages(Object devMessage) {
        devMessages.add(devMessage);
        return this;
    }

}

package com.example.ex3_2_back.data;

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
public class Result {
    private boolean success;
    private int code;
    private String message;
    private Object data;
    public final List<Object> errors = new ArrayList<>();
    public final List<Object> devMessages = new ArrayList<>();

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static Result success() {
        return Result.builder().success(true).build();
    }

    public static Result success(Object data) {
        return Result.builder().success(true).data(data).build();
    }

    public static Result error(String message) {
        return Result.builder().success(false).message(message).build();
    }

    public Result addErrors(Object error) {
        errors.add(error);
        return this;
    }

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result addDevMessages(Object devMessage) {
        devMessages.add(devMessage);
        return this;
    }

}

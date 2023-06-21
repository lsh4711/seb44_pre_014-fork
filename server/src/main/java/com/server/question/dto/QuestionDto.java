package com.server.question.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

public class QuestionDto {
    @Getter
    public static class Post {
        private String title;

        @Min(1)
        private long memberId;

        @NotBlank
        private String content;
    }

    @Getter
    public static class Patch {
        private String title;

        private String content;

        private Boolean solve;
    }
}
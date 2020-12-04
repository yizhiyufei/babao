package com.babao.system.domain.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ShortAnswer {
    private String topic;
    private Double score;
    private String answer;

    public ShortAnswer(String topic, Double score, String answer) {
        this.topic = topic;
        this.score = score;
        this.answer = answer;
    }
}

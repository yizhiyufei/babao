package com.babao.system.domain.pojo;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
public class Multiple {
    private String topic;
    private Double score;
    private Set<String> options;
    private Integer[] trueKeys;

    public Multiple(String topic, Double score, Integer[] trueKeys, Set<String> options) {
        this.topic = topic;
        this.score = score;
        this.trueKeys = trueKeys;
        this.options = options;
    }

    public Multiple() {
    }
}

package com.babao.system.domain.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 选择题
 */
@Setter
@Getter
public class Select {
    private String topic;
    private Double score;
    private Set<String> options;
    private Integer trueKey;

    public Select(String topic, Double score, Integer trueKey,Set<String> options) {
        this.topic = topic;
        this.score = score;
        this.trueKey = trueKey;
        this.options = options;
    }
}

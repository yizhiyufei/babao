package com.babao.system.domain.pojo;

import lombok.Data;

import java.util.List;

/**
 * 选择题
 */
@Data
public class Select {
    private String topic;
    private Double score;
    private List<String> options;
    private Integer trueKey;

}

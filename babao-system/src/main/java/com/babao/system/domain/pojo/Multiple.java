package com.babao.system.domain.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Multiple {
    private String topic;
    private Double score;
    private List<String> options;
    private Integer[] trueKeys;
}

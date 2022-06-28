package com.example.react_aws_proj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {

    //<T>	Type
    //<E>	Element
    //<K>	Key
    //<V>	Value
    //<N>	Number

    private String error;
    private List<T> data;

}

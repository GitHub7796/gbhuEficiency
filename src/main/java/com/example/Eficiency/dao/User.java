package com.example.Eficiency.dao;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class User {

    private String adress;

    private int age;

    private final String name="二当家小D";
    static Date createTime = new Date();
}

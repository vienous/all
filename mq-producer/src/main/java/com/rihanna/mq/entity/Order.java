package com.rihanna.mq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = -3509568047940677907L;
    private String id;
    private String name;
    private String messageId; //存储消息发送的唯一id
}

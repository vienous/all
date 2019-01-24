package com.rihanna.mq.consumer;

import com.rabbitmq.client.Channel;
import com.rihanna.mq.entity.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "order-queue",durable = "true"),
                    exchange = @Exchange(name = "order-exchange",durable = "true",type = "topic"),
                    key = "order.*"
            )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload Order order,
                               @Headers Map<String,Object> heahers,
                               Channel channel) throws Exception{
        // 消费者操作
        System.out.println("订单ID"+order.getId());
        Long deliveryTag = (Long)heahers.get(AmqpHeaders.DELIVERY_TAG);
        //签收
        channel.basicAck(deliveryTag,false);
    }
}

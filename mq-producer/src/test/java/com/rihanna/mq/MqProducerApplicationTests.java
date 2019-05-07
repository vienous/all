package com.rihanna.mq;

import com.rihanna.mq.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqProducerApplicationTests {

	@Autowired
	private OrderSender orderSender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void orderSender1() throws Exception {
//        Order order = new Order();
//        order.setId("20180124");
//        order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
//        order.setName("测试订单1");
//        orderSender.send(order);
	}
}


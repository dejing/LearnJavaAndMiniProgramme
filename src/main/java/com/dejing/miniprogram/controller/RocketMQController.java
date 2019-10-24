package com.dejing.miniprogram.controller;

import com.dejing.miniprogram.config.exception.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mq")
public class RocketMQController {
  private static String ProducerGroup = "producer";
  private static String NameSrv = "192.168.23.74:9876";

  @GetMapping("/producer")
  public AjaxResponse producer()
      throws MQClientException, UnsupportedEncodingException, RemotingException,
          InterruptedException, MQBrokerException {
    // Instantiate with a producer group name.
    DefaultMQProducer producer = new DefaultMQProducer(ProducerGroup);
    // Specify name server addresses.
    producer.setNamesrvAddr(NameSrv);
    // Launch the instance.
    producer.start();
    for (int i = 0; i < 100; i++) {
      // Create a message instance, specifying topic, tag and message body.
      Message msg =
          new Message(
              "TopicTest" /* Topic */,
              "TagA" /* Tag */,
              ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */);
      // Call send message to deliver message to one of brokers.
      SendResult sendResult = producer.send(msg);
      log.info("%s%n", sendResult);
    }
    // Shut down once the producer instance is not longer in use.
    producer.shutdown();


      return AjaxResponse.success();
  }

  @GetMapping("/asyncProducer")
  public AjaxResponse asyncProducer()
      throws MQClientException, UnsupportedEncodingException, RemotingException,
          InterruptedException {
    // Instantiate with a producer group name.
    DefaultMQProducer producer = new DefaultMQProducer("ProducerGroup");
    // Specify name server addresses.
    producer.setNamesrvAddr("192.168.23.31:9876");
    // Launch the instance.
    producer.start();
    producer.setRetryTimesWhenSendAsyncFailed(0);
    for (int i = 0; i < 100; i++) {
      final int index = i;
      // Create a message instance, specifying topic, tag and message body.
      Message msg =
          new Message(
              "TopicTest",
              "TagA",
              "OrderID188",
              "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
      producer.send(
          msg,
          new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
              log.info("%-10d OK %s %n", index, sendResult.getMsgId());
            }

            @Override
            public void onException(Throwable e) {
              log.info("%-10d Exception %s %n", index, e);
              e.printStackTrace();
            }
          });
    }
    // Shut down once the producer instance is not longer in use.
    producer.shutdown();

      return AjaxResponse.success();

  }

  @GetMapping("/consumer")
  public AjaxResponse consumer() throws MQClientException {
    // Instantiate with specified consumer group name.
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(ProducerGroup);

    // Specify name server addresses.
    consumer.setNamesrvAddr(NameSrv);

    // Subscribe one more more topics to consume.
    consumer.subscribe("TopicTest", "*");
    // Register callback to execute on arrival of messages fetched from brokers.
    consumer.registerMessageListener(
        new MessageListenerConcurrently() {

          @Override
          public ConsumeConcurrentlyStatus consumeMessage(
              List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            log.info("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
          }
        });

    // Launch the consumer instance.
    consumer.start();

    log.info("Consumer Started.%n");

      return AjaxResponse.success();

  }
}

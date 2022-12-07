package com.rekeningrijden.taxservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.queue.create.name}")
    private String createQueue;

    @Value("${rabbitmq.queue.update.name}")
    private String updateQueue;

    @Value("${rabbitmq.queue.delete.name}")
    private String deleteQueue;

    @Value("${rabbitmq.routing.create.key}")
    private String createKey;

    @Value("${rabbitmq.routing.update.key}")
    private String updateKey;

    @Value("${rabbitmq.routing.delete.key}")
    private String deleteKey;

    // spring bean for create queue
    @Bean
    public Queue createQueue(){
        return new Queue(createQueue);
    }

    // spring bean for update queue
    @Bean
    public Queue updateQueue(){
        return new Queue(updateQueue);
    }

    // spring bean for delete queue
    @Bean
    public Queue deleteQueue(){
        return new Queue(deleteQueue);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    // binding between create queue and exchange using routing key
    @Bean
    public Binding createBinding(){
        return BindingBuilder
                .bind(createQueue())
                .to(exchange())
                .with(createKey);
    }

    // binding between update queue and exchange using routing key
    @Bean
    public Binding updateBinding(){
        return BindingBuilder
                .bind(updateQueue())
                .to(exchange())
                .with(updateKey);
    }

    // binding between delete queue and exchange using routing key
    @Bean
    public Binding deleteBinding(){
        return BindingBuilder
                .bind(updateQueue())
                .to(exchange())
                .with(deleteKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}

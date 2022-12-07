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

    @Value("${rabbitmq.queue.baseprice.create.name}")
    private String createBasePriceQueue;

    @Value("${rabbitmq.queue.baseprice.update.name}")
    private String updateBasePriceQueue;

    @Value("${rabbitmq.queue.baseprice.delete.name}")
    private String deleteBasePriceQueue;

    @Value("${rabbitmq.queue.roadtax.create.name}")
    private String createRoadTaxQueue;

    @Value("${rabbitmq.queue.roadtax.update.name}")
    private String updateRoadTaxQueue;

    @Value("${rabbitmq.queue.roadtax.delete.name}")
    private String deleteRoadTaxQueue;


    @Value("${rabbitmq.routing.baseprice.create.key}")
    private String createBasePriceKey;

    @Value("${rabbitmq.routing.baseprice.update.key}")
    private String updateBasePriceKey;

    @Value("${rabbitmq.routing.baseprice.delete.key}")
    private String deleteBasePriceKey;

    @Value("${rabbitmq.routing.roadtax.create.key}")
    private String createRoadTaxKey;

    @Value("${rabbitmq.routing.roadtax.update.key}")
    private String updateRoadTaxKey;

    @Value("${rabbitmq.routing.roadtax.delete.key}")
    private String deleteRoadTaxKey;


    @Value("${rabbitmq.queue.timetax.update.name}")
    private String updateTimeTaxQueue;

    @Value("${rabbitmq.routing.timetax.update.key}")
    private String updateTimeTaxKey;

    // spring bean for create queue
    @Bean
    public Queue createBasePriceQueue(){
        return new Queue(createBasePriceQueue);
    }

    // spring bean for create queue
    @Bean
    public Queue createRoadTaxQueue(){
        return new Queue(createRoadTaxQueue);
    }

    // spring bean for update queue
    @Bean
    public Queue updateBasePriceQueue(){
        return new Queue(updateBasePriceQueue);
    }

    // spring bean for update queue
    @Bean
    public Queue updateRoadTaxQueue(){
        return new Queue(updateRoadTaxQueue);
    }

    // spring bean for update queue
    @Bean
    public Queue updateTimeTaxQueue(){
        return new Queue(updateTimeTaxQueue);
    }

    // spring bean for delete queue
    @Bean
    public Queue deleteBasePriceQueue(){
        return new Queue(deleteBasePriceQueue);
    }

    // spring bean for delete queue
    @Bean
    public Queue deleteRoadTaxQueue(){
        return new Queue(deleteRoadTaxQueue);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    // binding between create queue and exchange using routing key
    @Bean
    public Binding createBasePriceBinding(){
        return BindingBuilder
                .bind(createBasePriceQueue())
                .to(exchange())
                .with(createBasePriceKey);
    }

    // binding between update queue and exchange using routing key
    @Bean
    public Binding updateBasePriceBinding(){
        return BindingBuilder
                .bind(updateBasePriceQueue())
                .to(exchange())
                .with(updateBasePriceKey);
    }

    // binding between delete queue and exchange using routing key
    @Bean
    public Binding deleteBasePriceBinding(){
        return BindingBuilder
                .bind(deleteBasePriceQueue())
                .to(exchange())
                .with(deleteBasePriceKey);
    }

    @Bean
    public Binding createRoadTaxBinding(){
        return BindingBuilder
                .bind(createRoadTaxQueue())
                .to(exchange())
                .with(createRoadTaxKey);
    }

    // binding between update queue and exchange using routing key
    @Bean
    public Binding updateRoadTaxBinding(){
        return BindingBuilder
                .bind(updateRoadTaxQueue())
                .to(exchange())
                .with(updateRoadTaxKey);
    }

    // binding between delete queue and exchange using routing key
    @Bean
    public Binding deleteRoadTaxBinding(){
        return BindingBuilder
                .bind(deleteRoadTaxQueue())
                .to(exchange())
                .with(deleteRoadTaxKey);
    }

    // binding between delete queue and exchange using routing key
    @Bean
    public Binding updateTimeTaxBinding(){
        return BindingBuilder
                .bind(updateTimeTaxQueue())
                .to(exchange())
                .with(updateTimeTaxKey);
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

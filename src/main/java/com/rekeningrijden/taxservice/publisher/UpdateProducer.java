package com.rekeningrijden.taxservice.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rekeningrijden.taxservice.dto.BasePriceDto;
import com.rekeningrijden.taxservice.dto.RoadTaxDto;
import com.rekeningrijden.taxservice.dto.TimeTaxDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UpdateProducer {

    ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.baseprice.update.key}")
    private String basePriceRoutingKey;

    @Value("${rabbitmq.routing.roadtax.update.key}")
    private String roadTaxRoutingKey;

    @Value("${rabbitmq.routing.timetax.update.key}")
    private String timeTaxRoutingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateProducer.class);

    private RabbitTemplate rabbitTemplate;

    public UpdateProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(BasePriceDto basePriceDto) {
        try{
            String message = mapper.writeValueAsString(basePriceDto);
            rabbitTemplate.convertAndSend(exchange, basePriceRoutingKey, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(RoadTaxDto roadTaxDto) {
        try{
            String message = mapper.writeValueAsString(roadTaxDto);
            rabbitTemplate.convertAndSend(exchange, roadTaxRoutingKey, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(TimeTaxDto timeTaxDto) {
        try {
            String message = mapper.writeValueAsString(timeTaxDto);
            rabbitTemplate.convertAndSend(exchange, timeTaxRoutingKey, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

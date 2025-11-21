package br.com.warehouse.config;

import lombok.Value;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class AMQPConfig {

    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory,
                                  final Jackson2JsonMessageConverter converter) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    Queue queue(@Value("${spring.rabbitmq.queue.product-change-availability}") final String name){
        return new Queue(name, true);
    }

    @Bean
    DirectExchange exchange(@Value("${spring.rabbitmq.queue.product-change-availability}") final String name){
        return new DirectExchange(name);
    }

    @Bean
    Binding binding(final Queue queue,
                    final DirectExchange exchange,
                    @Value("${spring.rabbitmq.queue.product-change-availability}")
                    final String name) {
        return BindingBuilder.bind(queue).to(exchange).with(name);
    }

}


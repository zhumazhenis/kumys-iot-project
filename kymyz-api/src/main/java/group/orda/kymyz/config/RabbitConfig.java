package group.orda.kymyz.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String KYMYZ_DIRECT_EXCHANGE = "";

    public static final String ORDERS_QUEUE = "orders";
    public static final String ORDERS_ROUTING_KEY = "orders";

    @Bean
    public DirectExchange kymyzExchange() {
        return new DirectExchange(KYMYZ_DIRECT_EXCHANGE);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setCreateMessageIds(Boolean.TRUE);
        return converter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        rabbitTemplate.setExchange(KYMYZ_DIRECT_EXCHANGE);
        return rabbitTemplate;
    }

    @Bean
    public Queue ordersQueue() {
        return new Queue(ORDERS_QUEUE);
    }

    @Bean
    public Binding ordersBinding() {
        return BindingBuilder.bind(ordersQueue()).to(kymyzExchange()).with(ORDERS_ROUTING_KEY);
    }

}

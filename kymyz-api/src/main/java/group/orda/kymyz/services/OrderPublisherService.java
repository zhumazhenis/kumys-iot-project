package group.orda.kymyz.services;

import group.orda.kymyz.config.RabbitConfig;
import group.orda.kymyz.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public void publishOrder(Order order) {
        Map<String, Object> orderJson = new HashMap<>();
        orderJson.put("id", order.getId());
        orderJson.put("fullCups", order.getFullCups());
        orderJson.put("halfCups", order.getHalfCups());
        orderJson.put("status", order.getStatus());
        rabbitTemplate.convertAndSend(RabbitConfig.ORDERS_ROUTING_KEY, orderJson);
    }
}

package group.orda.kymyz.services;

import group.orda.kymyz.beans.OrderBean;
import group.orda.kymyz.mappers.OrderMapper;
import group.orda.kymyz.models.Order;
import group.orda.kymyz.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public Page<OrderBean> getAllOrders(Integer page, Integer size) {
        Page<Order> orderPage = orderRepository.findAll(PageRequest.of(page, size));
        return orderPage.map(orderMapper::toOrderBean);
    }

    public OrderBean save(OrderBean orderBean) {
        Order order = orderMapper.toOrder(orderBean);
        orderRepository.save(order);
        return orderMapper.toOrderBean(order);
    }
}

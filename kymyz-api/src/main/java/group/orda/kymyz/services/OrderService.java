package group.orda.kymyz.services;

import group.orda.kymyz.beans.OrderBean;
import group.orda.kymyz.beans.OrderEntryBean;
import group.orda.kymyz.mappers.OrderEntryMapper;
import group.orda.kymyz.mappers.OrderMapper;
import group.orda.kymyz.models.Order;
import group.orda.kymyz.models.OrderEntry;
import group.orda.kymyz.repositories.OrderEntryRepository;
import group.orda.kymyz.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEntryRepository orderEntryRepository;
    private final OrderMapper orderMapper;
    private final OrderEntryMapper orderEntryMapper;
    private final OrderPublisherService orderPublisherService;

    public Page<OrderBean> getAllOrders(Integer page, Integer size) {
        Page<Order> orderPage = orderRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
        return orderPage.map(orderMapper::toOrderBean);
    }

    public OrderBean save(OrderBean orderBean) {
        Order order = orderMapper.toOrder(orderBean);
        orderRepository.save(order);
        if (orderBean.getId() == null) {
            orderPublisherService.publishOrder(order);
        }
        return orderMapper.toOrderBean(order);
    }

    public List<OrderEntryBean> getAllOrderEntriesByOrderId(Long orderId) {
        List<OrderEntry> orderEntries = orderEntryRepository.findAllByOrderId(
                orderId,
                Sort.by(Sort.Direction.DESC, "type").and(Sort.by("index"))
        );
        return orderEntries.stream().map(orderEntryMapper::toOrderEntryBean).collect(Collectors.toList());
    }
}

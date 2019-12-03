package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.OrderEntryBean;
import group.orda.kymyz.models.Order;
import group.orda.kymyz.models.OrderEntry;
import group.orda.kymyz.repositories.OrderRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderEntryMapper {

    @Autowired
    private OrderRepository orderRepository;

    public abstract OrderEntry toOrderEntry(OrderEntryBean orderEntryBean);

    @AfterMapping
    protected void afterToOrderEntry(OrderEntryBean orderEntryBean, @MappingTarget OrderEntry orderEntry) {
        Order order = orderRepository.findById(orderEntryBean.getOrderId()).get();
        orderEntry.setOrder(order);
    }

    @Mappings({
            @Mapping(target = "orderId", source = "order.id")
    })
    public abstract OrderEntryBean toOrderEntryBean(OrderEntry orderEntry);

}

package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.OrderBean;
import group.orda.kymyz.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    public abstract OrderBean toOrderBean(Order order);

    public abstract Order toOrder(OrderBean orderBean);
}

package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.OrderBean;
import group.orda.kymyz.models.Order;
import group.orda.kymyz.models.OrderEntry;
import group.orda.kymyz.repositories.OrderEntryRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @Autowired
    private OrderEntryRepository orderEntryRepository;

    public abstract OrderBean toOrderBean(Order order);

    public abstract Order toOrder(OrderBean orderBean);

//    public abstract OrderViewBean toOrderViewBean(Order order);

    // TODO: create view in SQL
//    @AfterMapping
//    protected void afterToOrderViewBean(Order order, @MappingTarget OrderViewBean orderViewBean) {
//        List<OrderEntry> orderEntries = orderEntryRepository.findAllByOrderId(order.getId());
//
//        Long halfInqueueCount = orderEntries.stream().filter(oe -> OrderEntry.Status.INQUEUE.equals(oe.getStatus()) && OrderEntry.Type.HALF.equals(oe.getType())).count();
//        Long halfPutCount = orderEntries.stream().filter(oe -> OrderEntry.Status.PUT.equals(oe.getStatus()) && OrderEntry.Type.HALF.equals(oe.getType())).count();
//        Long halfFilledCount = orderEntries.stream().filter(oe -> OrderEntry.Status.FILLED.equals(oe.getStatus()) && OrderEntry.Type.HALF.equals(oe.getType())).count();
//        Long halfSortedCount = orderEntries.stream().filter(oe -> OrderEntry.Status.SORTED.equals(oe.getStatus()) && OrderEntry.Type.HALF.equals(oe.getType())).count();
//
//        Long fullInqueueCount = orderEntries.stream().filter(oe -> OrderEntry.Status.INQUEUE.equals(oe.getStatus()) && OrderEntry.Type.FULL.equals(oe.getType())).count();
//        Long fullPutCount = orderEntries.stream().filter(oe -> OrderEntry.Status.PUT.equals(oe.getStatus()) && OrderEntry.Type.FULL.equals(oe.getType())).count();
//        Long fullFilledCount = orderEntries.stream().filter(oe -> OrderEntry.Status.FILLED.equals(oe.getStatus()) && OrderEntry.Type.FULL.equals(oe.getType())).count();
//        Long fullSortedCount = orderEntries.stream().filter(oe -> OrderEntry.Status.SORTED.equals(oe.getStatus()) && OrderEntry.Type.FULL.equals(oe.getType())).count();
//
//        orderViewBean.setHalfInqueueCount(halfInqueueCount);
//        orderViewBean.setHalfPutCount(halfPutCount);
//        orderViewBean.setHalfFilledCount(halfFilledCount);
//        orderViewBean.setHalfSortedCount(halfSortedCount);
//
//        orderViewBean.setFullInqueueCount(fullInqueueCount);
//        orderViewBean.setFullPutCount(fullPutCount);
//        orderViewBean.setFullFilledCount(fullFilledCount);
//        orderViewBean.setFullSortedCount(fullSortedCount);
//    }
}

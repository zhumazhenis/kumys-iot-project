package group.orda.kymyz.services;

import group.orda.kymyz.beans.OrderEntryBean;
import group.orda.kymyz.mappers.OrderEntryMapper;
import group.orda.kymyz.models.OrderEntry;
import group.orda.kymyz.repositories.OrderEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEntryService {

    private final OrderEntryRepository orderEntryRepository;
    private final OrderEntryMapper orderEntryMapper;

    public OrderEntryBean save(OrderEntryBean orderEntryBean) {
        OrderEntry orderEntry = orderEntryRepository.findFirstByOrderIdAndIndex(orderEntryBean.getOrderId(), orderEntryBean.getIndex()).orElse(null);
        if (orderEntry == null) {
            orderEntry = orderEntryMapper.toOrderEntry(orderEntryBean);
            orderEntryRepository.save(orderEntry);
            return orderEntryMapper.toOrderEntryBean(orderEntry);
        } else {
            OrderEntry.Status status = OrderEntry.Status.valueOf(orderEntryBean.getStatus());
            orderEntry.setStatus(status);
        }
        orderEntryRepository.save(orderEntry);
        return orderEntryMapper.toOrderEntryBean(orderEntry);
    }
}

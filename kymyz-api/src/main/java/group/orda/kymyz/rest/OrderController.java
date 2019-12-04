package group.orda.kymyz.rest;

import group.orda.kymyz.beans.ListResponse;
import group.orda.kymyz.beans.OrderBean;
import group.orda.kymyz.beans.OrderEntryBean;
import group.orda.kymyz.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<Page<OrderBean>> getAllOrders(@RequestParam Integer page, @RequestParam Integer size) {
        Page<OrderBean> orderBeanPage = orderService.getAllOrders(page, size);
        return ResponseEntity.ok(orderBeanPage);
    }

    @GetMapping("/orders/{orderId}/order-entries")
    public ResponseEntity<ListResponse<OrderEntryBean>> getAllOrderEntriesByOrderId(@PathVariable Long orderId) {
        List<OrderEntryBean> orderEntryBeans = orderService.getAllOrderEntriesByOrderId(orderId);
        return ResponseEntity.ok(new ListResponse<>(orderEntryBeans));
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderBean> save(@RequestBody OrderBean orderBean) {
        OrderBean ob = orderService.save(orderBean);
        return ResponseEntity.ok(ob);
    }
}

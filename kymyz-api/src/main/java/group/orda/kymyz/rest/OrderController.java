package group.orda.kymyz.rest;

import group.orda.kymyz.beans.OrderBean;
import group.orda.kymyz.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<Page<OrderBean>> getAllOrders(@RequestParam Integer page, @RequestParam Integer size) {
        Page<OrderBean> orderBeanPage = orderService.getAllOrders(page, size);
        return ResponseEntity.ok(orderBeanPage);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderBean> save(@RequestBody OrderBean orderBean) {
        OrderBean ob = orderService.save(orderBean);
        return ResponseEntity.ok(ob);
    }
}

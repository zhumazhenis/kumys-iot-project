package group.orda.kymyz.rest;

import group.orda.kymyz.beans.OrderEntryBean;
import group.orda.kymyz.services.OrderEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderEntryController {

    private final OrderEntryService orderEntryService;

    @PostMapping("/order-entries")
    public ResponseEntity<OrderEntryBean> save(@RequestBody OrderEntryBean orderEntryBean) {
        OrderEntryBean oeb = orderEntryService.save(orderEntryBean);
        return ResponseEntity.ok(oeb);
    }
}

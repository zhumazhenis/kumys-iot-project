package group.orda.kymyz.rest;

import group.orda.kymyz.beans.MeasurementBean;
import group.orda.kymyz.services.MeasurementService;
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
public class MeasurementController {

    private final MeasurementService measurementService;

    @GetMapping("/measurements")
    public ResponseEntity<Page<MeasurementBean>> getAllMeasurements(@RequestParam Integer page, @RequestParam Integer size) {
        Page<MeasurementBean> measurementBeanPage = measurementService.getAllMeasurements(page, size);
        return ResponseEntity.ok(measurementBeanPage);
    }

    @PostMapping("/measurements")
    public ResponseEntity<MeasurementBean> save(@RequestBody MeasurementBean measurementBean) {
        MeasurementBean mb = measurementService.save(measurementBean);
        return ResponseEntity.ok(mb);
    }
}

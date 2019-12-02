package group.orda.kymyz.rest;

import group.orda.kymyz.beans.ProcessBean;
import group.orda.kymyz.services.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    @GetMapping("/processes")
    public ResponseEntity<Page<ProcessBean>> getAllProcesses(@RequestParam Integer page, @RequestParam Integer size) {
        Page<ProcessBean> processBeans = processService.getAllProcesses(page, size);
        return ResponseEntity.ok(processBeans);
    }
}

package group.orda.kymyz.rest;

import group.orda.kymyz.beans.InstructionBean;
import group.orda.kymyz.services.InstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstructionController {

    private final InstructionService instructionService;

    @GetMapping("/instructions")
    public ResponseEntity<Page<InstructionBean>> getAllInstructions(@RequestParam Integer page, @RequestParam Integer size) {
        Page<InstructionBean> instructionBeanPage = instructionService.getAllInstructions(page, size);
        return ResponseEntity.ok(instructionBeanPage);
    }
}

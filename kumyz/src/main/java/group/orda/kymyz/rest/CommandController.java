package group.orda.kymyz.rest;

import group.orda.kymyz.beans.CommandBean;
import group.orda.kymyz.services.CommandService;
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
public class CommandController {

    private final CommandService commandService;

    @GetMapping("/commands")
    public ResponseEntity<Page<CommandBean>> getAllCommands(@RequestParam Integer page, @RequestParam Integer size) {
        Page<CommandBean> commandBeanPage = commandService.getAllCommands(page, size);
        return ResponseEntity.ok(commandBeanPage);
    }
}

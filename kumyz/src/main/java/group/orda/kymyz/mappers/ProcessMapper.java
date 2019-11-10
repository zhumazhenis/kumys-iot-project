package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.CommandBean;
import group.orda.kymyz.beans.ProcessBean;
import group.orda.kymyz.models.Command;
import group.orda.kymyz.models.Process;
import group.orda.kymyz.repositories.CommandRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProcessMapper {

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private CommandMapper commandMapper;

    public abstract ProcessBean toProcessBean(Process process);

    @AfterMapping
    void afterToProcessBean(Process process, @MappingTarget ProcessBean processBean) {
        List<Command> commands = commandRepository.findAllByProcessId(process.getId());
        List<CommandBean> commandBeans = commands.stream().map(commandMapper::toCommandBean).collect(Collectors.toList());
        processBean.setCommands(commandBeans);
    }
}

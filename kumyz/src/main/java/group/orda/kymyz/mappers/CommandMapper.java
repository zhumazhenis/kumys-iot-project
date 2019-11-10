package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.CommandBean;
import group.orda.kymyz.beans.CommandParameterBean;
import group.orda.kymyz.models.Command;
import group.orda.kymyz.models.CommandParameter;
import group.orda.kymyz.repositories.CommandParameterRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {InstructionMapper.class, ProcessMapper.class})
public abstract class CommandMapper {

    @Autowired
    private CommandParameterRepository commandParameterRepository;

    @Autowired
    private CommandParameterMapper commandParameterMapper;

    @Mappings({
            @Mapping(target = "processId", source = "process.id"),
            @Mapping(target = "instructionId", source = "instruction.id")
    })
    public abstract CommandBean toCommandBean(Command command);

    @AfterMapping
    void afterToCommandBean(Command command, @MappingTarget CommandBean commandBean) {
        List<CommandParameter> commandParameters = commandParameterRepository.findAllByCommandId(command.getId());
        List<CommandParameterBean> commandParameterBeans = commandParameters.stream().map(commandParameterMapper::toCommandParameterBean).collect(Collectors.toList());
        commandBean.setParameters(commandParameterBeans);
    }
}

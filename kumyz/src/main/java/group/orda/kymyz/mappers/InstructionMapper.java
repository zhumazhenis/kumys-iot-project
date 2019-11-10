package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.InstructionBean;
import group.orda.kymyz.beans.InstructionPropertyBean;
import group.orda.kymyz.models.Instruction;
import group.orda.kymyz.models.InstructionProperty;
import group.orda.kymyz.repositories.InstructionPropertyRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class InstructionMapper {

    @Autowired
    private InstructionPropertyRepository instructionPropertyRepository;

    @Autowired
    private InstructionPropertyMapper instructionPropertyMapper;

    public abstract InstructionBean toInstructionBean(Instruction instruction);

    @AfterMapping
    void afterToInstructionBean(Instruction instruction, @MappingTarget InstructionBean instructionBean) {
        List<InstructionProperty> instructionProperties = instructionPropertyRepository.findAllByInstructionId(instruction.getId());
        List<InstructionPropertyBean> instructionPropertyBeans = instructionProperties.stream().map(instructionPropertyMapper::toInstructionPropertyBean).collect(Collectors.toList());
        instructionBean.setProperties(instructionPropertyBeans);
    }
}

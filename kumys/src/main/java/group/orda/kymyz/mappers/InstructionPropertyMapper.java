package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.InstructionPropertyBean;
import group.orda.kymyz.models.InstructionProperty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class InstructionPropertyMapper {
    @Mappings({
            @Mapping(target = "instructionId", source = "instruction.id")
    })
    public abstract InstructionPropertyBean toInstructionPropertyBean(InstructionProperty instructionProperty);
}

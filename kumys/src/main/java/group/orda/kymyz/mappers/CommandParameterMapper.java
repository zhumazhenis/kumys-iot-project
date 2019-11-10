package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.CommandParameterBean;
import group.orda.kymyz.models.CommandParameter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class CommandParameterMapper {

    @Mappings({
            @Mapping(target = "commandId", source = "command.id"),
            @Mapping(target = "instructionPropertyId", source = "instructionProperty.id")
    })
    public abstract CommandParameterBean toCommandParameterBean(CommandParameter commandParameter);
}

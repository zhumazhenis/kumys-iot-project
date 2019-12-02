package group.orda.kymyz.beans;

import lombok.Data;

@Data
public class CommandParameterBean {
    private Long id;
    private Long commandId;
    private Long instructionPropertyId;
    private String value;
}

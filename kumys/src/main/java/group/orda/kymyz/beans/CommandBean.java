package group.orda.kymyz.beans;

import group.orda.kymyz.models.CommandParameter;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class CommandBean {
    private Long id;
    private Long instructionId;
    private Long processId;
    private Date date;
    private String status;
    private List<CommandParameterBean> parameters = new LinkedList<>();
}

package group.orda.kymyz.beans;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class ProcessBean {
    private Long id;
    private Date date;
    private List<CommandBean> commands = new LinkedList<>();
}

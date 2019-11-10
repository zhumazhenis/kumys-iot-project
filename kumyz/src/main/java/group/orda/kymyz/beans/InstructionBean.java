package group.orda.kymyz.beans;

import lombok.Data;

import java.util.List;

@Data
public class InstructionBean {
    private Long id;
    private String name;
    private List<InstructionPropertyBean> properties;
}

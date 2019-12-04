package group.orda.kymyz.beans;

import lombok.Data;

import java.util.Date;

@Data
public class OrderBean {
    private Long id;
    private String status;
    private Date date;
    private Long fullCups;
    private Long halfCups;
}

package group.orda.kymyz.beans;

import lombok.Data;

import java.util.Date;

@Data
public class OrderBean {
    private Long id;
    private Integer numberOfCups;
    private Double volume;
    private Date date;
    private String status;
}

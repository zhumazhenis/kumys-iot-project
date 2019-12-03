package group.orda.kymyz.beans;

import lombok.Data;

@Data
public class OrderEntryBean {
    private Long id;
    private Long index;
    private String type;
    private String status;
    private Long orderId;
}

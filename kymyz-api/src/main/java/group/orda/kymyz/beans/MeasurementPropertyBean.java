package group.orda.kymyz.beans;

import lombok.Data;

@Data
public class MeasurementPropertyBean {
    private Long id;
    private Long measurementId;
    private String name;
    private String value;
}

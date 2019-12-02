package group.orda.kymyz.beans;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class MeasurementBean {
    private Long id;
    private Date date;
    private List<MeasurementPropertyBean> properties = new LinkedList<>();
}

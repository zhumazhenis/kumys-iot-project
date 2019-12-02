package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.MeasurementPropertyBean;
import group.orda.kymyz.models.Measurement;
import group.orda.kymyz.models.MeasurementProperty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class MeasurementPropertyMapper {

    @Mappings({
            @Mapping(target = "measurementId", source = "measurement.id")
    })
    public abstract MeasurementPropertyBean toMeasurementPropertyBean(MeasurementProperty measurementProperty);

    @Mappings({
            @Mapping(target = "id", source = "measurementPropertyBean.id"),
            @Mapping(target = "name", source = "measurementPropertyBean.name"),
            @Mapping(target = "value", source = "measurementPropertyBean.value"),
            @Mapping(target = "measurement", source = "measurement")
    })
    public abstract MeasurementProperty toMeasurementProperty(MeasurementPropertyBean measurementPropertyBean, Measurement measurement);
}

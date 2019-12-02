package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.MeasurementPropertyBean;
import group.orda.kymyz.models.Measurement;
import group.orda.kymyz.models.MeasurementProperty;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class MeasurementPropertyMapper {
    public abstract MeasurementPropertyBean toMeasurementPropertyBean(MeasurementProperty measurementProperty);

    public abstract MeasurementProperty toMeasurementProperty(MeasurementPropertyBean measurementPropertyBean, Measurement measurement);

    public void afterToMeasurementProperty(MeasurementPropertyBean measurementPropertyBean, Measurement measurement, @MappingTarget MeasurementProperty measurementProperty) {
        measurementProperty.setMeasurement(measurement);
    }
}

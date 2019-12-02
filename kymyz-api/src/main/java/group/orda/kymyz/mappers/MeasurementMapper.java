package group.orda.kymyz.mappers;

import group.orda.kymyz.beans.MeasurementBean;
import group.orda.kymyz.beans.MeasurementPropertyBean;
import group.orda.kymyz.models.Measurement;
import group.orda.kymyz.models.MeasurementProperty;
import group.orda.kymyz.repositories.MeasurementPropertyRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class MeasurementMapper {

    @Autowired
    private MeasurementPropertyRepository measurementPropertyRepository;

    @Autowired
    private MeasurementPropertyMapper measurementPropertyMapper;

    public abstract MeasurementBean toMeasurementBean(Measurement measurement);

    @AfterMapping
    protected void afterToMeasurementBean(Measurement measurement, @MappingTarget MeasurementBean measurementBean) {
        List<MeasurementProperty> measurementProperties = measurementPropertyRepository.findAllByMeasurementId(measurement.getId());
        List<MeasurementPropertyBean> measurementPropertyBeans = measurementProperties.stream().map(measurementPropertyMapper::toMeasurementPropertyBean).collect(Collectors.toList());
        measurementBean.setProperties(measurementPropertyBeans);
    }

    public abstract Measurement toMeasurement(MeasurementBean measurementBean);
}

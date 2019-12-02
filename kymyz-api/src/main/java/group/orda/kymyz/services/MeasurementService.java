package group.orda.kymyz.services;

import group.orda.kymyz.beans.MeasurementBean;
import group.orda.kymyz.beans.MeasurementPropertyBean;
import group.orda.kymyz.mappers.MeasurementMapper;
import group.orda.kymyz.mappers.MeasurementPropertyMapper;
import group.orda.kymyz.models.Measurement;
import group.orda.kymyz.models.MeasurementProperty;
import group.orda.kymyz.repositories.MeasurementPropertyRepository;
import group.orda.kymyz.repositories.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementPropertyRepository measurementPropertyRepository;
    private final MeasurementMapper measurementMapper;
    private final MeasurementPropertyMapper measurementPropertyMapper;

    public Page<MeasurementBean> getAllMeasurements(Integer page, Integer size) {
        Page<Measurement> measurementPage = measurementRepository.findAll(PageRequest.of(page, size));
        return measurementPage.map(measurementMapper::toMeasurementBean);
    }

    public MeasurementBean save(MeasurementBean measurementBean) {
        Measurement measurement = measurementMapper.toMeasurement(measurementBean);
        measurementRepository.save(measurement);
        List<MeasurementPropertyBean> propertyBeans = measurementBean.getProperties();
        List<MeasurementProperty> properties = propertyBeans.stream().map(pb -> measurementPropertyMapper.toMeasurementProperty(pb, measurement)).collect(Collectors.toList());
        measurementPropertyRepository.saveAll(properties);
        return measurementMapper.toMeasurementBean(measurement);
    }
}

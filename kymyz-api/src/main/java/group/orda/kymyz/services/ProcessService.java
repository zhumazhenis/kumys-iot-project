package group.orda.kymyz.services;

import group.orda.kymyz.beans.ProcessBean;
import group.orda.kymyz.mappers.ProcessMapper;
import group.orda.kymyz.models.Process;
import group.orda.kymyz.repositories.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final ProcessRepository processRepository;
    private final ProcessMapper processMapper;

    public Page<ProcessBean> getAllProcesses(Integer page, Integer size) {
        Page<Process> processes = processRepository.findAll(PageRequest.of(page, size));
        return processes.map(processMapper::toProcessBean);
    }
}

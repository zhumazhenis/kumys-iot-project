package group.orda.kymyz.services;

import group.orda.kymyz.beans.InstructionBean;
import group.orda.kymyz.mappers.InstructionMapper;
import group.orda.kymyz.models.Instruction;
import group.orda.kymyz.repositories.InstructionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructionService {

    private final InstructionRepository instructionRepository;
    private final InstructionMapper instructionMapper;

    public Page<InstructionBean> getAllInstructions(Integer page, Integer size) {
        Page<Instruction> instructionPage = instructionRepository.findAll(PageRequest.of(page, size));
        return instructionPage.map(instructionMapper::toInstructionBean);
    }
}

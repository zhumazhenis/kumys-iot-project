package group.orda.kymyz.services;

import group.orda.kymyz.beans.CommandBean;
import group.orda.kymyz.mappers.CommandMapper;
import group.orda.kymyz.repositories.CommandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandService {

    private final CommandRepository commandRepository;
    private final CommandMapper commandMapper;

    public CommandBean save(CommandBean commandBean) {
        return null;
    }
}

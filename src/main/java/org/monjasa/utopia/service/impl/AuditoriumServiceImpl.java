package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.auditorium.Auditorium;
import org.monjasa.utopia.dto.auditorium.request.AuditoriumRequest;
import org.monjasa.utopia.repository.AuditoriumRepository;
import org.monjasa.utopia.service.AuditoriumService;
import org.monjasa.utopia.util.mapper.AuditoriumMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    private final AuditoriumMapper auditoriumMapper;

    @Override
    public void create(AuditoriumRequest request) {
        Auditorium auditorium = auditoriumMapper.toEntity(request);
        auditoriumRepository.save(auditorium);
    }
}

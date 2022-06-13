package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;
import org.monjasa.utopia.repository.AuditoriumSeatRepository;
import org.monjasa.utopia.service.AuditoriumSeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditoriumSeatServiceImpl implements AuditoriumSeatService {

    private final AuditoriumSeatRepository auditoriumSeatRepository;

    @Override
    public List<AuditoriumSeat> getAllByIds(List<Long> ids) {
        return auditoriumSeatRepository.findAllById(ids);
    }
}

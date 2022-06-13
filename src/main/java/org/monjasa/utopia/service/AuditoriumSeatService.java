package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.auditorium.AuditoriumSeat;

import java.util.List;

public interface AuditoriumSeatService {

    List<AuditoriumSeat> getAllByIds(List<Long> ids);

}

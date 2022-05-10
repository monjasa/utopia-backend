package org.monjasa.utopia.util.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.monjasa.utopia.domain.Auditorium;
import org.monjasa.utopia.dto.request.AuditoriumRequest;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface AuditoriumMapper {

    Auditorium toEntity(AuditoriumRequest request);

}

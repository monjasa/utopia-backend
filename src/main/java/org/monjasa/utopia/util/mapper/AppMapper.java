package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.utopia.domain.App;
import org.monjasa.utopia.dto.AppDto;
import org.monjasa.utopia.dto.request.AppRequest;

@Mapper
public interface AppMapper {

    AppDto toDto(App app);

    App toEntity(AppRequest request);

}

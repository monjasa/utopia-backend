package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.App;
import org.monjasa.utopia.dto.AppDto;
import org.monjasa.utopia.dto.request.AppRequest;
import org.monjasa.utopia.repository.AppRepository;
import org.monjasa.utopia.service.AppService;
import org.monjasa.utopia.util.mapper.AppMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppRepository appRepository;

    private final AppMapper appMapper;

    @Override
    public AppDto create(AppRequest request) {
        App app = appRepository.save(appMapper.toEntity(request));
        return appMapper.toDto(app);
    }
}

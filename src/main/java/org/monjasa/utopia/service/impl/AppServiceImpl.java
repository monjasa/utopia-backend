package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.App;
import org.monjasa.utopia.repository.AppRepository;
import org.monjasa.utopia.service.AppService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final AppRepository appRepository;

    @Override
    public void create() {
        App app = new App();
        appRepository.save(app);
    }
}

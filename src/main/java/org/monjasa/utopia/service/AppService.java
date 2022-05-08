package org.monjasa.utopia.service;

import org.monjasa.utopia.dto.AppDto;
import org.monjasa.utopia.dto.request.AppRequest;

public interface AppService {

    AppDto create(AppRequest request);

}

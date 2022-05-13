package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> getAllByEmployeePositionId(Long employeePositionId);

}

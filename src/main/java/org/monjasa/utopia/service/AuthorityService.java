package org.monjasa.utopia.service;

import org.monjasa.utopia.domain.permission.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> getAllByEmployeePositionId(Long employeePositionId);

}

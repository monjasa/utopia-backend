package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.Authority;
import org.monjasa.utopia.repository.AuthorityRepository;
import org.monjasa.utopia.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public List<Authority> getAllByEmployeePositionId(Long employeePositionId) {
        return authorityRepository.findAllByEmployeePositionId(employeePositionId);
    }
}

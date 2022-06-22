package org.monjasa.utopia.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.employee.EmployeePosition;
import org.monjasa.utopia.dto.employee.EmployeePositionItemDto;
import org.monjasa.utopia.repository.EmployeePositionRepository;
import org.monjasa.utopia.service.EmployeePositionService;
import org.monjasa.utopia.util.mapper.EmployeePositionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeePositionServiceImpl implements EmployeePositionService {

    private final EmployeePositionRepository employeePositionRepository;

    private final EmployeePositionMapper employeePositionMapper;

    @Override
    public List<EmployeePositionItemDto> getAllItems() {
        List<EmployeePosition> employeePositions = employeePositionRepository.findAll();
        return employeePositions.stream()
                .map(employeePositionMapper::toItemDto)
                .toList();
    }
}

package org.monjasa.utopia.service.impl;

import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import org.monjasa.utopia.domain.employee.Employee;
import org.monjasa.utopia.domain.permission.Authority;
import org.monjasa.utopia.dto.employee.EmployeeConciseDto;
import org.monjasa.utopia.dto.employee.request.EmployeeRequest;
import org.monjasa.utopia.dto.permission.request.UserRequest;
import org.monjasa.utopia.repository.EmployeeRepository;
import org.monjasa.utopia.service.AuthorityService;
import org.monjasa.utopia.service.EmployeeService;
import org.monjasa.utopia.service.UserManagementService;
import org.monjasa.utopia.util.mapper.EmployeeMapper;
import org.monjasa.utopia.util.mapper.request.UserRequestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final AuthorityService authorityService;

    private final UserManagementService userManagementService;

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    private final UserRequestMapper userRequestMapper;

    @Override
    public void create(EmployeeRequest request) {
        UserRecord userRecord = createUserRecord(request);
        Employee employee = employeeMapper.toEntity(request);
        employee.setUid(userRecord.getUid());
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeConciseDto> getAllConcise() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toConciseDto)
                .toList();
    }

    private UserRecord createUserRecord(EmployeeRequest request) {
        List<Authority> authorities = authorityService.getAllByEmployeePositionId(request.getPositionId());
        UserRequest userRequest = userRequestMapper.toUserRequest(request, authorities);
        return userManagementService.create(userRequest);
    }
}

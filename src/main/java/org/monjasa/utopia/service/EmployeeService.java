package org.monjasa.utopia.service;

import org.monjasa.utopia.dto.employee.EmployeeConciseDto;
import org.monjasa.utopia.dto.employee.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    void create(EmployeeRequest request);

    List<EmployeeConciseDto> getAllConcise();

}

package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.monjasa.utopia.domain.employee.EmployeePosition;
import org.monjasa.utopia.dto.employee.EmployeePositionItemDto;

@Mapper
public interface EmployeePositionMapper {

    EmployeePositionItemDto toItemDto(EmployeePosition employeePosition);

}

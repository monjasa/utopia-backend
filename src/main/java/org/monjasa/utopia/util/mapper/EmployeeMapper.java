package org.monjasa.utopia.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.monjasa.utopia.domain.Employee;
import org.monjasa.utopia.dto.request.EmployeeRequest;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "position.id", source = "positionId")
    Employee toEntity(EmployeeRequest request);

}

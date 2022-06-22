package org.monjasa.utopia.dto.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeConciseDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private EmployeePositionItemDto position;

}

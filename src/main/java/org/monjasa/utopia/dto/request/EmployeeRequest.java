package org.monjasa.utopia.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

    private String email;

    private String firstName;

    private String lastName;

    private Long positionId;

}

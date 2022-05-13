package org.monjasa.utopia.util.mapper.request;


import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.monjasa.utopia.domain.Authority;
import org.monjasa.utopia.dto.request.EmployeeRequest;
import org.monjasa.utopia.dto.request.UserRequest;

import java.util.List;

import static com.google.firebase.auth.UserRecord.CreateRequest;

@Mapper
public interface UserRequestMapper {

    UserRequest toUserRequest(EmployeeRequest employeeRequest, List<Authority> authorities);

    CreateRequest toCreateRequest(UserRequest userRequest);

    @AfterMapping
    default void afterToUserRequest(@MappingTarget UserRequest userRequest, EmployeeRequest employeeRequest, List<Authority> authorities) {
        userRequest.setDisplayName(mapFullNameToDisplayName(employeeRequest.getFirstName(), employeeRequest.getLastName()));
        userRequest.setScopes(mapAuthoritiesToScopes(authorities));
    }

    private String mapFullNameToDisplayName(String firstName, String lastName) {
        return String.join(" ", firstName, lastName);
    }

    private List<String> mapAuthoritiesToScopes(List<Authority> authorities) {
        return authorities.stream().map(Authority::getScope).toList();
    }
}

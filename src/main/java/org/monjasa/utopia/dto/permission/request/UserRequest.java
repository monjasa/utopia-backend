package org.monjasa.utopia.dto.permission.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {

    private String email;

    private String displayName;

    private List<String> scopes;

}

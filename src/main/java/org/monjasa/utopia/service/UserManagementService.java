package org.monjasa.utopia.service;

import com.google.firebase.auth.UserRecord;
import org.monjasa.utopia.dto.permission.request.UserRequest;

public interface UserManagementService {

    UserRecord create(UserRequest userRequest);

}

package org.monjasa.utopia.service;

import com.google.firebase.auth.UserRecord;
import org.monjasa.utopia.dto.request.UserRequest;

public interface UserManagementService {

    UserRecord create(UserRequest userRequest);

}

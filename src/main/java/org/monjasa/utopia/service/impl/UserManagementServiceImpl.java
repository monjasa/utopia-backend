package org.monjasa.utopia.service.impl;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.monjasa.utopia.dto.request.UserRequest;
import org.monjasa.utopia.service.UserManagementService;
import org.monjasa.utopia.util.mapper.request.UserRequestMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.google.firebase.auth.UserRecord.CreateRequest;

@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    public static final String SCOPE_CLAIM_NAME = "scope";

    private final FirebaseAuth firebaseAuth;

    private final UserRequestMapper userRequestMapper;

    @Override
    @SneakyThrows
    public UserRecord create(UserRequest userRequest) {
        CreateRequest createRequest = userRequestMapper.toCreateRequest(userRequest);
        UserRecord userRecord = firebaseAuth.createUser(createRequest);
        setScopeClaim(userRequest, userRecord);
        return userRecord;
    }

    @SneakyThrows
    private void setScopeClaim(UserRequest userRequest, UserRecord userRecord) {
        Map<String, Object> claims = new HashMap<>(userRecord.getCustomClaims());
        claims.put(SCOPE_CLAIM_NAME, userRequest.getScopes());
        firebaseAuth.setCustomUserClaims(userRecord.getUid(), claims);
    }
}

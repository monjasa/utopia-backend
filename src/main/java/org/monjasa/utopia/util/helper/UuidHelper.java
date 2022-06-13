package org.monjasa.utopia.util.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UuidHelper {

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }
}

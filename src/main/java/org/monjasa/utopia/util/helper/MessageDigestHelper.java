package org.monjasa.utopia.util.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageDigestHelper {

    @SneakyThrows
    public static byte[] digestBySha1(String message) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.reset();
        messageDigest.update(message.getBytes(StandardCharsets.UTF_8));
        return messageDigest.digest();
    }
}

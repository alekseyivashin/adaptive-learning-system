package ru.ifmo.alekseyivashin.utils.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.utils.Crypter;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

@Component
public class CrypterImpl implements Crypter {

    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private Cipher cipher;
    private SecretKey key;

    public CrypterImpl() throws Exception {
        String encryptionKey = "H93Fnd90AP195vS8f982bfksSFDJF0q3f";
        KeySpec keySpec = new DESedeKeySpec(encryptionKey.getBytes());
        cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);

        SecretKeyFactory factory = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
        key = factory.generateSecret(keySpec);
    }

    @Override
    public String encrypt(String unencryptedPassword) {
        String encryptedPassword = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] bytes = cipher.doFinal(unencryptedPassword.getBytes());
            encryptedPassword = new String(Base64.encodeBase64(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

    @Override
    public String decrypt(String encryptedPassword) {
        String decryptedPassword = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bytes = cipher.doFinal(Base64.decodeBase64(encryptedPassword));
            decryptedPassword = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedPassword;
    }
}

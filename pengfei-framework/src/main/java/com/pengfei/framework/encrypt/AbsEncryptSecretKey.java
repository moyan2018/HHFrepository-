package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

abstract class AbsEncryptSecretKey implements IEncryptSecretKey {

    protected abstract String getInstance();

    protected abstract int getInitLength();

    @Override
    public byte[] generateKey() throws AbsBaseException, AbsBaseException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance( this.getInstance() );
            keyGenerator.init( this.getInitLength() );
            SecretKey secret = keyGenerator.generateKey();
            return secret.getEncoded();
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] encryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance( this.getInstance() );
            keyGenerator.init( this.getInitLength(), new SecureRandom(secretKey.getBytes()));
            SecretKey secret = keyGenerator.generateKey();
            byte[] enCodeFormat = secret.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, this.getInstance());
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            cipher.init( Cipher.ENCRYPT_MODE, key );
            return cipher.doFinal( contents );
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] decryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance( this.getInstance() );
            keyGenerator.init( this.getInitLength(), new SecureRandom(secretKey.getBytes()));
            SecretKey secret = keyGenerator.generateKey();
            byte[] enCodeFormat = secret.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, this.getInstance());
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            cipher.init( Cipher.DECRYPT_MODE, key );
            return cipher.doFinal( contents );
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }
}

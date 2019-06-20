package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

class EncryptSecretKeyDES extends AbsEncryptSecretKey {

    private String instance;
    private int initLength;

    public EncryptSecretKeyDES(String instance, int initLength){
        this.instance = instance;
        this.initLength = initLength;
    }

    @Override
    protected String getInstance(){
        return this.instance;
    }

    @Override
    protected int getInitLength() {
        return this.initLength;
    }

    @Override
    public byte[] generateKey() throws AbsBaseException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance( this.getInstance() );
            keyGenerator.init( this.getInitLength() );
            SecretKey generateKey = keyGenerator.generateKey();
            return generateKey.getEncoded();
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] encryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKeySpec = new DESKeySpec(secretKey.getBytes());
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance( this.getInstance() );
            SecretKey secret = secretKeyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            cipher.init( Cipher.ENCRYPT_MODE, secret, random );
            return cipher.doFinal(contents);
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] decryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKeySpec = new DESKeySpec(secretKey.getBytes());
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance( this.getInstance() );
            SecretKey secret = secretKeyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            cipher.init( Cipher.DECRYPT_MODE, secret, random );
            return cipher.doFinal(contents);
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }
}

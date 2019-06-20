package com.pengfei.utils.encrypt;

import com.pengfei.framework.encrypt.*;
import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.systemCode.EnSystemCode;
import com.pengfei.framework.systemCode.SystemCodeManager;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public final class EncryptUtils {

    private EncryptUtils(){

    }

    public static String encrypt(byte[] contents) throws AbsBaseException {
        return encrypt(contents, EnEncrypt.MD5, EnSystemCode.Base_64);
    }

    public static String encrypt(String content) throws AbsBaseException {
        return encrypt(content, EnEncrypt.MD5, EnSystemCode.Base_64);
    }

    public static String encrypt(byte[] contents, EnEncrypt enEncrypt, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode(EncryptManager.encrypt(contents, enEncrypt), enSystemCode);
    }

    public static String encrypt(String content, EnEncrypt enEncrypt, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode(EncryptManager.encrypt(content, enEncrypt), enSystemCode);
    }

    public static String generateKey() throws AbsBaseException {
        return generateKey(EnEncryptSecretKey.AES_256, EnSystemCode.Hex);
    }

    public static String generateKey(EnEncryptSecretKey enEncryptSecretKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.generateKey(enEncryptSecretKey), enSystemCode );
    }

    public static String encryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException {
        return encryptSecretKey(contents, secretKey, EnEncryptSecretKey.AES_256, EnSystemCode.Hex );
    }

    public static String encryptSecretKey(String content, String secretKey) throws AbsBaseException {
        return encryptSecretKey(content, secretKey, EnEncryptSecretKey.AES_256, EnSystemCode.Hex );
    }

    public static String encryptSecretKey(byte[] contents, String secretKey, EnEncryptSecretKey enEncryptSecretKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.encryptSecretKey(contents, secretKey, enEncryptSecretKey), enSystemCode );
    }

    public static String encryptSecretKey(String content, String secretKey, EnEncryptSecretKey enEncryptSecretKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.encryptSecretKey(content, secretKey, enEncryptSecretKey), enSystemCode );
    }

    public static byte[] decryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException {
        return decryptSecretKey(contents, secretKey, EnEncryptSecretKey.AES_256);
    }

    public static byte[] decryptSecretKey(String content, String secretKey) throws AbsBaseException {
        return decryptSecretKey(content, secretKey, EnEncryptSecretKey.AES_256, EnSystemCode.Hex);
    }

    public static byte[] decryptSecretKey(byte[] contents, String secretKey, EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException {
        return EncryptManager.decryptSecretKey(contents, secretKey, enEncryptSecretKey);
    }

    public static byte[] decryptSecretKey(String content, String secretKey, EnEncryptSecretKey enEncryptSecretKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptSecretKey( SystemCodeManager.decode(content, enSystemCode) , secretKey, enEncryptSecretKey);
    }

    public static String decryptSecretKeyString(byte[] contents, String secretKey) throws AbsBaseException {
        return decryptSecretKeyString(contents, secretKey, EnEncryptSecretKey.AES_256);
    }

    public static String decryptSecretKeyString(String content, String secretKey) throws AbsBaseException {
        return decryptSecretKeyString(content, secretKey, EnEncryptSecretKey.AES_256, EnSystemCode.Hex);
    }

    public static String decryptSecretKeyString(byte[] contents, String secretKey, EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException {
        return EncryptManager.decryptSecretKeyString(contents, secretKey, enEncryptSecretKey);
    }

    public static String decryptSecretKeyString(String content, String secretKey, EnEncryptSecretKey enEncryptSecretKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptSecretKeyString( SystemCodeManager.decode(content, enSystemCode) , secretKey, enEncryptSecretKey);
    }

    public static Map<String, String> getKeyPair() throws AbsBaseException {
        return getKeyPair(EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static Map<String, String> getKeyPair(EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        KeyPair keyPair = EncryptManager.getKeyPair(publicPrivateKey);
        Map<String, String> publicPrivateMap = new HashMap<>();
        publicPrivateMap.put("publicKey", SystemCodeManager.encode(keyPair.getPublic().getEncoded(), enSystemCode));
        publicPrivateMap.put("privateKey", SystemCodeManager.encode(keyPair.getPrivate().getEncoded(), enSystemCode));
        return publicPrivateMap;
    }

    public static String encryptPublicKey(byte[] contents, String publicKey) throws AbsBaseException {
        return encryptPublicKey(contents, publicKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String encryptPublicKey(byte[] contents, String publicKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.encryptPublicKey(contents, SystemCodeManager.decode(publicKey, enSystemCode), publicPrivateKey), enSystemCode );
    }

    public static String encryptPublicKey(String content, String publicKey) throws AbsBaseException {
        return encryptPublicKey(content, publicKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String encryptPublicKey(String content, String publicKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.encryptPublicKey(content, SystemCodeManager.decode(publicKey, enSystemCode), publicPrivateKey), enSystemCode );
    }

    public static byte[] decryptPublicKey(byte[] contents, String publicKey) throws AbsBaseException {
        return decryptPublicKey(contents, publicKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static byte[] decryptPublicKey(byte[] contents, String publicKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPublicKey(contents, SystemCodeManager.decode(publicKey, enSystemCode), publicPrivateKey);
    }

    public static byte[] decryptPublicKey(String content, String publicKey) throws AbsBaseException {
        return decryptPublicKey(content, publicKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static byte[] decryptPublicKey(String content, String publicKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPublicKey( SystemCodeManager.decode(content, enSystemCode), SystemCodeManager.decode(publicKey, enSystemCode), publicPrivateKey);
    }

    public static String decryptPublicKeyString(byte[] contents, String publicKey) throws AbsBaseException {
        return decryptPublicKeyString(contents, publicKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String decryptPublicKeyString(byte[] contents, String publicKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPublicKeyString(contents, SystemCodeManager.decode(publicKey, enSystemCode), publicPrivateKey);
    }

    public static String decryptPublicKeyString(String content, String publicKey) throws AbsBaseException {
        return decryptPublicKeyString(content, publicKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String decryptPublicKeyString(String content, String publicKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPublicKeyString( SystemCodeManager.decode(content, enSystemCode), SystemCodeManager.decode(publicKey, enSystemCode), publicPrivateKey);
    }

    public static String encryptPrivateKey(byte[] contents, String privateKey) throws AbsBaseException {
        return encryptPrivateKey(contents, privateKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String encryptPrivateKey(byte[] contents, String privateKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.encryptPrivateKey(contents, SystemCodeManager.decode(privateKey, enSystemCode), publicPrivateKey), enSystemCode );
    }

    public static String encryptPrivateKey(String content, String privateKey) throws AbsBaseException {
        return encryptPrivateKey(content, privateKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String encryptPrivateKey(String content, String privateKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode( EncryptManager.encryptPrivateKey(content, SystemCodeManager.decode(privateKey, enSystemCode), publicPrivateKey), enSystemCode );
    }

    public static byte[] decryptPrivateKey(byte[] contents, String privateKey) throws AbsBaseException {
        return decryptPrivateKey(contents, privateKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static byte[] decryptPrivateKey(byte[] contents, String privateKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPrivateKey(contents, SystemCodeManager.decode(privateKey, enSystemCode), publicPrivateKey);
    }

    public static byte[] decryptPrivateKey(String content, String privateKey) throws AbsBaseException {
        return decryptPrivateKey(content, privateKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static byte[] decryptPrivateKey(String content, String privateKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPrivateKey( SystemCodeManager.decode(content, enSystemCode), SystemCodeManager.decode(privateKey, enSystemCode), publicPrivateKey);
    }

    public static String decryptPrivateKeyString(byte[] contents, String privateKey) throws AbsBaseException {
        return decryptPrivateKeyString(contents, privateKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String decryptPrivateKeyString(byte[] contents, String privateKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPrivateKeyString(contents, SystemCodeManager.decode(privateKey, enSystemCode), publicPrivateKey);
    }

    public static String decryptPrivateKeyString(String content, String privateKey) throws AbsBaseException {
        return decryptPrivateKeyString(content, privateKey, EnEncryptPublicPrivateKey.RSA_1024, EnSystemCode.Base_64);
    }

    public static String decryptPrivateKeyString(String content, String privateKey, EnEncryptPublicPrivateKey publicPrivateKey, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.decryptPrivateKeyString( SystemCodeManager.decode(content, enSystemCode), SystemCodeManager.decode(privateKey, enSystemCode), publicPrivateKey);
    }

    public static String sign(byte[] contents, String privateKey) throws AbsBaseException {
        return sign(contents, privateKey, EnEncryptSign.SHA1_With_RSA, EnSystemCode.Base_64);
    }

    public static String sign(byte[] contents, String privateKey, EnEncryptSign enEncryptSign, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode(  EncryptManager.sign(contents, SystemCodeManager.decode(privateKey, enSystemCode), enEncryptSign), enSystemCode );
    }

    public static String sign(String content, String privateKey) throws AbsBaseException {
        return sign(content, privateKey, EnEncryptSign.SHA1_With_RSA, EnSystemCode.Base_64);
    }

    public static String sign(String content, String privateKey, EnEncryptSign enEncryptSign, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode(  EncryptManager.sign(content, SystemCodeManager.decode(privateKey, enSystemCode), enEncryptSign), enSystemCode );
    }

    public static boolean verify(byte[] contents, String publicKey, byte[] sign) throws AbsBaseException {
        return verify(contents, publicKey, sign, EnEncryptSign.SHA1_With_RSA, EnSystemCode.Base_64);
    }

    public static boolean verify(byte[] contents, String publicKey, byte[] sign, EnEncryptSign enEncryptSign, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.verify(contents, SystemCodeManager.decode(publicKey, enSystemCode), sign, enEncryptSign);
    }

    public static boolean verify(byte[] contents, String publicKey, String sign) throws AbsBaseException {
        return verify(contents, publicKey, sign, EnEncryptSign.SHA1_With_RSA, EnSystemCode.Base_64);
    }

    public static boolean verify(byte[] contents, String publicKey, String sign, EnEncryptSign enEncryptSign, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.verify(contents, SystemCodeManager.decode(publicKey, enSystemCode), SystemCodeManager.decode(sign, enSystemCode), enEncryptSign);
    }

    public static boolean verify(String content, String publicKey, String sign) throws AbsBaseException {
        return verify(content, publicKey, sign, EnEncryptSign.SHA1_With_RSA, EnSystemCode.Base_64);
    }

    public static boolean verify(String content, String publicKey, String sign, EnEncryptSign enEncryptSign, EnSystemCode enSystemCode) throws AbsBaseException {
        return EncryptManager.verify(content, SystemCodeManager.decode(publicKey, enSystemCode), SystemCodeManager.decode(sign, enSystemCode), enEncryptSign);
    }
}

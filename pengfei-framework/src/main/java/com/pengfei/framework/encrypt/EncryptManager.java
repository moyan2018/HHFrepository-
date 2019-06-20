package com.pengfei.framework.encrypt;

import com.pengfei.framework.FrameWorkCommon;
import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.exception.EncryptException;

import java.security.KeyPair;

public final class EncryptManager {

    private EncryptManager(){

    }

    public static byte[] encrypt(byte[] contents, EnEncrypt enEncrypt) throws AbsBaseException {
        enEncrypt = getEnEncrypt(enEncrypt);
        return enEncrypt.getEncrypt().encrypt( contents );
    }

    public static byte[] encrypt(String content, EnEncrypt enEncrypt) throws AbsBaseException{
        enEncrypt = getEnEncrypt(enEncrypt);
        try {
            return enEncrypt.getEncrypt().encrypt( content.getBytes(FrameWorkCommon.Default_Charset) );
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] generateKey(EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException{
        enEncryptSecretKey = getEnEncryptSecretKey(enEncryptSecretKey);
        return enEncryptSecretKey.getEncryptSecretKey().generateKey();
    }

    public static byte[] encryptSecretKey(byte[] contents, String secretKey, EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException{
        enEncryptSecretKey = getEnEncryptSecretKey(enEncryptSecretKey);
        return enEncryptSecretKey.getEncryptSecretKey().encryptSecretKey(contents, secretKey);
    }

    public static byte[] encryptSecretKey(String content, String secretKey, EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException{
        enEncryptSecretKey = getEnEncryptSecretKey(enEncryptSecretKey);
        try {
            return enEncryptSecretKey.getEncryptSecretKey().encryptSecretKey(content.getBytes(FrameWorkCommon.Default_Charset), secretKey);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] decryptSecretKey(byte[] contents, String secretKey, EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException{
        enEncryptSecretKey = getEnEncryptSecretKey(enEncryptSecretKey);
        return enEncryptSecretKey.getEncryptSecretKey().decryptSecretKey(contents, secretKey);
    }

    public static String decryptSecretKeyString(byte[] contents, String secretKey, EnEncryptSecretKey enEncryptSecretKey) throws AbsBaseException{
        enEncryptSecretKey = getEnEncryptSecretKey(enEncryptSecretKey);
        try {
            return new String(enEncryptSecretKey.getEncryptSecretKey().decryptSecretKey(contents, secretKey), FrameWorkCommon.Default_Charset);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static KeyPair getKeyPair(EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        return publicPrivateKey.getPublicPrivateKey().getKeyPair();
    }

    public static byte[] encryptPublicKey(byte[] contents, byte[] publicKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        return publicPrivateKey.getPublicPrivateKey().encryptPublicKey(contents, publicKey);
    }

    public static byte[] encryptPublicKey(String content, byte[] publicKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        try {
            return publicPrivateKey.getPublicPrivateKey().encryptPublicKey(content.getBytes(FrameWorkCommon.Default_Charset), publicKey);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] decryptPublicKey(byte[] contents, byte[] publicKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        return publicPrivateKey.getPublicPrivateKey().decryptPublicKey(contents, publicKey);
    }

    public static String decryptPublicKeyString(byte[] contents, byte[] publicKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        try {
            return new String(publicPrivateKey.getPublicPrivateKey().decryptPublicKey(contents, publicKey), FrameWorkCommon.Default_Charset);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] encryptPrivateKey(byte[] contents, byte[] privateKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        return publicPrivateKey.getPublicPrivateKey().encryptPrivateKey(contents, privateKey);
    }

    public static byte[] encryptPrivateKey(String content, byte[] privateKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        try {
            return publicPrivateKey.getPublicPrivateKey().encryptPrivateKey(content.getBytes(FrameWorkCommon.Default_Charset), privateKey);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] decryptPrivateKey(byte[] contents, byte[] privateKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        return publicPrivateKey.getPublicPrivateKey().decryptPrivateKey(contents, privateKey);
    }

    public static String decryptPrivateKeyString(byte[] contents, byte[] privateKey, EnEncryptPublicPrivateKey publicPrivateKey) throws AbsBaseException{
        publicPrivateKey = getEnEncryptPublicPrivateKey(publicPrivateKey);
        try {
            return new String(publicPrivateKey.getPublicPrivateKey().decryptPrivateKey(contents, privateKey), FrameWorkCommon.Default_Charset);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] sign(byte[] contents, byte[] privateKey, EnEncryptSign enEncryptSign) throws AbsBaseException{
        enEncryptSign = getEnEncryptSign(enEncryptSign);
        return enEncryptSign.getEncryptSign().sign(contents, privateKey);
    }

    public static byte[] sign(String content, byte[] privateKey, EnEncryptSign enEncryptSign) throws AbsBaseException{
        enEncryptSign = getEnEncryptSign(enEncryptSign);
        try {
            return enEncryptSign.getEncryptSign().sign( content.getBytes(FrameWorkCommon.Default_Charset) , privateKey);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static boolean verify(byte[] contents, byte[] publicKey, byte[] sign, EnEncryptSign enEncryptSign) throws AbsBaseException{
        enEncryptSign = getEnEncryptSign(enEncryptSign);
        return enEncryptSign.getEncryptSign().verify(contents, publicKey, sign);
    }

    public static boolean verify(String content, byte[] publicKey, byte[] sign, EnEncryptSign enEncryptSign) throws AbsBaseException{
        enEncryptSign = getEnEncryptSign(enEncryptSign);
        try {
            return enEncryptSign.getEncryptSign().verify(content.getBytes(FrameWorkCommon.Default_Charset), publicKey, sign);
        } catch (Exception e){
            handleException(e);
            return false;
        }
    }

    private static EnEncrypt getEnEncrypt(EnEncrypt enEncrypt){
        if( enEncrypt == null ){
            enEncrypt = EnEncrypt.MD5;
        }
        return enEncrypt;
    }

    private static EnEncryptSecretKey getEnEncryptSecretKey(EnEncryptSecretKey enEncryptSecretKey){
        if( enEncryptSecretKey == null ){
            enEncryptSecretKey = EnEncryptSecretKey.AES_256;
        }
        return enEncryptSecretKey;
    }

    private static EnEncryptPublicPrivateKey getEnEncryptPublicPrivateKey(EnEncryptPublicPrivateKey publicPrivateKey){
        if( publicPrivateKey == null ){
            publicPrivateKey = EnEncryptPublicPrivateKey.RSA_1024;
        }
        return publicPrivateKey;
    }

    private static EnEncryptSign getEnEncryptSign(EnEncryptSign enEncryptSign){
        if( enEncryptSign == null ){
            enEncryptSign = EnEncryptSign.SHA1_With_RSA;
        }
        return enEncryptSign;
    }

    static void handleException(Exception exception) throws AbsBaseException {
        if( exception instanceof AbsBaseException){
            throw (AbsBaseException) exception;
        } else {
            throw new EncryptException(exception);
        }
    }

}

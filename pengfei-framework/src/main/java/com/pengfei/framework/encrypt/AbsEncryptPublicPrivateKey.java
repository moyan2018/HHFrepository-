package com.pengfei.framework.encrypt;

import com.pengfei.framework.FrameWorkCommon;
import com.pengfei.framework.exception.AbsBaseException;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

abstract class AbsEncryptPublicPrivateKey implements IEncryptPublicPrivateKey {

    protected abstract String getInstance();

    protected abstract int initLength();

    protected PublicKey getPublicKeyPair(byte[] publicKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance( this.getInstance() );
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKey);
        return keyFactory.generatePublic(publicKeySpec);
    }

    protected PrivateKey getPrivateKeyPair(byte[] privateKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance( this.getInstance() );
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKey);
        return keyFactory.generatePrivate(privateKeySpec);
    }

    @Override
    public KeyPair getKeyPair() throws AbsBaseException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance( this.getInstance() );
            keyPairGenerator.initialize( this.initLength() );
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] encryptPublicKey(byte[] contents, byte[] publicKey) throws AbsBaseException {
        try {
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            PublicKey publicKeyPair = this.getPublicKeyPair(publicKey);
            cipher.init(Cipher.ENCRYPT_MODE, publicKeyPair);
            List<byte[]> contentList = FrameWorkCommon.splitBytes(contents, this.initLength() / 8 - 11);
            if( FrameWorkCommon.isNotEmpty(contentList) ){
                List<Byte> encryptList = new ArrayList<>();
                for(byte[] bts : contentList){
                    FrameWorkCommon.addList(encryptList, cipher.doFinal(bts));
                }
                return FrameWorkCommon.getBytes( encryptList );
            } else {
                return new byte[0];
            }
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] decryptPublicKey(byte[] contents, byte[] publicKey) throws AbsBaseException {
        try {
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            PublicKey publicKeyPair = this.getPublicKeyPair(publicKey);
            cipher.init(Cipher.DECRYPT_MODE, publicKeyPair);
            List<byte[]> contentList = FrameWorkCommon.splitBytes(contents, this.initLength() / 8);
            if( FrameWorkCommon.isNotEmpty(contentList) ){
                List<Byte> encryptList = new ArrayList<>();
                for(byte[] bts : contentList){
                    FrameWorkCommon.addList(encryptList, cipher.doFinal(bts));
                }
                return FrameWorkCommon.getBytes( encryptList );
            } else {
                return new byte[0];
            }
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] encryptPrivateKey(byte[] contents, byte[] privateKey) throws AbsBaseException {
        try {
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            PrivateKey privateKeyPair = this.getPrivateKeyPair(privateKey);
            cipher.init(Cipher.ENCRYPT_MODE, privateKeyPair);
            List<byte[]> contentList = FrameWorkCommon.splitBytes(contents, this.initLength() / 8 - 11);
            if( FrameWorkCommon.isNotEmpty(contentList) ){
                List<Byte> encryptList = new ArrayList<>();
                for(byte[] bts : contentList){
                    FrameWorkCommon.addList(encryptList, cipher.doFinal(bts));
                }
                return FrameWorkCommon.getBytes( encryptList );
            } else {
                return new byte[0];
            }
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public byte[] decryptPrivateKey(byte[] contents, byte[] privateKey) throws AbsBaseException {
        try {
            Cipher cipher = Cipher.getInstance( this.getInstance() );
            PrivateKey privateKeyPair = this.getPrivateKeyPair(privateKey);
            cipher.init(Cipher.DECRYPT_MODE, privateKeyPair);
            List<byte[]> contentList = FrameWorkCommon.splitBytes(contents, this.initLength() / 8);
            if( FrameWorkCommon.isNotEmpty(contentList) ){
                List<Byte> encryptList = new ArrayList<>();
                for(byte[] bts : contentList){
                    FrameWorkCommon.addList(encryptList, cipher.doFinal(bts));
                }
                return FrameWorkCommon.getBytes( encryptList );
            } else {
                return new byte[0];
            }
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

}

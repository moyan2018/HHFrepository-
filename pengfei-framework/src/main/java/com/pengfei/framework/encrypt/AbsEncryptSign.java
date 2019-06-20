package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

abstract class AbsEncryptSign implements IEncryptSign {

    protected abstract String getInstance();
    protected abstract String getInstanceSign();

    @Override
    public byte[] sign(byte[] contents, byte[] privateKey) throws AbsBaseException {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance( this.getInstance() );
            PrivateKey key = keyFactory.generatePrivate(keySpec);
            Signature signature = Signature.getInstance( this.getInstanceSign() );
            signature.initSign(key);
            signature.update( contents );
            return signature.sign();
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }

    @Override
    public boolean verify(byte[] contents, byte[] publicKey, byte[] sign) throws AbsBaseException {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance( this.getInstance() );
            PublicKey key = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance( this.getInstanceSign() );
            signature.initVerify(key);
            signature.update(contents);
            return signature.verify(sign);
        } catch (Exception e){
            EncryptManager.handleException(e);
            return false;
        }
    }
}

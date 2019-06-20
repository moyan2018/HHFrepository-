package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

import java.security.KeyPair;

interface IEncryptPublicPrivateKey {

    KeyPair getKeyPair() throws AbsBaseException;

    byte[] encryptPublicKey(byte[] contents, byte[] publicKey) throws AbsBaseException;

    byte[] decryptPublicKey(byte[] contents, byte[] publicKey) throws AbsBaseException, AbsBaseException;

    byte[] encryptPrivateKey(byte[] contents, byte[] privateKey) throws AbsBaseException;

    byte[] decryptPrivateKey(byte[] contents, byte[] privateKey) throws AbsBaseException;

}

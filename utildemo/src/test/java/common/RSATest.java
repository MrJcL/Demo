package common;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

/**
 * @program: Demo
 * @Date: 2019/2/21 23:07
 * @Author: LiJc
 * @Description:
 */
public class RSATest {

    /**
     * 生成密钥对
     */
    @Test
    public void test1(){
        RSAUtil.genKeyPair("D:\\公钥.txt","D:\\私钥.txt");
    }

    @Test
    public void test2() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String content = "真香警告！";
        System.out.println("原始内容为："+content);
        String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQ1IqhPNo8M/R1pHpocNuJ6enntJoB7OAaJrVoaHbvJOI4APkheX0J1UKizOGQNRr/V6vp3B+3MrPVGJ4lfRirrgnIK86PD5K/MChSWhxslWf3jQxr7AO8rMIPre7uoGjmY3pbSY82QUGDEhgDVsWTLTjWWqFQHVTwEfBPGgaktQIDAQAB";
        //根据公钥key获取公钥
        RSAPublicKey publicKey =  RSAUtil.getPublicKey(pubkey);
        //加密
        String content1 = RSAUtil.publicEncrypt(content, publicKey);
        System.out.println("加密后内容为："+content1);
        String prikey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJDUiqE82jwz9HWkemhw24np6ee0mgHs4BomtWhodu8k4jgA+SF5fQnVQqLM4ZA1Gv9Xq+ncH7cys9UYniV9GKuuCcgrzo8Pkr8wKFJaHGyVZ/eNDGvsA7yswg+t7u6gaOZjeltJjzZBQYMSGANWxZMtONZaoVAdVPAR8E8aBqS1AgMBAAECgYBtteOSApPa2QyM9VyYsy1LCrvafs/PN44HoVz4S3IU9B69h9cxCWOzyC3jP0p7QA9EcDhVPh90Wl8pxK0//sRpWZrKps3ZqCQKogLSHTIaRJvvgQwN26KtIwSoXDwKqpmyhufIhXdFDmSIKb8v8rF3Sl3Mt5I+hDT83fnTjyPUPQJBAOBNObrgZQ7CvMuwtKilWhAqlNbhibfc3k4dtJ+23uixUgHq+WME6w7B0NUixT6ua7v+RKZD1RO9ANDGCEIQzfsCQQClTDPsjrkerRBsXrge6xK2drisIpEFBdYoIz9lYmCHXJctkx5nhLogxxTeAJgFWBIcOgrx5OCYOQgr5p6FikkPAkA45j470sqwCOR9w3DAy1lienrRW9tkwem+5Tg5v9kiLEFCbUogPVInpzEDsFNbCEIaKXFewBxganS3gVT89WhbAkAV90NrKyg0iGEHVar4CNsKvkoaLdnBph3oZY62JVWYh1hbqRJARWYKlwoR2lhZVXPKpnfv3y9tax7H3rSwIElHAkB7j65B6+L8Ty0RiEzHCOVXnUoUTai/BZfQ5erA9yVM/VW8p1mE/qhJOTQ5hFniO0dicl3YZyaYHW1D+Z1V4naO";
        //获取私钥
        RSAPrivateKey privateKey = RSAUtil.getPrivateKey(prikey);
        //解密
        String content2 = RSAUtil.privateDecrypt(content1, privateKey);
        System.out.println("解密后内容为："+content2);
    }
}

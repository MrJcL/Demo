package common;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

/**
 * @program: Demo
 * @Date: 2019/2/22 10:18
 * @Author: LiJc
 * @Description:
 */
public class DESAndRSATest {


    /**
     * DES和RSA混合加密，先进行DES加密，将DES加密后的内容进行base64编码，再将base64编码的DES进行RSA加密
     */
    @Test
    public void test1() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String deskey = "password";//des密钥//长度8位
        String content = "真香警告！"; //内容
        System.out.println("原始加密内容为："+content);
        //DES加密
        byte[] encryptbyte =  DESUtil.desEncrypt(content, deskey); //加密后返回为字节数组
        String descontent = Base64.encodeBase64String(encryptbyte);
        System.out.println("DES加密后内容为："+ descontent);

        //RSA部分start
        String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQ1IqhPNo8M/R1pHpocNuJ6enntJoB7OAaJrVoaHbvJOI4APkheX0J1UKizOGQNRr/V6vp3B+3MrPVGJ4lfRirrgnIK86PD5K/MChSWhxslWf3jQxr7AO8rMIPre7uoGjmY3pbSY82QUGDEhgDVsWTLTjWWqFQHVTwEfBPGgaktQIDAQAB";
        //根据公钥key获取公钥
        RSAPublicKey publicKey =  RSAUtil.getPublicKey(pubkey);
        //RSA加密
        String rsacontent = RSAUtil.publicEncrypt(descontent, publicKey);
        System.out.println("RSA加密后内容为："+rsacontent);
        String prikey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJDUiqE82jwz9HWkemhw24np6ee0mgHs4BomtWhodu8k4jgA+SF5fQnVQqLM4ZA1Gv9Xq+ncH7cys9UYniV9GKuuCcgrzo8Pkr8wKFJaHGyVZ/eNDGvsA7yswg+t7u6gaOZjeltJjzZBQYMSGANWxZMtONZaoVAdVPAR8E8aBqS1AgMBAAECgYBtteOSApPa2QyM9VyYsy1LCrvafs/PN44HoVz4S3IU9B69h9cxCWOzyC3jP0p7QA9EcDhVPh90Wl8pxK0//sRpWZrKps3ZqCQKogLSHTIaRJvvgQwN26KtIwSoXDwKqpmyhufIhXdFDmSIKb8v8rF3Sl3Mt5I+hDT83fnTjyPUPQJBAOBNObrgZQ7CvMuwtKilWhAqlNbhibfc3k4dtJ+23uixUgHq+WME6w7B0NUixT6ua7v+RKZD1RO9ANDGCEIQzfsCQQClTDPsjrkerRBsXrge6xK2drisIpEFBdYoIz9lYmCHXJctkx5nhLogxxTeAJgFWBIcOgrx5OCYOQgr5p6FikkPAkA45j470sqwCOR9w3DAy1lienrRW9tkwem+5Tg5v9kiLEFCbUogPVInpzEDsFNbCEIaKXFewBxganS3gVT89WhbAkAV90NrKyg0iGEHVar4CNsKvkoaLdnBph3oZY62JVWYh1hbqRJARWYKlwoR2lhZVXPKpnfv3y9tax7H3rSwIElHAkB7j65B6+L8Ty0RiEzHCOVXnUoUTai/BZfQ5erA9yVM/VW8p1mE/qhJOTQ5hFniO0dicl3YZyaYHW1D+Z1V4naO";
        //获取私钥
        RSAPrivateKey privateKey = RSAUtil.getPrivateKey(prikey);
        //RSA解密
        String content1 = RSAUtil.privateDecrypt(rsacontent, privateKey);
        System.out.println("RSA解密后内容为："+content1);
        //RSA部分end

        //DES解密
        byte[] decryptbyte = DESUtil.desDecrypt(encryptbyte, deskey);  //将加密后返回的字节数组进行解密
        System.out.println("DES解密后内容为："+ new String(decryptbyte));
    }
}

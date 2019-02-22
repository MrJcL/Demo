package common;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * @program: Demo
 * @Date: 2019/2/20 21:00
 * @Author: LiJc
 * @Description:
 */
public class DESTest {

    @Test
    public void test1(){
        String deskey = "password";//des密钥//长度8位
        String content = "真香警告！"; //内容
        System.out.println("DES原始加密内容为："+content);
        //加密
        byte[] encryptbyte =  DESUtil.desEncrypt(content, deskey); //加密后返回为字节数组
        System.out.println("DES加密后内容为："+ Base64.encodeBase64String(encryptbyte));
        //解密
        byte[] decryptbyte = DESUtil.desDecrypt(encryptbyte, deskey);  //将加密后返回的字节数组进行解密
        System.out.println("DES解密后内容为："+ new String(decryptbyte));
    }
}

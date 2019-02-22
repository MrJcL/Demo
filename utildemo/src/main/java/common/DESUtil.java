package common;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;

/**
 * @program: Demo
 * @Date: 2019/2/20 20:59
 * @Author: LiJc
 * @Description:
 */
public class DESUtil {
    /**
     *  生成KEY
     */
    public static byte[] getKey(){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("----------------KEY生成失败！");
            return null;
        }
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byteKey = secretKey.getEncoded();
        return byteKey;
    }

    /**
     * DES加密
     *
     * @param context
     * @return
     */
    public static byte[] desEncrypt(String context, String key) {
        try {
            // KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey conventSecretKey = secretKeyFactory.generateSecret(desKeySpec);

            // 加密
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, conventSecretKey, new IvParameterSpec(key.getBytes("UTF-8")));
            return cipher.doFinal(context.getBytes("UTF-8"));
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * DES解密
     *
     * @param context
     * @return
     */
    public static byte[] desDecrypt(byte[] context, String key) {
        try {
            // KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey conventSecretKey = secretKeyFactory.generateSecret(desKeySpec);

            // 解密
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, conventSecretKey, new IvParameterSpec(key.getBytes("UTF-8")));
            return cipher.doFinal(context);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}

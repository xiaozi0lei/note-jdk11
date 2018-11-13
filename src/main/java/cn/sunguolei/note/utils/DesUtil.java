package cn.sunguolei.note.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class DesUtil {

    private final static String DES = "DES";

    /**
     * Description 根据键值进行加密
     *
     * @param data 加密的字串
     * @param key  加密键byte数组
     * @return 返回加密后的字串
     * @throws Exception 异常
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bt);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data 解密的数据
     * @param key  加密键byte数组
     * @return 返回解密后的字串
     * @throws Exception 异常
     */
    public static String decrypt(String data, String key) throws
            Exception {
        if (data == null) {
            return null;
        }

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] buf = decoder.decode(data);
        byte[] bt = decrypt(buf, key.getBytes());
        return new String(bt);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data 加密的数据
     * @param key  加密键byte数组
     * @return 返回加密后的数据
     * @throws Exception 异常
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey secureKey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);

        return cipher.doFinal(data);
    }


    /**
     * Description 根据键值进行解密
     *
     * @param data 解密的数据
     * @param key  加密键byte数组
     * @return 返回解密后的
     * @throws Exception 异常
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey secureKey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);

        return cipher.doFinal(data);
    }
}
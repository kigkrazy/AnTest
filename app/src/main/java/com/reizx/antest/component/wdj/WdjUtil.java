package com.reizx.antest.component.wdj;

import android.os.Binder;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class WdjUtil {
    /**
     * 阿里Utdid生成方法
     * @param inImei
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public final static byte[] _generateUtdid(String inImei) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String imei = inImei;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = IntUtils.getBytes(currentTimeMillis);
        byte[] bytes2 = IntUtils.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(IntUtils.getBytes(StringUtils.hashCode(imei)), 0, 4);
        byteArrayOutputStream.write(IntUtils.getBytes(StringUtils.hashCode(_calcHmac(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private static String _calcHmac(byte[] bArr) throws InvalidKeyException, NoSuchAlgorithmException {
        String str = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(str.getBytes(), instance.getAlgorithm()));
        return Base64.encodeToString(instance.doFinal(bArr), 2);
    }

}

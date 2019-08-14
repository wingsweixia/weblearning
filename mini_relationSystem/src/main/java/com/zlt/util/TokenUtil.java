/**
 * @Description: java类作用描述
 * @Author: weixia
 * @CreateDate: 2019/8/8$ 10:29$
 * @UpdateUser: yc
 * @UpdateDate: 2019/8/8$ 10:29$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
package com.zlt.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenUtil {        //使用单例模式，使全局只有一个TokenUtil类对象
    private static TokenUtil instance=null;//如果在类加载的时候初始化该实例对象，属于饿汉模式，在使用时才初始化属于懒汉模式

    private TokenUtil(){    //单例模式的私有构造方法
    }

    public static TokenUtil getInstance(){
        if(instance==null) {        //如果为空，调用构造方法创建一个对象并返回
            instance = new TokenUtil();
            return instance;
        }
        else        //否则直接返回对象
            return instance;
    }

    public String getToken(){
        String encodetoken="";
        //生成令牌
        String token=(System.currentTimeMillis()+new Random().nextInt(999999))+"";
        //对令牌进行加密
        try {
            MessageDigest md=MessageDigest.getInstance("md5");//获取一个使用md5加密算法的实例对象
            byte[] mds=md.digest(token.getBytes());
            BASE64Encoder encoder =new BASE64Encoder();
            encodetoken=encoder.encode(mds);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodetoken;
    }

}

package com.zhou.music_admin.contentprovider.function;

import org.apache.shiro.codec.Base64;

public class Transverter {

    public  static  String toDcode(String sourceCode ){
        if(Base64.isBase64(sourceCode.getBytes())){
            return "";
        }
        return Base64.decodeToString(sourceCode);
    }
    public static  String toEncode(String sourceCode){
        return Base64.encodeToString(sourceCode.getBytes());
    }
}

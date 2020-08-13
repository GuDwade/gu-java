package gu.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class JSONUtil {

    private  static ObjectMapper MAPPER;

    static{
        MAPPER=new ObjectMapper();
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }




    public static <T> T read(InputStream is, Class<T> clazz){
        try {
            return  MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            throw  new RuntimeException("json反序列化操作出错",e);
        }
    }
}

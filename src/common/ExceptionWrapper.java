package common;

import exception.RecordNotFindException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExceptionWrapper {
    public static Map getError(Exception e){
        if (e instanceof SQLException){
            Map map=new HashMap();
            map.put("errorCode",101);
            map.put("errorMsg","error in dataBase");
            map.put("javaError",e.getMessage());
            return map;
        }else if (e instanceof RecordNotFindException){
            Map map=new HashMap();
            map.put("errorCode",102);
            map.put("errorMsg","record doesnt exists");
            map.put("javaErroe",e.getMessage());
            return map;
        }else if (e instanceof NumberFormatException){
            Map map=new HashMap();
            map.put("errorCode",103);
            map.put("errorMsg","give number");
            map.put("javaError",e.getMessage());
            return map;
        }else{
            Map map=new HashMap();
            map.put("errorCode",104);
            map.put("errorMsg","please call with support");
            map.put("javaError",e.getMessage());
            return map;
        }
    }

}

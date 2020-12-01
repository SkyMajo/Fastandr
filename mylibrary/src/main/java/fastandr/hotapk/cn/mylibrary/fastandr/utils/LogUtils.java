package fastandr.hotapk.cn.mylibrary.fastandr.utils;


import java.util.HashMap;

/**
 * Created by 61930 on 2019/12/30.
 */

public class LogUtils {

    public static HashMap createLog(String content){
        HashMap data = new HashMap();
        data.put("logContent",content);
        return data;
    }
}

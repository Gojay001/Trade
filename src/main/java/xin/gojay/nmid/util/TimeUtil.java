package xin.gojay.nmid.util;

import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class TimeUtil {
    /**
     * 获取当前日期
     * @return "yyyy-MM-dd"日期
     */
    public static String getNowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    /// 测试代码
    /*public static void main(String[] args){
        System.out.println(getNowDate());
    }*/
}

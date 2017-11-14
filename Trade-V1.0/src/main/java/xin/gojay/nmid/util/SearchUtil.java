package xin.gojay.nmid.util;

/**
 * @author Gojay
 * @date 2017/11/14.
 */
public class SearchUtil {
    public static String changeString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <string.length(); i++) {
            stringBuilder.append("%");
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString() + "%";
    }

    /// 测试代码
    /*public static void main(String[] args) {
        System.out.println(changeString("一二三"));
    }*/
}

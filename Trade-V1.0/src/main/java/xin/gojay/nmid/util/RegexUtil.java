package xin.gojay.nmid.util;

import java.util.regex.Pattern;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class RegexUtil {
    public static final String REGEX_MOBILE =
            "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    public static final String REGEX_EMAIL =
            "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isMobile(String tel) {
        return Pattern.matches(REGEX_MOBILE, tel);
    }

    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /// 测试代码
    /*public static void main(String[] args) {
        System.out.println(RegexUtil.isMobile("13677654123"));
        System.out.println(RegexUtil.isEmail("gao.jay@foxmail.com"));
    }*/
}

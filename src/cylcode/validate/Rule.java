package cylcode.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: validate
 * @Param:
 * @Author: C84133883 chenyingliang
 * @Date: 2020/1/3 17:04
 **/
public class Rule {

    /**
     * 值必传
     *
     * @param column 值
     * @return
     */
    public boolean required(String column) {
        if (null == column) {
            return false;
        }
        return true;
    }

    /**
     * 参数是否介于 min max 两个值
     *
     * @param column 值
     * @param min    其中值1
     * @param max    其中值2
     * @return
     */
    public boolean between(String column, String min, String max) {
        if (column.equals(min) || column.equals(max)) {
            return true;
        }
        return false;
    }

    /**
     * 参数值是否介于min和max 之间 不包含MIN和MAX本身的值
     *
     * @param column
     * @param min
     * @param max
     * @return
     */
    public boolean between(double column, double min, double max) {
        if (column > min && column < max) {
            return true;
        }
        return false;
    }

    /**
     * 比对值是否一至
     *
     * @param column
     * @param comparison
     * @return
     */
    public boolean match(String column, String comparison) {
        if (!column.equals(comparison)) {
            return false;
        }

        return true;
    }

    /**
     * 对比值是否不一至
     *
     * @param column
     * @param comparison 对比值
     * @return
     */
    public boolean notMatch(String column, String comparison) {
        if (column.equals(comparison)) {
            return false;
        }

        return true;
    }

    /**
     * 是否存在于数据组
     *
     * @param column
     * @param array
     * @return
     */
    public boolean inArray(String column, String[] array) {
        if (array == null || array.length < 1) {
            return false;
        }
        for (String s : array) {
            if (column.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否存在于数据组
     *
     * @param column
     * @param array
     * @return
     */
    public boolean inArray(int column, int[] array) {
        if (array == null || array.length < 1) {
            return false;
        }
        for (int i : array) {
            if (column == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否为奇数
     *
     * @param column
     * @return
     */
    public boolean isOddNumber(int column) {
        int re = column % 2;
        if (re == 0) {
            return false;
        }
        return true;
    }

    /**
     * 是否为偶数
     *
     * @param column
     * @return
     */
    public boolean evenNumber(int column) {
        int re = column % 2;
        if (re == 0) {
            return true;
        }
        return false;
    }

    /**
     * 是否正数
     *
     * @param column
     */
    public boolean isPositiveNumber(int column) {
        if (column > 0) {
            return true;
        }
        return false;

    }

    /**
     * 是否为负数
     *
     * @param column
     * @return
     */
    public boolean isNegativeNumber(int column) {
        if (column < 0) {
            return true;
        }
        return false;

    }

    /**
     * 是否一个有效的IP
     *
     * @param column
     * @return
     */
    public boolean isIp(String column) {
        return regex(column, "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");


    }

    /**
     * 给定的参数是否是字母 即[a-zA-Z]
     *
     * @param column
     * @return
     */
    public boolean alpha(String column) {
        return regex(column, "^[a-zA-Z]+$");
    }

    /**
     * 给定的参数是否是字母和数字组成 即[a-zA-Z0-9]
     *
     * @param column
     * @return
     */
    public boolean alphaNum(String column) {
        return regex(column, "^[a-zA-Z0-9]+$");
    }

    /**
     * 给定的参数是否是字母和数字下划线破折号组成 即[a-zA-Z0-9\-\_]
     *
     * @param column
     * @return
     */
    public boolean alphaDash(String column) {
        return regex(column, "^[a-zA-Z0-9-_]+$");
    }

    /**
     * 是否是URL
     *
     * @param column
     * @return
     */
    public boolean url(String column) {
        return regex(column, "[a-zA-z]+://[^\\\\s]*");
    }

    /**
     * 是否为数字
     *
     * @param column
     * @return
     */
    public boolean number(String column) {
        return regex(column, "^d+$");
    }

    /**
     * 最大长度
     *
     * @param column
     * @param length
     * @return
     */
    public boolean maxLength(String column, int length) {
        if (column.length() > length) {
            return false;
        }
        return true;

    }

    /**
     * 最小长度
     *
     * @param column
     * @param length
     * @return
     */
    public boolean minLenght(String column, int length) {
        if (column.length() < length) {
            return false;
        }
        return true;
    }

    /**
     * 验证数组或字符串的长度是否在一个区间里面
     *
     * @param column
     * @param min
     * @param max
     * @return
     */
    public boolean betweenLength(String column, int min, int max) {
        int stringLength = column.length();
        if (stringLength > min && stringLength < max) {
            return true;
        }
        return false;
    }

    /**
     * 正则表达式验证
     *
     * @param column
     * @param rex
     * @return
     */
    public boolean regex(String column, String rex) {
        return Pattern.compile(rex).matcher(column).matches();

    }

    /**
     * 在某个日期之后
     *
     * @param column
     * @param date
     * @return
     */
    public boolean afterDate(String column, String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse(column);
        Date date2 = format.parse(column);
        if (date1.compareTo(date2) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 在某个日期之间
     *
     * @param column
     * @param date
     * @return
     */
    public boolean beforeDate(String column, String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse(column);
        Date date2 = format.parse(column);
        if (date1.compareTo(date2) < 0) {
            return true;
        }
        return false;
    }

    /**
     * 介于两日期之间
     * @param column
     * @param begin
     * @param end
     * @return
     */
    public boolean betweenDate(String column,String begin,String end) throws ParseException {
        if(afterDate(column,begin)&&beforeDate(column,end)){
            return true;
        }
        return false;
    }

}

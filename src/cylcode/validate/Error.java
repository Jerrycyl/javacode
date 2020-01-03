package cylcode.validate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: validate
 * @Param:
 * @Author: C84133883 chenyingliang
 * @Date: 2020/1/3 17:05
 **/
public class Error {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldAlias() {
        return fieldAlias;
    }

    public void setFieldAlias(String fieldAlias) {
        this.fieldAlias = fieldAlias;
    }

    private String fieldAlias;
    private Map<String,String> defaultErrorMsg;
    public Error() {
        defaultErrorMsg = new HashMap<>();
        defaultErrorMsg.put("required",":fieldName必须填写");
        defaultErrorMsg.put("between",":fieldName只能在 :arg0 - :arg1 之间");
        defaultErrorMsg.put("match",":fieldName值比对不一致");
        defaultErrorMsg.put("notMatch",":fieldName值比对一致");
        defaultErrorMsg.put("inArray",":fieldName必须存在数组中");
        defaultErrorMsg.put("isOddNumber",":fieldName只能为奇数");
        defaultErrorMsg.put("evenNumber","fieldName只能为偶数");
        defaultErrorMsg.put("isPositiveNumber",":fieldName只能为正数");
        defaultErrorMsg.put("isNegativeNumber",":fieldName只能为负数");
        defaultErrorMsg.put("isIp",":fieldName只能为IP值");
        defaultErrorMsg.put("alpha",":fieldName只能全部为字母");
        defaultErrorMsg.put("alphaNum",":fieldName只能是字母和数字");
        defaultErrorMsg.put("alphaDash",":fieldName只能是字母数字下划线和破折号");
        defaultErrorMsg.put("url",":fieldName只能是URL");
        defaultErrorMsg.put("number",":fieldName只能是数字");
        defaultErrorMsg.put("maxLength",":fieldName长度不能超过:arg0");
        defaultErrorMsg.put("minLenght",":fieldName长度不能小于:arg0");
        defaultErrorMsg.put("betweenLength",":fieldName长度只能介于:arg0和:arg1之间");
        defaultErrorMsg.put("regex",":fieldName不符合指定规则");
        defaultErrorMsg.put("afterDate",":fieldName必须在:arg0之后");
        defaultErrorMsg.put("beforeDate",":fieldName必须在:arg0之前");
        defaultErrorMsg.put("betweenDate",":fieldName必须介于:arg0和arg1之间");

    }

    /**
     * 析构函数
     */
    public void  finalize(){

    }

}

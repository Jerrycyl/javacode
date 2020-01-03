package cylcode;

import java.util.Collections;
import java.util.Map;

/**
 * @Description: validate 验证方法
 * @Param:
 * @Author: C84133883 chenyingliang
 * @Date: 2020/1/3 17:03
 **/
public class Validate<T> {

    protected String errorMsg;


    public String getError() {
        return this.error;
    }

    /**
     * @param data  原始数据对象
     * @param rule  规则
     * @param alias 别名
     * @pay attention to :
     */
    public boolean Validate(T[] data, Map<String, String> rule, Map<String, String> alias) throws Exception {
        if (data == null) {

            this.error = "需验证数据不能为空"；
            return false;
        }
        if (rule == null || Collections.emptyMap(rule)) {
            this.error = "验证规则不能为空";
            return false;
        }
        this.doValidate(data, rule, alias);

        return true;
    }

    private init

    /**
     * 验证字段是否合法
     *
     * @param array $data
     * @return bool
     */
    public boolean doValidate(T[] data, Map<String, String> rule, Map<String, String> alias) {
        for (T datum : data) {

            }

//            foreach($rules as $rule = > $ruleInfo){
//                if (!call_user_func([$this,$rule ],$spl, $column, $ruleInfo['arg'])){
//                    $this -> error = new Error($column, $spl -> get($column), $item['alias'], $rule, $ruleInfo['msg'], $ruleInfo['arg']);
//                    return false;
//                }
//            }
            $this -> verifiedData[$column] = $spl -> get($column);
        }

        return true;
    }


}

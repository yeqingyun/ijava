package cn.ilovejava.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yqy on 2016/7/14.
 */
public class JsonResult {
    private boolean success;
    private String msg;
    private Map<String,Object> data = new HashMap<>();

    public JsonResult() {
    }

    public JsonResult(boolean success) {
        this.success = success;
    }

    public JsonResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public void addData(String str,Object obj){
        data.put(str,obj);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

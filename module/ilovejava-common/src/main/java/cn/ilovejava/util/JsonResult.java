/**
 *
 */
package cn.ilovejava.util;
import java.util.HashMap;
import java.util.Map;


/**
 * @author  wuchenghua
 */
public class JsonResult {

    /**
     * 是否成功
     */
    private boolean success = false;

    /**
     * 消息
     */
    private String msg = "";

    /**
     * 数据
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    public JsonResult() {
    }

    /**
     * 以成功标志来构造
     *
     * @param success
     */
    public JsonResult(boolean success) {
        this.success = success;
    }

    /**
     * 以消息来构造
     *
     * @param msg
     */
    public JsonResult(String msg) {
        this.msg = msg;
    }

    /**
     * 以成功标志和消息来构造
     *
     * @param success
     * @param msg
     */
    public JsonResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }


    /**
     * 加入数据项
     *
     * @param name
     * @param value
     */
    public JsonResult addData(String name, Object value) {
        data.put(name, value);
        return this;
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

package com.scdkay.website.entity;

/**
 * 封装返回结果的实体类
 * Created by liurui on 2017/7/13.
 *
 * @param <T> 消息主体
 */
public class ResultEntity<T> {
    private int response_code;
    private String response_message;
    private String response_time;
    private T response_result;

    public ResultEntity() {
    }

    public ResultEntity(int response_code, String response_message, String response_time, T response_result) {
        this.response_code = response_code;
        this.response_message = response_message;
        this.response_time = response_time;
        this.response_result = response_result;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public String getResponse_time() {
        return response_time;
    }

    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }

    public T getResponse_result() {
        return response_result;
    }

    public void setResponse_result(T response_result) {
        this.response_result = response_result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultEntity<?> that = (ResultEntity<?>) o;

        if (response_code != that.response_code) return false;
        if (response_message != null ? !response_message.equals(that.response_message) : that.response_message != null)
            return false;
        if (response_time != null ? !response_time.equals(that.response_time) : that.response_time != null)
            return false;
        return response_result != null ? response_result.equals(that.response_result) : that.response_result == null;
    }

    @Override
    public int hashCode() {
        int result = response_code;
        result = 31 * result + (response_message != null ? response_message.hashCode() : 0);
        result = 31 * result + (response_time != null ? response_time.hashCode() : 0);
        result = 31 * result + (response_result != null ? response_result.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "response_code=" + response_code +
                ", response_message='" + response_message + '\'' +
                ", response_time='" + response_time + '\'' +
                ", response_result=" + response_result +
                '}';
    }
}

package com.scdkay.website.base;


import com.scdkay.website.utils.DateUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器基类，对请求返回和日志进行统一管理
 * Created by liurui on 2017/7/10.
 */
public class BaseController {
    //日志记录
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * 向前端页面返回json数据
     *
     * @param obj 返回的数据对象
     */
    String printFormatJson2UI(Object obj) {

        ObjectMapper mapper = new ObjectMapper();
        if (obj == null) {
            return "{\"response_code\":400,\"response_time\":\"" + DateUtil.currentDate("yyyy-MM-dd HH:mm:ss") + "\",\"response_result\":{\"返回对象为空！\"}}";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("response_code", 200);
        map.put("response_time", DateUtil.currentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("response_result", obj);
        try {
            return mapper.writeValueAsString(map);
        } catch (IOException e) {
            LOGGER.error("对象转json出错!", e);
            return "{\"response_code\":500,\"response_time\":\"" + DateUtil.currentDate("yyyy-MM-dd HH:mm:ss") + "\",\"response_result\":{\"对象转json出错！\"}}";
        }
    }
}

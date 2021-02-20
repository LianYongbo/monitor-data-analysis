package com.bdilab.monitor.util;

import org.springframework.stereotype.Component;

/**
 * 验证参数完整性
 *
 * @author Lian
 * @date 2021/2/16 21:16
 **/
@Component
public class VerifyIntegrity {
    /**
     * 验证String类型的参数是否为空或为Null
     *
     * @param field String类型的参数
     * @return 参数为空或为Null返回true；否则返回false
     */
    public Boolean verify(String field) {
        return "".equals(field) || field == null;
    }
}

package org.jclg.ems.Ret;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode implements IResponseCode {

    /**
     * 成功
     */
    SUCCESS(200, "请求成功"),

    /**
     * 失败
     */
    FAIL(400, "请求失败"),

    /**
     * 用户信息不存在
     */
    USER_NOT_FOUND(10001, "用户信息不存在"),
    ;

    /**
     * code
     */
    final Integer code;

    /**
     * message desc
     */
    final String message;
}
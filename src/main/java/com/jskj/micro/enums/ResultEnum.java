package com.jskj.micro.enums;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.enums
 * @description 一级错误和其他错误:均为9xxx,http状态码:均为xxx
 * @date 2018-05-04 13:35 星期五
 */
public enum ResultEnum {
    // ****************************【公共错误】****************************
    /**
     * 1002(失败)
     */
    FAIL("1002", "失败"),

    // ****************************【文件错误】****************************
    /**
     * 1004(文件不能为空)
     */
    FILE_IS_EMPTY("1004", "文件不能为空"),

    /**
     * 1005（文件不能大于10M）
     */
    FILE_TOO_BIG("1005", "文件不能大于10M"),
    // ****************************【一级错误】****************************
    /**
     * 9001(数据不唯一错误)
     */
    NONUNIQUE_ERROR("9001", "不唯一错误"),
    /**
     * 9002(Redis缓存没有开启)
     */
    REDIS_NO_OPEN("9002", "服务器缓存异常"),
    /**
     * 9003(执行数据库操作错误)
     */
    EXECUTE_SQL_ERROR("9003", "执行数据库操作错误"),

    /**
     * 9004(参数错误，请确认格式是否正确)
     */
    PARAMS_ERROR("9004", "参数错误，请确认格式是否正确"),

    /**
     * 9005(文件路径错误)
     */
    FILE_PATH_ERROR("1006", "文件路径错误"),

    /**
     * 9006(IO异常)
     */
    IO_ABNORMAL("9006", "IO异常"),

    /**
     * (9007)http内容不可读异常
     */
    HTTP_MESSAGE_NOT_READABLE("9007", "http内容不可读异常"),
    /**
     * 9008(json异常)
     */
    JSON_ERROR("9008", "json异常"),

    /**
     * 9009(空指针异常)
     */
    NULL_POINTER("9009", "空指针异常"),
    /**
     * 9010(类型转换异常)
     */
    CLASS_CAST("9010", "类型转换异常"),
    /**
     * 9011(未知方法异常)
     */
    NO_SUCH_METHOD("9011", "未知方法异常"),

    /**
     * 9012(下标越界异常)
     */
    INDEX_OUT_OF_BOUNDS("9012", "下标越界异常"),

    // ****************************【http状态码】****************************
    /**
     * 100(继续)
     */
    CONTINUE("100", "继续"),

    /**
     * 101(切换协议)
     */
    SWITCHING_PROTOCOLS("101", "切换协议"),

    /**
     * 200(成功)
     */
    OK("200", "成功"),

    /**
     * 201(已创建)
     */
    CREATED("201", "已创建"),

    /**
     * 202(已接受)
     */
    ACCEPTED("202", "已接受"),

    /**
     * 203(非授权信息)
     */
    NON_AUTHORITATIVE_INFORMATION("203", "非授权信息"),

    /**
     * 204(无内容)
     */
    NO_CONTENT("204", "无内容"),

    /**
     * 205(重置内容)
     */
    RESET_CONTENT("205", "重置内容"),

    /**
     * 206(部分内容)
     */
    PARTIAL_CONTENT("206", "部分内容"),

    /**
     * 300(多种选择)
     */
    MULTIPLE_CHOICES("300", "多种选择"),

    /**
     * 301(永久移动)
     */
    MOVED_PERMANENTLY("301", "永久移动"),

    /**
     * 302(临时移动)
     */
    FOUND("302", "临时移动"),

    /**
     * 303(查看其他位置)
     */
    SEE_OTHER("303", "查看其他位置"),

    /**
     * 304(未修改)
     */
    NOT_MODIFIED("304", "未修改"),

    /**
     * 305(使用代理)
     */
    USE_PROXY("305", "使用代理"),

    /**
     * 306(临时重定向)
     */
    TEMPORARY_REDIRECT("307", "临时重定向"),

    /**
     * 400(错误请求)
     */
    BAD_REQUEST("400", "错误请求"),

    /**
     * 401(未授权)
     */
    UNAUTHORIZED("401", "未授权"),

    /**
     * 403(已禁止)
     */
    FORBIDDEN("403", "已禁止"),

    /**
     * 404(未找到)
     */
    NOT_FOUND("404", "未找到"),

    /**
     * 405(方法禁用)
     */
    METHOD_NOT_ALLOWED("405", "方法禁用"),

    /**
     * 406(不接受)
     */
    NOT_ACCEPTABLE("406", "不接受"),

    /**
     * 407(需要代理授权)
     */
    PROXY_AUTHENTICATION_REQUIRED("407", "需要代理授权"),

    /**
     * 408(请求超时)
     */
    REQUEST_TIMEOUT("408", "请求超时"),

    /**
     * 409(冲突)
     */
    CONFLICT("409", "冲突"),

    /**
     * 410(已删除)
     */
    GONE("410", "已删除"),

    /**
     * 411(需要有效长度)
     */
    LENGTH_REQUIRED("411", "需要有效长度"),

    /**
     * 412(未满足前提条件)
     */
    PRECONDITION_FAILED("412", "未满足前提条件"),

    /**
     * 413(请求实体过大)
     */
    REQUEST_ENTITY_TOO_LARGE("413", "请求实体过大"),

    /**
     * 414(请求的 URI 过长)
     */
    REQUEST_URI_TOO_LONG("414", "请求的 URI 过长"),

    /**
     * 415(不支持的媒体类型)
     */
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型"),

    /**
     * 416(请求范围不符合要求)
     */
    REQUESTED_RANGE_NOT_SATISFIABLE("416", "请求范围不符合要求"),

    /**
     * 417(未满足期望值)
     */
    EXPECTATION_FAILED("417", "未满足期望值"),

    /**
     * 500(服务器内部错误)
     */
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),

    /**
     * 501(尚未实施)
     */
    NOT_IMPLEMENTED("501", "尚未实施"),

    /**
     * 502(错误网关)
     */
    BAD_GATEWAY("502", "错误网关"),

    /**
     * 503(服务不可用)
     */
    SERVICE_UNAVAILABLE("503", "服务不可用"),

    /**
     * 504(网关超时)
     */
    GATEWAY_TIMEOUT("504", "网关超时"),

    /**
     * 505(HTTP 版本不受支持)
     */
    HTTP_VERSION_NOT_SUPPORTED("505", "HTTP 版本不受支持"),
    // ****************************【其他错误】****************************

    /**
     * 该id不存在
     */
    FINDMSGBYID_FAILURE("9998", "枚举id不存在"),

    /**
     * 该内容不存在
     */
    FINDIDBYMSG_FAILURE("9999", "枚举内容不存在");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的状态id查找内容
     * @title findMsgByid
     */
    public static ResultEnum findMsgByid(String id) {
        for (ResultEnum resultEnum : values()) {
            if (resultEnum.getCode().equals(id)) {
                return resultEnum;
            }
        }
        return FINDMSGBYID_FAILURE;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的内容查找id
     * @title findidByMsg
     */
    public static ResultEnum findidByMsg(String mgs) {
        for (ResultEnum resultEnum : values()) {
            if (resultEnum.getMsg().equals(mgs)) {
                return resultEnum;
            }
        }
        return FINDIDBYMSG_FAILURE;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

package com.example.demo.entity;

/**
 * 返回编码
 * 
 * @author kakasun
 * @create 2018-03-11 上午8:28
 */
public enum ResponseCode {

	/** *0 SUCCESS* */
	SUCCESS(0,"SUCCESS"),
	/** *500 服务器异常* */
	ERROR(500,"服务器异常"),
	/** *1000 参数无效或缺失* */
	INVALID_PARAMETER(1000,"参数无效或缺失"),
	/** *1001 API key无效* */
	INVALID_API_KEY(1001,"API key无效"),
	/** *1003 Call_id参数无效或已被使用* */
	INVALIDCALL_ID_PARAMETER(1003,"Call_id参数无效或已被使用"),
	/** *1004 签名无效* */
	INCORRECT_SIGNATURE(1004,"签名无效"),
	/** *1005 参数过多* */
	TOO_MANY_PARAMETERS(1005,"参数过多"),
	/** *1006 后端服务暂时不可用* */
	SERVICE_TEMPORARILY_UNAVAILABLE(1006,"后端服务暂时不可用"),
	/** *1007 Open API接口不被支持* */
	UNSUPPORTED_OPENAPI_METHOD(1007,"Open API接口不被支持"),
	/** *1008 应用对open api接口的调用请求数达到上限* */
	REQUEST_LIMIT_REACHED(1008,"应用对open api接口的调用请求数达到上限"),
	/** *1009 验证码错误或过期* */
	CODE_INVALID(1009,"验证码错误或过期"),
	/** *1010 无此权限* */
	NO_PERMISSION(1010,"无此权限"),
	/** *2000 没有权限访问数据* */
	NO_PERMISSION_TO_ACCESS_DATA(2000,"没有权限访问数据"),
	/** *403000 用户未登录* */
	NEED_LOGIN(403000,"用户未登录"),
	/** *403001 账号密码不正确* */
	PASSWORD_REEOR(403001,"账号密码不正确"),
	/** *403002 账号不存在* */
	LOGINNAME_NOT_EXISTS(403002,"账号不存在"),
	/** *403003 密码不正确* */
	PASSWORD_WRONG(403003,"密码不正确"),
	/** *9000 流程参数不全* */
	ACT_PARAM_ERROR(9000,"流程参数不全"),
	/** *9001 业务主键为空* */
	BUSINESS_ID(9001,"业务主键为空"),
	/** *9003 业务操作错误* */
	BUSINESS_ERROR(9003,"业务操作错误"),
	/** *30001 Excel验证区域参数设置错误* */
	EXCEL_VALIDATION_CELL_ERROR(30001,"Excel验证区域参数设置错误"),
	/** *30002 Excel验证区域值不能为空* */
	EXCEL_VALIDATION_DATA_ERROR(30002,"Excel验证区域值不能为空");
	
	private final int code;
	private final String desc;

	ResponseCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}

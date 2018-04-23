package com.eyunhome.baseappframework.listener;

/**
 * 服务器结果回调
 * @author benhua
 *
 */
public abstract class ResponseResultListener<T> {
	/**
	 * 处理响应
	 * @param result 服务器响应
	 */
	public  abstract void  doResponse(T result);
}

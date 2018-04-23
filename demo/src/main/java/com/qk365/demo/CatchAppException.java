package com.qk365.demo;

import android.content.Context;

import com.eyunhome.baseappframework.common.LogUtil;
import com.qk365.demo.util.Constants;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 捕获应用错误
 */


public class CatchAppException implements UncaughtExceptionHandler {
	// 捕获全局异常  
	private Context mContext;
	private UncaughtExceptionHandler defaultHandler;
	public CatchAppException(Context context) {
		mContext = context;
		defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
	}

	public void uncaughtException(Thread arg0, Throwable arg1) {
		// 3.把错误的堆栈信息 获取出来   
		String errorinfo = "[---------程序挂掉-----]:"+getErrorInfo(arg1);
		String logFileDirectory = Constants.LogDef.LOG_DIRECTORY;
		String errorFileName = "error_log.txt";
		LogUtil.log(errorinfo, logFileDirectory, errorFileName);
		defaultHandler.uncaughtException(arg0,arg1);
	}
	
	/** 
	* 获取错误的信�? 
	* @param arg1 
	* @return 
	*/  
	private String getErrorInfo(Throwable arg1) {
		Writer writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		arg1.printStackTrace(pw);  
		pw.close();  
		String error= writer.toString();
		return error;  
	}  

}

package cn.edu.neu.core.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用返回结果类，保存了操作结果信息
 */
public class ExecuteResult {

	private String result = "success";//操作结果
	private String message = "";//提示信息
	private Map redirURLs = new HashMap();//下一步操作
	
	public void setResult(String result) {
		this.result = result;
	}

	public void addRedirURL(String desc, String url) {
		this.redirURLs.put(desc, url);
	}

	public void addMessage(String msg) {
		this.message=(msg);
	}

	public String getResult() {
		return result;
	}

	public Map getRedirURLs() {
		return redirURLs;
	}
	
	public String getMessage() {
		return message;
	}
}
package net.totome.iot.web.rms.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

public class BaseAction{
	
	private HttpServletResponse response;
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private HttpServletRequest request;
	
	public void writeJson(Object object){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer;
		JSONObject json = JSONObject.fromObject(object);
		try {
			writer = getResponse().getWriter();
			writer.write(json.toString());
			writer.flush();
			writer.close();
			writer = null;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Map<String, Object> jsonToMap(JSONObject jsonObj){
		return null;
	}
}

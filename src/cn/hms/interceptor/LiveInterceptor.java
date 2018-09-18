package cn.hms.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LiveInterceptor extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object obj = session.getAttribute("liveList");
		Object obj2 = session.getAttribute("listLike");
		if((obj == null && obj =="") || (obj2 == null && obj2 == "")){
			return "error";
		}
		return invocation.invoke();
	}

}

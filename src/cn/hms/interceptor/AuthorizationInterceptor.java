package cn.hms.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Object loginUser = invocation.getInvocationContext().getSession().get("user");
		if(loginUser == null){
			return "error";
		}else{
			return invocation.invoke();
		}
	}

}

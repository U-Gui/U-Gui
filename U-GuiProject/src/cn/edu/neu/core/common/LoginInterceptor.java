package cn.edu.neu.core.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.neu.core.Constants;
import cn.edu.neu.core.util.QueryUtil;




/**
 * 登录拦截器，用于阻止未登录用户访问系统
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
	     System.out.println(arg2.getClass().getName());

		if (arg2 instanceof HandlerMethod&& 
				((HandlerMethod) arg2).getBean() instanceof Anonymous ) {
			System.out.println("here");
			return true;
		}
		else{
			if (CommonBaseAction.getSession().getAttribute(
						Constants.LOGIN_USER) != null) {
				return true;
			}
		} 
		System.out.println("----logininterceptor:"+arg0.getHeader("Referer")+","+QueryUtil.getRequestURL(arg0));
		System.out.println("========"+arg0.getServletPath());
		System.out.println("========"+QueryUtil.getRequestURL(arg0));
		CommonBaseAction.getSession().setAttribute(Constants.ORIGINAL_URL,
					QueryUtil.getRequestURL(CommonBaseAction.getRequest()));
		//ExecuteResult er=new ExecuteResult();
		if(arg0.getHeader("x-requested-with")==null){//若客户端请求是传统同步请求
			
			arg0.setAttribute("redirUrl", arg0.getContextPath()+QueryUtil.getRequestURL(arg0));
			arg0.setAttribute("backUrl", arg0.getHeader("Referer"));
			if(arg0.getServletPath().startsWith("/admin")){
				arg0.getRequestDispatcher(Constants.ADMIN_LOGIN_URL).forward(arg0, arg1);
			}
			else{			
				arg0.getRequestDispatcher(Constants.LOGIN_URL).forward(arg0, arg1);
			}
		}
		else{//若客户端请求是Ajax异步请求
			/*er.addMessage(Constants.LOGIN_PROMPT);
			er.addRedirURL("关闭窗口", "");
			arg0.setAttribute("execute_result", er);	
			arg0.getRequestDispatcher("/execute_result").forward(arg0, arg1);*/
			arg1.setContentType("text/json;charset=UTF-8");
			PrintWriter out=arg1.getWriter();
			out.print("{\"login\":\""+Constants.LOGIN_PROMPT+"\"}");
			out.flush();
			out.close();
		}
		return false;
	}

}

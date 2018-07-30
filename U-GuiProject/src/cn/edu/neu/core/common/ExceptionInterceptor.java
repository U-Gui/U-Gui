package cn.edu.neu.core.common;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class ExceptionInterceptor implements HandlerInterceptor {


/*	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			ActionContext ac = invocation.getInvocationContext();
			HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
			//处理上传时的错误
			if (request instanceof MultiPartRequestWrapper) {
				MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;
				if (multiWrapper.hasErrors()) {
					StringBuffer errorsb = new StringBuffer(128);
					for (Iterator errorIter = multiWrapper.getErrors().iterator(); errorIter.hasNext();) {
						errorsb.append(errorIter.next());
					}
					String error = errorsb.toString();
					//对jakarta的错误信息进行匹配
					Pattern p = Pattern
							.compile("the request was rejected because its size \\((\\d+)\\) exceeds the configured maximum \\((\\d+)\\)");
					Matcher m = p.matcher(error);
					if (m.find()) {
						ac.put(Constants.CONTEXT_EXCEPTION, "您上传文件的尺寸为 (" + m.group(1) + ") 字节，超过了最大限制 (" + m.group(2)
								+ ") 字节。");
					} else {
						ac.put(Constants.CONTEXT_EXCEPTION, "上传时发生异常。");
					}
					ac.put(Constants.CONTEXT_EXCEPTION_INFO, error.toString());
					return Constants.EXCEPTION;
				}
			}
			return invocation.invoke();
		} catch (Exception e) {
			handleException(invocation, e);
			return Constants.EXCEPTION;
		}

	}

	private void handleException(ActionInvocation invocation, Exception e) {
		String message = "Caught exception while invoking action: " + invocation.getAction();
		log.error(message, e);

		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		invocation.getInvocationContext().put(Constants.CONTEXT_EXCEPTION, e.toString());
		invocation.getInvocationContext().put(Constants.CONTEXT_EXCEPTION_INFO, sw.toString());
	}*/

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
		return false;
	}

}

package product.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditLoggingInterceptor extends HandlerInterceptorAdapter {

	Logger logger = Logger.getLogger("auditLogger");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();

		logger.info("client host :  " + remoteHost);
		logger.info("client port : " + remotePort);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}

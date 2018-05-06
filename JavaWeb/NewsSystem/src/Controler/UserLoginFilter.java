package Controler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.webresources.Cache;

import com.sun.jersey.api.core.HttpResponseContext;

public class UserLoginFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FilterConfig filterConfig;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		try{
				HttpServletRequest httpRequest = (HttpServletRequest)request;
				HttpServletResponse httpResponse = (HttpServletResponse)response;
				boolean isVaild = true; //isVaild�ĳ�ʼֵΪtrue
				String uriStr = httpRequest.getRequestURI().toUpperCase();
				//�����½ҳ�治��login.jsp����Session�����У�currentUserΪ�գ�
				//��ôisVaildֵ����Ϊfalse
				if(uriStr.indexOf("LOGIN") == -1 && httpRequest.getSession().getAttribute("currentUser") == null){
					isVaild = false;
				}
	//			if(uriStr.indexOf("FINDNEWSLISTSERVEL") != -1){
	//				isVaild = true;
	//			}
				if(isVaild){
					filterChain.doFilter(request, response);
				}else{
					httpResponse.sendRedirect("/NewsSystem/Login.jsp");
				}
			}catch (ServletException sx){
				filterConfig.getServletContext().log(sx.getMessage());
			}catch(IOException iox){
				filterConfig.getServletContext().log(iox.getMessage());
			}
			
		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {

		this.filterConfig = filterConfig;
		
	}

}

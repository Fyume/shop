package cn.edu.zhku.jsj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(filterName = "/CacheFilter", urlPatterns = "*.jpg",initParams={@WebInitParam(name="cacheTiem",value="10")})
public class CacheFilter implements Filter {
	private FilterConfig fg;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		String url=request.getRequestURI();
		int expires=0;//假如是分钟
		if(url.endsWith(".jpg") || url.endsWith(".png") || url.endsWith(".gif")){
		expires=Integer.parseInt(fg.getInitParameter("cacheTiem"));
		}
		response.setDateHeader("Expires", System.currentTimeMillis()+expires*60*1000);
		//这里的时间是毫秒来算的，只是偏差值，要在系统时间的基础上，即这个时间位置相当于结束时间
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.fg=filterConfig;
	}

}

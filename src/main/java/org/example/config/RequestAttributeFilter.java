package org.example.config;

import java.io.IOException;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

@Component
public class RequestAttributeFilter implements Filter {

	public static final String NAME_ATTRIBUTE = RequestAttributeFilter.class.getName();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute(NAME_ATTRIBUTE, "Sowmiya");
		chain.doFilter(request, response);
	}

}

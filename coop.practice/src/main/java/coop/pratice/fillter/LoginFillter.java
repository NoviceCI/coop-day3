package coop.pratice.fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coop.pratice.beans.UserBean;

public class LoginFillter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fillterChain) throws IOException, ServletException {

		UserBean userBean = (UserBean) ((HttpServletRequest) request)
				.getSession().getAttribute("userBean");

		if (userBean == null || !userBean.isLogin) {

			String ctxPath = ((HttpServletRequest) request).getContextPath();

			((HttpServletResponse) response).sendRedirect(ctxPath
					+ "/index.xhtml");

		}

		fillterChain.doFilter(request, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

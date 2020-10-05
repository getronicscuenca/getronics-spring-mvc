package es.getronics.controller.interceptors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

public class LocaleChangeInterceptorGetronics extends LocaleChangeInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.i18n.LocaleChangeInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		String newLocale = request.getParameter(this.getParamName());
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		if(newLocale == null) {
			newLocale = "es_ES";
		}
		if (newLocale != null) {
			
			if (localeResolver == null) {
				throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
			}
			localeResolver.setLocale(request, response, StringUtils.parseLocaleString(newLocale));
		}
		// Proceed in any case.
		return true;
	}
}

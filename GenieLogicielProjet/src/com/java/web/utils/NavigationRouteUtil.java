package com.java.web.utils;

import javax.servlet.http.HttpServletRequest;

public class NavigationRouteUtil {
	public final static String SUFFIX = ".jsp";	
	public final static String PREFIX = "/views/";
	
	public static String navigate(HttpServletRequest request, String view, String page) {
		if("".equals(view)) {
			
			view = "/views/Home.jsp";
		}

		request.setAttribute("page", page + ".jsp");
		
		return PREFIX + view + SUFFIX;
	}
}

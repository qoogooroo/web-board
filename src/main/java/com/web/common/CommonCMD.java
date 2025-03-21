package com.web.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonCMD {

	public static String getCmd(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		if(idx > 0 ) {
			return uri.substring(idx);
		}
		return null;
	}
	
	public static void viewsForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
	
	public static void msgForawrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views/common/msg";
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}

package com.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.web.common.CommonView;
import com.web.dto.UserDTO;
import com.web.service.UserService;

@WebServlet(urlPatterns="/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		UserDTO user = new UserDTO();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		String url = "";
		String msg = "";
		if("join".equals(cmd)) {
			int result = userService.addUser(user);
			msg = "회원가입시 성공하였습니다";
			url = "/views/user/login";
			if(result==-1) {
				msg = "이미 존재하는 아이디입니다.";
				url = "/views/user/join";
			}
		} else if("login".equals(cmd)) {
			UserDTO loginUser = userService.login(user.getUiId(), user.getUiPwd());
			HttpSession session = request.getSession();
			session.setAttribute("user", loginUser);
			msg = "아이디나 비밀번호가 잘못되었습니다.";
			url = "/view/user/login";
			if(loginUser!=null) {
				msg = loginUser.getUiName() + "님 반갑습니다.";
				url="/";
			}
		}
		CommonView.forwardMsg(request, response, msg, url);

	}

}

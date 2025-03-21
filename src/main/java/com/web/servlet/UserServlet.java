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

//		String uri = request.getRequestURI();
//		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
//		response.setContentType("text/html;charset=UTF-8");
//		if ("user-list".equals(cmd)) {
//			String search = request.getParameter("search");
//			String searchStr = request.getParameter("searchStr");
//			Map<String,String> param = new HashMap<>();
//			param.put("search", search);
//			param.put("searchStr", searchStr);
//			List<UserDTO> users = userService.getUsers(param);
//			request.setAttribute("users", users);
//		} else if ("user-view".equals(cmd) || "user-update".equals(cmd)) {
//			String uiNumStr = request.getParameter("uiNum");
//			int uiNum = Integer.parseInt(uiNumStr);
//			UserDTO user = userService.getUser(uiNum);
//			request.setAttribute("user", user);
//		}
//		RequestDispatcher rd = request.getRequestDispatcher("/views" + uri);
//		rd.forward(request, response);
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
		}
		CommonView.forwardMsg(request, response, msg, url);
//		request.setCharacterEncoding("UTF-8");//한글 인코딩 세팅 안하면 한글이 깨져서 나옴
//		String uri = request.getRequestURI();
//		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
//		
//		UserDTO user = new UserDTO();
//		try {
//			BeanUtils.populate(user, request.getParameterMap());
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		
//		String msg = "";
//		String url = "";
//		if("login".equals(cmd)) {
//			UserDTO loginUser = userService.login(user.getUiId(), user.getUiPwd());
//			HttpSession session = request.getSession();
//			session.setAttribute("user", loginUser);
//			msg = "아이디나 비밀번호가 잘못되었습니다.";
//			url = "/view/user/login";
//			if(loginUser!=null) {
//				msg = loginUser.getUiName() + "님 반갑습니다.";
//				url="/";
//			}
//		} else if ("insert".equals(cmd)) {
//			msg = "입력 실패..";
//			if (userService.addUser(user) == 1) {
//				msg = "입력 성공!";
//			}
//			url = "/user/user-list";
//		} else if ("update".equals(cmd)) {
//			msg = "수정 실패..";
//			if(userService.modifyUser(user) == 1) {
//				msg = "수정 성공!";
//			}
//			url = "/user/user-view?uiNum=" + user.getUiNum();
//		} else if ("delete".equals(cmd)) {
//			msg = "삭제 실패..";
//			if(userService.removeUser(user.getUiNum()) == 1) {
//				msg = "삭제 성공!";
//			}
//			url = "/user/user-list";
//		}
//		request.setAttribute("msg", msg);
//		request.setAttribute("url", url);
//		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
//		rd.forward(request, response);
	}

}

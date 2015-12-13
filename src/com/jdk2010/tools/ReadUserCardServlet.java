package com.jdk2010.tools;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;

@Controller
@RequestMapping(value = "/")
public class ReadUserCardServlet extends BaseController {

	@RequestMapping("/ReadUserCardServlet")
	public void ReadUserCardServlet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("test");
		response.setContentType("application/x-java-serialized-object");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		InputStream in = request.getInputStream();
		ObjectInputStream inputFromApplet = new ObjectInputStream(in);
		HashMap echo = new HashMap();
		echo = (HashMap) inputFromApplet.readObject();
		System.out.println("echo = " + echo);
		// session.removeAttribute("CARDINFO");

		session.setAttribute("UCARDINFO", echo);

		OutputStream outstr = response.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(outstr);
		response.setContentType("text/html");
		oos.writeObject("");
		oos.flush();
		oos.close();
	}
}

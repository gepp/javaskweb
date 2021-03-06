package com.jdk2010.tools;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;

@Controller
@RequestMapping(value = "/")
public class ReadUserCardServlet extends BaseController {

	static Logger logger = LoggerFactory.getLogger(ReadUserCardServlet.class);
	
	@RequestMapping("/ReadUserCardServlet")
	public void ReadUserCardServlet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/x-java-serialized-object");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		InputStream in = request.getInputStream();
		ObjectInputStream inputFromApplet = new ObjectInputStream(in);
		HashMap echo = new HashMap();
		echo = (HashMap) inputFromApplet.readObject();
		logger.error("用户卡echo = " + echo);
		session.setAttribute("UCARDINFO", echo);
		OutputStream outstr = response.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(outstr);
		response.setContentType("text/html");
		oos.writeObject("");
		oos.flush();
		oos.close();
	}

	@RequestMapping("/ReadFiscalCardServlet")
	public void ReadFiscalCardServlet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			response.setContentType("application/x-java-serialized-object");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession(false);
			InputStream in = request.getInputStream();
			ObjectInputStream inputFromApplet = new ObjectInputStream(in);
			HashMap echo = new HashMap();
			echo = (HashMap) inputFromApplet.readObject();
			session.setAttribute("FCARDINFO", echo);

			OutputStream outstr = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outstr);
			response.setContentType("text/html");
			oos.writeObject("");
			oos.flush();
			oos.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

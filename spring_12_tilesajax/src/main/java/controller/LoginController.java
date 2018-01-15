package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.MemberDTO;
import service.ServiceImp;

@Controller
public class LoginController {
	ServiceImp service;

	public ServiceImp getService() {
		return service;
	}

	public void setService(ServiceImp service) {
		this.service = service;
	}

	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/joinProcess.do", method = RequestMethod.POST)
	public String joinProcess(HttpServletRequest req, Model model) {
		HashMap<String, String> chk = new HashMap<String, String>();
		chk.put("id", req.getParameter("id"));
		chk.put("pass", req.getParameter("pass"));
		MemberDTO dto = service.memChk(chk);
		if (dto != null) {
			model.addAttribute("dto", dto);
			return "index";
		}
		return "redirect:/index.do";
	}

	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginProcess.do", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest req, Model model) {
		HashMap<String, String> chk = new HashMap<String, String>();
		chk.put("id", req.getParameter("id"));
		chk.put("pass", req.getParameter("pass"));
		MemberDTO dto = service.memChk(chk);
		if (dto != null) {
			model.addAttribute("dto", dto);
			return "index";
		}

		return "redirect:/index.do";
	}

}

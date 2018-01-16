package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String joinProcess(HttpServletRequest req, MemberDTO dtoInput) {
		HttpSession session = req.getSession();

		if (dtoInput.getId() == null || dtoInput.getPass() == null)
			return "redirect:/index.do";

		MemberDTO dto = service.memChk(dtoInput);

		if (dto != null) {
			session.setAttribute("chkMember", dto.getId());
			System.out.println("회원가입이 이미 되어있습니다.");
		} else {
			service.insertMember(dtoInput);
			System.out.println(dtoInput.getId() + dtoInput.getPass());
		}
		return "index";
	}

	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginProcess.do", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest req, MemberDTO dtoInput) {
		MemberDTO dto = service.memChk(dtoInput);
		if (dto != null) {
			HttpSession session = req.getSession();
			session.setAttribute("dto", dto);
			return "index";
		}

		return "redirect:/index.do";
	}

	@RequestMapping("/logout.do")
	public String logoutProcess(HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
		if (dto != null) {
			session.invalidate();
			return "index";
		}

		return "redirect:/index.do";
	}

}

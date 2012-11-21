package com.spring.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.MemberDao;
import com.spring.mvc.model.Member;

@Controller
@RequestMapping("/")
public class AnotateController {

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("HelloWorld");
		model.addObject("msg", "hello world with annotation");
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/memberhome")
	public String memberHome(Model model) {
		model.addAttribute("msg", "Register User");
		model.addAttribute("newMember", new Member());
		List<Member> members = memberDao.findAllOrderedByName();
		model.addAttribute("members", members);
		model.addAttribute("memberCount", members.size());
		return "member";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			memberDao.create(newMember);
			return "redirect:/";
		} else {
			model.addAttribute("members", memberDao.findAllOrderedByName());
			return "member";
		}
	}

	@RequestMapping(value = "/loadCount")
	public int getCount() {
		System.out.println("Inside load count method....");
		int count = 10;
		return count;
	}

}

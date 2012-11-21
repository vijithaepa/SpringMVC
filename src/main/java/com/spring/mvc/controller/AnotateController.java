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

/**
 * Controller class to handle all requests.
 * 
 * @author Vijithe Epa
 */
@Controller
@RequestMapping("/")
public class AnotateController {

	@Autowired
	private MemberDao memberDao;

	/**
	 * Test method to print a simple message"
	 * 
	 * @return {@link ModelAndView} containing the message to print.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("HelloWorld");
		model.addObject("msg", "hello world with annotation");
		return model;
	}

	/**
	 * home page URL handling method.
	 * 
	 * @param model type {@link Model}.
	 * @return view name as {@link String}.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/memberhome")
	public String memberHome(Model model) {
		model.addAttribute("msg", "Register User");
		model.addAttribute("newMember", new Member());
		List<Member> members = memberDao.findAllOrderedByName();
		model.addAttribute("members", members);
		model.addAttribute("memberCount", members.size());
		return "member";
	}

	/**
	 * method to handle User register action.
	 * 
	 * @param newMember type {@link Member}.
	 * @param result type {@link BindingResult}
	 * @param model type {@link Model}.
	 * @return view name as {@link String}.
	 */
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

}

package com.kgc.board.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kgc.board.config.auth.dto.SessionUser;
import com.kgc.board.service.posts.PsPostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PsPostsController {

	private final PsPostsService psPostsService;
	
	private final HttpSession httpSession;
	
	@GetMapping("/psPosts")
	public String psPostsHome(Model model) {
		
		model.addAttribute("psPosts", psPostsService.findAllDesc());
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		return "/ps/psPosts";
	}
	
}

package com.kgc.board.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kgc.board.config.auth.dto.SessionUser;
import com.kgc.board.service.posts.PostsService;
import com.kgc.board.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final PostsService postsService;
	
	private final HttpSession httpSession;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("posts", postsService.findAllDesc());
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		return "index";
	}
	
	@GetMapping("/auth/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/posts/save")
	public String postsSave(Model model) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		return "postsSave";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		
		return "postsUpdate";
	}
	
	@GetMapping("/posts/detail/{id}")
	public String postsDetail(@PathVariable Long id, Model model) {
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		PostsResponseDto dto = postsService.findById(id);
		
		int hit = postsService.updateHit(id);
		
		if(hit ==1) {
			model.addAttribute("post", dto);
			return "postsDetail";
		
		}else {
			return null;
		}
	}
}
package com.kgc.board.web;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String index(Model model, @PageableDefault(size = 6, sort = "id", direction = Direction.DESC)Pageable pageable) {
		
//		model.addAttribute("posts", postsService.findAllDesc());
		model.addAttribute("posts", postsService.findAllPaging(pageable));
		model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
		model.addAttribute("next", pageable.next().getPageNumber());
		model.addAttribute("pageCheck", postsService.pageCheck(pageable));
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
			model.addAttribute("userPicture", user.getPicture());
		}
		
		return "index";
	}
	
	@GetMapping("/posts/search")
	public String search(Model model,@RequestParam String keyword) {

		model.addAttribute("searchResults", postsService.searchByTitleContent(keyword, keyword));
		model.addAttribute("keyword", keyword);

		return "searchResult";
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
			model.addAttribute("userPicture", user.getPicture());
		}
		
		return "postsSave";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
			model.addAttribute("userPicture", user.getPicture());
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
			model.addAttribute("userPicture", user.getPicture());
		}
		
		int hit = postsService.updateHit(id);
		
		PostsResponseDto dto = postsService.findById(id);
		
		if(hit ==1) {
			model.addAttribute("post", dto);
			return "postsDetail";
		
		}else {
			return null;
		}
	}
}
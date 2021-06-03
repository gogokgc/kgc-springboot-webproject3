package com.kgc.board.config.auth.dto;

import com.kgc.board.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser {

	private String name;
	private String email;
	private String picture;

	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
}

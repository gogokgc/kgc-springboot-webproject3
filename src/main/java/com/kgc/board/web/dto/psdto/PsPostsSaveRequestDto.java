package com.kgc.board.web.dto.psdto;

import com.kgc.board.domain.posts.PsPosts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PsPostsSaveRequestDto {

	private String title;
	
	private String content;
	
	private String author;
	
	
	
	public PsPosts toEntity() {
		
		return PsPosts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}

	@Builder
	public PsPostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

}
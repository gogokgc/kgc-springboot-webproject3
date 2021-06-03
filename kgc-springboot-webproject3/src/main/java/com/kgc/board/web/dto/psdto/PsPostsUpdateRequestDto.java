package com.kgc.board.web.dto.psdto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PsPostsUpdateRequestDto {

	private String title;
	private String content;
	
	@Builder
	public PsPostsUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	
	
}

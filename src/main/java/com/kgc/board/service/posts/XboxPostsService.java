package com.kgc.board.service.posts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgc.board.domain.posts.PsPosts;
import com.kgc.board.domain.posts.PsPostsRepository;
import com.kgc.board.web.dto.psdto.PsPostsListResponseDto;
import com.kgc.board.web.dto.psdto.PsPostsResponseDto;
import com.kgc.board.web.dto.psdto.PsPostsSaveRequestDto;
import com.kgc.board.web.dto.psdto.PsPostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class XboxPostsService {

	private final PsPostsRepository postsRepository;
	
	@Transactional
	public Long save(PsPostsSaveRequestDto requestDto) {
		
		return postsRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PsPostsUpdateRequestDto requestDto) {
		
		PsPosts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("There is No Posting. id : " + id)); 
		
		posts.update(requestDto.getTitle(),	requestDto.getContent());
		
		return id;
	}

	public PsPostsResponseDto findById(Long id) {
		
		PsPosts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("There is No Posting. id : " + id));
		
		return new PsPostsResponseDto(entity);
	}

	
	public List<PsPostsListResponseDto> findAllDesc(){
		return postsRepository.findAll().stream().map(PsPostsListResponseDto::new).collect(Collectors.toList());
	}
	
	@Transactional
	public void delete(Long id) {
		
		PsPosts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("There is No Posting. id : " + id));
		
		postsRepository.delete(posts);
	}
}
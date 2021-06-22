package com.kgc.board.domain.posts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<Posts, Long> {

	@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
	List<Posts> findAllDesc();
	
	@Modifying
	@Query("update Posts p set p.hit = p.hit + 1 where p.id = :id")
	int updateHit(@Param("id") Long id);
	
	List<Posts> findByContentContainingOrTitleContaining(String title, String content);
}

package com.kgc.board.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface XboxPostsRepository extends JpaRepository<XboxPosts, Long>{

//	@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//	List<PsPosts> findAllDesc();
}

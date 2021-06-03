package com.kgc.board.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PsPostsRepository extends JpaRepository<PsPosts, Long>{

//	@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//	List<PsPosts> findAllDesc();
}

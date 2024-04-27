package com.sha.springbootmicroservice5rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sha.springbootmicroservice5rating.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long>{
	
	List<Rating> findByUserId(Long userId);
	
	List<Rating> findByCourseId(Long courseId);

}

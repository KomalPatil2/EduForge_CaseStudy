package com.sha.springbootmicroservice5rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sha.springbootmicroservice5rating.model.Rating;
import com.sha.springbootmicroservice5rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}
	
	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getAllRatingsOfUser(Long userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsOfCourse(Long courseId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByCourseId(courseId);
	}
	
	

	
	
	

}

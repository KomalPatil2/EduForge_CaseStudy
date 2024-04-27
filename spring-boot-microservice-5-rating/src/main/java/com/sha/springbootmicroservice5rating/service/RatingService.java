package com.sha.springbootmicroservice5rating.service;

import java.util.List;

import com.sha.springbootmicroservice5rating.model.Rating;


public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getRatings();

	List<Rating> getAllRatingsOfUser(Long userId);
	
    List<Rating> getAllRatingsOfCourse(Long courseId);

}

package com.sha.springbootmicroservice5rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sha.springbootmicroservice5rating.model.Rating;
import com.sha.springbootmicroservice5rating.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
	
	@Autowired
	private RatingService rateService;
	
	@PostMapping 
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return new ResponseEntity<>(rateService.createRating(rating), HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(rateService.getRatings());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsOfUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(rateService.getAllRatingsOfUser(userId));
    }
    
    @GetMapping("course/{courseId}")
    public ResponseEntity<List<Rating>> getAllRatingsOfCourse(@PathVariable Long courseId)
    {
        return ResponseEntity.ok(rateService.getAllRatingsOfCourse(courseId));
    }

}

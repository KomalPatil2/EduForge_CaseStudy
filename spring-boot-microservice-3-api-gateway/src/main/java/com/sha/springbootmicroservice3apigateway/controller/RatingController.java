package com.sha.springbootmicroservice3apigateway.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.sha.springbootmicroservice3apigateway.request.RatingServiceRequest;
import com.sha.springbootmicroservice3apigateway.security.UserPrincipal;
 
@RestController
@RequestMapping("gateway/rating")
public class RatingController {
	@Autowired
	private RatingServiceRequest ratingServiceRqst;
	@PostMapping//gateway/purchase
    public ResponseEntity<?> createRating(@RequestBody Object rating)
    {
        return new ResponseEntity<>(ratingServiceRqst.createRating(rating), HttpStatus.CREATED);
    }
	@GetMapping
    public ResponseEntity<?> getRatings()
    {
        return ResponseEntity.ok(ratingServiceRqst.getRatings());
    }
 
    @GetMapping("/user")
    public ResponseEntity<?> getAllRatingsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(ratingServiceRqst.getAllRatingsOfUser(userPrincipal.getId()));
    }
    @GetMapping("/course")
    public ResponseEntity<?> getAllRatingsOfAuthorizedCourse(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(ratingServiceRqst.getAllRatingsOfCourse(userPrincipal.getId()));
    }
 
}
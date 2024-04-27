package com.sha.springbootmicroservice3apigateway.request;
 
import java.util.List;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
@FeignClient(value = "rating-service"
,path = "/api/rating"
,configuration = FeignConfiguration.class)


public interface RatingServiceRequest {
	
	@PostMapping//api/ratings
    Object createRating(@RequestBody Object requestBody);
	
	@GetMapping
    List<Object> getRatings();
 
    @GetMapping("user/{userId}")//api/ratings/{userId}
    List<Object> getAllRatingsOfUser(@PathVariable("userId") Long userId);
    
    @GetMapping("course/{courseId}")//api/ratings/{courseId}
    List<Object> getAllRatingsOfCourse(@PathVariable("courseId") Long courseId);
 
}

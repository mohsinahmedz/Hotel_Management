package com.RatingMicroservices.controller;

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

import com.RatingMicroservices.entites.Rating;
import com.RatingMicroservices.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	 @Autowired
	 private RatingService ratingService;
	 
	 @PostMapping("/")
	 public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		 Rating createOneRating = ratingService.createOneRating(rating);
		return new ResponseEntity<Rating>(createOneRating,HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/")
	 public ResponseEntity<List<Rating>> getAllRatings(){
		 List<Rating> ratings = ratingService.getRatings();
		return new ResponseEntity<List<Rating>>(ratings,HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/users/{userId}")
	 public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		 List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingByUserId,HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/hotels/{hotelId}")
	 public  ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		 List<Rating> hotelRatingByHotelId = ratingService.getHotelRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(hotelRatingByHotelId,HttpStatus.OK);
		 
	 }
}

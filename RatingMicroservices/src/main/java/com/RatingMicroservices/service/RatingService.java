package com.RatingMicroservices.service;

import java.util.List;

import com.RatingMicroservices.entites.Rating;

public interface RatingService {

	 Rating createOneRating(Rating rating);
	 List<Rating> getRatings(); 
	 
	 //get all Rating by userId and hotelId
	 List<Rating> getRatingByUserId(String userId);
	 List<Rating> getHotelRatingByHotelId(String hotelId);
	 
}

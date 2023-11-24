package com.RatingMicroservices.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingMicroservices.Repo.RatingRepo;
import com.RatingMicroservices.entites.Rating;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating createOneRating(Rating rating) {	
		String randomUserId = UUID.randomUUID().toString();	
		 rating.setRatingId(randomUserId);
		 return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getHotelRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}
 
}

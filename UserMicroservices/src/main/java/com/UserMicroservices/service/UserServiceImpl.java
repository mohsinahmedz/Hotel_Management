package com.UserMicroservices.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.UserMicroservices.entities.Hotel;
import com.UserMicroservices.entities.Rating;
import com.UserMicroservices.entities.User;
import com.UserMicroservices.exception.ResourceNotFoundException;
import com.UserMicroservices.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createuser(User user) {	 
		String randomUserId = UUID.randomUUID().toString();
		 user.setUId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return  userRepo.findAll();
	}
// http://localhost:8089/ratings/users/f39a8e1c-9d20-4f5a-ad26-01ebafbc4838
// http://localhost:8088/hotels/14512a05-3294-48b6-ac4a-bb224c642336
	@Override
	public User getOneUser(String userId) {
		User user = userRepo.findById(userId).orElseThrow(
			     ()-> new ResourceNotFoundException("User with give iD is not Avilable!!"+userId)
			   );
		
		Rating[] forObject = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUId(), Rating[].class);
		logger.info("{}",forObject);
		List<Rating> list = Arrays.stream(forObject).toList();
		list.stream().map(
				  rating ->{
					  ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
					     Hotel hotel = forEntity.getBody();
					     logger.info("status code:",forEntity.getStatusCode());
					     rating.setHotel(hotel);
					  return rating;
				  }
				).collect(Collectors.toList());
		
		user.setRatings(list);
	 
		
		
		return user;
	}

}

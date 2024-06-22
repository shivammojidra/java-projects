package com.mypractice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingsController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("movieId", 4.5f);
	}
	
	@RequestMapping("users/{userId}")
	public List<Rating> getUserRatings(@PathVariable("userId") String userId) {
		return Arrays.asList(
				new Rating("1234", 4.5f),
				new Rating("5897", 5f)
				);
	}
}

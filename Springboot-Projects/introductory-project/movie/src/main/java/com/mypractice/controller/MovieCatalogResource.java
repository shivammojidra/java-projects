package com.mypractice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mypractice.models.CatalogItem;
import com.mypractice.models.Movie;
import com.mypractice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId){
		
		//Getting all the rated movies
		List<Rating> ratings = Arrays.asList(
				new Rating("1285", 4.5f),
				new Rating("7486", 5f)
				);
 		
		
		// For each movie id, calling movie info service
		
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info/movies/" + rating.getMovieId(), Movie.class);
			
			/*Movie movie = webClientBuilder.build()
			.get()
			.uri("http://localhost:8084/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();*/
			
			
			return new CatalogItem(movie.getMovieName(), "Description", rating.getMovieRating());
		}).toList();
		
	}
}

package com.mypractice.models;

public class Rating {

	private String movieId;
	private float movieRating;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public float getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}
	
	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", movieRating=" + movieRating + "]";
	}
	
	public Rating(String movieId, float movieRating) {
		super();
		this.movieId = movieId;
		this.movieRating = movieRating;
	}
	
	
}

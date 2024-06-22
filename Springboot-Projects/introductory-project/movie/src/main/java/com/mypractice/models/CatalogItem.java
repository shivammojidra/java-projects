package com.mypractice.models;

public class CatalogItem {
	
	private String movieName;
	private String movieDescription;
	private float movieRating;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public float getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}
	
	public CatalogItem(String movieName, String movieDescription, float movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
	}
	
	@Override
	public String toString() {
		return "CatalogItem [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieRating="
				+ movieRating + "]";
	}
}

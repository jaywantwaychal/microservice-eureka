package org.jdsolutions.ratingsdata.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class MovieRatingResource {

	
	@RequestMapping("/{movieId}")
	public MovieRating getMovieRatings(@PathVariable("movieId") String movieId) {
		return new MovieRating(movieId, 3);
	}
	
	@RequestMapping("/users/{userId}")
	public UserMovieRatings getUserMovieRatings(@PathVariable ("userId") String userId) {
		
		UserMovieRatings userRatings = new UserMovieRatings();
		userRatings.setRatings(Arrays.asList(new MovieRating("12345", 3),
				new MovieRating("345", 1),
				new MovieRating("567", 2)));
		
		return userRatings;
	}
}

package org.jdsolutions.movieinfo.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieinfo")
public class MovieINfoResource {
	
	@RequestMapping("/{movieId}")
	public MovieInfo getMovieInfo(@PathVariable ("movieId") String movieId) {
		return new MovieInfo(movieId, "new Movie 2", "new Movie Description");
	}

}

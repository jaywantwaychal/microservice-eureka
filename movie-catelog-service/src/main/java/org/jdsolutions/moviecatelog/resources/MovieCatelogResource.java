package org.jdsolutions.moviecatelog.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder builder;
	
	@RequestMapping("/{userId}")
	public List<CatelogItem> getCatelog(@PathVariable("userId") String userId) {
		
			//using webclient		
	UserMovieRatings userMovieRatings = builder.build()
									.get()
									.uri("http://ratings-data-service/ratings/users/"+userId)
									.retrieve()
									.bodyToMono(UserMovieRatings.class)
									.block();
		
	//using rest Template
	 List<CatelogItem> catlog = userMovieRatings.getRatings().stream().map(rating -> {
			MovieInfo movie = restTemplate.getForObject("http://movie-info-service/movieinfo/"+rating.getMovieId(), MovieInfo.class);
			
			
			return new CatelogItem(movie.getName(), movie.getDesc(), rating.getRating());
		}).collect(Collectors.toList());
		
	 List<CatelogItem> catlog2 = userMovieRatings.getRatings().stream().map(rating -> {
		 
		 MovieInfo movie = builder.build()
				 				.get()
				 				.uri("http://movie-info-service/movieinfo/"+rating.getMovieId())
				 				.retrieve()
				 				.bodyToMono(MovieInfo.class)
				 				.block();
		 
		 return new CatelogItem(movie.getName(), movie.getDesc(), rating.getRating());
		 
	 }).collect(Collectors.toList());
	 
	 	catlog.addAll(catlog2);
	
	 	return catlog;
		
	}

}

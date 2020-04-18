package org.jdsolutions.moviecatelog.resources;

public class MovieInfo {
	private String movieId;
	private String name;
	private String desc;
	public MovieInfo(String movieId, String name, String desc) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "MovieInfo [movieId=" + movieId + ", name=" + name + ", desc=" + desc + "]";
	}
	public MovieInfo() {
		super();
	}
}

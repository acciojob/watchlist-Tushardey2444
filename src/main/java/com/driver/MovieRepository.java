package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieDb=new HashMap<>();
    private HashMap<String,Director> directorDb=new HashMap<>();
    private HashMap<String, List<String>> movieDirectorDb=new HashMap<>();
    private HashMap<String,Movie> unassignedMovieDb=new HashMap<>();
    public String addMovie(Movie movie){
        movieDb.put(movie.getName(),movie);
        unassignedMovieDb.put(movie.getName(),movie);
        return "success";
    }
    public void addMovieInMovieDb(Movie movie){
        movieDb.put(movie.getName(),movie);
    }
    public String addDirector(Director director){
        directorDb.put(director.getName(),director);
        return "success";
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        if(!movieDirectorDb.containsKey(directorName)){
            movieDirectorDb.put(directorName,new ArrayList<>());
        }
        movieDirectorDb.get(directorName).add(movieName);
        unassignedMovieDb.remove(movieName);
        return "success";
    }
    public Movie getMovieByName(String movieName){
        return movieDb.getOrDefault(movieName,null);
    }
    public Director getDirectorByName(String directorName){
        return directorDb.getOrDefault(directorName,null);
    }
    public List<String> getMoviesByDirectorName(String directorName){
        return movieDirectorDb.getOrDefault(directorName,new ArrayList<>());
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }
    public void deleteMovies(String movieName){
        movieDb.remove(movieName);
    }
    public String deleteDirectorByName(String directorName){
        directorDb.remove(directorName);
        movieDirectorDb.remove(directorName);
        return "success";
    }
    public List<String> findAllDirectors(){
        return new ArrayList<>(directorDb.keySet());
    }
    public List<Movie> unassignedMovies(){
        return new ArrayList<>(unassignedMovieDb.values());
    }
    public void deleteAllMovies(){
        movieDb=new HashMap<>();
    }
}

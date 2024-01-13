package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    MovieService movieService=new MovieService();

    @PostMapping(path = "/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
    @PostMapping(path = "/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.CREATED);
    }
    @PutMapping(path = "/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,
                                                       @RequestParam String directorName){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movieName,directorName),HttpStatus.CREATED);
    }
    @GetMapping(path = "/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.CREATED);
    }
    @GetMapping(path = "/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.CREATED);
    }
    @GetMapping(path = "/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director),HttpStatus.CREATED);
    }
    @GetMapping(path = "/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        return new ResponseEntity<>(movieService.deleteDirectorByName(directorName),HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.CREATED);
    }
}

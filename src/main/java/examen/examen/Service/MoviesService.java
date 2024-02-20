package examen.examen.Service;

import examen.examen.Model.Genre;
import examen.examen.Model.Movies;
import examen.examen.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repo;

    @Autowired
    private MoviesRepository moviesRepository;



    public List<Movies> getMoviesByName(String name) {
        return moviesRepository.findByName(name);
    }



    public List<Movies> getMoviesOrderedByReleaseDateDesc() {
        return repo.findAllByOrderByReleaseDateDesc();
    }
    public List<Movies> findMoviesByGenre(Genre genre) {
        return repo.findByGenre(genre);
    }
    public List<Movies> findMoviesByReleaseDateRange(Date startDate, Date endDate) {
        return repo.findByReleaseDateBetween(startDate, endDate);
    }

    public List<Movies> findMoviesByName(String name) {
        return repo.findByNameContaining(name);
    }
    public List<Movies> findMoviesByDirector(String directorName) {
        return repo.findByDirectorContaining(directorName);
    }

    public Movies saveMovie(Movies bean){
        return repo.save(bean);
    }

    public List<Movies> getAllMovies(){
        return repo.findAll();
    }

    public Page<Movies> PageOfMovies(Pageable page){
        return repo.findAll(page);
    }

    public void deleteMovie(long id){
        repo.deleteById(id);
    }

    public Movies getMovieById(long id){
        return repo.findById(id).get();
    }



}


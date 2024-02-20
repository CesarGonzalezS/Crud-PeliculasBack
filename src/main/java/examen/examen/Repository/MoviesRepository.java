package examen.examen.Repository;

import examen.examen.Model.Genre;
import examen.examen.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MoviesRepository  extends JpaRepository<Movies, Long> {

    List<Movies> findByName(String name);

    List<Movies> findByNameContaining(String name);

    List<Movies> findByDirectorContaining(String directorName);

    List<Movies> findByReleaseDateBetween(Date startDate, Date endDate);

    List<Movies> findByGenre(Genre genre);

    List<Movies> findAllByOrderByReleaseDateDesc();



}

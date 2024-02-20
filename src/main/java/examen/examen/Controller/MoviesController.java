    package examen.examen.Controller;

    import examen.examen.Model.Genre;
    import examen.examen.Model.Movies;
    import examen.examen.Service.GenresService;
    import examen.examen.Service.MoviesService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.Base64;
    import java.util.List;
    import java.util.Map;

    @RestController
    @RequestMapping("/api/movies")
    @CrossOrigin(origins = "http://localhost:5173")
    public class MoviesController {

        @Autowired
        MoviesService moviesService;

        @Autowired
        GenresService genresService;

        @GetMapping("/movies")
        public List<Movies> getMovies() {
            return moviesService.getAllMovies();
        }

        @PostMapping("/genres")
        public Genre addGenre(@RequestBody Genre genre) {
            return genresService.saveGenre(genre);
        }

        @GetMapping("/genres")
        public List<Genre> getGenres() {
            return genresService.getAllGenres();
        }

        // Método para eliminar una película por su nombre

        @DeleteMapping("/movies/Delete/{name}")
        public String deleteMovieByName(@RequestBody String name) {
            try {
                Movies movie = (Movies) moviesService.getMoviesByName(name);
                if (movie == null) {
                    return "Movie with name " + name + " not found";
                }
                moviesService.deleteMovie(movie.getId());
                return "Movie with name " + name + " deleted";
            } catch (Exception e) {
                return "Error deleting movie: " + e.getMessage();
            }
        }



        @PutMapping("/movies/{id}")
        public String updateMovie(@PathVariable Long id, @RequestBody Movies updatedMovie) {
            Movies movie = moviesService.getMovieById(id);
            movie.setName(updatedMovie.getName());
            movie.setYear(updatedMovie.getYear());
            movie.setGenre(updatedMovie.getGenre());
            moviesService.saveMovie(movie);
            return "Movie with ID " + id + " updated";
        }


        @PostMapping("/registermovies")
        public Movies addMovie(@RequestBody Map<String, Object> movieData) {
            try {
                String description = (String) movieData.get("description");
                String director = (String) movieData.get("director");
                String base64Image = (String) movieData.get("image");
                String name = (String) movieData.get("name");
                int year = Integer.parseInt((String) movieData.get("year"));
                Map<String, Object> genreData = (Map<String, Object>) movieData.get("genre");
                Genre genre = new Genre((Integer) genreData.get("id"), (String) genreData.get("name"));

                Movies movie = new Movies(description, director, base64Image, name, year, genre);

                return moviesService.saveMovie(movie);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error al guardar la película: " + e.getMessage());
            }
        }



    }


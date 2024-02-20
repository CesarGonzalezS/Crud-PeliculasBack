package examen.examen.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Genre genre;
    private int year;
    private String director;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(columnDefinition = "TEXT") // Ajusta el tipo de columna según tus necesidades
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String imageBase64;


    public Movies() {

    }


    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public Movies(@JsonProperty("description") String description,
                  @JsonProperty("director") String director,
                  @JsonProperty("imageBase64") String imageBase64,
                  @JsonProperty("name") String name,
                  @JsonProperty("year") int year,
                  @JsonProperty("genre") Genre genre) {
        this.description = description;
        this.director = director;
        this.imageBase64 = imageBase64;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }




    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", imageBase64='" + imageBase64 + '\'' +
                '}';
    }
}

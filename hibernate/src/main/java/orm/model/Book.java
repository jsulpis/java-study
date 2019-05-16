package orm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Book {
    private long id;
    private String title;
    private Author author;
    private Date releaseDate;

    public Book(String title, Author author, Date releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public long getId() {
        return id;
    }

    @ManyToOne
    public Author getAuthor() {
        return author;
    }

    @Temporal(TemporalType.DATE)
    public Date getReleaseDate() {
        return releaseDate;
    }
}

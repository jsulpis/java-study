package orm;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@Data
public class Book {
    private long id;
    private String title;
    private String author;
    private Date releaseDate;

    public Book(String title, String author, Date releaseDate) {
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

    @Temporal(TemporalType.DATE)
    public Date getReleaseDate() {
        return releaseDate;
    }
}

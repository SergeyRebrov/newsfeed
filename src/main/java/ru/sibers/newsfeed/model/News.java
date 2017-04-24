package ru.sibers.newsfeed.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Сlass for an entity stored in table 'news'.
 */

@Entity
@Table(name = "news")
public class News {

    // Entity primary key.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Entity data fields.
    @Column(name = "heading", nullable = false)
    @NotEmpty(message = "The heading should not be empty")
    private String heading;

    @Column(name = "publication_date", nullable = false)
    @NotNull(message = "Date must be specified")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @Column(name = "news_body", nullable = false)
    @NotEmpty(message = "The text of the news should not be empty")
    private String newsBody;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    public int getId() {
        return id;
    }

    // Getter & Setter for the Key
    public void setId(int id) {
        this.id = id;
    }
    public String getHeading() {
        return heading;
    }

    // Getters & Setters for fields
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // ToString method
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", publicationDate=" + publicationDate +
                ", newsBody='" + newsBody + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

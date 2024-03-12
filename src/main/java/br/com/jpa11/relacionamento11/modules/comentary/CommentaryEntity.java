package br.com.jpa11.relacionamento11.modules.comentary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.jpa11.relacionamento11.modules.blogPost.BlogPostEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "commentaries")
@JsonIgnoreProperties(value = "blogPost")
// muelhor o DTO do q o jsonignore, melhor n, recomendada
public class CommentaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String text;

    @ManyToOne
    @JoinColumn(name = "blog_post_id", referencedColumnName = "id")
    private BlogPostEntity blogPost;
}
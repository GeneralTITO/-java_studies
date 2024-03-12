package br.com.jpa11.relacionamento11.modules.blogPost;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

import br.com.jpa11.relacionamento11.modules.comentary.CommentaryEntity;

@Data
@Entity(name = "blog_post")
public class BlogPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String conteudo;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    private List<CommentaryEntity> commentarios;
}
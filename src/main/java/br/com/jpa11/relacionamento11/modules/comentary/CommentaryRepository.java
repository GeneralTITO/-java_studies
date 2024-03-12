package br.com.jpa11.relacionamento11.modules.comentary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryEntity, Long> {
    List<CommentaryEntity> findByBlogPost_id(Long blogPostId);
}
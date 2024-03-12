package br.com.jpa11.relacionamento11.modules.comentary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.jpa11.relacionamento11.modules.blogPost.BlogPostRepository;

@Service
public class CommentaryService {

    @Autowired
    private BlogPostRepository blogPostRepo;

    @Autowired
    private CommentaryRepository commentaryRepo;

    public CommentaryEntity create(CommentaryEntity payload, Long blogPostId) {
        var foundBlogPost = blogPostRepo.findById(blogPostId).get();
        payload.setBlogPost(foundBlogPost);
        var commentary = commentaryRepo.save(payload);
        return commentary;
    }

    public List<CommentaryEntity> read(Long blogPostId) {
        return commentaryRepo.findByBlogPost_id(blogPostId);
    }
}

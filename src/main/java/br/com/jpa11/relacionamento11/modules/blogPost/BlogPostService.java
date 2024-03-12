package br.com.jpa11.relacionamento11.modules.blogPost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepo;

    public BlogPostEntity create(BlogPostEntity payload) {
        var blogPost = blogPostRepo.save(payload);
        return blogPost;
    }

    public List<BlogPostEntity> read() {
        return blogPostRepo.findAll();
    }
}
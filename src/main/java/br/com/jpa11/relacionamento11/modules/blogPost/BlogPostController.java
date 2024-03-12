package br.com.jpa11.relacionamento11.modules.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog_posts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BlogPostEntity payload) {
        var blogPost = blogPostService.create(payload);
        return ResponseEntity.status(201).body(blogPost);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        var blogPosts = blogPostService.read();
        return ResponseEntity.status(200).body(blogPosts);
    }
}
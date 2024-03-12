package br.com.jpa11.relacionamento11.modules.comentary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commentaries")
public class CommentaryController {
    @Autowired
    private CommentaryService commentaryService;

    @PostMapping("/blog_posts/{blogPostId}")
    public ResponseEntity<?> create(
            @PathVariable Long blogPostId,
            @RequestBody CommentaryEntity payload) {
        var commentary = commentaryService.create(payload, blogPostId);
        return ResponseEntity.status(201).body(commentary);
    }

    @GetMapping("/blog_posts/{blogPostId}")
    public ResponseEntity<?> read(@PathVariable Long blogPostId) {
        var commentaries = commentaryService.read(blogPostId);
        return ResponseEntity.status(200).body(commentaries);
    }
}
package com.medufly.edu.controller;

import com.medufly.edu.entity.BlogPost;
import com.medufly.edu.repository.BlogPostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogPostRepository blogPostRepository;

    public BlogController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping
    public List<Map<String, Object>> listPosts() {
        return blogPostRepository.findByActiveTrueOrderByPublishedAtDesc().stream()
            .map(p -> {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("slug", p.getSlug());
                map.put("title", p.getTitle());
                map.put("category", p.getCategory());
                map.put("categoryColor", p.getCategoryColor());
                map.put("excerpt", p.getExcerpt());
                map.put("publishedAt", p.getPublishedAt());
                map.put("readTime", p.getReadTime());
                map.put("author", p.getAuthor());
                return map;
            })
            .toList();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<BlogPost> getPost(@PathVariable String slug) {
        Optional<BlogPost> opt = blogPostRepository.findBySlug(slug);
        return opt.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
}

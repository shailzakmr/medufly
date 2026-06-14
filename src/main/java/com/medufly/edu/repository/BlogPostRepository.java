package com.medufly.edu.repository;

import com.medufly.edu.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    Optional<BlogPost> findBySlug(String slug);
    List<BlogPost> findByActiveTrueOrderByPublishedAtDesc();
}

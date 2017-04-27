package com.github.sergeyrebrov.newsfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.sergeyrebrov.newsfeed.model.News;

/**
 * Repository : News.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}

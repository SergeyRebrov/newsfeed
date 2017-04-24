package ru.sibers.newsfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibers.newsfeed.model.News;

/**
 * Repository : News.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}

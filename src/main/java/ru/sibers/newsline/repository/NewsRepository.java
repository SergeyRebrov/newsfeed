package ru.sibers.newsline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibers.newsline.model.News;

/**
 * Repository : News.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}

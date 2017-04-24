package ru.sibers.newsfeed.service;

import org.springframework.data.domain.Page;
import ru.sibers.newsfeed.model.News;

/**
 * Service Interface for entity News.
 */
public interface NewsService {
     News addNews(News news);
     Page<News> getAll(Integer pageNumber, Integer pageSize);
}
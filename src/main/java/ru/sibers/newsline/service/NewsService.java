package ru.sibers.newsline.service;

import org.springframework.data.domain.Page;
import ru.sibers.newsline.model.News;

/**
 * Service Interface for entity News.
 */
public interface NewsService {
     News addNews(News news);
     Page<News> getAll(Integer pageNumber, Integer pageSize);
}
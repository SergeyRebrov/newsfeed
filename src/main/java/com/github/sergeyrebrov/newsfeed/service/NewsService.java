package com.github.sergeyrebrov.newsfeed.service;

import org.springframework.data.domain.Page;
import com.github.sergeyrebrov.newsfeed.model.News;

/**
 * Service Interface for entity News.
 */
public interface NewsService {
     News addNews(News news);
     Page<News> getAll(Integer pageNumber, Integer pageSize);
}
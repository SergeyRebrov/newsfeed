package ru.sibers.newsline.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibers.newsline.model.News;
import ru.sibers.newsline.repository.NewsRepository;
import ru.sibers.newsline.service.NewsService;

import javax.annotation.Resource;

/**
 * Implementation of NewsService
 */

@Service("NewsServiceImpl")
public class NewsServiceImpl implements NewsService {

    private static final Sort SORT_NEWS = new Sort(Sort.Direction.DESC,"publicationDate", "id");

    @Resource
    private NewsRepository newsRepository;

    @Override
    @Transactional
    public News addNews(News news) {
        return newsRepository.saveAndFlush(news);
    }

    @Override
    public Page<News> getAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize, SORT_NEWS);
        return newsRepository.findAll(pageable);
    }
}

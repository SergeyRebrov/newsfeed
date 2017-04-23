package ru.sibers.newsline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.sibers.newsline.model.News;
import ru.sibers.newsline.service.NewsService;
import ru.sibers.newsline.util.ImageUtil;
import ru.sibers.newsline.util.exception.ImageUploadException;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Spring MVC controller for 'News' management.
 */

@Controller
@SessionAttributes(value = "amountNews")
public class NewsController {

    private NewsService newsService;

    @Autowired(required = true)
    @Qualifier(value = "NewsServiceImpl")
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    /**
     * First method on start application.
     * Redirecting to news.jsp
     */
    @RequestMapping("/")
    public String main(Model model) {
        return "redirect:/news";
    }

    /**
     * List of news for the first page.
     */
    @RequestMapping(value = "news")
    public String listNews(Model model) {
        fillModelWithListNews(model, 1);
        return "news";
    }

    /**
     * List of news for a page from a web request.
     */
    @RequestMapping(value = "news/{pageNumber}")
    public String listNews(@PathVariable("pageNumber") int pageNumber, Model model) {
        fillModelWithListNews(model, pageNumber);
        return "news";
    }

    /**
     * Add news page
     */
    @RequestMapping(value = "addnews")
    public String addNews(Model model) {
        model.addAttribute("news", new News());
        return "addnews";
    }

    /**
     * Adding news with validation and data from the JSP form
     */
    @RequestMapping(value = "addnews/add", method = RequestMethod.POST)
    public ModelAndView addNews(@Valid @ModelAttribute News news, BindingResult result, @RequestParam("image") MultipartFile file) {

        ModelAndView mav = new ModelAndView();

        // If there are errors, then try again.
        if (result.hasErrors()) {
            mav.setViewName("addnews");
            return mav;
        }

        String pathToImage = null;

        try {
            pathToImage = ImageUtil.saveImage(file); // Trying to save the image
        } catch (ImageUploadException e) {
            // If there are exceptions when uploading the file, try again.
            mav.setViewName("addnews");
            mav.addObject("error", e.getMessage()); // Show errors on the web page
            return mav;
        }

        news.setImageUrl(pathToImage);  // Assign a value, otherwise the object is not added to the database
        newsService.addNews(news);      // Adding news to the database
        mav.setViewName("redirect:/news");
        return mav;
    }

    /**
     * Assigns a value for the amount of news on the page.
     */
    @RequestMapping(value = "news/amount", method = RequestMethod.POST)
    public String chooseAmountNews(@RequestParam("radioGroup") Integer amountNews, Model model) {
        model.addAttribute("amountNews", amountNews);
        return "redirect:/news";
    }

    /**
     * Filling the model with attributes, for pagination.
     */
    private void fillModelWithListNews(Model model, Integer pageNumber) {
        Integer amountNews = (Integer) model.asMap().get("amountNews");
        if (amountNews == null)
            amountNews = 10;

        Page<News> page = newsService.getAll(pageNumber, amountNews); // Get news list for page № pageNumber
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("listNews", page.iterator()); // List news on the web page
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("amountNews", amountNews);
    }

    /**
     * Binds the date from the Web request to the Date for the specified format..
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
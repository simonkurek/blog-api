package pl.szymonkurek.blogapi.manager;

import org.springframework.stereotype.Service;
import pl.szymonkurek.blogapi.deo.ArticleRepo;
import pl.szymonkurek.blogapi.deo.entity.Article;
import pl.szymonkurek.blogapi.deo.entity.SmallArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleManager {

    private ArticleRepo articleRepo;

    public ArticleManager(ArticleRepo articleRepo){
        this.articleRepo = articleRepo;
    }

    public Optional<Article> findById(Long id){
        return articleRepo.findById(id);
    }

    public List<Article> findAllByCategory(String category){
        return articleRepo.findAllByCategory(category);
    }

    public List<SmallArticle> findAll(){
        List<SmallArticle> articles = new ArrayList<>();
        articleRepo.findAll().forEach(article -> {
            articles.add(new SmallArticle(article.getId(), article.getTitle(), article.getDesc(), article.getCategory(), article.getAuthor()));
        });
        return articles;
    }
}

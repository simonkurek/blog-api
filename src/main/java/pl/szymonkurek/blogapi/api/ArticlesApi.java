package pl.szymonkurek.blogapi.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonkurek.blogapi.deo.entity.Article;
import pl.szymonkurek.blogapi.deo.entity.SmallArticle;
import pl.szymonkurek.blogapi.manager.ArticleManager;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ArticlesApi {

    private ArticleManager articleManager;

    public ArticlesApi(ArticleManager articleManager){
        this.articleManager = articleManager;
    }

    @GetMapping("/getAll")
    public List<SmallArticle> getAll(){
        return articleManager.findAll();
    }

    @GetMapping("/getByID")
    public Optional<Article> getArticle(@RequestParam Long id){
        return articleManager.findById(id);
    }

    @GetMapping("/getByCategory")
    public List<Article> findByCategory(@RequestParam String category){
        return articleManager.findAllByCategory(category);
    }
}

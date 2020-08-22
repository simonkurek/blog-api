package pl.szymonkurek.blogapi.deo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonkurek.blogapi.deo.entity.Article;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Long> {
    Optional<Article> findById(Long id);
    List<Article> findAllByCategory(String category);
}

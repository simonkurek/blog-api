package pl.szymonkurek.blogapi.deo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmallArticle {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String author;
}




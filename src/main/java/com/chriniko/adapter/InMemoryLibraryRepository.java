package com.chriniko.adapter;

import com.chriniko.application.LibraryRepository;
import com.chriniko.doc.Adapter;
import com.chriniko.domain.Article;
import com.chriniko.domain.Author;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Adapter
public class InMemoryLibraryRepository implements LibraryRepository {

    private final Map<String, Article> articlesByTitle;

    public InMemoryLibraryRepository() {
        this.articlesByTitle = new ConcurrentHashMap<>();

        IntStream.rangeClosed(1, 5)
                .forEach(articleIdx -> {

                    String title = "Title " + articleIdx;

                    Article article = new Article();
                    article.setTitle(title);
                    article.setDescription("Some short description " + articleIdx);
                    article.setText("Some long text " + articleIdx);

                    List<Author> authors = IntStream
                            .rangeClosed(1, 3)
                            .boxed()
                            .map(authorIdx -> new Author("fullname " + authorIdx,
                                    "firstname " + authorIdx,
                                    "initials " + authorIdx,
                                    "surname " + authorIdx)
                            )
                            .collect(Collectors.toList());

                    article.setAuthors(authors);

                    this.articlesByTitle.put(title, article);
                });
    }

    @Override
    public Optional<Article> findBy(String title) {
        return Optional.ofNullable(articlesByTitle.get(title));
    }
}

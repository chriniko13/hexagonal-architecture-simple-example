package com.chriniko.application;

import com.chriniko.doc.Port;
import com.chriniko.domain.Article;

import java.util.Optional;

@Port
public interface LibraryRepository {

    Optional<Article> findBy(String title);
}

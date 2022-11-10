package com.springgraphql.app.repositories;

import com.springgraphql.app.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

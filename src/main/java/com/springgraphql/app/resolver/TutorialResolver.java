package com.springgraphql.app.resolver;

import com.springgraphql.app.models.Author;
import com.springgraphql.app.models.Course;
import com.springgraphql.app.repositories.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Course> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Course course){
        return authorRepository.findById(course.getAuthor().getId()).orElseThrow(()->new RuntimeException("Author not found"));
    }
}

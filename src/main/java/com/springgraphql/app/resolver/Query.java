package com.springgraphql.app.resolver;

import com.springgraphql.app.models.Author;
import com.springgraphql.app.models.Course;
import com.springgraphql.app.repositories.AuthorRepository;
import com.springgraphql.app.repositories.CourseRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;
    private CourseRepository courseRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, CourseRepository courseRepository) {
        this.authorRepository = authorRepository;
        this.courseRepository = courseRepository;
    }

    public Iterable<Author>findAllAuthors(){
        return authorRepository.findAll();
    }

    public Iterable<Course>findAllCourses(){
        return courseRepository.findAll();
    }

    public Long countAuthors(){
        return authorRepository.count();
    }

    public Long countCourses(){
        return courseRepository.count();
    }

}

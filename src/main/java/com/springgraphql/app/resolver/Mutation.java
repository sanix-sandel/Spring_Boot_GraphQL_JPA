package com.springgraphql.app.resolver;

import com.springgraphql.app.models.Author;
import com.springgraphql.app.models.Course;
import com.springgraphql.app.repositories.AuthorRepository;
import com.springgraphql.app.repositories.CourseRepository;
import graphql.annotations.annotationTypes.GraphQLMutation;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;
    private CourseRepository courseRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, CourseRepository courseRepository) {
        this.authorRepository = authorRepository;
        this.courseRepository = courseRepository;
    }

    public Author createAuthor(String name, Integer age){
        Author author=new Author();
        author.setName(name);
        author.setAge(age);

        authorRepository.save(author);

        return author;
    }

    public Course createCourse(String title, String description, Long authorId){
        Course course=new Course();
        course.setAuthor(new Author(authorId));
        course.setTitle(title);
        course.setDescription(description);

        courseRepository.save(course);

        return course;
    }

    public Boolean deleteCourse(Long id){
        courseRepository.deleteById(id);
        return true;
    }

    public Course updateCourse(Long id, String title, String description){
        Optional<Course>courseOptional=courseRepository.findById(id);
        if(courseOptional.isPresent()){
            Course course=courseOptional.get();

            if(title!=null){
                course.setTitle(title);
            }
            if(description!=null){
                course.setDescription(description);
            }
            courseRepository.save(course);

            return course;
        }

        throw new RuntimeException("Not found course to update");
    }


}

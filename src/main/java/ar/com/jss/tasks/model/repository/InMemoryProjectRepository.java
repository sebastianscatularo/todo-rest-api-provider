package ar.com.jss.tasks.model.repository;

import ar.com.jss.tasks.model.domain.Project;
import com.google.common.base.Predicate;
import org.springframework.stereotype.Repository;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static com.google.common.collect.FluentIterable.from;

/**
 * @author sebastianscatularo@gmail.com.
 */

public abstract class InMemoryProjectRepository implements ProjectRepository {

    private Collection<Project> projects = new ArrayList<Project>();
    private IdGenerator idGenerator = new SimpleIdGenerator();
    public Collection<Project> findProjects() {
        return this.projects;
    }

    public Project save(Project project) {
        project.setId(0L);
        projects.add(project);
        return project;
    }

    public Project getProject(final String id) {
        return from(projects).firstMatch(new Predicate<Project>() {
            public boolean apply(Project input) {
                return UUID.fromString(id).equals(input.getId());
            }
        }).orNull();
    }
}

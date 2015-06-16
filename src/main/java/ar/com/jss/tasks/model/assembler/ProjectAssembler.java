package ar.com.jss.tasks.model.assembler;

import ar.com.jss.tasks.model.domain.Project;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

/**
 * @author sebastianscatularo@gmail.com.
 */
@Component
public class ProjectAssembler implements ResourceAssembler<Project, Resource<Project>> {

    public Resource<Project> toResource(Project entity) {
        return new Resource<Project>(entity);
    }
}

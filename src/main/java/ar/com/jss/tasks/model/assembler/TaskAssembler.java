package ar.com.jss.tasks.model.assembler;

import ar.com.jss.tasks.model.domain.Task;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

/**
 * @author sebastianscatularo@gmail.com.
 */
@Component
public class TaskAssembler implements ResourceAssembler<Task, Resource<Task>> {
    public Resource<Task> toResource(Task entity) {
        return new Resource<Task>(entity);
    }
}

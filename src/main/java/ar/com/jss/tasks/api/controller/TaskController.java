package ar.com.jss.tasks.api.controller;

import ar.com.jss.tasks.model.assembler.TaskAssembler;
import ar.com.jss.tasks.model.domain.Project;
import ar.com.jss.tasks.model.domain.Task;
import ar.com.jss.tasks.model.repository.ProjectRepository;
import ar.com.jss.tasks.model.repository.TaskRepository;
import com.google.common.base.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

/**
 * @author sebastianscatularo@gmail.com.
 */
@RestController
@RequestMapping(value = "/projects/{projectId}/tasks")
public class TaskController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final TaskRepository taskRepository;
    private final TaskAssembler taskAssembler;
    private final ProjectRepository projectRepository;

    @Autowired
    public TaskController(
            ProjectRepository projectRepository,
            TaskRepository taskRepository,
            TaskAssembler taskAssembler) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.taskAssembler = taskAssembler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Resource<Task>>> tasks(@PathVariable("projectId") String projectId) {
        final Collection<Task> tasks = projectRepository.findOne(Long.valueOf(projectId)).getTasks();
        Collection<Resource<Task>> resources = from(tasks).transform(new Function<Task, Resource<Task>>() {
            public Resource<Task> apply(Task input) {
                return taskAssembler.toResource(input);
            }
        }).toList();
        return ResponseEntity.ok(resources);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource<Task>> createTask(@PathVariable("projectId") String projectId, @RequestBody Task task) {
        log.info("Project id: {}", projectId);
        Project project = projectRepository.findOne(Long.valueOf(projectId));
        task.setProject(project);
        project.getTasks().add(task);
        Task saved = taskRepository.save(task);
        projectRepository.save(project);
        Resource<Task> resources = taskAssembler.toResource(saved);
        return ResponseEntity.ok(resources);
    }
}

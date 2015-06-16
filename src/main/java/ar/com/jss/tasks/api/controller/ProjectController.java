package ar.com.jss.tasks.api.controller;

import ar.com.jss.tasks.model.domain.Project;
import ar.com.jss.tasks.model.assembler.ProjectAssembler;
import ar.com.jss.tasks.model.repository.ProjectRepository;
import com.google.common.base.Function;
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
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author sebastianscatularo@gmail.com.
 */
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectAssembler projectAssembler;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, ProjectAssembler projectAssembler) {
        this.projectRepository = projectRepository;
        this.projectAssembler = projectAssembler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Resource<Project>>> projects() {
        Iterable<Project> projects = projectRepository.findAll();
        Collection<Resource<Project>> resources = from(projects).transform(new Function<Project, Resource<Project>>() {
            public Resource<Project> apply(Project input) {
                return projectAssembler.toResource(input);
            }
        }).toList();
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource<Project>> createProject(@RequestBody Project project) {
        Project savedProject = projectRepository.save(project);
        Resource<Project> resource = projectAssembler.toResource(savedProject);
        return ResponseEntity.created(linkTo(methodOn(ProjectController.class).getProject(String.valueOf(savedProject.getId()))).toUri()).body(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Project>> getProject(@PathVariable("id") String id) {
        Project project = projectRepository.findOne(Long.valueOf(id));
        Resource<Project> resource = projectAssembler.toResource(project);
        return ResponseEntity.ok(resource);
    }
}

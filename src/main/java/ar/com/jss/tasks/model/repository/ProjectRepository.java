package ar.com.jss.tasks.model.repository;

import ar.com.jss.tasks.model.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author sebastianscatularo@gmail.com.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}

package ar.com.jss.tasks.model.repository;

import ar.com.jss.tasks.model.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sebastianscatularo@gmail.com.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}

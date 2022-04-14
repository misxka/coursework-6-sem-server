package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}

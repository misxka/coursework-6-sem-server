package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {
}

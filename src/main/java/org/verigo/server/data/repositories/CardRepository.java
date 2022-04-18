package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {
}

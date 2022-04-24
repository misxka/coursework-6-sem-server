package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Card;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findAllByCategory_Id(Integer id);
}

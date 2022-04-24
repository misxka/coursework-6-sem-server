package org.verigo.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.Card;
import org.verigo.server.data.repositories.CardRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {
    @Autowired
    private CardRepository repository;

    @GetMapping(value = "/{categoryId}", produces = "application/json")
    public List<Card> getCardsByCategory(@PathVariable int categoryId) {
        List<Card> cards = repository.findAllByCategory_Id(categoryId);
        return cards;
    }
}

package org.verigo.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.verigo.server.data.entities.Card;
import org.verigo.server.data.repositories.CardRepository;
import org.verigo.server.data.repositories.CategoryRepository;
import org.verigo.server.payloads.responses.DeleteResponse;
import org.verigo.server.payloads.responses.card.CreateResponse;
import org.verigo.server.services.CloudinaryService;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {
    @Autowired
    private CardRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping(value = "/{categoryId}", produces = "application/json")
    public List<Card> getCardsByCategory(@PathVariable int categoryId) {
        List<Card> cards = repository.findAllByCategory_Id(categoryId);
        return cards;
    }

    @PostMapping(value = "")
    public CreateResponse createCategory(
        @RequestParam MultipartFile audio,
        @RequestParam MultipartFile image,
        @RequestParam String word,
        @RequestParam String translation,
        @RequestParam String categoryId
    ) {
        String imageId = cloudinaryService.upload(image, "image");
        String audioId = cloudinaryService.upload(audio, "video");

        Card card = new Card(word, translation, imageId, audioId);
        card.setCategory(categoryRepository.findById(Integer.valueOf(categoryId)).get());
        Card createdCard = repository.save(card);

        return new CreateResponse(createdCard, 201, "Карточка успешно создана.");
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeleteResponse deleteCard(@PathVariable int id) {
        Boolean isPresent = repository.existsById(id);
        if(!isPresent) return new DeleteResponse(404, "Карточка не найдена.");
        Card card = repository.findById(id).get();

        repository.deleteById(id);

        cloudinaryService.delete(card.getImage(), "image");
        cloudinaryService.delete(card.getAudio(), "video");

        return new DeleteResponse(200, "Карточка удалена.");
    }
}

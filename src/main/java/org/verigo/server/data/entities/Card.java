package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "cards")
@SequenceGenerator(name="CARD_SEQ", sequenceName="card_sequence")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CARD_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String image;

    @Column(unique = true, nullable = false)
    private String audio;

    @Column(unique = true, nullable = false)
    private String word;

    @Column(unique = true, nullable = false)
    private String translation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id", nullable = false)
    @JsonBackReference
    private Category category;


    public Card() {}

    public Card(String word, String translation, String image, String audio) {
        this.word = word;
        this.translation = translation;
        this.image = image;
        this.audio = audio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
            Objects.equals(word, card.word) &&
            Objects.equals(translation, card.translation) &&
            Objects.equals(image, card.image) &&
            Objects.equals(audio, card.audio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, translation, image, audio);
    }

    @Override
    public String toString() {
        return "Card{" +
            "id=" + id +
            ", word='" + word + '\'' +
            ", translation='" + translation + '\'' +
            ", image='" + image + '\'' +
            ", audio='" + audio + '\'' +
            '}';
    }
}

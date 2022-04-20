package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "categories")
@SequenceGenerator(name="CATEGORY_SEQ", sequenceName="category_sequence")
@JsonFilter("categoryFilter")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CATEGORY_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String link;

    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("category")
    private Set<Card> cards = new HashSet<Card>();


    public Category() {}

    public Category(String name, String link) {
        this.name = name;
        this.link = link;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
            Objects.equals(name, category.name) &&
            Objects.equals(link, category.link) &&
            Objects.equals(cards, category.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, link, cards);
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", link='" + link + '\'' +
            ", cards='" + cards + '\'' +
            '}';
    }
}

package com.likelion.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tutorials")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
  @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
  @Column(name = "title") private String title;
  @Column(name = "description") private String description;
  @Column(name = "published") private boolean published;

  @Override
  public String toString() {
    return String.format("Tutorial [id=%d, title=%s, desc=%s, published=%s]",
                         id, title, description, published);
  }
}

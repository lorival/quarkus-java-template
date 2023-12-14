package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.person;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class PersonTable {
  @Id
  @SequenceGenerator(
      name = "person_sequence_generator",
      sequenceName = "person_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence_generator")
  private Long id;

  private String name;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  private int age;
}

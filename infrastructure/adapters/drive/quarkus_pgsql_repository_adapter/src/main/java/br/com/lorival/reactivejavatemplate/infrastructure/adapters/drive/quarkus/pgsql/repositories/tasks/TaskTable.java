package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.tasks;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class TaskTable {
  @Id
  @SequenceGenerator(
      name = "tasks_sequence_generator",
      sequenceName = "tasks_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_sequence_generator")
  private Long id;

  private String detail;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  private boolean completed;

  @Column(name = "completed_at")
  private LocalDateTime completedAt;
}

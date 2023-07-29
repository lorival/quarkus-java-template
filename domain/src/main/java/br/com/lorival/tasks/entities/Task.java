package br.com.lorival.tasks.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "table_name", schema = "myapp")
public class Task {
  @Id @GeneratedValue private Long id;
  @NonNull String detail;
  LocalDateTime createdAt = LocalDateTime.now();
  boolean done = false;
}

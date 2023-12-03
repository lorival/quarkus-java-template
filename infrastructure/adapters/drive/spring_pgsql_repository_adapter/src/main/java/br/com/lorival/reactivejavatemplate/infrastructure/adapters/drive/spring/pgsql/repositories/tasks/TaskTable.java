package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.spring.pgsql.repositories.tasks;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks", schema = "public")
public class TaskTable {
  @Id private Long id;
  private String detail;
  private LocalDateTime createdAt;
  private boolean completed;
  private LocalDateTime completedAt;
}

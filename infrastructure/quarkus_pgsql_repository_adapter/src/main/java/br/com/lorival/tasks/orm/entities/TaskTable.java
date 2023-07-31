package br.com.lorival.tasks.orm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "table_name", schema = "myapp")
public class TaskTable {
  @Id @GeneratedValue private Long id;
  private String detail;
  private LocalDateTime createdAt;
  private boolean done;
}

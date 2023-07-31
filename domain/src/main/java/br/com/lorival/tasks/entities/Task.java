package br.com.lorival.tasks.entities;

import java.time.LocalDateTime;
import lombok.*;

@Data
@RequiredArgsConstructor
public class Task {
  private Long id;
  @NonNull private String detail;
  private LocalDateTime createdAt = LocalDateTime.now();
  private boolean done = false;
}

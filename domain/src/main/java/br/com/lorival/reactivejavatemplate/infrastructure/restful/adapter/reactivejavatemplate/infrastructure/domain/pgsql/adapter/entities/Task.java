package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities;

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

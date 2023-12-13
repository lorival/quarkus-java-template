package br.com.lorival.reactivejavatemplate.domain.entities;

import java.time.LocalDateTime;
import lombok.*;

@Data
@RequiredArgsConstructor
public class Person {
  private Long id;
  @NonNull private String name;
  private int age;
  private LocalDateTime createdAt = LocalDateTime.now();
}

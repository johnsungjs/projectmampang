package mampang.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class MampangApiResponse {
  private Object data;
  private String rc;
  private String rd;
}

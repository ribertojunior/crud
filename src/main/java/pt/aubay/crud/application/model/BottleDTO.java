package pt.aubay.crud.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BottleDTO {

  private String id;

  private Double height;

  private Double volume;

  private String material;
}

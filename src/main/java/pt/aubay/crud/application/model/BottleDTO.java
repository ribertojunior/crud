package pt.aubay.crud.application.model;

import lombok.Data;

@Data
public class BottleDTO {

  private String id;

  private int height;

  private double volume;

  private String material;
}

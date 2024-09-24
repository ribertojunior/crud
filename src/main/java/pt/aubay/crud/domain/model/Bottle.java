package pt.aubay.crud.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

/**
 * Encapsulates a bottle
 */
@Entity(name = "bottle")
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bottle {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  private String id;

  private double height;

  private double volume;

  private String color;

  private String material;

}

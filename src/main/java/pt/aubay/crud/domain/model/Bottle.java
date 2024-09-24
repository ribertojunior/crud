package pt.aubay.crud.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

  private String material;
}

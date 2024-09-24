package pt.aubay.crud.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "bootle")
@Table
@Data
public class Bottle {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  private String id;

  private int height;

  private double volume;

  private String material;
}

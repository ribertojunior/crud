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

@Entity(name = "cap")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cap {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  private String id;

  private String color;
}

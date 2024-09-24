package pt.aubay.crud.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pt.aubay.crud.application.model.BottleDTO;
import pt.aubay.crud.domain.model.Bottle;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BottleMapper {

  Bottle toModel(BottleDTO dto);
  BottleDTO toDTO(Bottle bottle);
  void updateBootleFromDto(BottleDTO dto, @MappingTarget Bottle bottle);
}
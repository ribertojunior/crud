package pt.aubay.crud.application.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pt.aubay.crud.application.model.BottleDTO;
import pt.aubay.crud.domain.model.Bottle;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = "spring", builder = @Builder(disableBuilder = true),
    uses = CapMapper.class)
public interface BottleMapper {

  Bottle toModel(BottleDTO dto);
  BottleDTO toDTO(Bottle bottle);
  void updateBottleFromDto(BottleDTO dto, @MappingTarget Bottle bottle);
}

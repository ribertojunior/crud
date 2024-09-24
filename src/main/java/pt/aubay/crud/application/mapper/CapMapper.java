package pt.aubay.crud.application.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import pt.aubay.crud.application.model.CapDTO;
import pt.aubay.crud.domain.model.Cap;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CapMapper {

  Cap toModel(CapDTO dto);
  CapDTO toDto(Cap cap);
}

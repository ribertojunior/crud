package pt.aubay.crud.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pt.aubay.crud.application.mapper.BottleMapper;
import pt.aubay.crud.application.model.BottleDTO;
import pt.aubay.crud.domain.model.Bottle;
import pt.aubay.crud.domain.repository.BottleRepository;

import java.util.Optional;

@Service
public class BottleService {

  @Autowired
  private BottleRepository bottleRepository;

  @Autowired
  private BottleMapper bottleMapper;

  public Page<BottleDTO> getAll(Pageable pageable) {
    return bottleRepository.findAll(pageable).map(bottleMapper::toDTO);
  }

  public BottleDTO createBottle(BottleDTO bottleDTO) {
    Bottle bottle = bottleMapper.toModel(bottleDTO);
    return bottleMapper.toDTO(bottleRepository.save(bottle));
  }

  public BottleDTO updateBottle(BottleDTO bottleDTO) throws RuntimeException {
    Optional<Bottle> optionalBottle = bottleRepository.findById(bottleDTO.getId());
    Bottle bottle = optionalBottle.orElseThrow(() -> new RuntimeException("Not Found: " + bottleDTO.getId()));
    bottleMapper.updateBottleFromDto(bottleDTO, bottle);
    return bottleMapper.toDTO(bottleRepository.save(bottle));
  }

  public void delete(String id){
    bottleRepository.deleteById(id);
  }

  public BottleDTO get(String id) {
    return bottleMapper.toDTO(
        bottleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not Found: " + id)));
  }
}

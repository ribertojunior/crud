package pt.aubay.crud.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.aubay.crud.application.model.BottleDTO;
import pt.aubay.crud.application.service.BottleService;

@RestController
public class BottleController {

  @Autowired
  private BottleService service;

  @GetMapping
  public ResponseEntity<Page<BottleDTO>> getBottles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size){
    Pageable pageable = Pageable.ofSize(size);
    pageable.withPage(page);
    return ResponseEntity.ok(service.getAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<BottleDTO> getBottle(@PathVariable String id){
    return ResponseEntity.ok(service.get(id));
  }

  @PostMapping
  public ResponseEntity<BottleDTO> post(@RequestBody BottleDTO bottleDTO) {
    return ResponseEntity.status(201).body(service.createBottle(bottleDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BottleDTO> put(@PathVariable("id") String id,  @RequestBody BottleDTO bottleDTO){
    bottleDTO.setId(id);
    return ResponseEntity.status(200).body(service.updateBottle(bottleDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

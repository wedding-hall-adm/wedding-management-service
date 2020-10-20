package pl.wedding.management.service.weddinghall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/weddinghall")
@RestController
class WeddingHallController {

    private final WeddingHallService weddingHallService;
    private final WeddingHallRepository weddingHallRepository;

    WeddingHallController(WeddingHallService weddingHallService, WeddingHallRepository weddingHallRepository){
        this.weddingHallService=weddingHallService;
        this.weddingHallRepository=weddingHallRepository;
    }

    @GetMapping
     ResponseEntity getAllWeddingHalls() {
        return ResponseEntity.ok(weddingHallRepository.findAll());
     }

    @GetMapping("/{id}")
     ResponseEntity getWeddingHallById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(weddingHallRepository.findById(id));
     }

    @PostMapping("/")
    void addWeddingHall(@RequestBody WeddingHall weddingHall){
        weddingHallService.addWeddingHall(weddingHall);
    }


    @DeleteMapping("/{id}")
    void  deleteWeddingHallById(@RequestParam("id") Long id) {
            weddingHallService.deleteById(id);
    }
}

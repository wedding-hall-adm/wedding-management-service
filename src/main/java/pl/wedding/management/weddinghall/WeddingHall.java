package pl.wedding.management.weddinghall;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/weddinghalls")
@RestController
class WeddingHallController {

    private final WeddingHallService weddingHallService;

    WeddingHallController(WeddingHallService weddingHallService){
        this.weddingHallService=weddingHallService;
    }

    @GetMapping
    public ResponseEntity getAllWeddingHalls() {
        return ResponseEntity.ok(weddingHallService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getWeddingHallById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(weddingHallService.findById(id));
    }

    @PostMapping("/")
    void addWeddingHall(@RequestBody WeddingHallService weddingHallService){
        weddingHallService.addWeddingHall(weddingHallService);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteWeddingHallById(@RequestParam("id") Long id) {
        try {
            weddingHallService.deleteById(id);
            return ResponseEntity.noContent();
        } catch (TaskNotFoundException e) {
            return ResponseEntity.notFound();
        }
    }
}

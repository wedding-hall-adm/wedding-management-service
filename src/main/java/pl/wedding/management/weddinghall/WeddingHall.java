package pl.wedding.management.weddinghall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WeddingHallController {

    @Autowired
    private WeddingHallService weddingHallService;

    @RequestMapping("/weddinghalls")
    public List<WeddingHall> getAllWeddingHalls(){
        return weddingHallService.getAllWeddingHalls();
    }

    @RequestMapping("/weddinghalls/{id}")
    public List(WeddingHall) getWeddingHall(@PathVariable Long id){
        return weddingHallService.getAllWeddingHalls(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/weddinghalls")
    public void addWeddingHall(@RequestBody WeddingHall weddingHall){
        weddingHallService.addWeddingHall(weddingHall);
    }
}

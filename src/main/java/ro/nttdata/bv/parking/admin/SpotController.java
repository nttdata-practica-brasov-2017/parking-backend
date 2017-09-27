package ro.nttdata.bv.parking.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.boundary.VacancyController;
import ro.nttdata.bv.parking.control.AdminService;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.repository.SpotRepository;

import java.util.List;

@RestController
public class SpotController {

    private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private SpotRepository spotRepository;

    @GetMapping("admin/view/spots")
    public List<Spot> postSpots() {
        return spotRepository.findAll();
    }

    @PostMapping("admin/create/spots")
    public void createSpot(@RequestBody Spot spot) {
        LOG.info("Spot number {} floor {} created", spot.getNumber(), spot.getFloor());
        adminService.createSpot(spot);
    }

    @DeleteMapping("admin/delete/spots")
    public void deleteSpot(@RequestParam(value = "number") int number,
                           @RequestParam(value = "floor") int floor) {
        LOG.info("Spot number {} floor {} deleted", number, floor);
        adminService.deleteSpot(number, floor);
    }
}

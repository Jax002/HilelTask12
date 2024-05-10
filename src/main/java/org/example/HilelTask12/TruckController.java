import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {
    private final DatabaseService databaseService;

    @Autowired
    public TruckController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/{truckId}/location")
    public ResponseEntity<Location> getTruckLocation(@PathVariable String truckId) {
        Location location = databaseService.getLocationByTruckId(truckId);
        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GPSTracker {
    private final DatabaseService databaseService;

    @Autowired
    public GPSTracker(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Scheduled(fixedRate = 10000)
    public void trackAndSaveLocation() {

        String truckId = "123";
        double latitude = 47.12345;
        double longitude = -122.54321;


        Location location = new Location();
        location.setTruckId(truckId);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        databaseService.saveLocation(location);
    }
}
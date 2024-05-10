import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private final LocationRepository locationRepository;

    @Autowired
    public DatabaseService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public Location getLocationByTruckId(String truckId) {
        return locationRepository.findFirstByTruckIdOrderByCreatedAtDesc(truckId);
    }
}
package Models;

import java.util.List;
import java.util.UUID;

public interface SamsungRepository {
     Samsung getSamsung(UUID uuid);
     void addSamsung(Samsung samsung);
     boolean updateSamsung(Samsung samsung);
     void removeSamsung(Samsung samsung);
     List<Samsung> getAllSamsungs();
}

package Models;

import java.util.List;
import java.util.UUID;

public interface XiaomiRepository {
    Xiaomi getXiaomi(UUID uuid);
    void addXiaomi(Xiaomi xiaomi);
    boolean updateXiaomi(Xiaomi xiaomi);
    void removeXiaomi(Xiaomi xiaomi);
    List<Xiaomi> getAllXiaomis();
}

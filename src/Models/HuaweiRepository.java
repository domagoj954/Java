package Models;

import java.util.List;
import java.util.UUID;

public interface HuaweiRepository {
     Huawei getHuawei(UUID uuid);
     void addHuawei(Huawei huawei);
     boolean updateHuawei(Huawei huawei);
     void removeHuawei(Huawei samsung);
     List<Huawei> getAllHuaweis();
}

package Models;

import java.util.List;
import java.util.UUID;

public interface AppleRepository {
    Apple getApple(UUID uuid);
    void addApple(Apple iphone);
    boolean updateApple(Apple iphone);
    void removeApple(Apple iphone);
    List<Apple> getAllApples();
}

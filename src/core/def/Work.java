package core.def;

import java.util.Map;
import java.util.UUID;

public interface Work {
    Report execute(Map<String, Object> ctx);
}

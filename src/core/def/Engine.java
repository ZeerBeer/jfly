package core.def;

import java.util.Map;

public interface Engine {
    Report run(Flow flow, Map<String, Object> ctx);
}

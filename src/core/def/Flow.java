package core.def;

import java.util.Map;

public interface Flow {
    Report execute(Map<String, Object> ctx);
}

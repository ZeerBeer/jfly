package core.def;

import java.util.Map;

public interface Work {
    Report execute(Map<String, Object> ctx);
}

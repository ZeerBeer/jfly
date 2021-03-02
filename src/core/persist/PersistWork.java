package core.persist;

import core.def.Report;

import java.util.Map;

public interface PersistWork {
    Report execute(Map<String, Object> ctx);

    String id();
}

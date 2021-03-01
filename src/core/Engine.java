package core;

import core.def.Flow;
import core.def.Report;

import java.util.Map;

public class Engine implements core.def.Engine {
    public Report run(Flow flow, Map<String, Object> ctx) {
        return flow.execute(ctx);
    }
}

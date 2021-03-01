package core;

import core.def.Engine;
import core.def.Flow;
import core.def.Report;

import java.util.Map;

public class RunEngine implements Engine {
    public Report run(Flow flow, Map<String, Object> ctx) {
        return flow.execute(ctx);
    }
}

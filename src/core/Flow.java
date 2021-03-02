package core;

import core.def.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Flow implements core.def.Flow, Step {
    private final List<Work> chain = new ArrayList<>();

    @Override public Flow withName(String name) {
        return this;
    }

    @Override public Flow then(Work nextWork) {
        chain.add(nextWork);
        return this;
    }

    @Override public Report execute(Map<String, Object> ctx) {
        Report rsp = null;
        for (Work work : chain) {
            rsp = work.execute(ctx);
            if (rsp == null || !Option.COMPLETED.apply(rsp)) {
                break;
            }
        }
        return rsp;
    }

    public Flow() { }
}

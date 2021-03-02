package core;

import core.def.Option;
import core.def.Report;
import core.def.Step;
import core.def.Work;
import core.persist.PersistStep;
import core.persist.PersistWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersistFlow implements core.def.Flow, PersistStep {
    private final List<PersistWork> chain = new ArrayList<>();

    @Override public PersistFlow withName(String name) {
        return this;
    }

    @Override public PersistFlow then(PersistWork nextWork) {
        chain.add(nextWork);
        return this;
    }

    @Override
    public Report execute(Map<String, Object> ctx) {
        Report rsp = null;
        for (PersistWork work : chain) {
            if (ctx.get(work.id()).equals("done"))
                continue;
            rsp = work.execute(ctx);
            if (rsp == null || !Option.COMPLETED.apply(rsp))
                break;
        }
        // 这里加入持久化逻辑 下面是 jackson 示例
        new ObjectMapper().writeValueAsString(ctx);
        return rsp;
    }

    public PersistFlow() { }
}

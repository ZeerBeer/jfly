import core.RunEngine;
import core.SeqFlow;
import core.Status;
import core.def.Flow;
import core.def.Report;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlowTest {
    public static void main(String[] args) {
        var rsp = new RunEngine().run(new SeqFlow().withName("hello world").then((Flow) ctx -> {
            System.out.print("Hello "); ctx.put("Hello", "World!");
            return new Report() {
                @Override public Map<String, Object> getContext() {
                    return ctx;
                }
                @Override public Status getStatus() {
                    return Status.COMPLETED;
                }
            };
        }).withName("Hello").then((Flow) ctx -> {
            System.out.println(ctx.get("Hello"));
            return new Report() {
                @Override public Map<String, Object> getContext() {
                    return ctx;
                }
                @Override public Status getStatus() {
                    return Status.FAILED;
                }
            };
     // }), new HashMap<>());                // thread unsafe
        }), new ConcurrentHashMap<>());      // thread safe
    }
}

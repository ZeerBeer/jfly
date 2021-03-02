import core.Engine;
import core.Flow;
import core.Status;
import core.def.Report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlowTest {
    public static void main(String[] args) {
         new Engine().run(new Flow().withName("hello world").then(ctx -> {
            System.out.print("Hello "); ctx.put("Hello", "World!");
            return new Report() {
                @Override public Map<String, Object> getContext() {
                    return ctx;
                }
                @Override public Status getStatus() {
                    return Status.COMPLETED;
                }
            };
        }).then(ctx -> {
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

package core.def;


public interface Step {
    Flow withName(String name);

    Flow then(Work nextWork);
}

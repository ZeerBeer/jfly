package core.persist;

import core.def.Flow;

public interface PersistStep {
    Flow withName(String name);

    Flow then(PersistWork nextWork);
}

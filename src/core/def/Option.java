package core.def;

import core.Status;

@FunctionalInterface
public interface Option {

    boolean apply(Report workReport);

    Option COMPLETED = rsp -> rsp.getStatus().equals(Status.COMPLETED);
    Option FAILED = rsp -> rsp.getStatus().equals(Status.FAILED);
}

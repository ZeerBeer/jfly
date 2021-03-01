package core.def;

import core.Status;

import java.util.Map;

public interface Report {

    Map<String, Object> getContext();

    Status getStatus();
}

package benchmarkdp.datagenerator.generator.codegenerator;

import java.util.HashMap;
import java.util.Map;

public class CompilerState {

	private Map<String, Object> variables;

	public CompilerState() {
		variables = new HashMap<String, Object>();
	}

	public void setVariable(String name, Object var) {
		variables.put(name, var);
	}

	public Object getVariable(String name) {
		return variables.get(name);
	}
}

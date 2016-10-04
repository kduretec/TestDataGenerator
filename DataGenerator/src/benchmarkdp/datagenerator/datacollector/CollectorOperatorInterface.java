package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.util.Map;

public interface CollectorOperatorInterface {

	Map<String, String> collect(File test);
}

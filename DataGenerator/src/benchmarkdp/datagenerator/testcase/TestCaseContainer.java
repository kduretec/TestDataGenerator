package benchmarkdp.datagenerator.testcase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="TestCases")
public class TestCaseContainer {
	
	
	private List<TestCase> testCases;
	
	@XmlTransient
	private Map<String, TestCase> index; 
	
	public TestCaseContainer() {
		testCases = new ArrayList<TestCase>();
		index = new HashMap<String, TestCase>(); 
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}

	@XmlElement(name="TestCase")
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
		/*System.out.println("Adding testcases to index");
		for (TestCase t : testCases) {
			index.put(t.getTestCaseName(), t);
		}*/
	} 		
	
	public void addTestCase(TestCase tc) {
		testCases.add(tc);
		index.put(tc.getTestCaseName(), tc);
	}
	
	public int numberTestCases() {
		return testCases.size();
	}
	
	public TestCase getTestCase(String name) {
		if (index.size() != testCases.size()) {
			index.clear();
			//System.out.println("Creating index");
			for (TestCase t : testCases) {
				index.put(t.getTestCaseName(), t);
			}
		}
		return index.get(name);
	}
}

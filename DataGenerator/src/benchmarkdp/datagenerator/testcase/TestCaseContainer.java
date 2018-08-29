package benchmarkdp.datagenerator.testcase;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TestCases")
public class TestCaseContainer {
	
	
	private List<TestCase> testCases;
	
	public TestCaseContainer() {
		testCases = new ArrayList<TestCase>();
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}

	@XmlElement(name="TestCase")
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	} 		
	
	public void addTestCase(TestCase tc) {
		testCases.add(tc);
	}
	
	public int numberTestCases() {
		return testCases.size();
	}
}

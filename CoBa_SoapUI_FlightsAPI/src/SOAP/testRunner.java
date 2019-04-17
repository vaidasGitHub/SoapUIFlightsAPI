package SOAP;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;

public class testRunner {
	
	@Test
	public void SoapTest() throws XmlException, IOException, SoapUIException {	
	
		WsdlProject flightsAPI = new WsdlProject( "C:\\Users\\vsieber-adm\\Documents\\CoBa-APITest-soapui-project.xml" );
		WsdlTestSuite testSuite = flightsAPI.getTestSuiteByName( "MF Flights" );
		
		for( int i = 0; i < testSuite.getTestCaseCount(); i++ ) {
			
			WsdlTestCase testCase = testSuite.getTestCaseAt(i);
			TestRunner testRunner = testCase.run( new PropertiesMap() , false);
			
			Assert.assertEquals( Status.FINISHED, testRunner.getStatus() );
		}
	}
	
}

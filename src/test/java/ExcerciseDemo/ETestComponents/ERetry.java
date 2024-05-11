package ExcerciseDemo.ETestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ERetry implements IRetryAnalyzer
{

	int max=1;
	int count=0;
	
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<max)
		{
			count++;
			return true;
		}
		return false;
	}
}

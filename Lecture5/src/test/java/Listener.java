import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class Listener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("MethodStart:" + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("MethodFinish{" + testResult.getStatus() + "}: " +
                method.getTestMethod().getMethodName() + System.lineSeparator());
    }
}
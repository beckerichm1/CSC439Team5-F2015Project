package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestCacheList.class, TestCacheToFile.class, TestMiniHttp.class, TestProxy.class, TestCacheRequest.class, TestCacheLog.class
})
public class SuiteTest {
	}
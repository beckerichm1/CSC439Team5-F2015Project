package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CacheListTest.class, CacheToFileTest.class, MiniHttpTest.class, ProxyTest.class, CacheRequestTest.class, CacheLogTest.class, HTTPGetterTest.class
})
public class SuiteTest {
	}
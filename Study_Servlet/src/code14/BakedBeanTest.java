package code14;

import static org.junit.Assert.*;

import org.junit.Test;


public class BakedBeanTest {

	@Test
	public void testGet() {
		BakedBean bakedBean = new BakedBean();
		System.out.println("Original bean: " +
                "level=" + bakedBean.getLevel() +
                ", goesWith=" + bakedBean.getGoesWith());
	}
	
	@Test
	public void testSet() {
		BakedBean bakedBean = new BakedBean();
		bakedBean.setLevel("高级");
		bakedBean.setGoesWith("上好佳");
		System.out.println("Original bean: " +
                "level=" + bakedBean.getLevel() +
                ", goesWith=" + bakedBean.getGoesWith());
	}
}

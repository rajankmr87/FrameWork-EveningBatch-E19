package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	// Assertion
	// Types of Assertion ---->*HardAssert *SoftAssert
	// HardAssert
	// *HardAssert is Static in Nature
	// *In HardAssert when ever @Test/Assert is failed,it stops the execution in
	// same Line
	// *When ever HardAssert Fails Throws AssertError Exception
	// *HardAssert is used only for Mandatory Fields.

	@Test
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
	}

	@Test
	public void m2() {
		int exp = 10;
		int act = 10;
		Assert.assertEquals(act, exp);
	}

	@Test
	public void m3() {
		int exp = 10;
		int act = 20;
		Assert.assertEquals(act, exp, "Assert are not Equal");
		System.out.println("AssertPass");
	}

	@Test
	public void m4() {
		String exp = "Qspiders";
		String act = "Qspiders";
		Assert.assertNotEquals(act, exp, "Both Are Equal");
		System.out.println("Both are not Equal==");

	}

	@Test
	public void m5() {
		String exp = "Qspiders";
		String act = "Qspider";
		Assert.assertNotEquals(act, exp, "Both Are Equal");
		System.out.println("Both are not Equal==");

	}

	@Test
	public void m6() {
		String exp = "Qspiders";
		String act = "Qspiders";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "AssertFail");
		System.out.println("Assert Pass");
	}

	@Test
	public void m7() {
		String exp = "Qspiders";
		String act = "Qspiders ";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "AssertFail");
		System.out.println("Assert Pass");
	}

	@Test
	public void m8() {
		String exp = "Qspiders";
		String act = "Qspiders ";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "AssertFail");
		System.out.println("Assert Pass");
	}

	@Test
	public void m9() {
		String exp = "Qspiders";
		String act = "Qspiders";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "AssertFail");
		System.out.println("Assert Pass");
	}

	@Test
	public void m10() {
		String s = null;
		Assert.assertNull(s, "value is not Null");
		System.out.println(" value it is Null");
	}

	@Test
	public void m11() {
		String s = "Qspiders";
		Assert.assertNull(s, "value is not Null");
		System.out.println(" value it is Null");
	}

	@Test
	public void m12() {
		String s = "Qspiders";
		Assert.assertNotNull(s, "value is Null");
		System.out.println(" value it not Null");
	}

	@Test
	public void m13() {
		String s = null;
		Assert.assertNotNull(s, "value is Null");
		System.out.println(" value it not Null");
	}

	@Test
	public void m14() {
		String exp = "Hello";
		String act = "Hello";
		Assert.assertSame(act, exp, "Not Same");
		System.out.println(" values are same");
	}

	@Test
	public void m15() {
		String exp = "Hello";
		String act = "Hi";
		Assert.assertSame(act, exp, "Not Same");
		System.out.println(" values are same");
	}

	@Test
	public void m16() {
		int exp = 10;
		int act = 20;
		Assert.assertNotSame(act, exp, "Same Values");
		System.out.println("Not Same Values");
	}

	@Test
	public void m17() {
		int exp = 10;
		int act = 10;
		Assert.assertNotSame(act, exp, "Same Values");
		System.out.println("Not Same Values");
	}

	@Test
	public void m18() {
		Assert.fail("im failing the script");

	}

}
 

package Harvaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CheckTest {

	private Check ClassCheck;
	
	@BeforeEach
	void beforeEach() {
		ClassCheck = new Check("Test");
	}
	
	@DisplayName("Values")
	@Test
	public void test_CheckDigit() {
		assertEquals(true, ClassCheck.checkDigit("2.394034"));		
		assertEquals(true, ClassCheck.checkDigit("2394.034"));		
		assertEquals(true, ClassCheck.checkDigit("2394034"));		
		assertEquals(true, ClassCheck.checkDigit("239403.4"));		
		assertEquals(true, ClassCheck.checkDigit("3"));
		

		assertEquals(false, ClassCheck.checkDigit("2.394.034"));		
		assertEquals(false, ClassCheck.checkDigit(".2394034"));		
		assertEquals(false, ClassCheck.checkDigit("2394034."));		
		assertEquals(false, ClassCheck.checkDigit(".45."));		
		assertEquals(false, ClassCheck.checkDigit("asdfd"));		
		assertEquals(false, ClassCheck.checkDigit("2.394d034"));		
	}

}

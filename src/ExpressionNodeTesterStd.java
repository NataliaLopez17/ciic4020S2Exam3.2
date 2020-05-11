import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExpressionNodeTesterStd {

	ExpressionNodeWrapper.BinaryExpressionTree T_12, T_3, T0, T1, T10, T20, T5;

	
	@Before
	public void setUp() {
		T_12 = new ExpressionNodeWrapper.BinaryExpressionTree(-12);
		T_3 = new ExpressionNodeWrapper.BinaryExpressionTree(-3);
		T0 = new ExpressionNodeWrapper.BinaryExpressionTree(0);
		T1 = new ExpressionNodeWrapper.BinaryExpressionTree(1);
		T10 = new ExpressionNodeWrapper.BinaryExpressionTree(10);
		T20 = new ExpressionNodeWrapper.BinaryExpressionTree(20);
		T5 = new ExpressionNodeWrapper.BinaryExpressionTree(5);
	}
	
	@Test
	public void evaluateSumTest() {

		ExpressionNodeWrapper.BinaryExpressionTree TIdentity 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.ADD,T0, T10);
		ExpressionNodeWrapper.BinaryExpressionTree TAdd1 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.ADD,T10, T5);
		ExpressionNodeWrapper.BinaryExpressionTree TAdd2 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.ADD,T_12, T5);
		ExpressionNodeWrapper.BinaryExpressionTree TAdd3 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.ADD,T_12, T_3);
		ExpressionNodeWrapper.BinaryExpressionTree TAdd4 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.ADD, T20, T20);
		ExpressionNodeWrapper.BinaryExpressionTree TConcatinatedAdd 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.ADD, TAdd1, TAdd2);
		
		
		assertEquals("Failed sum identity property", 10, TIdentity.evaluate(), 1E-10);
		assertEquals("Failed on simple sum", 15, TAdd1.evaluate(), 1E-10);
		assertEquals("Failed on adding a negative", -7, TAdd2.evaluate(), 1E-10);
		assertEquals("Failed on adding negatives", -15, TAdd3.evaluate(), 1E-10);
		assertEquals("Failed on adding same number", 40, TAdd4.evaluate(), 1E-10);
		assertEquals("Failed on multiple sums", 8, TConcatinatedAdd.evaluate(), 1E-10);
	}

	@Test
	public void evaluateSubstractTest() {

		ExpressionNodeWrapper.BinaryExpressionTree TIdentity 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS,T10, T0);
		ExpressionNodeWrapper.BinaryExpressionTree TInversion
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS,T0, T10);
		ExpressionNodeWrapper.BinaryExpressionTree TSub1 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS,T10, T5);
		ExpressionNodeWrapper.BinaryExpressionTree TSub2 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS,T_12, T5);
		ExpressionNodeWrapper.BinaryExpressionTree TSub3 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS,T_12, T_3);
		ExpressionNodeWrapper.BinaryExpressionTree TSub4 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS, T20, T20);
		ExpressionNodeWrapper.BinaryExpressionTree TConcatinatedSub 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MINUS, TSub1, TSub2);
		
		assertEquals("Failed minus identity property", 10, TIdentity.evaluate(), 1E-10);
		assertEquals("Failed minus inversion property", -10, TInversion.evaluate(), 1E-10);
		assertEquals("Failed on simple sub", 5, TSub1.evaluate(), 1E-10);
		assertEquals("Failed on subtracting to a negative", -17, TSub2.evaluate(), 1E-10);
		assertEquals("Failed on subtracting two negatives", -9, TSub3.evaluate(), 1E-10);
		assertEquals("Failed on subtracting same number", 0, TSub4.evaluate(), 1E-10);
		assertEquals("Failed on subtracting same number", 22, TConcatinatedSub.evaluate(), 1E-10);
	}
	
	@Test
	public void evaluateMultiplicationTest() {

		ExpressionNodeWrapper.BinaryExpressionTree TZero 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT,T10, T0);
		ExpressionNodeWrapper.BinaryExpressionTree TIdentity
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT,T10, T1);
		ExpressionNodeWrapper.BinaryExpressionTree TInversion
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT,T_3, T10);
		ExpressionNodeWrapper.BinaryExpressionTree TMult1 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT,T10, T5);
		ExpressionNodeWrapper.BinaryExpressionTree TMult2 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT,T_12, T_3);
		ExpressionNodeWrapper.BinaryExpressionTree TMult3 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT, T20, T20);
		ExpressionNodeWrapper.BinaryExpressionTree TConcatinatedMult 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.MULT, TMult1, TMult2);
		
		assertEquals("Failed multiplication zero property", 0, TZero.evaluate(), 1E-10);
		assertEquals("Failed multiplication identity property", 10, TIdentity.evaluate(), 1E-10);
		assertEquals("Failed multiplication inversion property", -30, TInversion.evaluate(), 1E-10);
		assertEquals("Failed on simple multiplication", 50, TMult1.evaluate(), 1E-10);
		assertEquals("Failed on multiplication with only negative", 36, TMult2.evaluate(), 1E-10);
		assertEquals("Failed on multiplication on the same number", 400, TMult3.evaluate(), 1E-10);
		assertEquals("Failed on multiple multiplications", 1800, TConcatinatedMult.evaluate(), 1E-10);
	}
	
	@Test
	public void evaluateDivisionTest() {

		ExpressionNodeWrapper.BinaryExpressionTree TZero1 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T10, T0);
		ExpressionNodeWrapper.BinaryExpressionTree TZero2 
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T0, T10);
		ExpressionNodeWrapper.BinaryExpressionTree TIdentity
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T10, T1);
		ExpressionNodeWrapper.BinaryExpressionTree TInversion1
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T5, T10);
		ExpressionNodeWrapper.BinaryExpressionTree TInversion2
		= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T20, T_3);
		ExpressionNodeWrapper.BinaryExpressionTree TDiv1 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T10, T5);
		ExpressionNodeWrapper.BinaryExpressionTree TDiv2 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV,T_12, T_3);
		ExpressionNodeWrapper.BinaryExpressionTree TDiv3 
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV, T20, T20);
		ExpressionNodeWrapper.BinaryExpressionTree TConcatinatedDiv
			= new ExpressionNodeWrapper.BinaryExpressionTree(ExpressionNodeWrapper.ExpressionType.DIV, TDiv2, TDiv1);
		
		assertEquals("Cannot Divide by 0. Send 0.", Double.POSITIVE_INFINITY, TZero1.evaluate(), 1E-10);
		assertEquals("Failed division zero property", 0, TZero2.evaluate(), 1E-10);
		assertEquals("Failed division identity property", 10, TIdentity.evaluate(), 1E-10);
		assertEquals("Failed division inversion property", 0.5, TInversion1.evaluate(), 1E-10);
		assertEquals("Failed division sign inversion property", -6.6666666666, TInversion2.evaluate(), 1E-10);
		assertEquals("Failed on simple division", 2, TDiv1.evaluate(), 1E-10);
		assertEquals("Failed on division with only negatives", 4, TDiv2.evaluate(), 1E-10);
		assertEquals("Failed on division with the same number", 1, TDiv3.evaluate(), 1E-10);
		assertEquals("Failed on multiple multiplications", 2, TConcatinatedDiv.evaluate(), 1E-10);
	}
}
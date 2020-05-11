public class ExpressionNodeWrapper {
	// types of operations
	public static enum ExpressionType {
		ADD, MINUS, MULT, DIV

	}

	// Represents an expression node
	public static interface ExpressionNode {
		public double getValue();
	}

	public static class NumericExpressionNode implements ExpressionNode {

		private double number;

		public NumericExpressionNode(double value) {
			this.number = value;
		}

		public double getValue() {
			return this.number;
		}

	}

	public static class ComputedExpressionNode implements ExpressionNode {
		// type of expression
		private ExpressionType expType;
		// left child node
		private ExpressionNode leftChild;
		// right child node
		private ExpressionNode rightChild;

		// getters
		public ExpressionType getExpType() {
			return expType;
		}

		public ExpressionNode getLeftChild() {
			return leftChild;
		}

		public ExpressionNode getRightChild() {
			return rightChild;
		}

		// setters
		public void setExpType(ExpressionType expType) {
			this.expType = expType;
		}

		public void setLeftChild(ExpressionNode leftChild) {
			this.leftChild = leftChild;
		}

		public void setRightChild(ExpressionNode rightChild) {
			this.rightChild = rightChild;
		}

		public ComputedExpressionNode(ExpressionType expType, ExpressionNode leftChild, ExpressionNode rightChild) {
			super();
			this.expType = expType;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		/////////////////////////////////////////////////////////////////////////////////////////
		//////////// FOR STUDENT
		@Override
		public double getValue() {
			if (ExpressionType.ADD == this.expType) {
				return this.getLeftChild().getValue() + this.getRightChild().getValue();
			}
			if (ExpressionType.DIV == this.expType) {
				return this.getLeftChild().getValue() / this.getRightChild().getValue();

			}
			if (ExpressionType.MINUS == this.expType) {
				return Math.floor(this.getLeftChild().getValue() - this.getRightChild().getValue());

			}
			return this.getLeftChild().getValue() * this.getRightChild().getValue();
		}

		// double result = 0.0;
		// if (this.expType == ExpressionType.ADD) result = leftChild.getValue() +
		// rightChild.getValue();
		// if (this.expType == ExpressionType.MINUS) result = leftChild.getValue() -
		// rightChild.getValue();
		// if (this.expType == ExpressionType.MULT) result = leftChild.getValue() *
		// rightChild.getValue();
		// if (this.expType == ExpressionType.DIV) result =
		// leftChild.getValue()/rightChild.getValue();
		// return result;
	}

	public static class BinaryExpressionTree {
		private ExpressionNode root;

		public BinaryExpressionTree(double value) {
			this.root = new NumericExpressionNode(value);
		}

		public BinaryExpressionTree(ExpressionType type, BinaryExpressionTree T1, BinaryExpressionTree T2) {
			this.root = new ComputedExpressionNode(type, T1.root, T2.root);
		}

		public double evaluate() {
			return this.root.getValue();
		}

	}
}
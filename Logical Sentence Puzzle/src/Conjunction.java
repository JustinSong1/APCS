
public class Conjunction extends LogicalSentence {
//	PropositionConstant left;
//	PropositionConstant right;
	LogicalSentence leftSent;
	LogicalSentence rightSent;

	
	public Conjunction() {
		super();
	}
//	public Conjunction(PropositionConstant left, PropositionConstant right) {
//		this.left = left;
//		this.right = right;
//	}
	public Conjunction(LogicalSentence leftSent, LogicalSentence rightSent) {
		this.leftSent = leftSent;
		this.rightSent = rightSent;
	}
	/**
	 * checks if both sentences evaluate to true
	 */
	public boolean evaluate(TruthAssignment t) {
		return (leftSent.evaluate(t) && rightSent.evaluate(t));
	}
}

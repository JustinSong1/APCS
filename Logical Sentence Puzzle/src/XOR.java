
public class XOR extends LogicalSentence {
//	PropositionConstant left;
//	PropositionConstant right;
	LogicalSentence leftSent;
	LogicalSentence rightSent;

	
	public XOR() {
		super();
	}
//	public Conjunction(PropositionConstant left, PropositionConstant right) {
//		this.left = left;
//		this.right = right;
//	}
	public XOR(LogicalSentence leftSent, LogicalSentence rightSent) {
		this.leftSent = leftSent;
		this.rightSent = rightSent;
	}
	public boolean evaluate(TruthAssignment t) {
		return ((leftSent.evaluate(t) && !rightSent.evaluate(t)) || (!leftSent.evaluate(t) && rightSent.evaluate(t)));
	}
}

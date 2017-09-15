
public class Disjunction extends LogicalSentence {
//	PropositionConstant left;
//	PropositionConstant right;
	LogicalSentence leftSent;
	LogicalSentence rightSent;

	
	public Disjunction() {
		super();
	}
//	public Conjunction(PropositionConstant left, PropositionConstant right) {
//		this.left = left;
//		this.right = right;
//	}
	public Disjunction(LogicalSentence leftSent, LogicalSentence rightSent) {
		this.leftSent = leftSent;
		this.rightSent = rightSent;
	}
	public boolean evaluate(TruthAssignment t) {
		return (leftSent.evaluate(t) || rightSent.evaluate(t));
	}
}

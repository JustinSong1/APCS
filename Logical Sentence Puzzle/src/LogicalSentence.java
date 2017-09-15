
public class LogicalSentence {
	private PropositionConstant constant;
	public LogicalSentence() {}
	public LogicalSentence(PropositionConstant constant) {
		this.constant = constant;
	}
	public boolean evaluate(TruthAssignment t) {
		return t.get(constant);
	}
}

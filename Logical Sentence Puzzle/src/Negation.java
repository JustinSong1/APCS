
public class Negation extends LogicalSentence {
	LogicalSentence sentence;
	public Negation(LogicalSentence sentence) {
		this.sentence = sentence;
	}
	/**
	 * returns the negation of the logical sentence it was passed
	 */
	@Override
	public boolean evaluate(TruthAssignment t) {
		return !sentence.evaluate(t);
	}
}

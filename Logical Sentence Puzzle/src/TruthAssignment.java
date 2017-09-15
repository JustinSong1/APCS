import java.util.HashMap;

public class TruthAssignment{
	//Stores the values of proposition constants in a hashmap for later reference
	private HashMap<PropositionConstant, Boolean> map = new HashMap<PropositionConstant, Boolean>();
	public void put(PropositionConstant constant, Boolean bool) {
		map.put(constant, bool);
	}

	public boolean get(PropositionConstant constant) {
		return map.get(constant);
	}
}

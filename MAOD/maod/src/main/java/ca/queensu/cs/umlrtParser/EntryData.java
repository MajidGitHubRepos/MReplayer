package ca.queensu.cs.umlrtParser;

import org.eclipse.uml2.uml.State;

public class EntryData {
	private final State source;
	private final String sourceName;
	private final State target;
	private final String targetName;
	

	
	public EntryData(State source, String sourceName , State target, String targetName) {
		this.source = source;
		this.sourceName = source.getName();
		this.target = target;
		this.targetName = target.getName();
	}
	
	public EntryData(String sourceName , String targetName) {
		this(null,sourceName, null, targetName);
	}

	
	public String getSourceName() {
		return sourceName;
	}

	
	public String getTargetName() {
		return targetName;
	}

}

package ca.queensu.cs.umlrtParser;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;

import ca.queensu.cs.umlrtParser.UmlrtUtils.PseudoStateKind;

public class StateData {
	
	private String capsuleName;
	private String parentName;
	private String regionName;
	private String stateName;
	private State state;
	private List<String> deferred;
	private List<String> entryActions;
	private List<String> exitActions;
	private boolean initial = false;
	private boolean end = false;
	private PseudoStateKind pseudoStateKind;
		
	public StateData(String capsuleName, State s, String sName, List<String> enList, List<String> exList, List<String> defList, String pName, String rName, boolean isInitialState, boolean isFinalState) {
		this.capsuleName = capsuleName;
		this.state = s;
		this.stateName = sName;
		this.deferred = defList;
		this.entryActions = enList;
		this.exitActions = exList;
		this.parentName = pName;
		this.regionName = rName;
		this.initial = isInitialState;
		this.end = isFinalState;
	}
	
	public StateData(String capsuleName, String sName, String pName, String rName) {
		this(capsuleName, null,sName, null, null, null, pName,rName, false, false);
	}
	public StateData(String capsuleName, String sName, String pName, String rName , boolean initial, boolean end) {
		this(capsuleName, null,sName, null, null, null, pName,rName, initial, end);
	}
	public StateData() {
		this(null, null,null, null, null, null, null,null, false,false);
	}
	
	
	
	//------------[GETERS]
	public String getCapsuleName() {
		return capsuleName;
	}
	
	public State getState() {
		return state;
	}
	public String getStateName() {
		return stateName;
	}
	public List<String> getDeferred() {
		return deferred;
	}
	
	public List<String> getEntryActions() {
		return entryActions;
	}
	
	public List<String> getExitActions() {
		return exitActions;
	}
	
	public String getParent() {
		return parentName;
	}
	
	public String getRegion() {
		return regionName;
	}
	
	public boolean isInitial() {
		return initial;
	}
	
	public boolean isEnd() {
		return end;
	}
	
	public PseudoStateKind getPseudoStateKind() {
		return pseudoStateKind;
	}
	//------------[SETERS]
	
	public void setDeferred(List<String> deferred) {
		this.deferred = deferred;
	}
	
	public void setParent(String parent) {
		this.parentName = parent;
	}
	
	public void setRegion(String region) {
		this.regionName = region;
	}
	
	public void setInitial(boolean initial) {
		this.initial = initial;
	}
	
	public void setEnd(boolean end) {
		this.end = end;
	}
	
	public void setPseudoStateKind(PseudoStateKind pseudoStateKind) {
		this.pseudoStateKind = pseudoStateKind;
	}
	
	public void setEntryActions(List<String> entryActions) {
		this.entryActions = entryActions;
	}
	
	public void setExitActions(List<String> exitActions) {
		this.exitActions = exitActions;
	}
	
	
	//----------
	
	public String allDataToString() {
		return "StateData [CapsuleName="+capsuleName+", StateName=" + stateName + ", region=" + regionName + ", state=" + state + ", deferred=" + deferred
				+ ", entryActions=" + entryActions + ", exitActions=" + exitActions + ", initial=" + initial
				+  ", end=" + end + ", pseudoStateKind=" + pseudoStateKind + "]";
	}
	

	

}

package ca.queensu.cs.umlrt;

import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;

import ca.queensu.cs.umlrt.UmlrtUtils.PseudoStateKind;

public class StateData {

	private String parentName;
	private String regionName;
	private String stateName;
	private State state;
	//private Collection<StateData<S, E>> submachineStateData;
	//private StateMachine<S, E> submachine;
	//private StateMachineFactory<S, E> submachineFactory;
	private List<String> deferred;
	private List<String> entryActions;
	private List<String> exitActions;
	//private Collection<? extends Action<S, E>> stateActions;
	private boolean initial = false;
	//private Action<S, E> initialAction;
	private boolean end = false;
	private PseudoStateKind pseudoStateKind;
	
	//public StateData() {}
	
	public StateData(State s, String sName, List<String> enList, List<String> exList, List<String> defList, String pName, String rName, boolean isInitialState, boolean isFinalState) {
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
	
	public StateData(String sName, String pName, String rName) {
		this(null,sName, null, null, null, pName,rName, false, false);
	}
	
	
	//------------[GETERS]
	public State getState() {
		return state;
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
	
	
	public void setEntyActions(List<String> entyActions) {
		this.entryActions = entyActions;
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
		return "StateData [parent=" + parentName + ", region=" + regionName + ", state=" + state + ", deferred=" + deferred
				+ ", entryActions=" + entryActions + ", exitActions=" + exitActions + ", initial=" + initial
				+  ", end=" + end + ", pseudoStateKind=" + pseudoStateKind + "]";
	}
	

	

}

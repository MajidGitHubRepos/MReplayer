package ca.queensu.cs.umlrt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;
import org.springframework.statemachine.transition.TransitionKind;

public class TransitionData {
	//private  String name;
	private final State source;
	private final State target;
	private final String sourceName;
	private final String targetName;
	private final String signal;
	private final List<String> guard;
	private final List<String> actions;
	private  TransitionKind kind;
	private final Long period;
	private final Integer count;
	private final String event;
	//private List<Vector<String, String>> triggers = new ArrayList<HashMap<String, String>>();
	//private final SecurityRule securityRule;

	//public TransitionData() {}
	public TransitionData(String sourceName, String targetName, String signal, List<String> actions, List<String> guard, TransitionKind kind) {
		this(null,sourceName, null, targetName, signal, actions, guard, kind, null, null, null);
	}
	
	public TransitionData(String sourceName, String targetName, List<String> actions, List<String> guard, TransitionKind kind, Long period, Integer count) {
		this(null,sourceName, null, targetName, null, actions, guard, kind, period, count, null);
	}
	
	public TransitionData(State source, String sourceName, State target, String targetName, String signal, List<String> actions, List<String> guard, TransitionKind kind, Long period, Integer count, String event) {
		this.source = source;
		this.sourceName = sourceName;
		this.target = target;
		this.targetName = targetName;
		this.signal = signal;
		this.guard = guard;
		this.actions = actions;
		this.kind = kind;
		this.period = period;
		this.count = count;
		this.event = event;
	}

	//------------[GETERS]
	//public String getName() {
	//	return name;
	//}
	public State getSource() {
		return source;
	}

	public State getTarget() {
		return target;
	}

	public String getEvent() {
		return event;
	}

	public Integer getCount() {
		return count;
	}

	public List<String> getActions() {
		return actions;
	}

	public List<String> getGuard() {
		return guard;
	}

	//public List<HashMap<String, String>> getTriggers() {
	//	return triggers;
	//}

	public TransitionKind getKind() {
		return kind;
	}


	//------------[SETTERS]
	//public void setName(String n) {
	//	this.name = n;
	//}
	/*
	public void setSource(String s) {
		this.sourceName = s;
	}

	public void setTargetName(String t) {
		this.targetName = t;
	}

	public void setEvent(String e) {
		this.event = e;
	}

	public void setCount(Integer i) {
		this.count= i;
	}

	public void setActions(String a) {
		this.actions = a;
	}

	public void setGuard(String g) {
		this.guard = g;
	}

	public void setTriggers(List<HashMap<String, String>> tr) {
		this.triggers = tr;
	}

	public void setKind (TransitionKind k) {
		this.kind = k;
	}
	*/
	
	public String allDataToString() {
		return "TransitionData [source=" + source + ", sourceName=" + sourceName +", target=" + target + ", targetName=" + targetName + ", signal=" + signal + ", actions=" + actions + ", guard=" + guard
				+ ", period=" + period + ", count=" + count + ", kind=" + kind +"]";
	}

}

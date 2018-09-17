package ca.queensu.cs.umlrtParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;
import org.springframework.statemachine.transition.TransitionKind;

public class TransitionData {
	//private  String name;
	public String capsuleName;
	private final State source;
	private final State target;
	private final String sourceName;
	private final String targetName;
	private final List<String> triggers;
	private final List<String> guards;
	private final List<String> actions;
	private  TransitionKind kind;
	private final Long period;
	private final Integer count;
	//private List<Vector<String, String>> triggers = new ArrayList<HashMap<String, String>>();
	//private final SecurityRule securityRule;

	//public TransitionData() {}
	public TransitionData(String capsuleName, String sourceName, String targetName, List<String> triggers, List<String> actions, List<String> guards, TransitionKind kind, Long period, Integer count) {
		this(capsuleName,null,sourceName, null, targetName, triggers, actions, guards, kind, period, count);
	}
	
	public TransitionData(String capsuleName, String sourceName, String targetName, List<String> triggers, List<String> actions, List<String> guard, TransitionKind kind) {
		this(capsuleName,null,sourceName, null, targetName, triggers, actions, guard, kind, null, null);
	}
	
	public TransitionData(String capsuleName, String sourceName, String targetName, List<String> actions, List<String> guard, TransitionKind kind, Long period, Integer count) {
		this(capsuleName,null,sourceName, null, targetName, null, actions, guard, kind, period, count);
	}
	
	public TransitionData(String capsuleName, State source, String sourceName, State target, String targetName, List<String> triggers, List<String> actions, List<String> guards, TransitionKind kind, Long period, Integer count) {
		this.capsuleName = capsuleName;
		this.source = source;
		this.sourceName = sourceName;
		this.target = target;
		this.targetName = targetName;
		this.triggers = triggers;
		this.guards = guards;
		this.actions = actions;
		this.kind = kind;
		this.period = period;
		this.count = count;
		//this.event = event;
	}

	//------------[GETERS]
	//public String getName() {
	//	return name;
	//}
	public String getCapsuleName() {
		return capsuleName;
	}
	
	public State getSource() {
		return source;
	}

	public State getTarget() {
		return target;
	}
	
	public String getSourceName() {
		return sourceName;
	}

	public String getTargetName() {
		return targetName;
	}
	
	public Integer getCount() {
		return count;
	}

	public List<String> getActions() {
		return actions;
	}

	public List<String> getGuard() {
		return guards;
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
		return "TransitionData [CapsuleName= "+capsuleName+", source= " + source + ", sourceName=" + sourceName +", target=" + target + ", targetName=" + targetName + ", triggers=" + triggers + ", actions=" + actions + ", guards=" + guards
				+ ", period=" + period + ", count=" + count + ", kind=" + kind +"]";
	}

}

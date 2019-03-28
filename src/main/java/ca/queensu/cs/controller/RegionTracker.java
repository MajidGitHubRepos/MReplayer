package ca.queensu.cs.controller;

public class RegionTracker {
	//current state e.g.:"SimpleCS::C0::StateMachine::Region::S0"->"SimpleCS::C0::StateMachine::Region::S0::Region1::S02"
	//idx=[StateMachine], idx-1 = [CapsuleName], idx+1 = [RegionName], idx+2 = [State/Transition Name] 
	String currentState;

}

package ca.queensu.cs.umlrt;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.ContentTreeIterator;

/*import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.Capsule;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.CapsulePart;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.Protocol;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.ProtocolContainer;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.RTConnector;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.RTMessageSet;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.RTPort;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.UMLRealTimePackage;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.RTPseudostate;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.RTRegion;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.RTState;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.RTStateMachine;
import org.eclipse.papyrusrt.umlrt.profile.statemachine.UMLRTStateMachines.UMLRTStateMachinesPackage;*/
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
//import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.springframework.util.StringUtils;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;

public class ParserEngine implements Runnable {
	private EList<PackageableElement> modelElements;
	public HashMap<String, StateMachine> stateMachineMap;
	public List<StateData> listStateData;
	public List<TransitionData> listTransitionData;
	private final List<EntryData> entrys = new ArrayList<EntryData>();
	private final List<ExitData> exits = new ArrayList<ExitData>();
	private final Map<String, LinkedList<ChoiceData>> choices = new HashMap<String, LinkedList<ChoiceData>>();
	private final Map<String, LinkedList<JunctionData>> junctions = new HashMap<String, LinkedList<JunctionData>>();
	private final Map<String, List<String>> forks = new HashMap<String, List<String>>();
	private final Map<String, List<String>> joins = new HashMap<String, List<String>>();
	private final List<HistoryData> historys = new ArrayList<HistoryData>();

	public ParserEngine(EList<PackageableElement> me) {
		this.modelElements = me;
		HashMap<String, StateMachine> stateMachineMap = new HashMap<String, StateMachine>();
		this.listStateData = new ArrayList<StateData>();
		this.listTransitionData = new ArrayList<TransitionData>(); 

	}

	//==================================================================	
	//==============================================[showStateMachines]
	//==================================================================
	public void showStateMachines() {
		Iterator i = stateMachineMap.entrySet().iterator();
		int counter = 0;
		while(i.hasNext())
		{
			counter++;
			String key = i.next().toString();  
			StateMachine value = stateMachineMap.get(key);
			System.out.println("["+ counter+"]> (KEY): "+key + ", (VALUE): " + value);
		}

	}

	//==================================================================	
	//==============================================[Run]
	//==================================================================	
	public final void run() {
		elementsExtractor();
		
		System.out.println("=======================[StateData]==========================");
		for (int i = 0; i<listStateData.size(); i++) {
			System.out.println("["+i+"]:" +listStateData.get(i).allDataToString());
		}
		//-------
		System.out.println("=======================[TransitionData]==========================");
		for (int i = 0; i<listTransitionData.size(); i++) {
			System.out.println("["+i+"]:" +listTransitionData.get(i).allDataToString());
		}


	}

	//==================================================================	
	//==============================================[elementsExtractor]
	//==================================================================	
	public void elementsExtractor() {
		HashMap<String, StateMachine> smMap = new HashMap<String, StateMachine>();

		int i=0;
		List<StateMachine> stateMachines = new ArrayList<StateMachine>();
		while(i < modelElements.size()) {
			PackageableElement element = modelElements.get(i);
			//System.out.println("--------------> modelElement: "+ element );

			if(element instanceof Class) {
				if ( (((Class) element).getOwnedBehaviors() != null && ((Class) element).getOwnedBehaviors().size() > 0))
					if (((Class) element).getOwnedBehaviors().get(0) instanceof StateMachine)
						stateMachines.add((StateMachine) ((Class) element).getOwnedBehaviors().get(0));	
			}

			i++;
		}

		// expect root machine to be a one having no machines in a submachineState field.
		//====================================================== [Extract State Machines]			
		for (StateMachine stateMachine : stateMachines) {
			smMap.put(stateMachine.getName(), stateMachine);
			handleStateMachine(stateMachine);
		}
		this.stateMachineMap = smMap;
		// all machines are iterated so we only do sanity check here for a root machine
		if (this.stateMachineMap == null) {
			throw new IllegalArgumentException("Can't find root statemachine from model");
		}
		//showStateMachines();
	}


	//==================================================================	
	//==============================================[handleStateMachine]
	//==================================================================	
	private void handleStateMachine(StateMachine stateMachine) {
		for (Region region : stateMachine.getRegions()) {
			handleRegion(region);
		}
	}

	//==================================================================	
	//==============================================[handleRegion]
	//==================================================================
	private void handleRegion(Region region) {
		for (Vertex vertex : region.getSubvertices()) {
			//[Start]----------------------------------------------------------[State]
			if (vertex instanceof State) {
				
				State state = (State)vertex;
				List<String> entryList = new ArrayList();
				List<String> exitList = new ArrayList();
				List<String> deferredList = new ArrayList();
				String parentName = "";
				String regionName = "";
				String sName = state.getName();
				
				//System.out.println("state: " + state);

				if (state.getContainer().getOwner() instanceof State) {
					parentName = ((State)state.getContainer().getOwner()).getName();					
				}

				if (parentName == null && region.getOwner() instanceof StateMachine) {
					EList<State> submachineStates = ((StateMachine)region.getOwner()).getSubmachineStates();
					if (submachineStates.size() == 1) {
						parentName = submachineStates.get(0).getName();
					}
				}

				if (state.getOwner() instanceof Region) {
					regionName = ((Region)state.getOwner()).getName();

				}

				if (state.getEntry() instanceof OpaqueBehavior) {
					String stateBody = UmlrtUtils.resolveBodyByLanguage("C++", (OpaqueBehavior)state.getEntry());
					//System.out.println("--------------> Body[getEntry]: "+ stateBody);
					entryList = UmlrtUtils.actionCodeProcessing(stateBody);
				}

				if (state.getExit() instanceof OpaqueBehavior) {
					String stateBody = UmlrtUtils.resolveBodyByLanguage("C++", (OpaqueBehavior)state.getExit());
					//System.out.println("--------------> Body[getExit]: "+ stateBody);
					exitList = UmlrtUtils.actionCodeProcessing(stateBody);
				}
				boolean isInitialState = UmlrtUtils.isInitialState(state);
				deferredList = UmlrtUtils.resolveDeferredEvents(state);
				boolean isFinalState = UmlrtUtils.isFinalState(state);
				StateData stateDate = new StateData(state,sName, entryList, exitList, deferredList, parentName, regionName, isInitialState, isFinalState); //My Solution
				/*StateData stateData = handleActions(
						new StateData(state,sName, entryList, exitList, deferredList, parentName, regionName, isInitialState, isFinalState), state);*/

				listStateData.add(stateDate);
				//System.out.println(stateDate.allDataToString());

				// add states via entry/exit reference points
				for (ConnectionPointReference cpr : state.getConnections()) {
					if (cpr.getEntries() != null) {
						for (Pseudostate cp : cpr.getEntries()) {
							StateData cpStateData = new StateData(cp.getName(), parentName, regionName);
							cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.ENTRY);
							listStateData.add(cpStateData);
						}
					}
					if (cpr.getExits() != null) {
						for (Pseudostate cp : cpr.getExits()) {
							StateData cpStateData = new StateData(cp.getName(), parentName, regionName);
							cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.EXIT);
							listStateData.add(cpStateData);
						}
					}
				}

				// do recursive handling of regions
				for (Region sub : state.getRegions()) {
					handleRegion(sub);
				}
			}
			//[End]----------------------------------------------------------[State]
			//[Start]----------------------------------------------------------[Pseudostate]
			if (vertex instanceof Pseudostate) {
				Pseudostate state = (Pseudostate)vertex;
				String parentName = null;
				String regionName = null;
				if (state.getContainer().getOwner() instanceof State) {
					parentName = ((State)state.getContainer().getOwner()).getName();
				}
				if (state.getOwner() instanceof Region) {
					regionName = ((Region)state.getOwner()).getName();
				}

				if (state.getKind() == PseudostateKind.CHOICE_LITERAL) {
					StateData cpStateData = new StateData(state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.CHOICE);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.JUNCTION_LITERAL) {
					StateData cpStateData = new StateData(state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.JUNCTION);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.FORK_LITERAL) {
					StateData cpStateData = new StateData(state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.FORK);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.JOIN_LITERAL) {
					StateData cpStateData = new StateData(state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.JOIN);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.SHALLOW_HISTORY_LITERAL) {
					StateData cpStateData = new StateData(state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.HISTORY_SHALLOW);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.DEEP_HISTORY_LITERAL) {
					StateData cpStateData = new StateData(state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.HISTORY_DEEP);
					listStateData.add(cpStateData);
				}
			}
		} //[End] Vertex
			//[End]----------------------------------------------------------[Pseudostate]
			//[Start]----------------------------------------------------------[Transitions]
			for (Transition transition : region.getTransitions()) {
				// for entry/exit points we need to create these outside
				// of triggers as link from point to a state is most likely
				// just a link and don't have any triggers.
				// little unclear for now if link from points to a state should
				// have trigger?
				// anyway, we need to add entrys and exits to a model
				
				//System.out.println("==>>> transiton: " + transition);
				boolean targetPseudostate = false;
				boolean sourcePseudostate = false;
				
				if (transition.getSource() instanceof ConnectionPointReference) {
					// support ref points if only one is defined as for some
					// reason uml can define multiple ones which is not
					// realistic with state machines
					EList<Pseudostate> cprentries = ((ConnectionPointReference)transition.getSource()).getEntries();
					if (cprentries != null && cprentries.size() == 1 && cprentries.get(0).getKind() == PseudostateKind.ENTRY_POINT_LITERAL) {
						entrys.add(new EntryData(cprentries.get(0).getName(), transition.getTarget().getName()));
					}
					EList<Pseudostate> cprexits = ((ConnectionPointReference)transition.getSource()).getExits();
					if (cprexits != null && cprexits.size() == 1 && cprexits.get(0).getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
						exits.add(new ExitData(cprexits.get(0).getName(), transition.getTarget().getName()));
					}
				}
				
				//State s = (State)transition.getSource();
				if (transition.getSource() instanceof Pseudostate) {
					if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.ENTRY_POINT_LITERAL) {
						entrys.add(new EntryData(transition.getSource().getName(), transition.getTarget().getName()));
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
						exits.add(new ExitData(transition.getSource().getName(), transition.getTarget().getName()));
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.CHOICE_LITERAL) {
						LinkedList<ChoiceData> list = choices.get(transition.getSource().getName());
						if (list == null) {
							list = new LinkedList<ChoiceData>();
							choices.put(transition.getSource().getName(), list);
						}
						List<String> guard = resolveGuard(transition);
						List<String> actions = UmlrtUtils.resolveTransitionActions(transition);
						// we want null guards to be at the end
						if (guard == null) {
							list.addLast(new ChoiceData(transition.getSource().getName(), transition.getTarget().getName(), guard, actions));
						} else {
							list.addFirst(new ChoiceData(transition.getSource().getName(), transition.getTarget().getName(), guard, actions));
						}
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.JUNCTION_LITERAL) {
						LinkedList<JunctionData> list = junctions.get(transition.getSource().getName());
						if (list == null) {
							list = new LinkedList<JunctionData>();
							junctions.put(transition.getSource().getName(), list);
						}
						List<String> guard = resolveGuard(transition);
						List<String> actions = UmlrtUtils.resolveTransitionActions(transition);
						// we want null guards to be at the end
						if (guard == null) {
							list.addLast(new JunctionData<String, String>(transition.getSource().getName(), transition.getTarget().getName(), guard, actions));
						} else {
							list.addFirst(new JunctionData<String, String>(transition.getSource().getName(), transition.getTarget().getName(), guard, actions));
						}
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.FORK_LITERAL) {
						List<String> list = forks.get(transition.getSource().getName());
						if (list == null) {
							list = new ArrayList<String>();
							forks.put(transition.getSource().getName(), list);
						}
						list.add(transition.getTarget().getName());
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.SHALLOW_HISTORY_LITERAL) {
						historys.add(new HistoryData(transition.getSource().getName(), transition.getTarget().getName()));
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.DEEP_HISTORY_LITERAL) {
						historys.add(new HistoryData(transition.getSource().getName(), transition.getTarget().getName()));
					} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.INITIAL_LITERAL) {
						sourcePseudostate = true;
					}
				}
				if (transition.getTarget() instanceof Pseudostate) {
					if (((Pseudostate)transition.getTarget()).getKind() == PseudostateKind.JOIN_LITERAL) {
						List<String> list = joins.get(transition.getTarget().getName());
						if (list == null) {
							list = new ArrayList<String>();
							joins.put(transition.getTarget().getName(), list);
						}
						list.add(transition.getSource().getName());
					}else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
						targetPseudostate = true;
					}
				}
				List<String> guard = null;
				Long period = null;
				Integer count = null;
				// go through all triggers and create transition
				// from signals, or transitions from timers
				for (Trigger trigger : transition.getTriggers()) {
					guard = resolveGuard(transition);
					Event event = trigger.getEvent();
					if (event instanceof SignalEvent) {
						Signal signal = ((SignalEvent)event).getSignal();
						if (signal != null) {
							// special case for ref point
							if (transition.getTarget() instanceof ConnectionPointReference) {
								EList<Pseudostate> cprentries = ((ConnectionPointReference)transition.getTarget()).getEntries();
								if (cprentries != null && cprentries.size() == 1) {
									listTransitionData.add(new TransitionData(transition.getSource().getName(),
											cprentries.get(0).getName(), signal.getName(), UmlrtUtils.resolveTransitionActions(transition),
											guard, UmlrtUtils.mapUmlTransitionType(transition)));
								}
							} else {
								listTransitionData.add(new TransitionData(transition.getSource().getName(),
										transition.getTarget().getName(), signal.getName(), UmlrtUtils.resolveTransitionActions(transition),
										guard, UmlrtUtils.mapUmlTransitionType(transition)));
							}
						}
					}else if (event instanceof TimeEvent) {
						TimeEvent timeEvent = (TimeEvent)event;
						period = getTimePeriod(timeEvent);
						if (period != null) {
							count = null;
							if (timeEvent.isRelative()) {
								count = 1;
							}
							listTransitionData.add(new TransitionData(transition.getSource().getName(),
									transition.getTarget().getName(), UmlrtUtils.resolveTransitionActions(transition),
									guard, UmlrtUtils.mapUmlTransitionType(transition), period, count));
						}
					}
				}//for
				if ((transition.getSource() instanceof State) && (transition.getTarget() instanceof State) || (sourcePseudostate) || (targetPseudostate)) {
					listTransitionData.add(new TransitionData(transition.getSource().getName(),
							transition.getTarget().getName(), UmlrtUtils.resolveTransitionActions(transition),
							guard, UmlrtUtils.mapUmlTransitionType(transition), period, count));
					
				}
				// create anonymous transition if needed
				if (shouldCreateAnonymousTransition(transition)) {
					listTransitionData.add(new TransitionData(transition.getSource().getName(), transition.getTarget().getName(),
							null, UmlrtUtils.resolveTransitionActions(transition), resolveGuard(transition),
							UmlrtUtils.mapUmlTransitionType(transition)));
				}
			
			}
			//[End]----------------------------------------------------------[Transitions]
		
	}//[End] Region
	
	//---------------[Functions]
	private List<String> resolveGuard(Transition transition) {
		List<String> guard = null;
		for (Constraint c : transition.getOwnedRules()) {
			if (c.getSpecification() instanceof OpaqueExpression) {
				String guardStr = UmlrtUtils.resolveBodyByLanguage("C++", (OpaqueExpression)c.getSpecification());
				guard.add(guardStr);
			}
		}
		return guard;
	}
	
	private Long getTimePeriod(TimeEvent event) {
		try {
			return Long.valueOf(event.getWhen().getExpr().integerValue());
		} catch (Exception e) {
			return null;
		}
	}
	
	private boolean shouldCreateAnonymousTransition(Transition transition) {
		if (transition.getSource() == null || transition.getTarget() == null) {
			// nothing to do as would cause NPE later
			return false;
		}
		if (!transition.getTriggers().isEmpty()) {
			return false;
		}
		if (!StringUtils.hasText(transition.getSource().getName())) {
			return false;
		}
		if (!StringUtils.hasText(transition.getTarget().getName())) {
			return false;
		}
		if (transition.getSource() instanceof Pseudostate) {
			if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.FORK_LITERAL) {
				return false;
			}
		}
		if (transition.getTarget() instanceof Pseudostate) {
			if (((Pseudostate)transition.getTarget()).getKind() == PseudostateKind.JOIN_LITERAL) {
				return false;
			}
		}
		return true;
	}
	


}

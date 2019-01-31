package ca.queensu.cs.umlrtParser;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */
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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.Capsule;
import org.eclipse.papyrusrt.umlrt.uml.UMLRTFactory;
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
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
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
	private String topCapsuleName;
	private static EList<PackageableElement> modelElements;
	public HashMap<String, StateMachine> stateMachineMap;
	public List<StateData> listStateData;
	public List<TransitionData> listTransitionData;
	public List<CapsuleConn> listCapsuleConn;
	private final List<EntryData> entrys = new ArrayList<EntryData>();
	private final List<ExitData> exits = new ArrayList<ExitData>();
	private final Map<String, LinkedList<ChoiceData>> choices = new HashMap<String, LinkedList<ChoiceData>>();
	private final Map<String, LinkedList<JunctionData>> junctions = new HashMap<String, LinkedList<JunctionData>>();
	private final Map<String, List<String>> forks = new HashMap<String, List<String>>();
	private final Map<String, List<String>> joins = new HashMap<String, List<String>>();
	private final List<HistoryData> historys = new ArrayList<HistoryData>();
	private final Map<String, List<TableDataMember>> listTableData = new HashMap<String, List<TableDataMember>>();
	private List<String> listPortName_connectorName_PortName = new ArrayList<String>();


	public String elementInstanceName;
	public String elementName;
	public String capDone = "";
	boolean isInitTr;
	boolean umlrtParsingDone;

	public ParserEngine(EList<PackageableElement> me, String topCapsuleName) {
		this.modelElements = me;
		//HashMap<String, StateMachine> stateMachineMap = new HashMap<String, StateMachine>();
		this.listStateData = new ArrayList<StateData>();
		this.listTransitionData = new ArrayList<TransitionData>();
		this.elementInstanceName = "";
		this.elementName = "";
		this.isInitTr = false;
		this.umlrtParsingDone = false;
		this.listCapsuleConn = new ArrayList<CapsuleConn>();
		this.topCapsuleName = topCapsuleName;

	}
	
	public static EList<PackageableElement> getModelElements() {
		return modelElements;
	}
	public boolean getUmlrtParsingDone() {
		return this.umlrtParsingDone;
	}
	public List<CapsuleConn> getListCapsuleConn(){
		return this.listCapsuleConn;
	}
	public Map<String, List<TableDataMember>> getListTableData() {
		return listTableData;
	}

	//==================================================================	
	//==============================================[showStateMachines]
	//==================================================================
	public void showStateMachines() {
		System.out.println("=======================[showStateMachines]==========================");

		Iterator iterator = stateMachineMap.entrySet().iterator();
		int counter = 0;
		while(iterator.hasNext())
		{
			counter++;
			Map.Entry mentry = (Map.Entry) iterator.next();  
			System.out.println("["+ counter+"]> (KEY): "+ mentry.getKey() + ", (VALUE): " + mentry.getValue());
		}

	}

	//==================================================================	
	//==============================================[Run]
	//==================================================================	
	public final void run() {
		elementsExtractor();
		showElements();
		this.umlrtParsingDone = true;

	}

	//==================================================================	
	//==============================================[showElements]
	//==================================================================	
	public void showElements() {
		System.out.println("=======================[StateData]==========================");
		for (int i = 0; i<listStateData.size(); i++) {
			System.out.println("["+i+"]:" +listStateData.get(i).allDataToString());
		}
		//-------
		System.out.println("=======================[TransitionData]==========================");
		for (int i = 0; i<listTransitionData.size(); i++) {
			System.out.println("["+i+"]:" +listTransitionData.get(i).allDataToString());
		}
		//-------
		System.out.println("=======================[choices]==========================");
		for (Map.Entry<String, LinkedList<ChoiceData>> entry  : choices.entrySet()) {
			System.out.println("---> entry.getKey(): "+entry.getKey());
			//System.out.println("---> entry.getValue().get(1): "+entry.getValue().get(1));
			for (int i = 0; i < entry.getValue().size(); i++) {
				System.out.println("---> Guard["+i+"]: entry.getValue().get("+i+"): "+entry.getValue().get(i).allDataToString());
			}
		}
		//-------
		System.out.println("=======================[TableData]==========================");
		for (Map.Entry<String, List<TableDataMember>> entry  : listTableData.entrySet()) {
			System.out.println("---> entry.getKey(): "+entry.getKey());
			//System.out.println("---> entry.getValue().get(1): "+entry.getValue().get(1));
			for (int i = 0; i < entry.getValue().size(); i++) {
				System.out.println("---> TableData["+i+"]: entry.getValue().get("+i+"): "+entry.getValue().get(i).allDataToString());

			}
		}
		//-------
		System.out.println("=======================[CapsuleConn]==========================");
		for (int i = 0; i<listCapsuleConn.size(); i++) {
			System.out.println("["+i+"]:" +listCapsuleConn.get(i).allDataToString());
		}
	}
	
	//==================================================================	
	//==============================================[elementsExtractor]
	//==================================================================	
	public void elementsExtractor() {
		HashMap<String, StateMachine> smMap = new HashMap<String, StateMachine>();
		String capsuleName = "";
		String capsuleInstanceName = "";
		List <String> listCapsuleName_InstanceName = new ArrayList<String>();
		String connectorName = "";
		String portName = "";
		String protocolName = "";
		String connEnd1PortName = "";
		String connEnd2PortName = "";
	
		int i=0;
		do {
			PackageableElement elementTmp = modelElements.get(i);
			System.out.println(">>>>>>>>>>>>> elementTmp: "+ elementTmp.getName());
			

			if ((elementTmp.getName() != null) && (elementTmp.getName().contentEquals(topCapsuleName))) {
				System.out.println("--------------> [Found!] TopModelElement: "+ topCapsuleName);
				
				listCapsuleName_InstanceName.add(topCapsuleName+"::"+"Top"); //TODO: top capusle must be named "Top"
		        HashMap<String, Property> mapNameParts = new HashMap<>(); 

				//List<Property> listPart = new ArrayList<Property>();
				//------------
				System.out.println(">>>>>>>>>>>>> capInstanceName: "+ elementTmp.getName());
				System.out.println(">>>>>>>>>>>>> capInstanceName: "+ elementTmp.getName());



				UmlrtUtils.getCapsulePartsRecursive(((Class) elementTmp), elementTmp.getName(), mapNameParts, listPortName_connectorName_PortName);

				//------------
				
				//listPart = ((Class) elementTmp).getParts();

				Iterator it = mapNameParts.entrySet().iterator();
			    while (it.hasNext()) {
			    	String capInstanceName ="";
			    	String capName ="";
			        Map.Entry pair = (Map.Entry)it.next();
			        String key = pair.getKey().toString();
			        
			        if (key.contains("_")) {
						int lastIndexOf_ = key.lastIndexOf("__");
						capName = key.substring(0, lastIndexOf_);
						String tmpCapInstanceName = key.substring(lastIndexOf_+2);
						
						lastIndexOf_ = capName.lastIndexOf("__");
						capInstanceName = key.substring(0,lastIndexOf_+2)+tmpCapInstanceName;
						listCapsuleName_InstanceName.add(capName+"::"+capInstanceName);
					}		    	        
			        it.remove(); // avoids a ConcurrentModificationException
			    }
				
				//extract connectors
				for (Connector connector : UmlrtUtils.getConnectors((Class)elementTmp)) {

					connectorName = connector.getName();
					ConnectorEnd connEnd1 = connector.getEnds().get(0);
					ConnectorEnd connEnd2 = connector.getEnds().get(1);
					String partWithPort1 = "";
					String partWithPort2 = "";

					if (connEnd1 != null && connEnd1.getRole() instanceof Port) {
						connEnd1PortName = connEnd1.getRole().getName();
						partWithPort1 = connEnd1.getPartWithPort().getName();

					}
					if (connEnd2 != null && connEnd2.getRole() instanceof Port) {
						connEnd2PortName = connEnd2.getRole().getName();
						partWithPort2 = connEnd2.getPartWithPort().getName();
					}
					listPortName_connectorName_PortName.add(partWithPort1+"__"+connEnd1PortName+"::"+connectorName+"::"+partWithPort2+"__"+connEnd2PortName);
					//break;
				}
			}
			i++;
		}while(i < modelElements.size());
		//System.out.println(">>>>>>>>>>>>> listPortName_connectorName_PortName: "+ listPortName_connectorName_PortName);

		i=0;
		List<StateMachine> stateMachines = new ArrayList<StateMachine>();
		while(i < modelElements.size()) {
			PackageableElement element = modelElements.get(i);
			this.elementInstanceName = "";
			this.elementName = "";
			//System.out.println("--------------> modelElement: "+ element )

			if(element instanceof Class) {

				//Get capsule connector
				CapsuleConn capsuleConn = new CapsuleConn();
				capsuleName = element.getName();
				capsuleInstanceName = "";
				String tmpStr = "";
				String tmpCapsuleName = "";
				
				for (int k = 0; k<listCapsuleName_InstanceName.size();k++) {
					String [] splitCapsuleName_InstanceName = listCapsuleName_InstanceName.get(k).split("::");
					int firstIndexOf_ = splitCapsuleName_InstanceName[0].indexOf("__");
					int lastIndexOf_ = splitCapsuleName_InstanceName[0].lastIndexOf("__");
					if (lastIndexOf_ > 0)
						tmpCapsuleName = splitCapsuleName_InstanceName[0].substring(lastIndexOf_+2);
					else //it is Top capsule
						tmpCapsuleName = this.topCapsuleName;
					if (firstIndexOf_ > 0)
						tmpStr = splitCapsuleName_InstanceName[0].substring(firstIndexOf_+2);
					
					if (tmpCapsuleName.contentEquals(capsuleName)) {
						this.elementName = capsuleName;
						if (this.elementInstanceName != "")
							this.elementInstanceName = this.elementInstanceName + ", " +splitCapsuleName_InstanceName[1];
						else
							this.elementInstanceName = splitCapsuleName_InstanceName[1];

						if (capsuleInstanceName == "") {
							capsuleInstanceName = splitCapsuleName_InstanceName[1];
							if (capsuleInstanceName.contentEquals("Top")) //Top dosen't have any instance 
								break;
						} else
							capsuleInstanceName = capsuleInstanceName + ", "+ splitCapsuleName_InstanceName[1];
						//break;
					}
					
				}
				if (capsuleInstanceName == "")
					capsuleInstanceName = "__NOT_FOUND__";

				capsuleConn.setCapsuleName(capsuleName);
				capsuleConn.setCapsuleInstanceName(capsuleInstanceName);
				listCapsuleConn.add(capsuleConn);

				for (Port port : UmlrtUtils.getPorts((Class)element)) {
					
					
					
					portName = port.getName();
					if (port.getType() != null){
						protocolName = port.getType().getName();
					}
					if (protocolName != null) {
						for(int t=0; t<listCapsuleConn.size();t++) {

							if (listCapsuleConn.get(t).getCapsuleInstanceName().contentEquals(capsuleInstanceName)) {

								//add port
								//port.isBehavior() added
								//when it is not a Behavior port is means it a Relay port!
								//TODO: SAP/SPP can be checked later
								listCapsuleConn.get(t).addListPortName(portName+"::"+port.isBehavior());

								for (int k = 0; k< listPortName_connectorName_PortName.size(); k++) {
									if (listPortName_connectorName_PortName.get(k).contains(portName)) {
										String tmpPortName_connectorName_PortName =  listPortName_connectorName_PortName.get(k);

										if (UmlrtUtils.isConnected__PortName_connectorName_PortName__TocapsuleInstanceName(listCapsuleConn, tmpPortName_connectorName_PortName, capsuleInstanceName, portName)) {
											listCapsuleConn.get(t).addPortName_connectorName_protocolName(listPortName_connectorName_PortName.get(k)+"::"+protocolName);
											//break;
										}
									}
								}
								//break;
							}
						}
					}
				}

				if ( (((Class) element).getOwnedBehaviors() != null && ((Class) element).getOwnedBehaviors().size() > 0))
					if (((Class) element).getOwnedBehaviors().get(0) instanceof StateMachine) {
						smMap.put(element.getName(), (StateMachine) ((Class) element).getOwnedBehaviors().get(0) );
						
						handleStateMachine((StateMachine) ((Class) element).getOwnedBehaviors().get(0));
					}
			}
			i++;
		}

		// expect root machine to be a one having no machines in a submachineState field.
		//====================================================== [Extract State Machines]			
		//for (StateMachine stateMachine : stateMachines) {
		//smMap.put(stateMachine.getName(), stateMachine);
		//handleStateMachine(stateMachine);
		//}
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
		List<TableDataMember> tableDataMember = new ArrayList<TableDataMember>();
		isInitTr = false;
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
				//boolean isInitialState = UmlrtUtils.isInitialState(state);  // checked in psudoStates 
				deferredList = UmlrtUtils.resolveDeferredEvents(state);
				//boolean isFinalState = UmlrtUtils.isFinalState(state); // checked in psudoStates 
				StateData stateDate = new StateData(this.elementName,this.elementInstanceName, state,sName, entryList, exitList, deferredList, parentName, regionName, false, false); //My Solution
				/*StateData stateData = handleActions(
						new StateData(state,sName, entryList, exitList, deferredList, parentName, regionName, isInitialState, isFinalState), state);*/

				listStateData.add(stateDate);

				// add states via entry/exit reference points
				for (ConnectionPointReference cpr : state.getConnections()) {
					if (cpr.getEntries() != null) {
						for (Pseudostate cp : cpr.getEntries()) {
							StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, cp.getName(), parentName, regionName);
							cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.ENTRY);
							listStateData.add(cpStateData);
						}
					}
					if (cpr.getExits() != null) {
						for (Pseudostate cp : cpr.getExits()) {
							StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, cp.getName(), parentName, regionName);
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
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.CHOICE);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.JUNCTION_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.JUNCTION);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.FORK_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.FORK);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.JOIN_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.JOIN);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.SHALLOW_HISTORY_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.HISTORY_SHALLOW);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.DEEP_HISTORY_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.HISTORY_DEEP);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.INITIAL_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName, true, false);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.INITIAL);
					listStateData.add(cpStateData);
				} else if (state.getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
					StateData cpStateData = new StateData(this.elementName,this.elementInstanceName, state.getName(), parentName, regionName, false, true);
					cpStateData.setPseudoStateKind(UmlrtUtils.PseudoStateKind.EXIT);
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

			List<String> guards = new ArrayList<String>();
			List<String> triggers = new ArrayList<String>();
			Long period = null;
			Integer count = null;
			isInitTr = false;
			String transitonName = transition.getName();
			boolean srcOrTrgPseudostate = false;
			boolean trAdded = false;

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
				srcOrTrgPseudostate = true;
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
					guards = resolveGuard(transition);
					List<String> actions = UmlrtUtils.resolveTransitionActions(transition);
					// we want null guards to be at the end
					if (guards == null) {
						list.addLast(new ChoiceData(transition.getSource().getName(), transition.getTarget().getName(), guards, actions));
					} else {
						list.addFirst(new ChoiceData(transition.getSource().getName(), transition.getTarget().getName(), guards, actions));
					}
				} else if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.JUNCTION_LITERAL) {
					LinkedList<JunctionData> list = junctions.get(transition.getSource().getName());
					if (list == null) {
						list = new LinkedList<JunctionData>();
						junctions.put(transition.getSource().getName(), list);
					}
					guards = resolveGuard(transition);
					List<String> actions = UmlrtUtils.resolveTransitionActions(transition);
					// we want null guards to be at the end
					if (guards == null) {
						list.addLast(new JunctionData<String, String>(transition.getSource().getName(), transition.getTarget().getName(), guards, actions));
					} else {
						list.addFirst(new JunctionData<String, String>(transition.getSource().getName(), transition.getTarget().getName(), guards, actions));
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
				} 
			}
			if (transition.getTarget() instanceof Pseudostate) {
				srcOrTrgPseudostate = true;
				if (((Pseudostate)transition.getTarget()).getKind() == PseudostateKind.JOIN_LITERAL) {
					List<String> list = joins.get(transition.getTarget().getName());
					if (list == null) {
						list = new ArrayList<String>();
						joins.put(transition.getTarget().getName(), list);
					}
					list.add(transition.getSource().getName());
				}
			}

			// go through all triggers and create transition
			// from signals, or transitions from timers

			for (Trigger trigger : transition.getTriggers()) {
				guards = resolveGuard(transition);
				Event event = trigger.getEvent();
				if (event instanceof CallEvent) {
					//System.out.println("--- in Trigger CallEvent");
					triggers = UmlrtUtils.getTriggers(transition);
				}
				/* 
				if (event instanceof SignalEvent) {
					System.out.println("--- in Trigger resolve");
					Signal signal = ((SignalEvent)event).getSignal();
					if (signal != null) {
						// special case for ref point
						if (transition.getTarget() instanceof ConnectionPointReference) {
							EList<Pseudostate> cprentries = ((ConnectionPointReference)transition.getTarget()).getEntries();
							if (cprentries != null && cprentries.size() == 1) {
								listTransitionData.add(new TransitionData(transition.getSource().getName(),
										cprentries.get(0).getName(), triggers, UmlrtUtils.resolveTransitionActions(transition),
										guards, UmlrtUtils.mapUmlTransitionType(transition)));
							}
						} else {
							listTransitionData.add(new TransitionData(transition.getSource().getName(),
									transition.getTarget().getName(), triggers, UmlrtUtils.resolveTransitionActions(transition),
									guards, UmlrtUtils.mapUmlTransitionType(transition)));

						}
					}
				}*/else if (event instanceof TimeEvent) {
					TimeEvent timeEvent = (TimeEvent)event;
					period = getTimePeriod(timeEvent);
					if (period != null) {
						count = null;
						if (timeEvent.isRelative()) {
							count = 1;
						}	
					}
				}
				listTransitionData.add(new TransitionData(this.elementName,this.elementInstanceName,transitonName,transition.getSource(),transition.getSource().getName()
						, transition.getTarget(), transition.getTarget().getName(), triggers, UmlrtUtils.resolveTransitionActions(transition),
						guards, UmlrtUtils.mapUmlTransitionType(transition), period, count, isInitTr));
				trAdded = true;
				break; // all triggers will be got from getTriggers function in umlrtUtils
			}//for

			// create anonymous transition if needed
			if ((shouldCreateAnonymousTransition(transition) || srcOrTrgPseudostate) && !trAdded) {
				
					listTransitionData.add(new TransitionData(this.elementName,this.elementInstanceName,transitonName, transition.getSource(),transition.getSource().getName(),
							transition.getTarget(), transition.getTarget().getName(),triggers, UmlrtUtils.resolveTransitionActions(transition),
							guards, UmlrtUtils.mapUmlTransitionType(transition), period, count, isInitTr));
			}

		}
		//[End]----------------------------------------------------------[Transitions]
		List<TableDataMember> listTableDataMember = tableMaker();
		//elementInstanceName is equal to capsuleInstanceName
		listTableData.put(this.elementInstanceName, listTableDataMember); // Table is made for the given state machine !
	}//[End] Region

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[Functions]
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//---------------[Functions]

	//==================================================================	
	//==============================================[tableMaker]
	//==================================================================	

	private List<TableDataMember> tableMaker() {
		List<TableDataMember> listTableDataMember = new ArrayList<TableDataMember>();
		String trCapName = "";
		for (int i = 0; i<listTransitionData.size(); i++) {
			TableDataMember tableDataMember = new TableDataMember();
			trCapName = listTransitionData.get(i).getCapsuleInstanceName();

			//System.out.println("listTransitionData.get ["+i+"]: " + trCapName);

			if (((listTransitionData.get(i).getSourceName() != null ) || (listTransitionData.get(i).getIsInit()))  
					&& (!capDone.contains(trCapName))) {

				for (int j = 0; j<listStateData.size(); j++) {
					if (((listTransitionData.get(i).getSourceName() == listStateData.get(j).getStateName()) || 
							((listTransitionData.get(i).getIsInit()) && listStateData.get(j).getCapsuleInstanceName().contains(trCapName))) 
							&& (listStateData.get(j).getCapsuleInstanceName() == trCapName)){tableDataMember.setSource(listStateData.get(j));
							//System.out.println("[SRC] listStateData.get("+j+"): " + listStateData.get(j).allDataToString());
							//System.out.println("listTransitionData.get(i).getTargetName(): " + listTransitionData.get(i).getTargetName());
							break;
					}
				}
				for (int j = 0; j<listStateData.size(); j++) {
					if (((listTransitionData.get(i).getTargetName() == listStateData.get(j).getStateName()) || 
							(listStateData.get(j).isEnd() && listStateData.get(j).getCapsuleInstanceName().contains(trCapName))) 
							&& (listStateData.get(j).getCapsuleInstanceName() == trCapName)){tableDataMember.setTarget(listStateData.get(j) );
							//System.out.println("[TRG] listStateData.get("+j+"): " + listStateData.get(j).allDataToString());
							break;
					}
				}
			}

			if (((tableDataMember.getTarget() != null) && (tableDataMember.getSource() != null))) {
				tableDataMember.setTransition(listTransitionData.get(i));
				//System.out.println(">> listTransitionData.get("+i+").getSourceName(): " + listTransitionData.get(i).getSourceName());
				listTableDataMember.add(tableDataMember);
			}
		}
		capDone= capDone + ", " + trCapName;
		return listTableDataMember;
	}

	//==================================================================	
	//==============================================[resolveGuard]
	//==================================================================
	private List<String> resolveGuard(Transition transition) {
		List<String> guard = new ArrayList<String>();
		for (Constraint c : transition.getOwnedRules()) {
			if (c.getSpecification() instanceof OpaqueExpression) {
				String guardStr = UmlrtUtils.resolveBodyByLanguage("C++", (OpaqueExpression)c.getSpecification());
				//System.out.println("guardStr: "+guardStr);
				guard.add(guardStr);
			}
		}
		return guard;
	}

	//==================================================================	
	//==============================================[getTimePeriod]
	//==================================================================
	private Long getTimePeriod(TimeEvent event) {
		try {
			return Long.valueOf(event.getWhen().getExpr().integerValue());
		} catch (Exception e) {
			return null;
		}
	}

	//==================================================================	
	//==============================================[shouldCreateAnonymousTransition]
	//==================================================================

	private boolean shouldCreateAnonymousTransition(Transition transition) {
		//if ((transition.getSource() instanceof State) && (transition.getTarget() instanceof State)) {
		//return true;
		//}
		if (transition.getSource() instanceof Pseudostate) {
			if (((Pseudostate)transition.getSource()).getKind() == PseudostateKind.INITIAL_LITERAL) {
				isInitTr = true;
				return true;
			}
		}
		if (transition.getTarget() instanceof Pseudostate) {
			if (((Pseudostate)transition.getTarget()).getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
				return true;
			}
		}
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

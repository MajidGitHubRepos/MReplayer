package ca.queensu.cs.umlrtParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.BodyOwner;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.springframework.statemachine.transition.TransitionKind;
import org.springframework.util.StringUtils;

import ca.queensu.cs.controller.Controller;


public class UmlrtUtils {
	public static String partName = "";
	public static String topCapsuleInstanceName;
	
	public enum PseudoStateKind {

        /** Indicates an initial kind. */
        INITIAL,

        /** End or terminate kind */
        END,

        /** Choice kind */
        CHOICE,

        /** Junction kind */
        JUNCTION,

        /** History deep kind */
        HISTORY_DEEP,

        /** History shallow kind */
        HISTORY_SHALLOW,

        /** Fork kind */
        FORK,

        /** Join kind */
        JOIN,

        /** Entrypoint kind */
        ENTRY,

        /** Exitpoint kind */
        EXIT
	}
	
	//==================================================================	
	//==============================================[getResource]
	//==================================================================	
	public static XMIResource getResource(String modelPath) {
		File inputModelFile = new File(modelPath);
	   	File mainDir = new File(inputModelFile.getParent());
	   	
		// Read modeul file
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		XMIResource mainResource = (XMIResource) resourceSet.getResource(URI.createURI(inputModelFile.getAbsolutePath()), true);		
	    EcoreUtil.resolveAll(mainResource);
	    return mainResource;
	}
	
	//==================================================================	
	//==============================================[resolveBodyByLanguage]
	//==================================================================
	public static String resolveBodyByLanguage(String language, BodyOwner owner) {
		try {
			return owner.getBodies().get(owner.getLanguages().indexOf(language)).trim();
		} catch (Exception e) {
			return null;
		}
	}
	
	//==================================================================	
	//==============================================[resolveTransitionAction]
	//==================================================================
	public static String resolveTransitionAction(Transition transition) {
		String transitionAction = "";
		if (transition.getEffect() instanceof OpaqueBehavior) {
			transitionAction = resolveBodyByLanguage("C++", (OpaqueBehavior)transition.getEffect());
		}
		return transitionAction;
	}
	
	//==================================================================	
	//==============================================[resolveInitialTransition]
	//==================================================================
	public static Transition resolveInitialTransition(State state) {
		for (Transition t : state.getIncomings()) {
			if (t.getSource() instanceof Pseudostate) {
				if (((Pseudostate)t.getSource()).getKind() == PseudostateKind.INITIAL_LITERAL) {
					return t;
				}
			}
		}
		return null;
	}
	
	//==================================================================	
	//==============================================[isInitialState]
	//==================================================================
	public static boolean isInitialState(State state) {
		return resolveInitialTransition(state) != null;
	}
	
	//==================================================================	
	//==============================================[isFinalState]
	//==================================================================
	public static boolean isFinalState(State state) {
		return state instanceof FinalState;
	}
	
	//==================================================================	
	//==============================================[resolveDererredEvents]
	//==================================================================
	public static List<String> resolveDeferredEvents(State state) {
		ArrayList<String> events = new ArrayList<String>();
		for (Trigger trigger : state.getDeferrableTriggers()) {
			Event event = trigger.getEvent();
			if (event instanceof SignalEvent) {
				Signal signal = ((SignalEvent)event).getSignal();
				events.add(signal.getName());
			}
		}
		return events;
	}

	//==================================================================	
	//==============================================[actionCodeProcessing]
	//==================================================================	
	public static List<String> actionCodeProcessing(String actionCode) {
		List<String> list = new ArrayList();
		
		String[] lines = actionCode.split(System.getProperty("line.separator"));
		
		// iterating over an array 
        for (int i = 0; i < lines.length; i++) { 
            String line = lines[i];
            if (line.contains(".send(")) {
            	String[] tokens = line.split("\\s+");
            	for (String token : tokens) {
            		if (token.contains(".send(")) {
            			list.add(token);
            		}else if (token.contains(".sendAt(")) {
            			list.add(token);
            		} 
                }
            }else if (line.contains(".sendAt(")) {
            	String[] tokens = line.split("\\s+");
            	for (String token : tokens) {
            		if (token.contains(".send(")) {
            			list.add(token);
            		}else if (token.contains(".sendAt(")) {
            			list.add(token);
            		} 
                }
            }
        }
        
        //for (int j=0; j<list.size();j++)
        //	System.out.println("["+j+"]:"+list.get(j));
		return list;
	}
	
	//==================================================================	
	//==============================================[resolveTransitionActions]
	//==================================================================	
	public static List<String> resolveTransitionActions(Transition transition) {
		List<String> actions = new ArrayList<String>();
		List<String> tmpActions = new ArrayList<String>();
		String action = resolveTransitionAction(transition);
		if (action != null) {
			tmpActions = actionCodeProcessing(action);
			for (int i = 0; i< tmpActions.size(); i++)
				actions.add(tmpActions.get(i));
		}
		return actions;
	}
	
	//==================================================================	
	//==============================================[mapUmlTransitionType]
	//==================================================================		
	public static TransitionKind mapUmlTransitionType(Transition transition) {
		org.eclipse.uml2.uml.TransitionKind kind = transition.getKind();
		if (kind == org.eclipse.uml2.uml.TransitionKind.LOCAL_LITERAL) {
			return TransitionKind.LOCAL;
		} else if (kind == org.eclipse.uml2.uml.TransitionKind.INTERNAL_LITERAL) {
			return TransitionKind.INTERNAL;
		} else {
			return TransitionKind.EXTERNAL;
		}
	}
	
	//==================================================================	
	//==============================================[getTriggers]
	//==================================================================		
	public static List<String> getTriggers(Transition t) {
		List<String> triggers = new ArrayList<String>();
		for (Trigger trig : t.getTriggers()) {
			if (trig.getPorts() != null && trig.getPorts().size() > 0) {
				String port = trig.getPorts().get(0).getName();
				//System.out.println("---> trig.getPorts().get(0).getName():"+ port);
				//System.out.println("---> ((CallEvent) trig.getEvent()):"+ ((CallEvent) trig.getEvent()));
				String msg = "";
				if (((CallEvent) trig.getEvent()).getOperation() != null) {
					msg = ((CallEvent) trig.getEvent()).getOperation().getName();
					triggers.add(String.format("%s.%s", port, msg));
				}else {
					//TODO: We should handle time events properly!
					CallEvent timeEvent = (CallEvent) trig.getEvent();
					triggers.add(String.format("%s.%s", "__TIMER__", "__TIME__"));
					//period = getTimePeriod(timeEvent);
				}

				// Object e3 = triggers.get(0).getEvent();
				// List<Element> elems = triggers.get(0).getEvent().eGet(Operation.class);

			}
		}
		return triggers;
	}

	//==================================================================	
	//==============================================[getPorts]
	//==================================================================	
	public static EList<Port> getPorts(Class capsule) {
		return capsule.getOwnedPorts();
	}
	
	//==================================================================	
	//==============================================[getConnectors]
	//==================================================================	
	public static EList<Connector> getConnectors(Class capsule) {
		return capsule.getOwnedConnectors();
	}
	
	//==================================================================	
	//==============================================[getConnectorEnds]
	//==================================================================	
	public static List<ConnectorEnd> getConnectorEnds(Class containerCapsule) {

		List<ConnectorEnd> connectorEnds = new ArrayList<ConnectorEnd>();
		for (Connector con : containerCapsule.getOwnedConnectors()) {
			ConnectorEnd end1 = con.getEnds().get(0);
			ConnectorEnd end2 = con.getEnds().get(1);
			connectorEnds.add(end1);
			connectorEnds.add(end2);
		}
		return connectorEnds;
	}
	
	//==================================================================	
	//==============================================[getTopCapsuleName]
	//==================================================================	
	
	public static String getTopCapsuleName(Element root) {
        String retVal = null;

        EAnnotation anno = root.getEAnnotation("UMLRT_Default_top");

        if (anno != null) {
                retVal = anno.getDetails().get("top_name");

        }

        return retVal != null ? retVal : "Top";
	}

	//==================================================================	
	//==============================================[foundPortName_connectorName_PortName]
	//==================================================================	
			
		public static boolean isConnected__PortName_connectorName_PortName__TocapsuleInstanceName(List<CapsuleConn> listCapsuleConn, String portName_connectorName_PortName , String capsuleInstanceName, String portName){
			
			String[] splitPortName_connectorName_PortName = portName_connectorName_PortName.split("\\::");
			String[] splitCapsuleInstanceName = capsuleInstanceName.split("\\,");
			
			for (int i = 0 ; i< splitCapsuleInstanceName.length; i++) {
				String CapsuleInstanceName__portName = splitCapsuleInstanceName[i]+"__"+portName;
				for (int j = 0 ; j< splitPortName_connectorName_PortName.length; j++) {
					if (CapsuleInstanceName__portName.contains(splitPortName_connectorName_PortName[j]))
						return true;
				}
				
			}
				
			return false;
		}
	
		//==================================================================	
		//==============================================[getCapsulePartsRecursive]
		//==================================================================	
		public static void getCapsulePartsRecursive(Class capsule, String prvInstanceName, HashMap<String, Property> mapNameParts,  List<String> listPortName_connectorName_PortName) {
			if (capsule == null)
				return;
			//			List<Property> tmpParts = new ArrayList<Property>();
			
		
			
			for (Property part : capsule.getParts()) {
				// TODO: why getAppliedStereotypes is always empty! [https://www.eclipse.org/forums/index.php/t/953534/]
				// for (Stereotype s : part.getAppliedStereotypes()) 
				// if (s.getName().equals("CapsulePart")){
				if (part.getType() instanceof Class) {
					
					if (partName != "") {
						partName = partName + "__" + part.getType().getName()+ "__" +part.getName();
				}else {
					topCapsuleInstanceName = prvInstanceName;
					partName=topCapsuleInstanceName+"__"+part.getType().getName()+ "__" +part.getName();
				}
					mapNameParts.put(partName, part);
					String tmpStr = "";
					
					int lastIndexOf_ = partName.lastIndexOf("__");
					tmpStr = partName.substring(0,lastIndexOf_);
					lastIndexOf_ = tmpStr.lastIndexOf("__");
					String capName = tmpStr.substring(lastIndexOf_+2);
					
					for(int i=0;i < ParserEngine.getModelElements().size();i++) {
						PackageableElement element = ParserEngine.getModelElements().get(i);
						if((element instanceof Class) && (capName.contains(element.getName()))) {
							//extract connectors
							for (Connector connector : UmlrtUtils.getConnectors((Class)element)) {  // Not for top 
								String connectorName = "";
								String portName = "";
								String protocolName = "";
								String connEnd1PortName = "";
								String connEnd2PortName = "";
								String partWithPort1 = "";
								String partWithPort2 = "";
								

								connectorName = connector.getName();
								ConnectorEnd connEnd1 = connector.getEnds().get(0);
								ConnectorEnd connEnd2 = connector.getEnds().get(1);

								if (connEnd1 != null && connEnd1.getRole() instanceof Port) {
									connEnd1PortName = connEnd1.getRole().getName();
									if (connEnd1.getPartWithPort() != null)
										partWithPort1 = connEnd1.getPartWithPort().getName();
									else
										partWithPort1 = getUpperCapsuleInstanceName(partName);
								}
								
								if (connEnd2 != null && connEnd2.getRole() instanceof Port) {
									connEnd2PortName = connEnd2.getRole().getName();
									if (connEnd2.getPartWithPort() != null)
										partWithPort2 = connEnd2.getPartWithPort().getName();
									else
										partWithPort2 = getUpperCapsuleInstanceName(partName);
								}
								String tmpPortName_connectorName_PortName = partWithPort1+"__"+connEnd1PortName+"::"+connectorName+"::"+partWithPort2+"__"+connEnd2PortName;
								if (!existsInListPortName_connectorName_PortName(listPortName_connectorName_PortName, tmpPortName_connectorName_PortName))
									listPortName_connectorName_PortName.add(tmpPortName_connectorName_PortName);
								//break;
							}
						}
					}
					
					
					//parts.add(part);
					getCapsulePartsRecursive((Class) part.getType(),part.getName(), mapNameParts, listPortName_connectorName_PortName);
					if (partName.contains("_")) {
						lastIndexOf_ = partName.lastIndexOf("__");
						tmpStr = partName.substring(0, lastIndexOf_);
						lastIndexOf_ = tmpStr.lastIndexOf("__");
						partName = tmpStr.substring(0, lastIndexOf_);
					}
				}
				// }
			}
		}
	
		//==================================================================	
		//==============================================[lookingForTargetPort]
		//==================================================================			
		public static String lookingForTargetPort(List<CapsuleConn> listCapsuleConn, String srcPort, String trgPort) {
			for (int i = 0; i< listCapsuleConn.size(); i++) {
				List<String> listCapsulePortName = listCapsuleConn.get(i).getListPortName(); //TODO: when more than one relay port is required should be checked 
				List<String> listCapsulePortConn = listCapsuleConn.get(i).getListPortName_connectorName_PortName_protocolName();
				
				for (int j = 0; j< listCapsulePortConn.size(); j++) {
					
					String [] spiltCapsulePortConn = listCapsulePortConn.get(j).split("\\::");
					if (spiltCapsulePortConn[0].contentEquals(trgPort)) {
						//TODO: should be checked whether this port is relay or not
						//Only one relay port is supported for now!
						if (!spiltCapsulePortConn[2].contentEquals(srcPort))
							return spiltCapsulePortConn[2];
					}
					if (spiltCapsulePortConn[2].contentEquals(trgPort)) {
						//TODO: should be checked whether this port is relay or not
						//Only one relay port is supported for now!
						if (!spiltCapsulePortConn[0].contentEquals(srcPort))
							return spiltCapsulePortConn[0];
					}
				}
			}

			return "__NOT_FOUND__";
		}
		
		//==================================================================	
		//==============================================[isRelayPort]
		//==================================================================			
		public static boolean isRelayPort(List<CapsuleConn> listCapsulePortConn, String port) {
			
			for (int i = 0; i< listCapsulePortConn.size();i++) {
				List<String> listCapsulePortName = listCapsulePortConn.get(i).getListPortName();
				for (int j = 0; j< listCapsulePortName.size();j++) {
					String [] spiltCapsulePortName = listCapsulePortName.get(j).split("\\::");
					if (port.contains(spiltCapsulePortName[0])) {
						if (spiltCapsulePortName[1].contentEquals("true")) //isBehavior
							return false;
						else
							return true; //it is a Relay port
					}
				}
			}
			System.err.println("==================[The port is not match!]======================");
			return false;
			
		}
		//==================================================================	
		//==============================================[existsInListPortName_connectorName_PortName]
		//==================================================================			
		public static boolean existsInListPortName_connectorName_PortName(List<String> listPortName_connectorName_PortName, String tmpPortName_connectorName_PortName){
			for (int i = 0; i<listPortName_connectorName_PortName.size(); i++) {
				
				if(listPortName_connectorName_PortName.get(i).contentEquals(tmpPortName_connectorName_PortName))
					return true;
			}
			
			return false;
		}

		//==================================================================	
		//==============================================[getUpperCapsuleInstanceName]
		//==================================================================			
		public static String getUpperCapsuleInstanceName(String partName){
			// extracting upperCapsuleInstanceName for relay ports when getPartWithPort() returns null

			String tmpStr = "";
			String upperCapsuleInstanceName = "__NOT_FOUND__";
			int lastIndexOf_ = 0;
			if (countOccurences(partName,"__")>2) {
				//example: Top_C0_c0_C01_c01    =>  c0
				lastIndexOf_ = partName.lastIndexOf("__");
				tmpStr = partName.substring(0, lastIndexOf_);
				lastIndexOf_ = tmpStr.lastIndexOf("__");
				tmpStr = tmpStr.substring(0, lastIndexOf_);
				lastIndexOf_ = tmpStr.lastIndexOf("__");
				upperCapsuleInstanceName = tmpStr.substring(lastIndexOf_+2);

			} else {
				//example: Top_C0_c0    =>  c0
				lastIndexOf_ = partName.lastIndexOf("__");
				upperCapsuleInstanceName = partName.substring(lastIndexOf_+2);
			}
			return upperCapsuleInstanceName;
		}
		//==================================================================	
		//==============================================[countOccurences]
		//==================================================================			

		static int countOccurences(String string, String substring)  
		{ 
			// split the string by spaces in a 
			int count = 0;
		     int idx = 0;

		     while ((idx = string.indexOf(substring, idx)) != -1)
		     {
		        idx++;
		        count++;
		     }

		     return count;
		} 
		
}

package ca.queensu.cs.umlrtParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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

public class UmlrtUtils {
	
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
				String msg = ((CallEvent) trig.getEvent()).getOperation().getName();
				// Object e3 = triggers.get(0).getEvent();
				// List<Element> elems = triggers.get(0).getEvent().eGet(Operation.class);
				triggers.add(String.format("%s.%s", port, msg));
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
			
		public static boolean foundPortName_connectorName_PortName(List<CapsuleConn> listCapsuleConn, String PortName_connectorName_PortName , String capsuleName){
			
			for (int i = 0 ; i< listCapsuleConn.size(); i++) {
				
				String tmp = listCapsuleConn.get(i).allDataToString();
				if ((tmp.contains(PortName_connectorName_PortName) && (listCapsuleConn.get(i).getCapsuleInstanceName().contentEquals(capsuleName)))) {
					return true;
				}
			}
			
			return false;
		}
	
	//==================================================================	
	//==============================================[getCapsulePartsRecursive]
	//==================================================================	
		public static void getCapsulePartsRecursive(Class capsule, List<Property> parts) {
			if (capsule == null)
				return;
//			List<Property> tmpParts = new ArrayList<Property>();
			for (Property part : capsule.getParts())
				for (Stereotype s : part.getAppliedStereotypes())
					if (s.getName().equals("CapsulePart")){
						parts.add(part);
						getCapsulePartsRecursive((Class) part.getType(), parts);
					}
//			parts.addAll(tmpParts);
//			for (Property part : tmpParts)
//				getCapsulePartsRecursive((Class) part.getType(), parts);

//			return parts;
		}

}

package ca.queensu.cs.umlrt;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.OpaqueBehavior;


public class UmlrtParser {
	
	
	   
	   public static void main(String args[]) {
		   
		   UmlrtElements umlrtElements = new UmlrtElements();
		   
		   
		/*	
			//---------------------------------------------------------------------------
			
			
			File inputModelFile = new File("/home/babaei/Downloads/MDebugger/lastUpdate/MDebugger-master/Samples/PingPong/PingPong.uml");

			// Read modeul file
			ResourceSet resourceSet = new ResourceSetImpl();
			UMLResourcesUtil.init(resourceSet);
			XMIResource mainResource = (XMIResource) resourceSet.getResource(URI.createURI(inputModelFile.getAbsolutePath()), true);		
			EcoreUtil.resolveAll(mainResource);

			// Get and iterate over content
			TreeIterator<EObject> objects = EcoreUtil.getAllContents(mainResource, true);
			while(objects.hasNext())
			{
			    EObject object = objects.next();
			    String id = mainResource.getID(object);
			    System.out.println("******* id is: " +id);
			    System.out.println("******* object is: " +object);
		//==================================================== [Extract State Machines]
			    if(object instanceof StateMachine)
			    {
			        //System.out.println("Object "+((StateMachine) object).getName()+" is a state machine!");
		//==================================================== [Extract Members (states, transitions) in State Machine]
			        List<NamedElement> members = ((StateMachine) object).getRegions().get(0).getOwnedMembers();
			        //System.out.println("******* list is: " +members);
			        for(NamedElement member:members)
					{
			        	//System.out.println("******* member is: " +member);
		//==================================================== [Extract States in State Machine]
						if (member instanceof State) {
							//System.out.println("******* StateName is: " +member.getName());
							//System.out.println("******* State getOwnedElements is: " +member.getOwnedElements());
							
						
		//==================================================== [Extract stateInfo in State]
							List<Element> stateInfo =   member.getOwnedElements();
							for(Element info:stateInfo)
							{
		//==================================================== [Extract OpaqueBehavior in StateInfo]
								if (info instanceof OpaqueBehavior) {
									//System.out.println("******* info [OpaqueBehavior] is: " +info);
									 if (((OpaqueBehavior) info).isSetLanguages()) {
						                    int bodyIndex = 0;
						                    for (String targetLanguage : ((OpaqueBehavior) info).getLanguages()) {
						                        if ("C++".equals(targetLanguage)) {
						                        	System.out.println("******* Body : "+((OpaqueBehavior) info).getBodies().get(bodyIndex));
						                        }
						                    }
									 }
								}
								
							}
							
						}
					}

			   		//for(Class capsule: capsules)
			   		//{
			   		//	System.out.println("******* Capsule name is: " +capsule.getName());
			   		//}
			        
			        
			        List<Transition> transitions = ((StateMachine) object).getRegions().get(0).getTransitions();
			        for (Transition tr: transitions){
		 				System.out.println("------------------- transition name is: " +tr.getName());
		 			}
			        
			        
			        
			        
			    }
			}
		   
		   */
		   
		   	File inputModelFile = new File("/home/majid/workspace/PingPong.bk/PingPong.uml");
		   	File mainDir = new File(inputModelFile.getParent());
		   	
			// Read modeul file
			ResourceSet resourceSet = new ResourceSetImpl();
			UMLResourcesUtil.init(resourceSet);
			XMIResource mainResource = (XMIResource) resourceSet.getResource(URI.createURI(inputModelFile.getAbsolutePath()), true);		
		    EcoreUtil.resolveAll(mainResource);

		    Model inputModel = (Model) EcoreUtil.getObjectByType(mainResource.getContents(), UMLPackage.Literals.MODEL);

		    List<XMIResource> allResources = new LinkedList<XMIResource>();
		    allResources.add(mainResource);

		    EList<PackageableElement> modelElements = inputModel.getPackagedElements();	
		    //List<PackageableElement> movedElements = new ArrayList<PackageableElement>();
		    
		    System.out.println("--------------> modelElements.size(): "+ modelElements.size() );
		    umlrtElements.elementsExtraction(modelElements);
		    
	   }
	  
	   

	}
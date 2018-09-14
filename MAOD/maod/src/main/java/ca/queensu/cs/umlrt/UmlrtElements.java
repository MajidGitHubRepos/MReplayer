package ca.queensu.cs.umlrt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StateMachine;

public class UmlrtElements {
	
	 public void elementsExtraction(EList<PackageableElement> modelElements) {
		   
		    int i=0;
			List<StateMachine> stateMachines = new ArrayList<StateMachine>();
	        while(i < modelElements.size()) {
	            PackageableElement element = modelElements.get(i);
	            System.out.println("--------------> modelElement: "+ element );
	            	
	            if(element instanceof Class) {
	            	if ( (((Class) element).getOwnedBehaviors() != null && ((Class) element).getOwnedBehaviors().size() > 0))
	            		//Behavior b = ((Class) element).getOwnedBehaviors().get(0);
	            		if (((Class) element).getOwnedBehaviors().get(0) instanceof StateMachine)
	            			stateMachines.add((StateMachine) ((Class) element).getOwnedBehaviors().get(0));	
				}
	           		//System.out.println( "------------> element.getName(): " + element.getName());
	           		//System.out.println( "------------> element: " + element);
	           		
	                i++;
	        }
	        
			// expect root machine to be a one having no machines in a submachineState field.
//========================================================================================================== [Extract State Machines]			
			for (StateMachine stateMachine : stateMachines) {
				System.out.println("=================> machine: " + stateMachine);
			}
			
			
			
			// Get and iterate over content
//			TreeIterator<EObject> objects = EcoreUtil.getAllContents(mainResource, true);
//			while(objects.hasNext())
//			{
//			    EObject object = objects.next();
//			    
//			    if (object instanceof Transition){
//			    String id = mainResource.getID(object);
//			    System.out.println("******* id is: " +id);
//			    System.out.println("******* object is: " +object);
//			
//			    }
//			}
		   
		//MedelMapping mp = new MedelMapping();
  //mp.parsingModel(mainResource); 		
		   
	   }
	   

}

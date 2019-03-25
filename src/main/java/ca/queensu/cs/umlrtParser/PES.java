package ca.queensu.cs.umlrtParser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class PES {
	
	
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
			//find the init state
			
			//sb->sb add to the path
			
			//mark transition into/out of sc
			//from which region into witch region
			
			
			
			
		}

}

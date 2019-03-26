package ca.queensu.cs.umlrtParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class PES {
	
		public List<String> listPaths = new ArrayList<String>();
		public static Map<String, List<String>> mapRegionPaths = new HashMap<String, List<String>>();
		//==================================================================	
		//==============================================[pathMaker]
		//==================================================================	
		void pathMaker(String path, String transitionHashCode) {
			String [] transitionData = transitionHashCode.split("\\-");
			List<String> listNxtIds = new ArrayList<String>();
			
			String nxtTransitionID = "";
			//transitionData<StateID_src, transitionID, StateID_trg>
			if (checkStateBasic(transitionData[2])) {
				if (path.contentEquals("") && (!path.contains(transitionData[1])))
					path=transitionData[1];
				else if (!path.contains(transitionData[1]))
					path=path+","+transitionData[1];
					listPaths.add(path);
					listNxtIds = findNxtTransitionIDs(transitionData, path);
					for (String id : listNxtIds) {
						String transitionHashCodeNxt = ParserEngine.mapTransitionData.get(id).getPath();
						pathMaker("",transitionHashCodeNxt);
					}
			}else {
				listNxtIds = findNxtTransitionIDs(transitionData, path);
				
				if (path.contentEquals("") && (!path.contains(transitionData[1])))
					path=transitionData[1];
				else if (!path.contains(transitionData[1]))
					path=path+","+transitionData[1];
				
				for (String id : listNxtIds) {
					path=path+","+id;
					String transitionHashCodeNxt = ParserEngine.mapTransitionData.get(id).getPath();
					pathMaker(path,transitionHashCodeNxt);
				}
			}			
		}
		//==================================================================	
		//==============================================[showElements]
		//==================================================================	
		public void showElements() {
			System.out.println("=======================[listPaths]==========================");
			
			for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
				System.out.println("[KEY]= "+entry.getKey());
				listPaths = entry.getValue();
				for (int i = 0; i<listPaths.size(); i++) {
					System.out.println("["+i+"]:" +listPaths.get(i));
				}
			}
		}
			//-------
		//==================================================================	
		//==============================================[findNxtTransitionID]
		//==================================================================	
		List<String> findNxtTransitionIDs(String [] transitionData, String path) {
			List<String> listNxtIds = new ArrayList<String>();
			/*
			boolean S_trg_ENTRY = false; 
			boolean S_src_EXIT = false; 
			//Entry
			if ( (ParserEngine.mapStateData.get(transitionData[2]).getPseudoStateKind() != null)
					&& ParserEngine.mapStateData.get(transitionData[2]).getPseudoStateKind().toString().contentEquals("ENTRY"))
				S_trg_ENTRY = true;
			//Exit
			if ( (ParserEngine.mapStateData.get(transitionData[0]).getPseudoStateKind() != null)
					&& ParserEngine.mapStateData.get(transitionData[0]).getPseudoStateKind().toString().contentEquals("EXIT"))
				S_src_EXIT = true;
			
			if (S_trg_ENTRY) {
			// change trg
				String nameSpace = ParserEngine.mapStateData.get(transitionData[2]).getPseudostate().getNamespace().getName();
				String nameSpace = ParserEngine.mapStateData.get(transitionData[2]).getPseudostate()
				System.out.println("=======================[nameSpace] "+ nameSpace);

				
			}
			if (S_src_EXIT) {
			//chage src
				
			}
			*/
			for (TransitionData tr :  ParserEngine.listTransitionData){
				String [] pathSplit = tr.getPath().split("\\-");
				if (pathSplit[0].contentEquals(transitionData[2]) && (!path.contains(pathSplit[1]))) {
					listNxtIds.add(pathSplit[1]);
				}
			}
			return listNxtIds;
		}
		
		//==================================================================	
		//==============================================[checkStateBasic]
		//==================================================================	
		boolean checkStateBasic(String stateID) {
			
			StateData stateData = ParserEngine.mapStateData.get(stateID);
			//System.out.println("=======================> [stateID]"+ stateID);
			//System.out.println("=======================> [stateData]"+ stateData.allDataToString());

			if ((stateData.getPseudoStateKind() != null)) { //TODO: Exit is not a basic state
				if (stateData.getPseudoStateKind().toString().contentEquals("EXIT") ||
						stateData.getPseudoStateKind().toString().contentEquals("ENTRY"))
					return true;
				else
					return false;
			}else 	
				return true;
		}
	
		//==================================================================	
		//==============================================[handleStateMachine]
		//==================================================================	
		public void makeMapRegionPaths() {
			for (TransitionData tr :  ParserEngine.listTransitionData){
				String [] pathSplit = tr.getPath().split("\\-");
				if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind() != null) {
					if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind().toString().contentEquals("INITIAL")) {
						listPaths = new ArrayList<String>();
						pathMaker("", tr.getPath());
						mapRegionPaths.put(tr.getCapsuleInstanceName()+"__"+tr.getReginName(), listPaths);
					}
				}
			}
			showElements();
		}

		

}

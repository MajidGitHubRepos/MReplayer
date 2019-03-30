package ca.queensu.cs.umlrtParser;

import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class PES {

	public List<String> listRegionalPaths = new ArrayList<String>();
	public List<String> listModelPaths = new ArrayList<String>();
	public static Map<String, List<String>> mapRegionPaths = new HashMap<String, List<String>>();
	public static Map<String, List<String>> mapModelRegionPaths = new HashMap<String, List<String>>();
	public static Map<String, String> mapQnameId     = new HashMap<String, String>();
	


	//==================================================================	
	//==============================================[pathMaker]
	//==================================================================	
	 public void pathMaker(String transitionHashCode) {
		Stack<String> stack = new Stack<String>();
		String [] transitionData = transitionHashCode.split("\\-");
		List<String> listNxtIds = new ArrayList<String>();
		List<String> listStateMet = new ArrayList<String>();

		String path = "";
		String stateTrgID = transitionData[2];
		String nxtTransitionID = "";
		String transitionHashCodeNxt = "";
		String lastIdInPath = "";
		String state = transitionData[2];
		//transitionData<StateID_src, transitionID, StateID_trg>
		//Make sure no redundant path is in listPath
		stack.push(transitionData[1]);
		
		while (!stack.isEmpty()) {
			
			path = stack.pop();
			
			lastIdInPath = extractLastPathID(path);
			
			transitionHashCodeNxt = ParserEngine.mapTransitionData.get(lastIdInPath).getPath();
			String [] hashCodeNxtSplit = transitionHashCodeNxt.split("\\-");
			
			
			
			//state = hashCodeNxtSplit[2];
			
			if (checkStateBasic(hashCodeNxtSplit[2])) {
				if (!listStateMet.contains(hashCodeNxtSplit[2])) {
				listNxtIds = findNxtTransitionIDs(hashCodeNxtSplit, "");
				for (String id : listNxtIds) {
					if (!stack.contains(id)) {
						//stack.pop();
						stack.push(id);
					}
				}
				}
				if (!listRegionalPaths.contains(path)) {
					listRegionalPaths.add(path);
					listStateMet.add(hashCodeNxtSplit[2]);
				}
				//if (listNxtIds.size() == 0) stack.pop();
			}else {
				if (!listStateMet.contains(hashCodeNxtSplit[2])) {
				listNxtIds = findNxtTransitionIDs(hashCodeNxtSplit, path);
				for (String id : listNxtIds) { 
					if (!stack.contains(path+","+id)) {
						//stack.pop(); 
						stack.push(path+","+id); 
						}
					}
				}
				//if (listNxtIds.size() == 0) stack.pop();
			}
			
			
		}
	}
	
	//==================================================================	
	//==============================================[extractLastPathID]
	//==================================================================	
	public String extractLastPathID(String path) {
		
		if (path.contains(",")) {
			int lastIndex = path.lastIndexOf(",");
			return path.substring(lastIndex+1);
		}else {  
			return path;
		}
	}
	
	//==================================================================	
	//==============================================[extractLastPathID]
	//==================================================================	
	public String extractOwnerRegion(String region) {
			int i = region.lastIndexOf("_");
			int j = region.lastIndexOf("::");
			if (region.contains("::") && i>j) {
				int lastIndex = region.lastIndexOf("_");
				return region.substring(0,lastIndex);
			}else {  
				return null;
			}
		}
	 
	//==================================================================	
	//==============================================[showElements]
	//==================================================================	
	public void showElements() {
		System.out.println("=======================[mapRegionPaths]==========================");

		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey());
			listRegionalPaths = entry.getValue();
			for (int i = 0; i<listRegionalPaths.size(); i++) {
				System.out.println("["+i+"]:" +listRegionalPaths.get(i));
			}
		}
		System.out.println("=======================[MapQNameId]==========================");

		for (Map.Entry<String, String> entry : mapQnameId.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey() + " [VALUE]= "+entry.getValue());
		}
		System.out.println("=======================[mapModelRegionPaths]==========================");

		for (Map.Entry<String, List<String>> entry : mapModelRegionPaths.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey());
			List<String>paths = entry.getValue();
			for (int i = 0; i<paths.size(); i++) {
				System.out.println("["+i+"]:" +paths.get(i));
			}
		}
	}
	//==================================================================	
	//==============================================[findNxtTransitionID]
	//==================================================================	
	List<String> findNxtTransitionIDs(String [] transitionData, String path) {
		List<String> listNxtIds = new ArrayList<String>();
		for (TransitionData tr :  ParserEngine.listTransitionData){
			String [] pathSplit = tr.getPath().split("\\-");
			if (pathSplit[0].contentEquals(transitionData[2]) && 
					(!path.contains(pathSplit[1])) &&	//No redundant path
					(tr.getCapsuleInstanceName().contentEquals(ParserEngine.mapTransitionData.get(transitionData[1]).getCapsuleInstanceName())) && //The same capsule
					(tr.getReginName().contentEquals(ParserEngine.mapTransitionData.get(transitionData[1]).getReginName()))) { //The same region 
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
	//==============================================[makeMapQnameId]
	//==================================================================	
	public void makeMapQnameId() {
		int nullCounter = 1; 
		for (TransitionData tr :  ParserEngine.listTransitionData){
			if (tr.getTransition() != null)
				if (tr.getTransition().getQualifiedName() != null)
					mapQnameId.put(tr.getTransition().getQualifiedName(), tr.getId());
				else
					mapQnameId.put("__NULL__"+nullCounter++,tr.getId());
		}
		for (StateData st :  ParserEngine.listStateData){
			if ((st.getPseudostate() == null) && (st.getState() != null)) {
				if (st.getState().getQualifiedName() != null)
					mapQnameId.put(st.getState().getQualifiedName(), st.getId());
				else
					mapQnameId.put("__NULL__"+nullCounter++,st.getId());
			}else if ((st.getPseudostate() != null) && (st.getState() == null)) {
				if (st.getPseudostate().getQualifiedName() != null)
					mapQnameId.put(st.getPseudostate().getQualifiedName(), st.getId());
				else
					mapQnameId.put("__NULL__"+nullCounter++,st.getId());
			}
		}
	}

	//==================================================================	
	//==============================================[makeMapRegionPaths]
	//==================================================================	
	public void makeMapRegionPaths() {
		makeMapQnameId();
		for (TransitionData tr :  ParserEngine.listTransitionData){
			String [] pathSplit = tr.getPath().split("\\-");
			if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind() != null) {
				if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind().toString().contentEquals("INITIAL")) {
					listRegionalPaths = new ArrayList<String>();
					pathMaker(tr.getPath());
					mapRegionPaths.put(tr.getCapsuleInstanceName()+"::"+tr.getReginName(), listRegionalPaths);
				}
			}
		}
		makeListCompletePaths();
		showElements();
	}

	//==================================================================	
	//==============================================[makeListCompletePaths]
	//==================================================================	
	public void makeListCompletePaths() {
		List<String> _listPath = new ArrayList<String>();
		String lastTr = "";
		String ownerRegion = "";
		String orgPath = "";

		String exitPointId_inner = "";
		String exitPointId_outer = "";

		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			//Find the border transitions
			_listPath = entry.getValue();
			for (int i = 0; i<_listPath.size(); i++) {
				exitPointId_inner = "";
				//get the last trID
				orgPath = _listPath.get(i);
				lastTr = extractLastPathID(_listPath.get(i));
				if(ParserEngine.mapTransitionData.get(lastTr).getTrgId() != null) {
					String in_id = ParserEngine.mapTransitionData.get(lastTr).getTrgId();
//(START)  Tr1->[x]->Tr2 -------------------------------------------------------------------------------------------------------------
					if (ParserEngine.mapStateData.get(in_id).getPseudoStateKind().toString().contentEquals("EXIT")) { 
						exitPointId_inner = ParserEngine.mapTransitionData.get(lastTr).getTrgId();

						exitPointId_outer = "";
						//findTheOwner
						ownerRegion = extractOwnerRegion(entry.getKey());
						System.out.println("ownerRegion: " + ownerRegion);
						if(ownerRegion != null) {
							List<String>ownerPaths = mapRegionPaths.get(ownerRegion);

							List<String> _listTmp = new ArrayList<String>();
							for (String path : ownerPaths) {
								//getFirstTr in ownerPaths
								String [] pathSplit = path.split("\\,");
								if(ParserEngine.mapTransitionData.get(pathSplit[0]).getSrcId() != null) {

									String out_id = ParserEngine.mapTransitionData.get(pathSplit[0]).getSrcId();

									if (ParserEngine.mapStateData.get(out_id).getPseudoStateKind().toString().contentEquals("EXIT"))
										exitPointId_outer = ParserEngine.mapTransitionData.get(pathSplit[0]).getSrcId();

									if(exitPointId_outer.contentEquals(exitPointId_inner)) {
										_listTmp.add(orgPath+","+path);
										listModelPaths.add(orgPath+","+path);
									}
								}
							}
							if(exitPointId_outer.contentEquals(exitPointId_inner)) 
								mapModelRegionPaths.put(entry.getKey(),_listTmp);
						}
					}
//(END)  Tr1->[x]->Tr2 -------------------------------------------------------------------------------------------------------------
				}
			}
		}

	}



}

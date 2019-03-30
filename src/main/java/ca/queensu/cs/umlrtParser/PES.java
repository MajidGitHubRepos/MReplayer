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
	public static List<Map<String, List<String>>> listMapModelRegionPaths =  new ArrayList<Map<String, List<String>>>();
	


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
		updateMapRegionPaths();
		showElements();
	}
	//==================================================================	
	//==============================================[findPathInUpperRegion]
	//==================================================================	
	void findPathInUpperRegion(String region, String id, List<String> listMatchPaths) {
		//List<String> listOutPaths = new ArrayList<String>();
		List<String>ownerPaths = mapRegionPaths.get(region);
		for (String path : ownerPaths) {
			//getFirstTr in ownerPaths
			String [] pathSplit = path.split("\\,");
			String tr_1st = pathSplit[0];
			if((ParserEngine.mapTransitionData.get(tr_1st).getSrcId() != null) && 
					id.contentEquals(ParserEngine.mapTransitionData.get(tr_1st).getSrcId())) {
				    listMatchPaths.add(path);
					if(ParserEngine.mapStateData.get(ParserEngine.mapTransitionData.get(tr_1st).getTrgId()).getPseudoStateKind() != null) {
						//find the upper region
						String upperRegion = extractOwnerRegion(region);
						//find id
						String newId = ParserEngine.mapTransitionData.get(tr_1st).getTrgId();
						if((upperRegion != null) && (newId != null))
						findPathInUpperRegion(upperRegion, newId, listMatchPaths);
					}else
						break;
			}
		}
		
	}

	//==================================================================	
	//==============================================[updateMapRegionPaths]
	//==================================================================	
	public void updateMapRegionPaths() {
		List<String> listCurrentPath = new ArrayList<String>();
		boolean foundStableState = true;
		String lastTr = "";
		String ownerRegion = "";
		String orgPath = "";

		String exitPointId_inner = "";
		String exitPointId_outer = "";
		String entryPointId_inner = "";
		String entryPointId_outer = "";

		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			
			
			String currentRegion = entry.getKey();
			//Find the border transitions
			listCurrentPath = entry.getValue();
			for (int i = 0; i<listCurrentPath.size(); i++) {
				List<String> listMatchPaths = new ArrayList<String>();
				exitPointId_inner = "";
				exitPointId_outer = "";
				entryPointId_inner = "";
				entryPointId_outer = "";
				
				
				//get the last trID
				orgPath = listCurrentPath.get(i);
				lastTr = extractLastPathID(orgPath);
				
				
				//lastTr->[x]  EXIT
				if((ParserEngine.mapTransitionData.get(lastTr).getTrgId() != null) &&
						ParserEngine.mapStateData.get(ParserEngine.mapTransitionData.get(lastTr).getTrgId()).getPseudoStateKind().toString().contentEquals("EXIT"))
					exitPointId_inner = ParserEngine.mapTransitionData.get(lastTr).getTrgId();
				
				//lastTr->[]   ENTRY
				if((ParserEngine.mapTransitionData.get(lastTr).getTrgId() != null) &&
						ParserEngine.mapStateData.get(ParserEngine.mapTransitionData.get(lastTr).getTrgId()).getPseudoStateKind().toString().contentEquals("ENTRY"))
					entryPointId_inner = ParserEngine.mapTransitionData.get(lastTr).getTrgId();
				
				
				if (!entryPointId_inner.isEmpty() || !exitPointId_inner.isEmpty()) {
					foundStableState = false;
				}
					
				while(!foundStableState) {
					//lookfor the follower in the upper Region
					ownerRegion = extractOwnerRegion(currentRegion);
					if(ownerRegion != null) {
						if (!exitPointId_inner.isEmpty()) 
							findPathInUpperRegion(ownerRegion,exitPointId_inner,listMatchPaths);
						else if (!entryPointId_inner.isEmpty())
							findPathInUpperRegion(ownerRegion,entryPointId_inner,listMatchPaths);
					
						if(listMatchPaths.size()>0) {
							for(String newPath : listMatchPaths) {
								orgPath = orgPath+","+newPath;
							}
							listCurrentPath.set(i, orgPath);
							mapModelRegionPaths.put(entry.getKey(),listCurrentPath);
							foundStableState =  true;
						}
						if (listMatchPaths.size()==0)
							foundStableState =  true;
					
					}else {
						foundStableState =  true;
					}
						
					if (foundStableState) {
						break;
					}
					
				}
					
			}
		}

	}



}

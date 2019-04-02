package ca.queensu.cs.umlrtParser;

import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.springframework.util.StringUtils;

public class PES {

	public List<String> listRegionalPaths = new ArrayList<String>();
	public List<String> listModelPaths = new ArrayList<String>();
	public static Map<String, List<String>> mapRegionPaths = new HashMap<String, List<String>>();
	public static Map<String, List<String>> mapModelRegionPaths = new HashMap<String, List<String>>();
	public static Map<String, String> mapQnameId     = new HashMap<String, String>();
	public static Map<String, String> mapIdQname     = new HashMap<String, String>();
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
	//==============================================[countPathInMapRegionPaths]
	//==================================================================	
	public int countPathInMapRegionPaths(String path) {
		int count = 0;
		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			
			for(String str : entry.getValue()) {
				if(str.contains(path)) {
					String [] strSplit = str.split("\\,");
					if (!ParserEngine.mapTransitionData.get(strSplit[strSplit.length-1]).getIsInit()) //path ends at initTr
						count++;
				}
			}
		}
		//System.out.println("=======================path[count]: "+path+"["+count+"]");
		return count;
	}

	//==================================================================	
	//==============================================[removeShortPaths]
	//==================================================================	
	public void removeShortPaths() {
		List<String> listLocalPaths = new ArrayList<String>();

		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			List<String> listNewPaths = new ArrayList<String>();			
			listLocalPaths = entry.getValue();
			for(String p : listLocalPaths) {

				if ((countPathInMapRegionPaths(p)<=1) || 
						(ParserEngine.mapTransitionData.get(p)!=null && ParserEngine.mapTransitionData.get(p).getIsInit()))
					listNewPaths.add(p);
			}
			mapRegionPaths.put(entry.getKey(), listNewPaths);
		}
	} 

	//==================================================================	
	//==============================================[removeDuplicates]
	//==================================================================	
	public void removeDuplicates() {
		Set<String> set = new LinkedHashSet<>(); 
		 
		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			set.addAll(entry.getValue());
			entry.getValue().clear();
			entry.getValue().addAll(set);
			set.clear();
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
	//==============================================[extractUpperRegion]
	//==================================================================	
	public String extractUpperRegion(String region) {
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
	//==============================================[extractLowerRegion]
	//==================================================================	
	public String extractLowerRegion(String id) {
		String lowerRegion = "";
		String instanceName = "";

		String stateName = ParserEngine.mapStateData.get(id).getPseudostate().getNamespace().getName();
		String nameSpace = "";

		for (StateData sd :  ParserEngine.listStateData){
			if((sd.getStateName()!=null) && (sd.getStateName().contentEquals(stateName))) {
				nameSpace = sd.getState().getQualifiedName()+"::";
				break;
			}
		}

		if ( (nameSpace != null) && (stateName != null)) {
			for (StateData sd :  ParserEngine.listStateData){

				if((sd.getState()!=null) && (sd.getState().getQualifiedName().contains(nameSpace))) {
					instanceName = sd.getCapsuleInstanceName();
					String [] qNameSplit = sd.getState().getQualifiedName().split("\\::");

					for (String str : qNameSplit) {

						if(str.contains("Region")) {
							if (lowerRegion.isEmpty())
								lowerRegion = str;
							else
								lowerRegion = lowerRegion + "_" +str;

						}
					}
					break;
				}
			}
			return instanceName+"::"+lowerRegion; 
		}
		return "";
	}
	//==================================================================	
	//==============================================[showElements]
	//==================================================================	
	public void showElements() {
		System.out.println("=======================[mapRegionPaths]==========================");
		String pathCurr = "";
		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey());
			listRegionalPaths = entry.getValue();
			for (int i = 0; i<listRegionalPaths.size(); i++) {
				
				if(listRegionalPaths.get(i).contains(",")) {
					String [] pathsSplit = listRegionalPaths.get(i).split("\\,");
					pathCurr = "";
					for (String str : pathsSplit) {
						if (pathCurr.isEmpty())
							pathCurr = mapIdQname.get(str);
						else	
						pathCurr = pathCurr+ "-->" + mapIdQname.get(str);
					}
				}else {
					pathCurr = mapIdQname.get(listRegionalPaths.get(i));
				}
				System.out.println("["+i+"]:" +pathCurr);
			}
		}
		System.out.println("=======================[mapModelRegionPaths]==========================");

		for (Map.Entry<String, List<String>> entry : mapModelRegionPaths.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey());
			List<String>paths = entry.getValue();
			for (int i = 0; i<paths.size(); i++) {
				System.out.println("["+i+"]:" +paths.get(i));
			}
		}
		/*System.out.println("=======================[MapQNameId]==========================");

		for (Map.Entry<String, String> entry : mapQnameId.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey() + " [VALUE]= "+entry.getValue());
		}
		System.out.println("=======================[MapIdQName]==========================");

		for (Map.Entry<String, String> entry : mapIdQname.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey() + " [VALUE]= "+entry.getValue());
		}
		*/
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
	//==============================================[makeMapModelRegionPaths]
	//==================================================================
	public void makeMapModelRegionPaths() {
		Set<String> set = new LinkedHashSet<>(); 
		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			String [] keySplit = entry.getKey().split("\\::");
			String capInstances = keySplit[0];
			String region = keySplit[1];
			List<String> currentRegionList = new ArrayList<String>();
			
			currentRegionList = mapModelRegionPaths.get(capInstances);
			if((currentRegionList != null) && (currentRegionList.size()>0)) {
				currentRegionList.add(region);
				set.addAll(currentRegionList);
				currentRegionList.clear();
				currentRegionList.addAll(set);
				set.clear();
				mapModelRegionPaths.put(capInstances, currentRegionList);
			}else {
				List<String> newRegionList = new ArrayList<String>();
				newRegionList.add(region);
				mapModelRegionPaths.put(capInstances, newRegionList);
			}
		}

		//Sorting region in each capsule based on "_"

		for (Map.Entry<String, List<String>> entry : mapModelRegionPaths.entrySet()) {
			int count_ = 0;
			String sameLeveRegions = "";
			List<String> currentRegionList = new ArrayList<String>();
			do {
				sameLeveRegions = "";
				for(String region : entry.getValue()) {
					if (StringUtils.countOccurrencesOf(region, "_")==count_) {
						if (sameLeveRegions.isEmpty())
							sameLeveRegions = region;
						else
							sameLeveRegions = sameLeveRegions + "," + region;
					}
				}
				currentRegionList.add(sameLeveRegions);
				count_++;
			}while(!sameLeveRegions.isEmpty());
			if (!sameLeveRegions.isEmpty()) {				
				mapModelRegionPaths.put(entry.getKey(), currentRegionList);
			}
		}
	}


	
	//==================================================================	
	//==============================================[makeMapQnameId]
	//==================================================================	
	public void makeMapQnameId() {
		int nullCounter = 1; 
		for (TransitionData tr :  ParserEngine.listTransitionData){
			if (tr.getTransition() != null) {
				if (tr.getTransition().getQualifiedName() != null)
					mapQnameId.put(tr.getTransition().getQualifiedName(), tr.getId());
				else
					mapQnameId.put("__NULL__"+nullCounter++,tr.getId());
			
				mapIdQname.put(tr.getId(),tr.getTransition().getName());
			}
		}
		for (StateData st :  ParserEngine.listStateData){
			if ((st.getPseudostate() == null) && (st.getState() != null)) {
				if (st.getState().getQualifiedName() != null) {
					mapQnameId.put(st.getState().getQualifiedName(), st.getId());
					mapIdQname.put(st.getId(),st.getStateName());
				}else {
					mapQnameId.put("__NULL__"+nullCounter++,st.getId());
					mapIdQname.put(st.getId(),"__NULL__"+nullCounter++);
				}
				
			}else if ((st.getPseudostate() != null) && (st.getState() == null)) {
				if (st.getPseudostate().getQualifiedName() != null) {
					mapQnameId.put(st.getPseudostate().getQualifiedName(), st.getId());
					mapIdQname.put(st.getId(),st.getStateName());
				}else {
					mapQnameId.put("__NULL__"+nullCounter++,st.getId());
					mapIdQname.put(st.getId(),"__NULL__"+nullCounter++);
				}
			}
		}
	}

	//==================================================================	
	//==============================================[makeMapRegionPaths]
	//==================================================================	
	public void makeMapRegionPaths() {
		makeMapQnameId();
		String stateName = "";
		String capInstance = "";
		int counter = 0;
		boolean isInit = false;
		for (TransitionData tr :  ParserEngine.listTransitionData){
			isInit = tr.getIsInit();
			stateName = "";
			String [] pathSplit = tr.getPath().split("\\-");
			String qName = tr.getTransition().getQualifiedName();
			if (qName != null) {
				int idx = qName.lastIndexOf("Region");
				String tmpStr = qName.substring(0,idx-2);
				idx = tmpStr.lastIndexOf("::");
				stateName= tmpStr.substring(idx+2);
			}
			
			if (!tr.getCapsuleInstanceName().isEmpty())
				capInstance = tr.getCapsuleInstanceName();
			else if (!tr.getCapsuleName().isEmpty())
				capInstance = tr.getCapsuleName();
			else 
				capInstance = "__NoCapsuleName__"+counter++;
			
			if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind() != null) {
				if((ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind().toString().contentEquals("INITIAL")) || isInit) {
					listRegionalPaths = new ArrayList<String>();
					pathMaker(tr.getPath());
					if (mapRegionPaths.get(tr.getCapsuleInstanceName()+"::"+tr.getReginName()) != null)
						listRegionalPaths.addAll(mapRegionPaths.get(capInstance+"::"+tr.getReginName()));
					
					mapRegionPaths.put(capInstance+"::"+tr.getReginName(), listRegionalPaths);
				}
			}else if (((ParserEngine.mapStateData.get(pathSplit[0]).getStateName() != null) &&
					(ParserEngine.mapStateData.get(pathSplit[0]).getStateName().contentEquals(stateName)))) {
				listRegionalPaths = new ArrayList<String>();
				pathMaker(tr.getPath());
				if (mapRegionPaths.get(capInstance+"::"+tr.getReginName()) != null)
					listRegionalPaths.addAll(mapRegionPaths.get(capInstance+"::"+tr.getReginName()));
				
				mapRegionPaths.put(capInstance+"::"+tr.getReginName(), listRegionalPaths);
				
			}
		}
		makeMapModelRegionPaths();
		updateMapRegionPaths();
		showElements();
	}

	//==================================================================	
	//==============================================[findPathInUpperLowerRegion]
	//==================================================================	
	void findPathInUpperLowerRegion(String region, String id, List<String> listMatchPaths) {
		//List<String> listOutPaths = new ArrayList<String>();
		List<String>lowerPaths = mapRegionPaths.get(region);
		String initPath = "";
		boolean noMatchPath = true;

		for (String path : lowerPaths) {

			//getFirstTr in ownerPaths
			String tr_1st;
			if(path.contains(",")) {
				String [] pathSplit = path.split("\\,");
				tr_1st = pathSplit[0];
			}else
				tr_1st = path;
					
			if(ParserEngine.mapTransitionData.get(tr_1st).getIsInit()) {
				initPath = path;
			}
			if((ParserEngine.mapTransitionData.get(tr_1st).getSrcId() != null) && 
					id.contentEquals(ParserEngine.mapTransitionData.get(tr_1st).getSrcId())) {
				noMatchPath = false;
				
				String trgStateId = ""; 
				if (ParserEngine.mapTransitionData.get(tr_1st).getTarget() != null) { //is exit/entry point
					trgStateId = ParserEngine.mapTransitionData.get(tr_1st).getPath();
					String [] tmpStrSplit = trgStateId.split("\\-");
					trgStateId = tmpStrSplit[2];
				}else { // is not basic state
					trgStateId = ParserEngine.mapTransitionData.get(tr_1st).getTrgId();
				}
				if(ParserEngine.mapStateData.get(trgStateId).getPseudoStateKind() != null) {
					
					String PseudoStateKind = ParserEngine.mapStateData.get(trgStateId).getPseudoStateKind().toString();
					//find id
					String newId = ParserEngine.mapTransitionData.get(tr_1st).getTrgId();

					if (PseudoStateKind.contentEquals("ENTRY")) {
						listMatchPaths.add(path);
						String lowerRegion = extractLowerRegion(newId);
						findPathInUpperLowerRegion(lowerRegion, newId, listMatchPaths);

					}else if (PseudoStateKind.contentEquals("EXIT")) {
						listMatchPaths.add(path);
						String upperRegion = extractUpperRegion(region);
						findPathInUpperLowerRegion(upperRegion, newId, listMatchPaths);

					}else if(PseudoStateKind.contentEquals("CHOICE")) {
						//add all paths from the choice point to the list
						List<String> allRegionPaths = mapRegionPaths.get(region);
						for(String cPath: allRegionPaths) {
							String [] pathSplitTmp = cPath.split("\\,");
							//check wheather choice point in the cPath
							for(String p : pathSplitTmp) {
								if (ParserEngine.mapTransitionData.get(p).getPath().contains(newId)) {
									listMatchPaths.add("choice");
									listMatchPaths.add(cPath);
									break;
								}
							}
						}
						break;
					}else if(PseudoStateKind.contentEquals("JUNCTION")) {
						List<String> allRegionPaths = mapRegionPaths.get(region);
						for(String jPath: allRegionPaths) {
							//String [] pathSplitTmp = jPath.split("\\,");
							if(jPath.contains(tr_1st)) {
								listMatchPaths.add(jPath);
								break; // Junction has only one output
							}
						}
						if (listMatchPaths.size()==0)
							System.err.println("=================[No MatchPath found for the Junction state]================");
						//break;
					}else {
						System.err.println("=================[Bad Type!]================");
					}
				}else {
					listMatchPaths.add(path);
					//break;
				}
			}
		}
		if (noMatchPath == true) { //history => only the init tr is added to the listMatchPaths
			listMatchPaths.add("itself");
			listMatchPaths.add(initPath);
		}
	}

	//==================================================================	
	//==============================================[updateMapRegionPaths]
	//==================================================================	
	public void updateMapRegionPaths() {
		List<String> listCurrentPath = new ArrayList<String>();
		List<String> listPathsDone = new ArrayList<String>();
		
		String lastTr = "";
		String upperRegion = "";
		String lowerRegion = "";
		String orgPath = "";

		String exitPointId_inner = "";
		String exitPointId_outer = "";
		String entryPointId_inner = "";
		String entryPointId_outer = "";
		
		for (Map.Entry<String, List<String>> entry : mapModelRegionPaths.entrySet()) {
			
			Collections.reverse(entry.getValue()); //reverse the list to process the most inner regions first 
			for (String region: entry.getValue()) {
				String currentRegion =  entry.getKey()+"::"+region;
				
				listCurrentPath = mapRegionPaths.get(currentRegion);
				for (int i = 0; i<listCurrentPath.size(); i++) {
					boolean updated = false;
					String dPath = listCurrentPath.get(i);
					if (!listPathsDone.contains(dPath)) {
						List<String> listMatchPaths = new ArrayList<String>();
						exitPointId_inner = "";
						exitPointId_outer = "";
						entryPointId_inner = "";
						entryPointId_outer = "";
						upperRegion = "";
						lowerRegion = "";


						//get the last trID
						orgPath = listCurrentPath.get(i);
						lastTr = extractLastPathID(orgPath);


						//lastTr->[x]  EXIT
						if((ParserEngine.mapTransitionData.get(lastTr).getTrgId() != null) &&
								ParserEngine.mapStateData.get(ParserEngine.mapTransitionData.get(lastTr).getTrgId()).getPseudoStateKind().toString().contentEquals("EXIT")) {
							exitPointId_inner = ParserEngine.mapTransitionData.get(lastTr).getTrgId();
							upperRegion = extractUpperRegion(currentRegion);
							//System.out.println("=======================> [upperRegion]"+ upperRegion);

						}

						//lastTr->[]   ENTRY
						else if((ParserEngine.mapTransitionData.get(lastTr).getTrgId() != null) &&
								ParserEngine.mapStateData.get(ParserEngine.mapTransitionData.get(lastTr).getTrgId()).getPseudoStateKind().toString().contentEquals("ENTRY")) {
							entryPointId_outer = ParserEngine.mapTransitionData.get(lastTr).getTrgId();
							lowerRegion = extractLowerRegion(entryPointId_outer);
							//System.out.println("=======================> [lowerRegion]"+ lowerRegion);

						}


						if((!upperRegion.contentEquals("")) || (!lowerRegion.contentEquals(""))) {

							if (!exitPointId_inner.isEmpty()) 
								findPathInUpperLowerRegion(upperRegion,exitPointId_inner,listMatchPaths);
							else if (!entryPointId_outer.isEmpty())
								findPathInUpperLowerRegion(lowerRegion,entryPointId_outer,listMatchPaths);
							boolean itself = false;
							boolean pChoiceAdded = false;
							boolean setChoice = false;
							boolean choice = false;
							String basePath = "";
							//if (listMatchPaths.contains("choice") || (listMatchPaths.size()>1))
							basePath = listCurrentPath.get(i);
							
							List<String> listChoicePaths = new ArrayList<String>();
							if(listMatchPaths.size()>0) {
								for(String newPath : listMatchPaths) {
									if(setChoice) {
										orgPath = orgPath +","+newPath;
										setChoice = !setChoice;
										pChoiceAdded = true;
								    }else if(newPath.contentEquals("itself")) {
										itself = true;
									}else if(newPath.contentEquals("choice")) {
										choice = true;
										setChoice = !setChoice;
										if(pChoiceAdded) {
											pChoiceAdded = false;
											if (!updated) { listCurrentPath.set(i, orgPath); updated = true; orgPath = basePath;}
											else {listCurrentPath.add(orgPath); orgPath = basePath;}
										}
									}else 
										if (!updated) { listCurrentPath.set(i, basePath+","+newPath); updated = true;}
										else {listCurrentPath.add(basePath+","+newPath); orgPath = basePath;}
									
									}
								}

								if (itself) {
									String oPath = listCurrentPath.get(i);
									listCurrentPath.set(i, orgPath);
									listCurrentPath.add(oPath);
									itself = false;
								}else if(choice) {//nothing
									if(pChoiceAdded) {
										pChoiceAdded = false;
										if (!updated) { String orgPathTmp = listCurrentPath.get(i); listCurrentPath.set(i, orgPath); updated = true; orgPath = orgPathTmp;}
										else {listCurrentPath.add(orgPath); orgPath = listCurrentPath.get(i);}
									}
								}else {
								//	listCurrentPath.set(i, orgPath);
								}

							}
					}
					listPathsDone.add(dPath);
				}
			}
		}
		removeDuplicates();
		removeShortPaths();
	}
}
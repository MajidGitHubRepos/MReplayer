package ca.queensu.cs.umlrtParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class PES {

	public List<String> listPaths = new ArrayList<String>();
	public static Map<String, List<String>> mapRegionPaths = new HashMap<String, List<String>>();
	public static Map<String, String> mapIdQname     = new HashMap<String, String>();
	


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
			
			if (path.contains(",")) {
				int lastIndex = path.lastIndexOf(",");
				lastIdInPath = path.substring(lastIndex+1);
			}else { lastIdInPath = path;}
			
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
				if (!listPaths.contains(path)) {
					listPaths.add(path);
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
	//==============================================[showElements]
	//==================================================================	
	public void showElements() {
		System.out.println("=======================[mapRegionPaths]==========================");

		for (Map.Entry<String, List<String>> entry : mapRegionPaths.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey());
			listPaths = entry.getValue();
			for (int i = 0; i<listPaths.size(); i++) {
				System.out.println("["+i+"]:" +listPaths.get(i));
			}
		}
		System.out.println("=======================[MapIdQName]==========================");

		for (Map.Entry<String, String> entry : mapIdQname.entrySet()) {
			System.out.println("[KEY]= "+entry.getKey() + " [VALUE]= "+entry.getValue());
		}
		
	}
	//-------
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
	//==============================================[makeMapIdQname]
	//==================================================================	
	public void makeMapIdQname() {
		for (TransitionData tr :  ParserEngine.listTransitionData){
			if (tr.getTransition() != null)
				mapIdQname.put(tr.getId(), tr.getTransition().getQualifiedName());
			else
				mapIdQname.put(tr.getId(), "__NULL__");
		}
		for (StateData st :  ParserEngine.listStateData){
			if (st.getState() != null)
				mapIdQname.put(st.getId(), st.getState().getQualifiedName());
			else if (st.getPseudostate() != null)
				mapIdQname.put(st.getId(), st.getPseudostate().getQualifiedName());
			else
				mapIdQname.put(st.getId(), "__NULL__");
		}
	}

	//==================================================================	
	//==============================================[makeMapRegionPaths]
	//==================================================================	
	public void makeMapRegionPaths() {
		makeMapIdQname();
		for (TransitionData tr :  ParserEngine.listTransitionData){
			String [] pathSplit = tr.getPath().split("\\-");
			if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind() != null) {
				if(ParserEngine.mapStateData.get(pathSplit[0]).getPseudoStateKind().toString().contentEquals("INITIAL")) {
					listPaths = new ArrayList<String>();
					pathMaker(tr.getPath());
					mapRegionPaths.put(tr.getCapsuleInstanceName()+"__"+tr.getReginName(), listPaths);
				}
			}
		}
		showElements();
	}




}

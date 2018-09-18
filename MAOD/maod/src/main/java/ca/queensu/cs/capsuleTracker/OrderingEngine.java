package ca.queensu.cs.capsuleTracker;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.util.List;
import java.util.Map;

import ca.queensu.cs.umlrtParser.TableDataMember;

public class OrderingEngine implements Runnable {

	private  Map<String, List<TableDataMember>> listTableData;

	public OrderingEngine(Map<String, List<TableDataMember>> listTableData ) {
		this.listTableData = listTableData;
	}

	public final void run() {

		//showElements();
		//TableDataMember initTableDataMember = findingInitTransitions();
		 
		//while(true) {if (requirementMet(event)) break; else System.out.print(""); }

	}

	//==================================================================	
	//==============================================[showElements]
	//==================================================================	
	public void showElements() {
		//-------
		System.out.println("=======================[TableData in OrderingEngine]==========================");
		for (Map.Entry<String, List<TableDataMember>> entry  : listTableData.entrySet()) {
			System.out.println("---> entry.getKey(): "+entry.getKey());
			//System.out.println("---> entry.getValue().get(1): "+entry.getValue().get(1));
			for (int i = 0; i < entry.getValue().size(); i++) {
				System.out.println("---> TableData["+i+"]: entry.getValue().get("+i+"): "+entry.getValue().get(i).allDataToString());

			}
		}
	}
	
	//==================================================================	
	//==============================================[findingInitTransitions]
	//==================================================================	
	/*
	public TableDataMember findingInitTransitions(){
		//listTableData
	}
	*/
	
	//==================================================================	
	//==============================================[findingInitTransitions]
	//==================================================================	
	/*
	public boolean requirementMet(event){
			//listTableData		
	}
	*/

}

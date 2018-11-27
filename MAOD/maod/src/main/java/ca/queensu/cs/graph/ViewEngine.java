package ca.queensu.cs.graph;

import java.util.List;
import java.util.Map;

import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.UmlrtParser;

public class ViewEngine implements Runnable {
	public static Map<String, List<TableDataMember>> listTableData;
	public static UmlrtParser umlrtParser;
	
	public ViewEngine() {
		this.listTableData = null;
		this.umlrtParser = new UmlrtParser();
	}

	//==================================================================	
	//==============================================[Run]
	//==================================================================	
	public final void run() {
		listTableData = umlrtParser.getlistTableData();
		makeMxGraphModel();

	}



	//==================================================================	
	//==============================================[makeMxGraphModel]
	//==================================================================	
	public final void makeMxGraphModel() {
		System.out.println("["+ Thread.currentThread().getName() +"]==========================[makeMxGraphModel]==========================");


	}

}

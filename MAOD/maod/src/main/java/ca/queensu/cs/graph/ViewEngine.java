package ca.queensu.cs.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ca.queensu.cs.controller.Controller;
import ca.queensu.cs.umlrtParser.EntryData;
import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.UmlrtParser;
import ca.queensu.cs.umlrtParser.UmlrtUtils;

public class ViewEngine implements Runnable {
	public static UmlrtParser umlrtParser;
	public static OutputStream outputFileStream;
	


	public ViewEngine() {
		this.umlrtParser = new UmlrtParser();
	}

	//==================================================================	
	//==============================================[Run]
	//==================================================================	
	public final void run() {		
		try {
			makeInitJsonFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		makeMxGraphModel();

	}

	//==================================================================	
	//==============================================[makeInitJsonFile]
	//==================================================================	
	public final void makeInitJsonFile() throws IOException {
		System.out.println("["+ Thread.currentThread().getName() +"]==========================[makeInitJsonFile]==========================");

		//		
		//		JSONArray list1 = new JSONArray(); list1.add("foo"); list1.add(new Integer(100)); list1.add(new Double(1000.21));
		//
		//		JSONArray list2 = new JSONArray(); list2.add(new Boolean(true)); list2.add(null);
		//
		//		JSONObject obj = new JSONObject(); obj.put("name","foo"); obj.put("num",new Integer(100)); obj.put("balance",new Double(1000.21)); obj.put("is_vip",new Boolean(true)); obj.put("nickname",null);
		//
		//		obj.put("list1", list1); obj.put("list2", list2);
		//
		//		System.out.println(obj); 
		//		
		//		Result: {"balance":1000.21,"list2":[true,null],"num":100,"list1":["foo",100,1000.21],"nickname":null,"is_vip":true,"name":"foo"}
		//		
		//		https://code.google.com/archive/p/json-simple/wikis/EncodingExamples.wiki


		/*
		 * 
		 * Achtung: All State and tansition should have be named!
		 * 
		 */



		List<JSONObject> listJSONobj = new ArrayList<JSONObject>();
		JSONObject objTop = new JSONObject();
		JSONArray listCapsulesInstance = new JSONArray();
		JSONArray listCapsulesInstances = new JSONArray();
		objTop.put("name", "Top");
		//listJSONobj.add(topObj);
		//System.out.println("---> listTableData: " + Controller.listTableData.entrySet());
		for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {
			System.out.println("---> entry.getKey(): "+entry.getKey());
			
			//JSONObject objCapsules = new JSONObject();
			String capsuleInstance = entry.getKey().replaceAll("\\s+","");
			
			if (capsuleInstance.contains(",")) {
				String [] capsuleInstances = capsuleInstance.split("\\,");

				
				for (int i = 0; i < capsuleInstances.length; i++) {
					JSONObject objCapsulesInstance = new JSONObject();
					objCapsulesInstance.put("name", capsuleInstances[i]);
					JSONArray listSM = new JSONArray();
					for (int j = 0; j < entry.getValue().size(); j++) {
						//every value is a transition

						JSONObject objTR = new JSONObject();
						objTR.put("name",entry.getValue().get(j).getTransition().getTransitonName());
						objTR.put("style","");
						listSM.add(objTR);

						JSONObject objStateSrc = new JSONObject();
						objStateSrc.put("name",entry.getValue().get(j).getSource().getStateName());
						objStateSrc.put("style","");
						listSM.add(objStateSrc);

						JSONObject objStateTrg = new JSONObject();
						objStateTrg.put("name",entry.getValue().get(j).getTarget().getStateName());
						objStateTrg.put("style","");
						listSM.add(objStateTrg);
					}
					objCapsulesInstance.put("stateMachine", listSM);
					listCapsulesInstances.add(objCapsulesInstance);
				}
				objTop.put("capsules", listCapsulesInstances);
			}
			
			else {
				System.out.println("==================================[in else]============================");

					JSONObject objCapsulesInstance = new JSONObject();
					objCapsulesInstance.put("name", capsuleInstance);
					JSONArray listSM = new JSONArray();
					

					for (int j = 0; j < entry.getValue().size(); j++) {
						//every value is a transition

						JSONObject objTR = new JSONObject();
						objTR.put("name",entry.getValue().get(j).getTransition().getTransitonName());
						objTR.put("style","");
						listSM.add(objTR);

						JSONObject objStateSrc = new JSONObject();
						objStateSrc.put("name",entry.getValue().get(j).getSource().getStateName());
						objStateSrc.put("style","");
						listSM.add(objStateSrc);

						JSONObject objStateTrg = new JSONObject();
						objStateTrg.put("name",entry.getValue().get(j).getTarget().getStateName());
						objStateTrg.put("style","");
						listSM.add(objStateTrg);
					}
					objCapsulesInstance.put("stateMachine", listSM);
					listCapsulesInstance.add(objCapsulesInstance);
				//}
					
			}
			objTop.put("capsules", listCapsulesInstance);
			
		}
		System.out.println("==================================[write into the model.json]============================");
		ClassLoader classLoader = getClass().getClassLoader();
		String outputFileName = "input_output_Files/model.json";
		File outputFile = new File(classLoader.getResource(outputFileName).getFile());
		outputFile.createNewFile();
		System.out.println("\n["+ Thread.currentThread().getName() +"]> outputFile exists in : "+ outputFile.getAbsolutePath());
		
		outputFileStream = new FileOutputStream(outputFile,false);
		//FileWriter file;
		outputStreamToFile(outputFileStream,objTop.toJSONString());
		//-------



	}

	//==================================================================	
	//==============================================[outputStreamToFile]
	//==================================================================	
	private static void outputStreamToFile(OutputStream os, String data) {
		try {
			os.write(data.getBytes(), 0, data.length());
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}/*finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
	}
	//==================================================================	
	//==============================================[makeMxGraphModel]
	//==================================================================	
	public final void makeMxGraphModel() {
		System.out.println("["+ Thread.currentThread().getName() +"]==========================[makeMxGraphModel]==========================");


	}

}

package ca.queensu.cs.antler4AC;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ca.queensu.cs.antler4AC.ACLexer;
import ca.queensu.cs.antler4AC.ACParser;
import ca.queensu.cs.antler4AC.EvalVisitor;

public class Main {

	public static void main(String[] args) throws Exception {
		/*String expression = "n= 5; "
				+ "for (n=5;  n  >  0 ;n--) {\n" + 
				"\n" + 
				"  # expressions can be surrounded by parenthesis, of course\n" + 
 
				"  n--;  log n;\n" + 
 
				"\n" + 
				"}";
		*/
		//String expression = "int count = 1;";
		//String expression = "int count = 4; for (count = 0 ; count < 10 ; count++) { log \"count: \" + count; if (count % 2 == 0) {log \" EVEN\"; } else if(count == 5) {port.msg(count).sendAt(count);}else { log \" ODD\"; }  } showHeap; showListSendMsg;";
		
		
		String expression = "logfile.open(this->getName()); showHeap; showListSendMsg;";
		Map<String, Value> maplocalHeap = new HashMap<String, Value>();
		maplocalHeap.put("pingCount", new Value(1.0,"Double"));
		ACLexer lexer = new ACLexer(new ANTLRInputStream(expression));
		ACParser parser = new ACParser(new CommonTokenStream(lexer));
		new EvalVisitor(maplocalHeap).visit(parser.parse());
		//ParseTree tree = parser.parse();
		EvalVisitor visitor = new EvalVisitor(maplocalHeap);
	}

}

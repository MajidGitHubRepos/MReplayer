package ca.queensu.cs.antler4AC;

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
		String expression = "count = 6; for (count = 0 ; count < 10 ; count++) { log \"count: \" + count; if (count % 2 == 0) {log \" EVEN\"; } else { log \" ODD\"; }  } showHeap; showListSendMsg;";
		
		
		ACLexer lexer = new ACLexer(new ANTLRInputStream(expression));
		ACParser parser = new ACParser(new CommonTokenStream(lexer));
		new EvalVisitor().visit(parser.parse());
		ParseTree tree = parser.parse();
		EvalVisitor visitor = new EvalVisitor();
	}

}

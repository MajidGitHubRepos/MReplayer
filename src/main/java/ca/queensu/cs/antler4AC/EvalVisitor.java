package ca.queensu.cs.antler4AC;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.misc.NotNull;


/* 
 * java -jar antlr-4.7.2-complete.jar -visitor AC.g4
 * 
 */


public class EvalVisitor extends ACBaseVisitor<Value> {

	// used to compare floating point numbers
	public static final double SMALL_VALUE = 0.00000000001;

	// store variables (there's only one global scope!)
	private Map<String, Value> HeapMem = new HashMap<String, Value>();
	private List<SendMessage> listPortMsg = new ArrayList<SendMessage>();

	public EvalVisitor(Map<String, Value> mapLocalHeap) {
		if (mapLocalHeap != null)
			for (Entry<String, Value> entry : mapLocalHeap.entrySet()) {
				HeapMem.put(entry.getKey(), entry.getValue());
			}
	}
	public EvalVisitor() {
		this(null);
	}

	public String getOpertionType(Value left,Value right) {

		String type = "String";
		if (left.type.contentEquals("Integer") && right.type.contentEquals("Integer")) {
			type = "Integer";
		}else if (left.type.contentEquals("Double") && !right.type.contentEquals("String")) {
			type = "Double";
		}else if (!left.type.contentEquals("String") && right.type.contentEquals("Double")) {
			type = "Double";
		}else if (!left.type.contentEquals("String") && right.type.contentEquals("Double")) {
			type = "Double";
		}
		return type;
	}

	public List<SendMessage> getListPortMsg() {
		return listPortMsg;
	}

	public Map<String, Value> getHeapMem() {
		return HeapMem;
	}

	// assignment/id overrides
	@Override
	public Value visitNormalAssignment(ACParser.NormalAssignmentContext ctx) {
		String id = ctx.ID().getText();
		Value value = HeapMem.get(id);
		//System.out.println("in visitNormalAssignment: "+value);
		if(value == null) {
			throw new RuntimeException("no such variable: " + id);
		}
		value = this.visit(ctx.expr());
		return HeapMem.put(id, value);
	}

	@Override
	public Value visitBasicAssignment(ACParser.BasicAssignmentContext ctx) {

		String id = ctx.ID().getText();
		if (ctx.expr() == null)
			return HeapMem.put(id, new Value (0, ""));
		else {
			switch (ctx.op.getType()) {
			case ACParser.INTVAR:
				return HeapMem.put(id, new Value (this.visit(ctx.expr()).asDouble().intValue(),"Integer"));
			case ACParser.DOUBLEVAR:
				return HeapMem.put(id, new Value (this.visit(ctx.expr()),"Double"));
			case ACParser.STRINGVAR:
				return HeapMem.put(id, new Value (this.visit(ctx.expr()),"String"));
			default:
				return HeapMem.put(id, new Value (this.visit(ctx.expr()),""));
			}
		}


	}

	@Override
	public Value visitMinusminusAssignment(ACParser.MinusminusAssignmentContext ctx) {
		String id = ctx.ID().getText();
		Value value = HeapMem.get(id);
		if(value == null) {
			throw new RuntimeException("no such variable: " + id);
		}
		switch (value.type) {
		case "Double":
			return HeapMem.put(id, new Value(value.asDouble()-1, "Double"));
		case "Integer":
			return HeapMem.put(id, new Value(value.asInteger()-1, "Integer"));
		case "Real":
			return HeapMem.put(id, new Value(value.asDouble()-1, "Double"));
		default:
			throw new RuntimeException("no such type: " + id);
		}
	}

	@Override
	public Value visitPlusplusAssignment(ACParser.PlusplusAssignmentContext ctx) {
		String id = ctx.ID().getText();
		Value value = HeapMem.get(id);

		if(value == null) {
			throw new RuntimeException("no such variable: " + id);
		}

		switch (value.type) {
		case "Double":
			return HeapMem.put(id, new Value(value.asDouble()+1, "Double"));
		case "Integer":
			return HeapMem.put(id, new Value(value.asInteger()+1, "Integer"));
		case "Real":
			return HeapMem.put(id, new Value(value.asDouble()+1, "Double"));
		default:
			throw new RuntimeException("no such type: " + id);

		}
	}

	@Override
	public Value visitPlusplusExpr(ACParser.PlusplusExprContext ctx) {
		Value value = this.visit(ctx .expr());
		return new Value(value.asDouble()+1, "Double");
	}

	@Override
	public Value visitMinusminusExpr(ACParser.MinusminusExprContext ctx) {
		Value value = this.visit(ctx .expr());
		return new Value(value.asDouble()-1, "Double");
	}

	@Override
	public Value visitIdAtom(ACParser.IdAtomContext ctx) {
		String id = ctx.getText();


		Value value = HeapMem.get(id);
		if(value == null) {
			// throw new RuntimeException("no such variable: " + id); //TODO: all varibale should be given properly later like: this->hostConfig=config;
		}
		return value;
	}

	// atom overrides
	@Override
	public Value visitStringAtom(ACParser.StringAtomContext ctx) {
		String str = ctx.getText();
		// strip quotes
		str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
		return new Value(str, "String");
	}

	@Override
	public Value visitNumberAtom(ACParser.NumberAtomContext ctx) {
		if (ctx.getText().contains("."))
			return new Value(Double.valueOf(ctx.getText()), "Double");
		else
			return new Value(Integer.valueOf(ctx.getText()), "Integer");
	}

	@Override
	public Value visitBooleanAtom(ACParser.BooleanAtomContext ctx) {
		return new Value(Boolean.valueOf(ctx.getText()), "Boolean");
	}

	@Override
	public Value visitNilAtom(ACParser.NilAtomContext ctx) {
		return new Value(null, "");
	}

	// expr overrides
	@Override
	public Value visitParExpr(ACParser.ParExprContext ctx) {
		return this.visit(ctx.expr());
	}

	@Override
	public Value visitPowExpr(ACParser.PowExprContext ctx) {
		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));
		
		
		switch (left.type) {
		case "Double":
			return new Value(Math.pow(left.asDouble(), right.asDouble()), "Double");
		case "Integer":
			return new Value(Math.pow(left.asInteger(), right.asInteger()), "Integer");
		case "Real":
			return new Value(Math.pow(left.asDouble(), right.asDouble()), "Double");
		default:
			throw new RuntimeException("no such type! ");
		}
	}

	@Override
	public Value visitUnaryMinusExpr(ACParser.UnaryMinusExprContext ctx) {
		Value value = this.visit(ctx.expr());
		
		switch (value.type) {
		case "Double":
			return new Value(-value.asDouble(), "Double");
		case "Integer":
			return new Value(-value.asInteger(), "Integer");
		case "Real":
			return new Value(value.asDouble(), "Double");
		default:
			throw new RuntimeException("no such type! ");
		}
	}

	@Override
	public Value visitNotExpr(ACParser.NotExprContext ctx) {
		Value value = this.visit(ctx.expr());
		return new Value(!value.asBoolean(), "Boolean");
	}

	@Override
	public Value visitMultiplicationExpr(@NotNull ACParser.MultiplicationExprContext ctx) {
		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));

		String type = getOpertionType(left,right);

		switch (ctx.op.getType()) {
		case ACParser.MULT:
			switch (type) {
			case "Double":
				return new Value(left.asDouble() * right.asDouble(), type);
			case "Integer":
				return new Value(left.asInteger() * right.asInteger(), type);
			case "Real":
				return new Value(left.asDouble() * right.asDouble(), "Double");
			default:
				throw new RuntimeException("no such type! ");
			}
		case ACParser.DIV:
			switch (type) {
			case "Double":
				return new Value(left.asDouble() / right.asDouble(), type);
			case "Integer":
				return new Value(left.asInteger() / right.asInteger(), type);
			case "Real":
				return new Value(left.asDouble() / right.asDouble(), "Double");
			default:
				throw new RuntimeException("no such type! ");
			}
		case ACParser.MOD:
			switch (type) {
			case "Double":
				return new Value(left.asDouble()  % right.asDouble(), type);
			case "Integer":
				return new Value(left.asInteger() % right.asInteger(), type);
			case "Real":
				return new Value(left.asDouble()  % right.asDouble(), "Double");
			default:
				throw new RuntimeException("no such type! ");
			}
		default:
			throw new RuntimeException("unknown operator: " + ACParser.tokenNames[ctx.op.getType()]);
		}
	}
	@Override
	public Value visitAdditiveExpr(@NotNull ACParser.AdditiveExprContext ctx) {

		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));

		String type = getOpertionType(left,right);
		//System.out.println(ctx.op.getType() + " int visitAdditiveExpr [type]: " + left.type + ", " + right.type + ", " + ACParser.PLUS + ", " + type);

		switch (ctx.op.getType()) {
		case ACParser.PLUS:

			switch (type) {
			case "Double":
				return new Value(left.asDouble() + right.asDouble(), type);
			case "Integer":
				return new Value(left.asInteger() + right.asInteger(), type);
			case "Real":
				return new Value(left.asDouble() + right.asDouble(), "Double");
			default:
				return new Value(left.asString() + right.asString(), "String");
			}

		case ACParser.PLUSPLUS:
			switch (type) {
			case "Double":
				return new Value(left.asDouble() + 1, type);
			case "Integer":
				return new Value(left.asInteger() + 1, type);
			case "Real":
				return new Value(left.asDouble() + 1, "Double");
			}

		case ACParser.MINUS:
			switch (type) {
			case "Double":
				return new Value(left.asDouble() - right.asDouble(), type);
			case "Integer":
				return new Value(left.asInteger() - right.asInteger(), type);
			case "Real":
				return new Value(left.asDouble() - right.asDouble(), "Double");
			}
		case ACParser.MINUSMINUS:
			switch (type) {
			case "Double":
				return new Value(left.asDouble() - 1, type);
			case "Integer":
				return new Value(left.asInteger() - 1, type);
			case "Real":
				return new Value(left.asDouble() - 1, "Double");
			
			}
		default:
			throw new RuntimeException("unknown operator: " + ACParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Value visitRelationalExpr(@NotNull ACParser.RelationalExprContext ctx) {

		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));

		switch (ctx.op.getType()) {
		case ACParser.LT:
			return new Value(left.asDouble() < right.asDouble(), "");
		case ACParser.LTEQ:
			return new Value(left.asDouble() <= right.asDouble(),"");
		case ACParser.GT:
			return new Value(left.asDouble() > right.asDouble(),"");
		case ACParser.GTEQ:
			return new Value(left.asDouble() >= right.asDouble(),"");
		default:
			throw new RuntimeException("unknown operator: " + ACParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Value visitEqualityExpr(@NotNull ACParser.EqualityExprContext ctx) {

		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));

		switch (ctx.op.getType()) {
		case ACParser.EQ:
			return left.isDouble() && right.isDouble() ?
					new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE, "") :
						new Value(left.equals(right),"");
		case ACParser.NEQ:
			return left.isDouble() && right.isDouble() ?
					new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE, "") :
						new Value(!left.equals(right),"");
		default:
			throw new RuntimeException("unknown operator: " + ACParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Value visitAndExpr(ACParser.AndExprContext ctx) {
		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));
		return new Value(left.asBoolean() && right.asBoolean(), "Boolean");
	}

	@Override
	public Value visitOrExpr(ACParser.OrExprContext ctx) {
		Value left = this.visit(ctx.expr(0));
		Value right = this.visit(ctx.expr(1));
		return new Value(left.asBoolean() || right.asBoolean(), "Boolean");
	}

	// log override
	@Override
	public Value visitLog(ACParser.LogContext ctx) {
		Value value = this.visit(ctx.expr());
		System.out.println(value);
		return value;
	}

	// if override
	@Override
	public Value visitIf_stat(ACParser.If_statContext ctx) {

		List<ACParser.Condition_blockContext> conditions =  ctx.condition_block();

		boolean evaluatedBlock = false;

		for(ACParser.Condition_blockContext condition : conditions) {

			Value evaluated = this.visit(condition.expr());

			if(evaluated.asBoolean()) {
				evaluatedBlock = true;
				// evaluate this block whose expr==true
				this.visit(condition.stat_block());
				break;
			}
		}

		if(!evaluatedBlock && ctx.stat_block() != null) {
			// evaluate the else-stat_block (if present == not null)
			this.visit(ctx.stat_block());
		}
		return Value.VOID;
	}

	// while override
	@Override
	public Value visitWhile_stat(ACParser.While_statContext ctx) {

		Value value = this.visit(ctx.expr());

		while(value.asBoolean()) {

			// evaluate the code block
			this.visit(ctx.stat_block());

			// evaluate the expression
			value = this.visit(ctx.expr());
		}

		return Value.VOID;
	}


	@Override
	public Value visitDoWhileLoop(ACParser.DoWhileLoopContext ctx) {
		Value value = this.visit(ctx.expr());

		do{
			// evaluate the code block
			this.visit(ctx.stat_block());

			// evaluate the expression
			value = this.visit(ctx.expr());
		} while(value.asBoolean());

		return Value.VOID;
	}


	@Override
	public Value visitForLoop(ACParser.ForLoopContext ctx) {
		
		
		String id = ctx.ID().getText();

		if (ctx.op != null) {
			switch (ctx.op.getType()) {
			case ACParser.INTVAR:
				HeapMem.put(id, new Value (this.visit(ctx.expr(0)).asDouble().intValue(),"Integer"));
			case ACParser.DOUBLEVAR:
				HeapMem.put(id, new Value (this.visit(ctx.expr(0)).asDouble(),"Double"));
			default:
				HeapMem.put(id, new Value (this.visit(ctx.expr(0)).asDouble().intValue(),"Integer"));
			}
	}
		Value valueCondition = this.visit(ctx.expr(1));
		Value valueEnd = this.visit(ctx.expr(2));

		while (valueCondition.asBoolean()) {
			// evaluate the code block
			this.visit(ctx.stat_block());            
			HeapMem.put(id, new Value (this.visit(ctx.expr(2)).asDouble().intValue(),"Integer"));
			valueCondition = this.visit(ctx.expr(1));
		}
		return Value.VOID;
	}

	@Override
	public Value visitSend_stat(ACParser.Send_statContext ctx) {
		String port = ctx.ID(0).getText();
		String msg = ctx.ID(1).getText();
		String dataName = "";
		Value data;
		if (ctx.expr() != null) {
			dataName = ctx.expr().getText();
			data = this.visit(ctx.expr());
		}else {
			dataName = "";
			data = null;
		}

		SendMessage sendMsg = new SendMessage(port,msg, dataName, data, null);
		listPortMsg.add(sendMsg);

		return data;
	}

	@Override
	public Value visitSendat_stat(ACParser.Sendat_statContext ctx) {
		String port = ctx.ID(0).getText();
		String msg = ctx.ID(1).getText();
		String dataName = ctx.expr(0).getText();
		Value data = this.visit(ctx.expr(0));
		Value dest = new Value(0,"");

		if (ctx.getText().contains("msg->sapIndex0_")){
			dest = new Value("msg->sapIndex0_","String");
		}else	
			dest = this.visit(ctx.expr(1));

		SendMessage sendMsg = new SendMessage(port,msg, dataName, data, dest);
		listPortMsg.add(sendMsg);

		return data;
	}

	@Override
	public Value visitUnknowns(ACParser.UnknownsContext ctx) {
		//System.out.println("in [visitUnknowns]");

		//Do nothing
		return new Value(0, "");
	}

	@Override
	public Value visitShowHeapMem(ACParser.ShowHeapMemContext ctx){


		System.out.println("=====================[HeapMem]=================");
		for (Entry<String, Value> entry : HeapMem.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: "+ entry.getValue().toString());
		}
		return new Value(0,"");

	}

	@Override
	public Value visitShowListSendMsg(ACParser.ShowListSendMsgContext ctx){
		System.out.println("=====================[listPortMsg]=================");
		for (SendMessage portMsg : listPortMsg) {
			System.out.println(portMsg.allDataToString());
		}
		return new Value(0,"");

	}



}

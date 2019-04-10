package ca.queensu.cs.antler4AC;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.misc.NotNull;


/* 
 * sed -i '1s/^/package ca.queensu.cs.antler4AC; /' ACBaseListener.java ACBaseVisitor.java ACListener.java ACParser.java ACLexer.java ACVisitor.java
 */


public class EvalVisitor extends ACBaseVisitor<Value> {

    // used to compare floating point numbers
    public static final double SMALL_VALUE = 0.00000000001;

    // store variables (there's only one global scope!)
    private Map<String, Value> HeapMem = new HashMap<String, Value>();
    private List<SendMessage> listPortMsg = new ArrayList<SendMessage>();

    // assignment/id overrides
    @Override
    public Value visitNormalAssignment(ACParser.NormalAssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());
        return HeapMem.put(id, value);
    }
    
    @Override
    public Value visitBasicAssignment(ACParser.BasicAssignmentContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.expr() == null)
        	return HeapMem.put(id, new Value (0));
        else 
        	return HeapMem.put(id, new Value (this.visit(ctx.expr())));
    }
    
    @Override
    public Value visitMinusminusAssignment(ACParser.MinusminusAssignmentContext ctx) {
    	String id = ctx.ID().getText();
        Value value = HeapMem.get(id);
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
    	//Value value = this.visit(ctx .expr());
        Value newValue = new Value(value.asDouble()-1);
        HeapMem.put(id, newValue);
        return new Value(value.asDouble()-1);
    }
    
    @Override
    public Value visitPlusplusAssignment(ACParser.PlusplusAssignmentContext ctx) {
    	String id = ctx.ID().getText();
        Value value = HeapMem.get(id);
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        Value newValue = new Value(value.asDouble()+1);
        HeapMem.put(id, newValue);
        return new Value(value.asDouble()+1);
    }
    
    @Override
    public Value visitPlusplusExpr(ACParser.PlusplusExprContext ctx) {
    	Value value = this.visit(ctx .expr());
        return new Value(value.asDouble()+1);
    }
    
    @Override
    public Value visitMinusminusExpr(ACParser.MinusminusExprContext ctx) {
    	Value value = this.visit(ctx .expr());
        return new Value(value.asDouble()-1);
    }

    @Override
    public Value visitIdAtom(ACParser.IdAtomContext ctx) {
        String id = ctx.getText();
        Value value = HeapMem.get(id);
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(ACParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(ACParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(ACParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(ACParser.NilAtomContext ctx) {
        return new Value(null);
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
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(ACParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(ACParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull ACParser.MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case ACParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case ACParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case ACParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + ACParser.tokenNames[ctx.op.getType()]);
        }
    }
    @Override
    public Value visitAdditiveExpr(@NotNull ACParser.AdditiveExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case ACParser.PLUS:
                return left.isDouble() && right.isDouble() ?
                        new Value(left.asDouble() + right.asDouble()) :
                        new Value(left.asString() + right.asString());
            case ACParser.PLUSPLUS:
                return new Value(left.asDouble() + 1);

            case ACParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            case ACParser.MINUSMINUS:
                return new Value(left.asDouble() - 1);

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
                return new Value(left.asDouble() < right.asDouble());
            case ACParser.LTEQ:
                return new Value(left.asDouble() <= right.asDouble());
            case ACParser.GT:
                return new Value(left.asDouble() > right.asDouble());
            case ACParser.GTEQ:
                return new Value(left.asDouble() >= right.asDouble());
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
                        new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                        new Value(left.equals(right));
            case ACParser.NEQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                        new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + ACParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(ACParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(ACParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
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
    	Value valueStart = this.visit(ctx.expr(0));
    	HeapMem.put(id, valueStart);
        
    	
        Value valueCondition = this.visit(ctx.expr(1));
        Value valueEnd = this.visit(ctx.expr(2));

        while (valueCondition.asBoolean()) {
        	// evaluate the code block
            this.visit(ctx.stat_block());
           
            //valueStart = this.visit(ctx.assignment());
            valueEnd = this.visit(ctx.expr(2));
            valueStart = valueEnd;
            Value newValue = new Value(valueStart.asDouble());
            HeapMem.put(id, newValue);
            valueCondition = this.visit(ctx.expr(1));
            newValue = null;
        }
        return Value.VOID;
    }
    
    @Override
    public Value visitSend_stat(ACParser.Send_statContext ctx) {
    	String port = ctx.ID(0).getText();
    	String msg = ctx.ID(1).getText();
    	Value data = this.visit(ctx.expr());
    	
    	SendMessage sendMsg = new SendMessage(port,msg, data, null);
    	listPortMsg.add(sendMsg);
    	
    	return data;
    }
    
    @Override
    public Value visitSendat_stat(ACParser.Sendat_statContext ctx) {
    	String port = ctx.ID(0).getText();
    	String msg = ctx.ID(1).getText();
    	Value data = this.visit(ctx.expr(0));
    	Value dest = new Value(0);

    	if (ctx.getText().contains("msg->sapIndex0_")){
    		dest = new Value("msg->sapIndex0_");
    	}else	
    		dest = this.visit(ctx.expr(1));
    	
    	SendMessage sendMsg = new SendMessage(port,msg, data, dest);
    	listPortMsg.add(sendMsg);
    	
    	return data;
    }
    
    @Override
    public Value visitShowHeapMem(ACParser.ShowHeapMemContext ctx){
    	

		System.out.println("=====================[HeapMem]=================");
		for (Entry<String, Value> entry : HeapMem.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value: "+ entry.getValue().toString());
		}
		return new Value(0);
    	
    }
    
    @Override
    public Value visitShowListSendMsg(ACParser.ShowListSendMsgContext ctx){
    	System.out.println("=====================[listPortMsg]=================");
		for (SendMessage portMsg : listPortMsg) {
			System.out.println(portMsg.allDataToString());
		}
		return new Value(0);
    	
    }
    

	
}

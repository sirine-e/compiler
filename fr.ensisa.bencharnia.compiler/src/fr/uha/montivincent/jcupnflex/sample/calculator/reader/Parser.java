
//----------------------------------------------------
// The following code was generated by jh-javacup-1.3 20240325
// Fri Apr 25 09:05:30 CEST 2025
//----------------------------------------------------

package fr.uha.montivincent.jcupnflex.sample.calculator.reader;

import fr.uha.montivincent.jcupnflex.sample.calculator.TomlModel;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/** jh-javacup-1.3 20240325 generated parser.
  * @version Fri Apr 25 09:05:30 CEST 2025
  */
public class Parser extends com.github.jhoenicke.javacup.runtime.LRParser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(com.github.jhoenicke.javacup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(com.github.jhoenicke.javacup.runtime.Scanner s, com.github.jhoenicke.javacup.runtime.SymbolFactory sf) {super(s,sf);}
  /** The static parse table */
  static com.github.jhoenicke.javacup.runtime.ParseTable CUP$parse_table =
    new com.github.jhoenicke.javacup.runtime.ParseTable(new String[] {
    "\074\000\002\012\002\004\004\000\005\000\005" +
    "\000\001\006\003\014\002\005\002\016\002\003" +
    "\001\002\002\002\003\002\004\001\003\001\001" +
    "\010\001\010\002\010\002\010\001\010\002\010" +
    "\002\010\001\020\000\013\000\013\002\015\000" +
    "\015\002\017\000\017\002\063\077\u0157\u014d\u017d" +
    "\153\u0143\225\u014f\277\323\063\105\u0105\261\177" +
    "\u0145\211\165\073\323\157\u0149\325\145\131\273" +
    "\113\103\u013d\u0139\u0129\155\275\u0133\065\363\u0125" +
    "\357\u0123\u0115\223\u010f\171\u0101\u0109\365\243\141" +
    "\361\073\231\u01a7\000\000\000\000\000\000\000" +
    "\000\000\000\000\000\000\000\000\000\000\000" +
    "\000\000\000\000\000\000\000\000\000\000\000" +
    "\000\000\000\000\000\000\000\000\000\000\000" +
    "\000\000\000\000\000\000\000\000\000\000\000" +
    "\063\001\012\072\042\012\012\072\042\012\022" +
    "\036\012\003\000\072\012\005\000\072\013\002" +
    "\061\004\000\003\033\117\000\005\012\072\061" +
    "\004\032\111\012\072\012\072\030\072\000\072" +
    "\030\072\033\121\000\072\000\072\027\072\032" +
    "\113\027\072\004\027\057\064\024\024\037\016" +
    "\024\024\030\072\057\064\021\061\030\072\030" +
    "\072\016\074\027\072\016\074\052\133\027\072" +
    "\027\072\024\024\020\057\052\135\024\024\024" +
    "\024\006\026\050\046\006\026\016\074\062\034" +
    "\050\046\016\074\016\074\062\034\050\127\050" +
    "\046\056\060\056\063\062\034\006\017\050\131" +
    "\015\051\006\017\006\017\056\065\056\067\056" +
    "\060\056\071\031\060\031\063\056\073\040\020" +
    "\010\041\040\020\040\020\040\020\031\065\031" +
    "\067\031\060\031\071\023\060\023\063\031\073" +
    "\026\070\011\043\026\070\026\070\026\070\023" +
    "\065\023\067\023\060\023\071\045\044\060\032" +
    "\023\073\055\006\045\044\060\032\043\062\055" +
    "\006\045\127\045\044\060\032\043\062\055\006" +
    "\054\030\045\131\060\145\051\046\054\030\014" +
    "\047\047\052\051\046\053\141\054\030\047\052" +
    "\063\001\051\046\046\044\044\054\047\052\036" +
    "\056\046\044\044\054\041\010\036\056\041\010" +
    "\046\044\044\054\035\042\036\056\034\050\005" +
    "\014\035\042\005\014\034\050\063\001\063\001" +
    "\035\042\017\022\034\050\017\022\017\022\017" +
    "\053\007\066\063\001\007\066\007\066\007\066" +
    "\025\101\063\001\002\017\025\101\025\101\002" +
    "\017\002\017\001\017\063\001\063\001\001\017" +
    "\001\017\003\040\063\001\003\025\063\001\063" +
    "\001\063\001\063\001\063\001\063\001\063\001" +
    "\063\001\063\001\063\001\063\001\063\001\063" +
    "\001\063\001\063\001\063\001\063\001\076\021" +
    "\050\004\051\046\001\057\031\040\011\015\007" +
    "\057\003\022\023\005\003\004\043\005\001\042" +
    "\042\023\040\002\001\006\036\052\026\006\061" +
    "\006\023\036\041\017\036\043\033\002\037\001" +
    "\010\031\007\033\006\001\033\014\015\007\001" +
    "\001\001\001\001\001\016"
    });

  /** Return parse table */
  protected com.github.jhoenicke.javacup.runtime.ParseTable parse_table() {
    return CUP$parse_table;
  }

  /** Instance of action encapsulation class. */
  protected Action$ action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new Action$(this);
    }

  /** Invoke a user supplied parse action. */
  public com.github.jhoenicke.javacup.runtime.Symbol do_action(
    int                        act_num,
    java.util.ArrayList<com.github.jhoenicke.javacup.runtime.Symbol> stack)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$do_action(act_num, stack);
  }





    private static TomlModel model = new TomlModel();
    
    public void report_error(String message, Object info) {
        StringBuffer m = new StringBuffer("Error");
        m.append(info.toString());
        m.append(" : "+message);
        System.err.println(m.toString());
    }
   
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }
    
    public void setValue(String name, int value) {
        model.putValue(name, value);
    }
    
    public int getValue(String name) {
        Object val = model.getValue(name);
        return val instanceof Integer ? (Integer)val : 0;
    }




/** Cup generated class to encapsulate user supplied action code.*/
static class Action$ {
  private final Parser parser;

  /** Constructor */
  Action$(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  @SuppressWarnings({ "unused", "unchecked" })
  public final com.github.jhoenicke.javacup.runtime.Symbol CUP$do_action(
    int                        CUP$act_num,
    java.util.ArrayList<com.github.jhoenicke.javacup.runtime.Symbol> CUP$stack)
    throws java.lang.Exception
    {
      /* Stack size for peeking into the stack */
      int CUP$size = CUP$stack.size();

      /* select the action based on the action number */
      switch (CUP$act_num)
        {
          // $START ::= program EOF 
          case 0:
            {
              Object RESULT;
RESULT = null;
/* ACCEPT */
parser.done_parsing();
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$START, CUP$stack.get(CUP$size - 2), CUP$stack.get(CUP$size - 1), RESULT);
            }

          // $parenthesis1 ::= __REGEXP_7__ value 
          case 1:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol p$ = CUP$stack.get(CUP$size - 1);
              Object p = (Object) p$.value;
  	RESULT = p;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis1, CUP$stack.get(CUP$size - 2), p$, RESULT);
            }

          // array ::= __REGEXP_1__ value $parenthesis1$0_many __REGEXP_2__ 
          case 2:
            {
              List<Object> RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol list$ = CUP$stack.get(CUP$size - 2);
              java.util.List<Object> list = (java.util.List<Object>) list$.value;
              com.github.jhoenicke.javacup.runtime.Symbol first$ = CUP$stack.get(CUP$size - 3);
              Object first = (Object) first$.value;
 
														list.add(0, first);
														RESULT = list;
													 
              return parser.getSymbolFactory2().newSymbol(ENonterminal.array, CUP$stack.get(CUP$size - 4), CUP$stack.get(CUP$size - 1), RESULT);
            }

          // block ::= __REGEXP_1__ key __REGEXP_2__ EOLN list 
          case 3:
            {
              com.github.jhoenicke.javacup.runtime.Symbol list$ = CUP$stack.get(CUP$size - 1);
              List<Map<String,Object>> list = (List<Map<String,Object>>) list$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n$ = CUP$stack.get(CUP$size - 4);
              List<String> n = (List<String>) n$.value;
  
														model.enterContext(n,false); 
										                for (Map<String,Object> item : list) {
										                    model.putAll(item);
										                }
										                model.exitContext();
										                //System.out.println(model.toJson());
													 
              return parser.getSymbolFactory2().newSymbol(ENonterminal.block, CUP$stack.get(CUP$size - 5), list$);
            }

          // block ::= __REGEXP_3__ key __REGEXP_4__ EOLN list 
          case 4:
            {
              com.github.jhoenicke.javacup.runtime.Symbol list$ = CUP$stack.get(CUP$size - 1);
              List<Map<String,Object>> list = (List<Map<String,Object>>) list$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n$ = CUP$stack.get(CUP$size - 4);
              List<String> n = (List<String>) n$.value;
  
														model.enterContext(n,true);
										                for (Map<String,Object> item : list) {
										                    model.putAll(item);
										                }
										                model.exitContext();
										                //System.out.println(model.toJson());
													 
              return parser.getSymbolFactory2().newSymbol(ENonterminal.block, CUP$stack.get(CUP$size - 5), list$);
            }

          // block ::= list 
          case 5:
            {
              com.github.jhoenicke.javacup.runtime.Symbol list$ = CUP$stack.get(CUP$size - 1);
              List<Map<String,Object>> list = (List<Map<String,Object>>) list$.value;
  
														if (model.isAtRoot()) {
													        for (Map<String,Object> i : list) {
													            model.putAll(i);
													        }
													    }
									                    //System.out.println(model.toJson());
													 
              return parser.getSymbolFactory2().newSymbol(ENonterminal.block, list$, list$);
            }

          // instr ::= key __REGEXP_5__ value 
          case 6:
            {
              Map<String,Object> RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol e$ = CUP$stack.get(CUP$size - 1);
              Object e = (Object) e$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n$ = CUP$stack.get(CUP$size - 3);
              List<String> n = (List<String>) n$.value;
  								
														Map<String,Object> ret = new HashMap<>();
										                model.putValue(n, e);
										                Map<String, Object> current = ret;

														for (int i = 0; i < n.size(); i++) {
														    String key = n.get(i);
														    if (i == n.size() - 1) {
														        current.put(key, e);
														    } else {
														        Map<String, Object> newMap = new HashMap<>();
														        current.put(key, newMap);
														        current = newMap;
														    }
														}
														
														RESULT = ret;
													 
              return parser.getSymbolFactory2().newSymbol(ENonterminal.instr, n$, e$, RESULT);
            }

          // $parenthesis2 ::= __REGEXP_6__ key_expr 
          case 7:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol p$ = CUP$stack.get(CUP$size - 1);
              Object p = (Object) p$.value;
  	RESULT = p.toString();  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis2, CUP$stack.get(CUP$size - 2), p$, RESULT);
            }

          // key ::= key_expr $parenthesis2$0_many 
          case 8:
            {
              List<String> RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol list$ = CUP$stack.get(CUP$size - 1);
              java.util.List<Object> list = (java.util.List<Object>) list$.value;
              com.github.jhoenicke.javacup.runtime.Symbol first$ = CUP$stack.get(CUP$size - 2);
              Object first = (Object) first$.value;
 
														list.add(0, first.toString());
														List<String> resultList = new ArrayList<String>();
														for (Object obj : list) resultList.add(obj.toString());
														RESULT = resultList;
													 
              return parser.getSymbolFactory2().newSymbol(ENonterminal.key, first$, list$, RESULT);
            }

          // $parenthesis3 ::= instr EOLN 
          case 9:
            {
              Map<String,Object> RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol i$ = CUP$stack.get(CUP$size - 2);
              Map<String,Object> i = (Map<String,Object>) i$.value;
  RESULT=i;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis3, i$, CUP$stack.get(CUP$size - 1), RESULT);
            }

          // list ::= $parenthesis3$0_many 
          case 10:
            {
              List<Map<String,Object>> RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol l$ = CUP$stack.get(CUP$size - 1);
              java.util.List<Map<String,Object>> l = (java.util.List<Map<String,Object>>) l$.value;
  RESULT=l;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.list, l$, l$, RESULT);
            }

          // num_expr ::= NUMBER EXPO 
          case 11:
            {
              Double RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol e$ = CUP$stack.get(CUP$size - 1);
              String e = (String) e$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n1$ = CUP$stack.get(CUP$size - 2);
              Double n1 = (Double) n1$.value;
  RESULT = Double.parseDouble(new java.math.BigDecimal(n1).toPlainString() + e);  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.num_expr, n1$, e$, RESULT);
            }

          // num_expr ::= NUMBER __REGEXP_6__ NUMBER 
          case 12:
            {
              Double RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol n2$ = CUP$stack.get(CUP$size - 1);
              Double n2 = (Double) n2$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n1$ = CUP$stack.get(CUP$size - 3);
              Double n1 = (Double) n1$.value;
  RESULT = Double.parseDouble(new java.math.BigDecimal(n1).toPlainString() + "." + new java.math.BigDecimal(n2).toPlainString());   
              return parser.getSymbolFactory2().newSymbol(ENonterminal.num_expr, n1$, n2$, RESULT);
            }

          // num_expr ::= NUMBER __REGEXP_6__ NUMBER EXPO 
          case 13:
            {
              Double RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol e$ = CUP$stack.get(CUP$size - 1);
              String e = (String) e$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n2$ = CUP$stack.get(CUP$size - 2);
              Double n2 = (Double) n2$.value;
              com.github.jhoenicke.javacup.runtime.Symbol n1$ = CUP$stack.get(CUP$size - 4);
              Double n1 = (Double) n1$.value;
  RESULT = Double.parseDouble(new java.math.BigDecimal(n1).toPlainString() + "." + new java.math.BigDecimal(n2).toPlainString() + e);  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.num_expr, n1$, e$, RESULT);
            }

          // program ::= block EOLN program 
          case 14:
            {
              return parser.getSymbolFactory2().newSymbol(ENonterminal.program, CUP$stack.get(CUP$size - 3), CUP$stack.get(CUP$size - 1));
            }

          // program ::= block 
          case 15:
            {
  System.out.println(model.toJson());  
              com.github.jhoenicke.javacup.runtime.Symbol CUP$sym = CUP$stack.get(CUP$size - 1);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.program, CUP$sym, CUP$sym);
            }

          // value ::= TEXT 
          case 16:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol n$ = CUP$stack.get(CUP$size - 1);
              String n = (String) n$.value;
  RESULT=n;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, n$, n$, RESULT);
            }

          // value ::= __REGEXP_8__ num_expr 
          case 17:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol e$ = CUP$stack.get(CUP$size - 1);
              Double e = (Double) e$.value;
  RESULT = - e;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, CUP$stack.get(CUP$size - 2), e$, RESULT);
            }

          // value ::= __REGEXP_9__$0_1 num_expr 
          case 18:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol e$ = CUP$stack.get(CUP$size - 1);
              Double e = (Double) e$.value;
  RESULT = + e;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, CUP$stack.get(CUP$size - 2), e$, RESULT);
            }

          // value ::= BOOL 
          case 19:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol e$ = CUP$stack.get(CUP$size - 1);
              String e = (String) e$.value;
  if (e.equals("true")) RESULT=true; else RESULT=false;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, e$, e$, RESULT);
            }

          // value ::= __REGEXP_9__$0_1 __REGEXP_10__ 
          case 20:
            {
              Object RESULT;
  RESULT = new Double(Double.POSITIVE_INFINITY);  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, CUP$stack.get(CUP$size - 2), CUP$stack.get(CUP$size - 1), RESULT);
            }

          // value ::= __REGEXP_8__ __REGEXP_10__ 
          case 21:
            {
              Object RESULT;
  RESULT = new Double(Double.NEGATIVE_INFINITY);  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, CUP$stack.get(CUP$size - 2), CUP$stack.get(CUP$size - 1), RESULT);
            }

          // value ::= array 
          case 22:
            {
              Object RESULT;
              com.github.jhoenicke.javacup.runtime.Symbol n$ = CUP$stack.get(CUP$size - 1);
              List<Object> n = (List<Object>) n$.value;
  RESULT=n;  
              return parser.getSymbolFactory2().newSymbol(ENonterminal.value, n$, n$, RESULT);
            }

          // __REGEXP_9__$0_1 ::= 
          case 23:
            {
              com.github.jhoenicke.javacup.runtime.Symbol CUP$sym = CUP$stack.get(CUP$size - 1);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.__REGEXP_9__$0_1, CUP$sym, CUP$sym);
            }

          // $parenthesis1$0_many ::= 
          case 24:
            {
              java.util.ArrayList<Object> RESULT = new java.util.ArrayList<Object>();
              com.github.jhoenicke.javacup.runtime.Symbol CUP$sym = CUP$stack.get(CUP$size - 1);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis1$0_many, CUP$sym, CUP$sym, RESULT);
            }

          // $parenthesis1$0_many ::= $parenthesis1$0_many $parenthesis1 
          case 25:
            {
              com.github.jhoenicke.javacup.runtime.Symbol CUP$1 = CUP$stack.get(CUP$size - 1);
              com.github.jhoenicke.javacup.runtime.Symbol CUP$0 = CUP$stack.get(CUP$size - 2);
              java.util.ArrayList<Object> RESULT = (java.util.ArrayList<Object>) CUP$0.value;
              RESULT.add((Object) CUP$1.value);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis1$0_many, CUP$0, CUP$1, RESULT);
            }

          // $parenthesis2$0_many ::= 
          case 26:
            {
              java.util.ArrayList<Object> RESULT = new java.util.ArrayList<Object>();
              com.github.jhoenicke.javacup.runtime.Symbol CUP$sym = CUP$stack.get(CUP$size - 1);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis2$0_many, CUP$sym, CUP$sym, RESULT);
            }

          // $parenthesis2$0_many ::= $parenthesis2$0_many $parenthesis2 
          case 27:
            {
              com.github.jhoenicke.javacup.runtime.Symbol CUP$1 = CUP$stack.get(CUP$size - 1);
              com.github.jhoenicke.javacup.runtime.Symbol CUP$0 = CUP$stack.get(CUP$size - 2);
              java.util.ArrayList<Object> RESULT = (java.util.ArrayList<Object>) CUP$0.value;
              RESULT.add((Object) CUP$1.value);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis2$0_many, CUP$0, CUP$1, RESULT);
            }

          // $parenthesis3$0_many ::= 
          case 28:
            {
              java.util.ArrayList<Map<String,Object>> RESULT = new java.util.ArrayList<Map<String,Object>>();
              com.github.jhoenicke.javacup.runtime.Symbol CUP$sym = CUP$stack.get(CUP$size - 1);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis3$0_many, CUP$sym, CUP$sym, RESULT);
            }

          // $parenthesis3$0_many ::= $parenthesis3$0_many $parenthesis3 
          case 29:
            {
              com.github.jhoenicke.javacup.runtime.Symbol CUP$1 = CUP$stack.get(CUP$size - 1);
              com.github.jhoenicke.javacup.runtime.Symbol CUP$0 = CUP$stack.get(CUP$size - 2);
              java.util.ArrayList<Map<String,Object>> RESULT = (java.util.ArrayList<Map<String,Object>>) CUP$0.value;
              RESULT.add((Map<String,Object>) CUP$1.value);
              return parser.getSymbolFactory2().newSymbol(ENonterminal.$parenthesis3$0_many, CUP$0, CUP$1, RESULT);
            }

          /* . . . . . .*/
          default:
            throw new InternalError(
               "Invalid action number found in internal parse table");

        }
    }
}

}

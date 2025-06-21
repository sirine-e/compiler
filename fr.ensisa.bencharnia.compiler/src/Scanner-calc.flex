
%%

%package fr.uha.montivincent.jcupnflex.sample.calculator.reader
%class Lexer
%public 
%cupJHMH 


%{

    private Symbol fallback () {
    	return symbol(ETerminal.OOA);
		//throw new Error("Unrecognized character '"+yytext()+"' -- ignored");
	}    

%}



%%

<YYINITIAL> {
  "+"		{ return symbol(ETerminal.__REGEXP_9__); }
  ","		{ return symbol(ETerminal.__REGEXP_7__); }
  "-"		{ return symbol(ETerminal.__REGEXP_8__); }
  "."		{ return symbol(ETerminal.__REGEXP_6__); }
  "="		{ return symbol(ETerminal.__REGEXP_5__); }
  "["		{ return symbol(ETerminal.__REGEXP_1__); }
  "[["		{ return symbol(ETerminal.__REGEXP_3__); }
  "]"		{ return symbol(ETerminal.__REGEXP_2__); }
  "]]"		{ return symbol(ETerminal.__REGEXP_4__); }
  "inf"		{ return symbol(ETerminal.__REGEXP_10__); }
  "nan"		{  return symbol(ETerminal.NUMBER, new Double(Double.NaN));  }
  "true"		{ return symbol(ETerminal.BOOL, yytext()); }
  "false"		{ return symbol(ETerminal.BOOL, yytext()); }
  [ \t\f]		{  }
  \r\n|\r|\n		{ return symbol(ETerminal.EOLN); }
  0b[01]+		{  double doubleValue = (double) Long.parseLong(new String(zzBuffer, zzStartRead + 2, zzMarkedPos - zzStartRead - 2), 2);return symbol(ETerminal.NUMBER, new Double(doubleValue));  }
  0o[0-7]+		{  double doubleValue = (double) Long.parseLong(new String(zzBuffer, zzStartRead + 2, zzMarkedPos - zzStartRead - 2), 8);return symbol(ETerminal.NUMBER, new Double(doubleValue));  }
  0x[a-fA-F0-9]+		{  double doubleValue = (double) Long.parseUnsignedLong(new String(zzBuffer, zzStartRead+2, zzMarkedPos-zzStartRead-2),16);return symbol (ETerminal.NUMBER, new Double(doubleValue));  }
  '[^'\n]*'		{  return symbol (ETerminal.TEXT, new String( zzBuffer, zzStartRead+1, zzMarkedPos-zzStartRead-2 ));  }
  [^\"]?#.*		{  }
  [eE][+-]?[0-9]+		{  return symbol(ETerminal.EXPO, new String(zzBuffer,zzStartRead, zzMarkedPos-zzStartRead));  }
  '''([\s\S]*?)'''		{  return symbol (ETerminal.TEXT, new String( zzBuffer, zzStartRead+4, zzMarkedPos-zzStartRead-7));  }
  \"\"\"([\s\S]*?)\"\"\"		{  return symbol (ETerminal.TEXT, new String( zzBuffer, zzStartRead+4, zzMarkedPos-zzStartRead-7));  }
  [A-Za-z_][A-Za-z0-9_-]*		{ return symbol(ETerminal.ID, yytext()); }
  [0-9]+("_"[0-9]+)*		{  return symbol(ETerminal.NUMBER, new Double(Double.parseDouble(new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead).replace("_", ""))));  }
  \"([^\"\n\\]*(\\.[^\"\n\\]*)*)\"		{  return symbol (ETerminal.TEXT, new String( zzBuffer, zzStartRead+1, zzMarkedPos-zzStartRead-2 ));  }
}


[^]			 { return fallback(); }


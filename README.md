# TOML to JSON translator

## Features : 

<ins>Key syntax:</ins>
 - simple keys ( bare_key = "value" )
 - quoted keys ( 'quoted' = 'val' )
 - dotted keys ( abc.val.new = 4 )
 - dotted quoted ( site.'google'.com = true )
 - numeric keys ( 3.14159 = "pi" )
 	
<ins>Value types:</ins>
 - string : single quote, double quotes, multi line, ...
 - number : int, float, nan, inf, underscore separated
     hexa, octa, binary
     ( all converted to Double by the parser )
 - boolean : true, false 
 - arrays : simple [ 1, 2 ] and nested [ [1,2], ['a','b'] ]
 	
<ins>Table support:</ins>
 - regular tables [ general ]
 - dotted tables [ gen.gen2 ]
 - double tables [[ table ]]
  	
<ins>Special:</ins>
 - inline comments with # ...
 - key value pairs with same key (last one kept)
 - key cannot start with number 11A = "hello" 
  

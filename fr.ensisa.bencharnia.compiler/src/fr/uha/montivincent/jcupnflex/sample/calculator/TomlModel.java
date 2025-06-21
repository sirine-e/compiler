package fr.uha.montivincent.jcupnflex.sample.calculator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TomlModel {
	private final Stack<TreeMap<String, Object>> contextStack;
    
    public TomlModel() {
        this.contextStack = new Stack<>();
        this.contextStack.push(new TreeMap<>());
    }

    public void enterContext(List<String> path, boolean isArray) {
    	// Start from root context
        while (contextStack.size() > 1) {
            contextStack.pop();
        }
        
        // Navigate or create the full path
        for (String key : path) {
            Object current = contextStack.peek().get(key);
            
            if (isArray) {
                if (!(current instanceof List)) {
                    current = new ArrayList<Map<String, Object>>();
                    contextStack.peek().put(key, current);
                }
                List<Map<String, Object>> array = (List<Map<String, Object>>) current;
                if (array.isEmpty()) {
                    array.add(new TreeMap<String, Object>());
                }
                contextStack.push((TreeMap<String, Object>) array.get(array.size() - 1));
            } else {
                if (!(current instanceof TreeMap)) {
                    current = new TreeMap<String, Object>();
                    contextStack.peek().put(key, current);
                }
                contextStack.push((TreeMap<String, Object>) current);
            }
        }
    }
    
    public boolean isAtRoot() {
        return contextStack.size() == 1;
    }

    public void exitContext() {
    	// Only keep root context
        while (contextStack.size() > 1) {
            contextStack.pop();
        }    
    }

    public void putValue(String key, Object value) {
    	contextStack.peek().put(key, value);
    }
    
    private List<String> parseKey(String keyStr) {
    	List<String> keys = new ArrayList<>();
        boolean inQuotes = false;
        boolean inSingleQuotes = false;
        StringBuilder currentKey = new StringBuilder();
        
        for (int i = 0; i < keyStr.length(); i++) {
            char c = keyStr.charAt(i);
            
            if (c == '"' && !inSingleQuotes) {
                inQuotes = !inQuotes;
                // Only add the quote if we're inside quotes
                if (inQuotes || (i > 0 && keyStr.charAt(i-1) == '"')) {
                    currentKey.append(c);
                }
            } else if (c == '\'' && !inQuotes) {
                inSingleQuotes = !inSingleQuotes;
                // Only add the quote if we're inside quotes
                if (inSingleQuotes || (i > 0 && keyStr.charAt(i-1) == '\'')) {
                    currentKey.append(c);
                }
            } else if (c == '.' && !inQuotes && !inSingleQuotes) {
                // Only split on dots that aren't inside quotes
                String key = currentKey.toString().trim();
                if (!key.isEmpty()) {
                    keys.add(key);
                }
                currentKey = new StringBuilder();
            } else {
                currentKey.append(c);
            }
        }
        
        // Add the last key segment
        String lastKey = currentKey.toString().trim();
        if (!lastKey.isEmpty()) {
            keys.add(lastKey);
        }
        
        return keys;
    }
    
    private Object parseValue(String valueStr) {
        valueStr = valueStr.trim();
        
        // Handle strings
        if (valueStr.startsWith("\"") || valueStr.startsWith("'")) {
            return valueStr.substring(1, valueStr.length() - 1);
        }
        
        // Handle multiline strings
        if (valueStr.startsWith("\"\"\"") || valueStr.startsWith("'''")) {
            return valueStr.substring(3, valueStr.length() - 3).trim();
        }
        
        // Handle booleans
        if (valueStr.equalsIgnoreCase("true")) return true;
        if (valueStr.equalsIgnoreCase("false")) return false;
        
        // Handle numbers
        try {
            if (valueStr.contains("_")) {
                valueStr = valueStr.replace("_", "");
            }
            
            if (valueStr.startsWith("0x")) {
                return Long.parseLong(valueStr.substring(2), 16);
            } else if (valueStr.startsWith("0o")) {
                return Long.parseLong(valueStr.substring(2), 8);
            } else if (valueStr.startsWith("0b")) {
                return Long.parseLong(valueStr.substring(2), 2);
            } else if (valueStr.contains(".") || valueStr.toLowerCase().contains("e")) {
                return Double.parseDouble(valueStr);
            } else {
                return Long.parseLong(valueStr);
            }
        } catch (NumberFormatException e) {
            // Not a number, return as string
            return valueStr;
        }
    }
    
    public void putAll(Map<String, Object> map) {
    	for (Map.Entry<String, Object> entry : map.entrySet()) {
            List<String> keys = parseKey(entry.getKey());
            putValue(keys, entry.getValue());
        }
    }

    public Object getValue(String key) {
        return contextStack.peek().get(key);
    }

    public void putValue(List<String> keys, Object value) {
        if (keys.isEmpty()) return;
        
        String currentKey = keys.get(0);
        if (keys.size() == 1) {
            putValue(currentKey, value);
            return;
        }
        
        if (!(contextStack.peek().get(currentKey) instanceof TreeMap)) {
            putValue(currentKey, new TreeMap<>());
        }
        
        TreeMap<String, Object> nestedMap = (TreeMap<String, Object>) contextStack.peek().get(currentKey);
        contextStack.push(nestedMap);
        putValue(keys.subList(1, keys.size()), value);
        contextStack.pop();
    }

    public void addArray(List<String> keys, List<Object> values) {
    	if (keys.isEmpty()) return;
        
        if (keys.size() == 1) {
            // Replace existing array completely
        	contextStack.peek().put(keys.get(0), new ArrayList<>(values));
        } else {
            // Handle nested path
            String currentKey = keys.get(0);
            List<String> remainingKeys = keys.subList(1, keys.size());
            
            if (!(contextStack.peek().get(currentKey) instanceof TreeMap)) {
                putValue(currentKey, new TreeMap<>());
            }
            
            TreeMap<String, Object> nestedMap = (TreeMap<String, Object>) contextStack.peek().get(currentKey);
            contextStack.push(nestedMap);
            addArray(remainingKeys, values);
            contextStack.pop();
        }
    }
    

    public String toJson() {
        return convertToJson(contextStack.firstElement(), 0);
    }
    
    private String convertToJson(Object value, int indent) {
	    StringBuilder sb = new StringBuilder();
	    String indentation = "  ".repeat(indent);
	
	    if (value instanceof Map) {
	        Map<?, ?> map = (Map<?, ?>) value;
	        sb.append("{\n");
	        boolean first = true;
	        
	        for (Entry<?, ?> entry : map.entrySet()) {
	            if (!first) sb.append(",\n");
	            first = false;
	            
	            sb.append(indentation).append("  \"")
	              .append(escapeJsonString(entry.getKey().toString()))
	              .append("\": ")
	              .append(convertToJson(entry.getValue(), indent + 1));
	        }
	        
	        sb.append("\n").append(indentation).append("}");
	    } else if (value instanceof List) {
	        List<?> list = (List<?>) value;
	        sb.append("[\n");
	        boolean first = true;
	        
	        for (Object item : list) {
	            if (!first) sb.append(",\n");
	            first = false;
	            
	            sb.append(indentation).append("  ")
	              .append(convertToJson(item, indent + 1));
	        }
	        
	        sb.append("\n").append(indentation).append("]");
	    } else if (value instanceof String) {
	        sb.append("\"").append(escapeJsonString((String) value)).append("\"");
	    } else if (value instanceof Number || value instanceof Boolean) {
	        sb.append(value);
	    } else if (value == null) {
	        sb.append("null");
	    } else {
	        sb.append("\"").append(escapeJsonString(value.toString())).append("\"");
	    }
	
	    return sb.toString();
    }

    private String escapeJsonString(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '"': sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\b': sb.append("\\b"); break;
                case '\f': sb.append("\\f"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                default:
                    if (c <= 0x1F) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }

}

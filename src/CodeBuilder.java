import java.util.LinkedHashMap;
import java.util.Map;

public class CodeBuilder {

	private String className;
    private Map<String, String> memberNameToType = new LinkedHashMap<String, String>();
    public CodeBuilder(String className)
    {
        this.className = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
        memberNameToType.put(name, type);
        return this;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("public class " + className + "\n{");
    	for (Map.Entry<String, String> entry : memberNameToType.entrySet()) {
    		sb.append("\n");
			sb.append("  public "+ entry.getValue()+ " " + entry.getKey()+";");
		}
    	sb.append("\n}");
    	
		return sb.toString();
        
    }
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb.toString());

	}

}

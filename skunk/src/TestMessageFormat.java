import java.text.MessageFormat;

import com.sun.xml.internal.ws.util.StringUtils;


public class TestMessageFormat {

	public TestMessageFormat() {
		// TODO Auto-generated constructor stub
	}
	private static final String linkFormat = "integration/displayEntity?entityType={0}&repositoryAlias={1}&entityId={2}&entityName={3}";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String link = MessageFormat.format(linkFormat, "SESSION", "WORKREP", "121,4,5","procedure");
	System.out.println(link);
	
	
	System.out.println(getRepositoryAlias(linkFormat));
	}

	
    private static String getRepositoryAlias(String iDetailLink)
    {
        String aRepositoryAlias = "";
        if (iDetailLink != null)
        {
        	aRepositoryAlias = iDetailLink.substring(iDetailLink.indexOf("repositoryAlias=")+16, iDetailLink.indexOf("&entityId"));
        }
        return aRepositoryAlias;
    } 
}

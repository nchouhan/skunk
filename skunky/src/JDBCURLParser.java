import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

public class JDBCURLParser {

	public static void main(String[] args) {
		// String url =

		// Syntax -
		// jdbc:oracle:driver_type:[username/password]@database_specifier
		// Url for instance connection
		String url1 = "jdbc:oracle:thin:@slc01ajl.us.oracle.com:11367:db6268";
		String url2 = "";
		// Url for Service Connection
		/*
		 * Sample
		 * jdbc:oracle:thin:[<user>/<password>]@//<host>[:<port>]/<service>
		 * jdbc:oracle:oci:[<user>/<password>]@//<host>[:<port>]/<service>
		 */
		String url3 = "jdbc:oracle:thin:@//myserver.com/customer_db";
		String pattern1 = "jdbc:oracle:thin:@//((\\w+)(:(\\w*))/(\\w+)";
		String url4 = "jdbc:oracle:oci:scott/tiger@//myserver.com:5521/customer_db";
		String url5 = "jdbc:oracle:thin:@ldap://ldap.example.com:7777/sales,cn=OracleContext,dc=com";

		// Cluster
		String url6 = "jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=on)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=host1) (PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=host2)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=service_name)))";
		String url7 = "jdbc:oracle:oci:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=cluster_alias)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=service_name)))";
		// IPV6
		String url8 = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=[2001:0db8:7654:3210:FEDC:BA98:7654:3210])(PORT=5521))(CONNECT_DATA=(SERVICE_NAME=sales.example.com))";

		parse1();
		// String cleanURI = url.substring(5);
		//
		// URI uri = URI.create(cleanURI);
		// System.out.println(uri.getScheme());
		// System.out.println(uri.getHost());
		// System.out.println(uri.getPort());
		// System.out.println(uri.getPath());
	}

	public enum DBType {
		DRIZZLE, MYSQL, ORACLE
	}

	public static void parse2(final String url) {
		String url1 = "abc.com.au.de:1678";
		// jdbc:oracle:thin:@//(\\w+)((.(\\w+))+):(\\d*)
		String pattern1 = "(\\w+[\\.\\w+]*):(\\w*)";

		final Pattern p = Pattern.compile(pattern1);
		final Matcher m = p.matcher(url1);
		if (m.find()) {
			for (int i = 1; i <= m.groupCount(); i++) {
				System.out.println(m.group(i));
			}

		}
	}

	private static void parse(String url, String pattern) {
		System.out.println("================PATTERN ========");
		System.out.println("PATTERN SIGNATURE :" + pattern);
		System.out.println("MATCHER STRING  :" + url);
		final Pattern p1 = Pattern.compile(pattern);
		final Matcher m1 = p1.matcher(url);
		if (m1.find()) {
			for (int i = 1; i <= m1.groupCount(); i++) {
				System.out.println("GroupNumber  :"+i+":         GroupValue    :"+m1.group(i));
			}
		}
	}

	public static void parse1() {
		String pattern5 = "jdbc[:]{0,1}([\\w+]*):(thin|oci|db2|mysql){0,1}:@{0,1}/{0,2}(\\w+[\\.\\w+]*):{0,1}([\\w+]*)[:|/|;]{0,1}([\\w+]*=){0,1}(\\w*)";
		//Oracle patterns 
		String url1 = "jdbc:oracle:thin:@slc01ajl.us.oracle.com:1123";
		String url2 = "jdbc:oracle:thin:@slc01ajl.us.oracle.com:11367:db6268";
		String url3 = "jdbc:oracle:thin:@//myserver.com.au:1678";
		String url4 = "jdbc:oracle:thin:@//myserver.com.au:1678/costomer_db";
		String url5 = "jdbc:oracle:thin:@//myserver.com.au/costomer_db";
		String url6 = "jdbc:oracle:oci:@//myserver.com.au/costomer_db";
		//db2 patterns
		String url17 = "jdbc:weblogic:db2://slc02pfl.us.oracle.com:50010;DatabaseName=orcl9143";
		String url18 = "jdbc:weblogic:db2://slc02pfl.us.oracle.com:50010:orcl9143";
		String url19 = "jdbc:weblogic:db2://slc02pfl.us.oracle.com:50010/orcl9143";
		String url20 = "jdbc:db2://slc02pfl.us.oracle.com:50010/orcl9143";
		String url21 = "jdbc:db2://slc02pfl.us.oracle.com:50010:orcl9143";
		String iJDBCUrl	= "jdbc:weblogic:db2://slc02pfl.us.oracle.com:50010;databaseName=orcl9143";
		String mysqljdbcUrl1	 = "jdbc:mysql://adc6140804.us.oracle.com:3306";
		
		parse(url4, pattern5);
		parse(url2, pattern5);
		parse(url1, pattern5);
		parse(url5, pattern5);
		parse(url6, pattern5);
		parse(url17, pattern5);
		parse(url18, pattern5);
		parse(url19, pattern5);
		parse(url20, pattern5);
		parse(url21, pattern5);
		parse(iJDBCUrl,pattern5);
		parse(mysqljdbcUrl1,pattern5);
	}

	public static void parse(final String url) {
		final DBType dbType;
		final String username;
		final String password;
		final String hostname;
		final int port;
		final String database;

		final Pattern p = Pattern
				.compile("^jdbc:(oracle|drizzle|mysql:thin)://((\\w+)(:(\\w*))?@)?([^/:]+)(:(\\d+))?(/(\\w+))?");
		final Matcher m = p.matcher(url);
		if (m.find()) {
			if (m.group(1).equals("mysql:thin")) {
				dbType = DBType.MYSQL;
			} else {
				dbType = DBType.DRIZZLE;
			}

			username = (m.group(3) == null ? "" : m.group(3));
			password = (m.group(5) == null ? "" : m.group(5));
			hostname = (m.group(6) == null ? "" : m.group(6));
			if (m.group(8) != null) {
				port = Integer.parseInt(m.group(8));
			} else {
				if (dbType == DBType.DRIZZLE) {
					port = 3306;
				} else {
					port = 3306;
				}
			}
			database = m.group(10);
			System.out.println("dbType" + dbType);
			System.out.println("username" + username);
			System.out.println("password" + password);
			System.out.println("hostname" + hostname);
			System.out.println("port" + port);
			System.out.println("database" + database);
			// return new JDBCUrl(dbType, username, password, hostname, port,
			// database);
		} else {
			// return null;
		}
	}
}

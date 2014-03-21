import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

public class Test {

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
		String urlmysql = "jdbc:sqlserver://adc6140804.us.oracle.com:50457;databasename=odi_repository";
		parse1(url3);
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
//		System.out.println("Group-3:"+m1.group(3));
//		System.out.println("Group-4:"+m1.group(4));
//		System.out.println("Group-6:"+m1.group(6));
		if (m1.find()) {
			for (int i = 1; i <= m1.groupCount(); i++) {
				System.out.println("Group - "+i+":"+m1.group(i));
			}
		}
	}

	public static void parse1(final String url) {
		String url1 = "jdbc:oracle:thin:@slc01ajl.us.oracle.com:1123";
		String url2 = "jdbc:oracle:thin:@slc01ajl.us.oracle.com:11367:db6268";
		String url3 = "jdbc:oracle:thin:@//myserver.com.au:1678";
		String url4 = "jdbc:oracle:thin:@//myserver.com.au:1678/costomer_db";
		// jdbc:oracle:thin:@//(\\w+)((.(\\w+))+):(\\d*)
		String pattern1 = "jdbc:oracle:thin:@(\\w+[\\.\\w+]*)([\\:\\w+]*)";
		String pattern2 = "jdbc:oracle:thin:@(\\w+[\\.\\w+]*)([\\:\\w+]*):(\\w+)";
		String pattern3 = "jdbc:oracle:thin:@//(\\w+[\\.\\w+]*)([\\:\\w+]*)";
		String pattern4 = "jdbc:oracle:thin:@//(\\w+[\\.\\w+]*)([\\:\\w+]*)/(\\w*)";
		//Combination of pattern2 and 4
//		String pattern5 = "(jdbc:oracle:thin):@/*(\\w+[\\.\\w+]*)([\\:\\w+]*)[:|/](\\w*)";
		String pattern5 = "jdbc:oracle:(thin|oci){1}:@/{0,2}(\\w+[\\.\\w+]*):{0,1}([\\w+]*)[:|/]{0,1}(\\w*)";
		String url5 = "jdbc:oracle:thin:@//myserver.com.au/costomer_db";
		String url6 = "jdbc:oracle:oci:@//myserver.com.au/costomer_db";
		String url7 = "jdbc:sqlserver://adc6140804.us.oracle.com:50457;databasename=odi_repository";
		String url8 = "jdbc:sqlserver://adc6140804.us.oracle.com:50457:odi_repository";

		
		
		String JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER = "jdbc[:]{0,1}([\\w+]*):(thin|oci|db2|mysql|sqlserver|microsoft_sqlserver_database){0,1}:@{0,1}/{0,2}(\\w+[\\.\\w+]*):{0,1}([\\w+]*)[:|/|;]{0,1}([\\w+]*=){0,1}(\\w*)"; 
		parse(url4, JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		parse(url2, JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		parse(url1, JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		parse(url5, JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		parse(url6, JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		parse(url7,JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		parse(url8,JDBC_URL_DB2_ORACLE_MYSQL_SQLSERVER);
		/*final DBType dbType;
		final String username;
		final String password;
		final String hostname;
		final int port;
		final String database;*/
		/*System.out.println("================PATTERN - 1========");
		System.out.println("PATTERN SIGNATURE :" + pattern1);
		System.out.println("MATCHER STRING  :" + url1);
		final Pattern p1 = Pattern.compile(pattern1);
		final Matcher m1 = p1.matcher(url1);
		if (m1.find()) {
			for (int i = 1; i <= m1.groupCount(); i++) {
				System.out.println(m1.group(i));
			}
		}
		System.out.println("================PATTERN - 2========");
		System.out.println("PATTERN SIGNATURE :" + pattern2);
		System.out.println("MATCHER STRING  :" + url2);
		final Pattern p2 = Pattern.compile(pattern2);
		final Matcher m2 = p2.matcher(url2);
		if (m2.find()) {
			for (int i = 1; i <= m2.groupCount(); i++) {
				System.out.println(m2.group(i));
			}
		}
		System.out.println("================PATTERN - 3========");
		System.out.println("PATTERN SIGNATURE :" + pattern3);
		System.out.println("MATCHER STRING  :" + url3);
		final Pattern p3 = Pattern.compile(pattern3);
		final Matcher m3 = p3.matcher(url3);
		if (m3.find()) {
			for (int i = 1; i <= m3.groupCount(); i++) {
				System.out.println(m3.group(i));
			}
		}
		System.out.println("================PATTERN - 4========");
		System.out.println("PATTERN SIGNATURE :" + pattern4);
		System.out.println("MATCHER STRING  :" + url4);
		final Pattern p4 = Pattern.compile(pattern4);
		final Matcher m4 = p4.matcher(url4);
		if (m4.find()) {
			for (int i = 1; i <= m4.groupCount(); i++) {
				System.out.println(m4.group(i));
			}
		}*/
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

package com.gnt.qxgl.common.util;

import java.beans.Introspector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;

import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HibernateTool{
	static public String savePath="c:/";
	static public String package_name = "com.gnt.qxgl.hz2004.entity";
	static public String interface_name = "java.io.Serializable";
	static public String parent_name = "";
	static public String schema="HZ2004";
	static public String dbconnection = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	static public String uid = "HZ2004";
	static public String pwd = "123456";
	static public String driver = "oracle.jdbc.driver.OracleDriver";
	static public String assigned = "";
	
	//<String,List<String>>
	static public Map keyData = new HashMap();
	static public Set<String> assignedSet = new HashSet<String>();
	//<String,String>
	static public Map tableCommons = new HashMap();	
	//字段注释，KEY=表名＋字段名<String,String>
	static public Map mComments = new HashMap();
	//<String,Vector<Vector<Object>>>: "字段名","数据类型","长度","精度","空值","主键","默认值"
	static public Map mData = new HashMap();
	static public boolean patternFlag=false;
	//要排除的表
	static public Set noSet = new HashSet();

	private static Set<String> RESERVED_KEYWORDS;
	static {
		RESERVED_KEYWORDS = new HashSet<String>();
		
		RESERVED_KEYWORDS.add( "abstract" );
		RESERVED_KEYWORDS.add( "continue" );
		RESERVED_KEYWORDS.add( "for" );
		RESERVED_KEYWORDS.add( "new" );
		RESERVED_KEYWORDS.add( "switch" );
		RESERVED_KEYWORDS.add( "assert" );
		RESERVED_KEYWORDS.add( "default" );
		RESERVED_KEYWORDS.add( "goto" );
		RESERVED_KEYWORDS.add( "package" );
		RESERVED_KEYWORDS.add( "synchronized" );
		RESERVED_KEYWORDS.add( "boolean" );
		RESERVED_KEYWORDS.add( "do" );
		RESERVED_KEYWORDS.add( "if" );
		RESERVED_KEYWORDS.add( "private" );
		RESERVED_KEYWORDS.add( "this" );
		RESERVED_KEYWORDS.add( "break" );
		RESERVED_KEYWORDS.add( "double" );
		RESERVED_KEYWORDS.add( "implements" );
		RESERVED_KEYWORDS.add( "protected" );
		RESERVED_KEYWORDS.add( "throw" );
		RESERVED_KEYWORDS.add( "byte" );
		RESERVED_KEYWORDS.add( "else" );
		RESERVED_KEYWORDS.add( "import" );
		RESERVED_KEYWORDS.add( "public" );
		RESERVED_KEYWORDS.add( "throws" );
		RESERVED_KEYWORDS.add( "case" );
		RESERVED_KEYWORDS.add( "enum" );
		RESERVED_KEYWORDS.add( "instanceof" );
		RESERVED_KEYWORDS.add( "return" );
		RESERVED_KEYWORDS.add( "transient" );
		RESERVED_KEYWORDS.add( "catch" );
		RESERVED_KEYWORDS.add( "extends" );
		RESERVED_KEYWORDS.add( "int" );
		RESERVED_KEYWORDS.add( "short" );
		RESERVED_KEYWORDS.add( "try" );
		RESERVED_KEYWORDS.add( "char" );
		RESERVED_KEYWORDS.add( "final" );
		RESERVED_KEYWORDS.add( "interface" );
		RESERVED_KEYWORDS.add( "static" );
		RESERVED_KEYWORDS.add( "void" );
		RESERVED_KEYWORDS.add( "class" );
		RESERVED_KEYWORDS.add( "finally" );
		RESERVED_KEYWORDS.add( "long" );
		RESERVED_KEYWORDS.add( "strictfp" );
		RESERVED_KEYWORDS.add( "volatile" );
		RESERVED_KEYWORDS.add( "const" );
		RESERVED_KEYWORDS.add( "float" );
		RESERVED_KEYWORDS.add( "native" );
		RESERVED_KEYWORDS.add( "super" );
		RESERVED_KEYWORDS.add( "while" );
	}
	
	private static boolean isReservedJavaKeyword(String str) {
		return RESERVED_KEYWORDS.contains(str);
	}
	
	public static String columnToPropertyName(String columnName) {
  		String decapitalize = Introspector.decapitalize(toUpperCamelCase(columnName) );
  		
  		return keywordCheck( decapitalize );
  	}
  
  	private static String keywordCheck(String possibleKeyword) {
  		if(isReservedJavaKeyword(possibleKeyword)) {
  			possibleKeyword = possibleKeyword + "_";
  		}
  		return possibleKeyword;
  	}
  	
	/**
	 * Converts a database name (table or column) to a java name (first letter capitalised). 
	 * employee_name -> EmployeeName.
	 *
	 * Derived from middlegen's dbnameconverter.
	 * @param s The database name to convert.
	 * 
	 * @return The converted database name.
	 */
	private static String toUpperCamelCase(String s) {
		if ( "".equals(s) ) {
			return s;
		}
		StringBuffer result = new StringBuffer();
		
		boolean capitalize = true;
		boolean lastCapital = false;
		boolean lastDecapitalized = false;
		String p = null;
		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i + 1);
			if ( "_".equals(c) || " ".equals(c) || "-".equals(c) ) {
				capitalize = true;
				continue;
			}
			
			if ( c.toUpperCase().equals(c) ) {
				if (lastDecapitalized && !lastCapital) {
					capitalize = true;
				}
				lastCapital = true;
			}
			else {
				lastCapital = false;
			}
			
			//if(forceFirstLetter && result.length()==0) capitalize = false;
			
			if (capitalize) {
				if (p == null || !p.equals("_") ) {
					result.append(c.toUpperCase() );
					capitalize = false;
					p = c;
				}
				else {
					result.append(c.toLowerCase() );
					capitalize = false;
					p = c;
				}
			}
			else {
				result.append(c.toLowerCase() );
				lastDecapitalized = true;
				p = c;
			}
			
		}
		String r = result.toString();
		return r;
	}
	
	static public void setStatesLn(String msg) {
		System.out.println(msg);
	}

	static public void setStates(String msg) {
		System.out.print(msg);
	}
	
	public HibernateTool(){	
	}
	
	static public void main(String argc[]) throws Exception{
		
		Connection conn = null;
		DatabaseMetaData dm = null;
		String msg = "";
		
		try {
			if(argc.length>=10){
				savePath = argc[0];
				package_name = argc[1];
				interface_name = argc[2];
				parent_name = argc[3];
				schema = argc[4];
				driver = argc[5];
				dbconnection = argc[6];
				uid = argc[7];
				pwd = argc[8];
				
				String temp = argc[9];
				noSet.clear();
				String s[]=temp.split(",");
				if(s!=null){
					for(int i=0;i<s.length;i++)
						if(s[i].length()>=1) noSet.add(s[i]);
				}
				
				assigned = argc[10];
				if(assigned!=null){
					String[] ss = assigned.split(",");
					for(int i=0;i<ss.length;i++){
						assignedSet.add(ss[i].trim().toUpperCase());
					}
				}
			}
			if(argc.length>=12){
				patternFlag=true;
			}
			setStates("正在连接数据库：" + dbconnection + "...");
			Class.forName(driver);
			conn = DriverManager.getConnection(dbconnection, uid, pwd);
			setStatesLn("数据库已连接.");

			dm = conn.getMetaData();

			HibernateTool.keyData.clear();
			HibernateTool.mData.clear();
			HibernateTool.mComments.clear();
			HibernateTool.tableCommons.clear();
						
			String columnName = null;
			String columnType = null;
			String datasize = null;
			String digits = null;
			String nullable = null;
			String column_def = null;
			
			ResultSet res2 = null;
			ResultSet res = dm.getTables(null, HibernateTool.schema, null,new String[] { "TABLE","VIEW" });
			while (res.next()) {
				String table = res.getString("TABLE_NAME").toUpperCase();
				String tableType = res.getString("TABLE_TYPE").toUpperCase();
				
				if(tableType.equals("VIEW") || table.equals("XT_XTCSB_BACK_20140818")){
					continue;
				}
				
				if(!table.startsWith("XT_"))
					continue;

				//------------
				setStatesLn("分析表" + table + "...");		
				res2 = dm.getPrimaryKeys(null,schema,table);
				List keylist = (List)HibernateTool.keyData.get(table);
				if(keylist==null){
						keylist=new ArrayList();
						HibernateTool.keyData.put(table, keylist);
				}
				
				while(res2.next()){
					//String s1 =res2.getString("TABLE_NAME");
					String s2=res2.getString("COLUMN_NAME");
					keylist.add(s2);
				}
			
				//特别处理
				if(tableType.equals("VIEW")){
					if(table.equals("XTBA_SYS_ZZJG"))
						keylist.add("ORGANIZE_CODE");

					if(table.equals("XTBA_SYS_ZZJY"))
						keylist.add("USER_CODE");

					if(table.equals("XTBA_SYS_ZZJG_ZZJY"))
						keylist.add("ID");

					if(table.equals("SYS_CODE"))
						keylist.add("ID");
					
					if(table.equals("SYS_CODETYPE"))
						keylist.add("ID_CODETYPE");
					
				}
					
				if(keylist.size()==0)
					if(msg.equals("")) msg=table;
					else msg += "\r\n" + table;
						
				res2.close();
						
				res2 = dm.getColumns(null,schema, table,"%");
			    while(res2.next()){			            	
			       	columnName = res2.getString("COLUMN_NAME");
			       	columnType = res2.getString("TYPE_NAME");
			       	datasize = res2.getString("COLUMN_SIZE");
			       	digits = res2.getString("DECIMAL_DIGITS");
			       	nullable = res2.getString("NULLABLE");
			       	column_def = res2.getString("COLUMN_DEF");
			        
			       	int kh = columnType.indexOf("(");
			       	if(kh>0) columnType = columnType.substring(0,kh);
			       	
			       	if(column_def==null) column_def="";
			       	if(digits==null) digits="";
			       	if(nullable==null) nullable="";
			       	if(datasize==null) datasize="";
			       	
			       	column_def=column_def.trim();
			       	if(column_def.equalsIgnoreCase("null")) column_def="";
			            	
			        //"表名","字段名","数据类型","长度","精度","空值","主键"
			        Vector v = new Vector();
	            	v.add(columnName);
	            	v.add(columnType);
	            	v.add(datasize);
	            	v.add(digits);
			        
			            	
	            	if(nullable.equals("1"))
	            		v.add(new Boolean(true));
	            	else
	            		v.add(new Boolean(false));
			            	
	            	if(keylist.contains(columnName))
	            		v.add(new Boolean(true));
	            	else
	            		v.add(new Boolean(false));
	            	
			        //<Vector<Object>>
			        Vector vrow = (Vector)HibernateTool.mData.get(table);
			        if(vrow==null){
			        	//<Vector<Object>>
			        	vrow = new Vector();
			        	HibernateTool.mData.put(table, vrow);
			        }
			        
			        v.add(column_def);
			        vrow.add(v);
			    }
			    res2.close();
			}
			res.close();
					
			setStatesLn("获取注释信息...");	
		    String sql = "select a1.table_name, a1.column_name, substr(nvl(a2.comments, a1.table_name) ,0,80) comments" +
    				"	from all_tab_cols a1, all_col_comments a2 " +
    				"		where a1.table_name = a2.table_name(+) " +
    				"	and a1.owner = a2.owner(+)" +
    				" 	and a1.column_name=a2.column_name(+)" +
    				" and a1.owner = '" + schema + "'";
		    Statement stmt = conn.createStatement();
		    res = stmt.executeQuery(sql);
		    while(res.next()){
		       	String tablename = res.getString("table_name"); 
		       	String colname = res.getString("column_name");
		       	String comments = res.getString("comments");
		       	if(comments!=null && !comments.trim().equals("") && !comments.equals(tablename)){
		       		comments = new String(comments.getBytes("UTF-8"),"GBK");
		       		HibernateTool.mComments.put(tablename + "_" + colname, comments);
		       	}
		    }
		    res.close();
		            
		    sql = "select table_name,table_type,comments from all_tab_comments ";
		    sql += " where owner = '" + schema + "'";
		    res = stmt.executeQuery(sql);
		    while(res.next()){
		    	String tablename = res.getString("table_name"); 
		    	String comments = res.getString("comments");
		    	if(comments!=null && !comments.trim().equals("")){
		    		comments = new String(comments.getBytes("UTF-8"),"GBK");
		    		HibernateTool.tableCommons.put(tablename, comments);
		    	}
		    }
		    res.close();
		    stmt.close();

			if(!msg.equals(""))
				setStatesLn("下列表没有找到主键：" + msg);
			
			MakePOJO pojo = new MakePOJO(schema,package_name,savePath,parent_name,
					interface_name,mData,keyData);
			pojo.start();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			setStatesLn("POJO创建结束！");
		}
	}
}

class MakePOJO{
	String error = "";
	static Map classType = new HashMap();
	DefaultReverseEngineeringStrategy hibernateTool = new DefaultReverseEngineeringStrategy();
	static Set keyWord = new HashSet();
	static{
		keyWord.add("INITIAL");
	}
	
	static{
		classType.put("VARCHAR", new ClassesType("String","","java.lang.String",true));
		classType.put("VARCHAR2", new ClassesType("String","","java.lang.String",true));
		classType.put("NVARCHAR2", new ClassesType("String","","java.lang.String",true));
		classType.put("NVARCHAR", new ClassesType("String","","java.lang.String",true));
		classType.put("INTEGER", new ClassesType("Integer","","java.lang.Integer",true));
		classType.put("CHAR", new ClassesType("String","","java.lang.String",true));
		classType.put("NCHAR", new ClassesType("String","","java.lang.String",true));
		classType.put("CHAR2", new ClassesType("String","","java.lang.String",true));
		classType.put("DATE", new ClassesType("Date","java.util.Date","java.util.Date",true));
		classType.put("LONG", new ClassesType("Long","","java.lang.Long",true));
		classType.put("DOUBLE", new ClassesType("Double","","java.lang.Double",true));
		classType.put("FLOAT", new ClassesType("Double","","java.lang.Double",true));
		classType.put("RAW", new ClassesType("String","","java.lang.String",true));
		classType.put("LONG RAW", new ClassesType("String","","java.lang.String",true));
		classType.put("TIMESTAMP", new ClassesType("Date","java.util.Date","java.util.Date",true));
		classType.put("CLOB", new ClassesType("String","","org.springframework.orm.hibernate3.support.ClobStringType",false));
		classType.put("BLOB", new ClassesType("byte[]","","org.springframework.orm.hibernate3.support.BlobByteArrayType",false));
	}

	String packname = null;
	String savepath = null;
	String savepath1 = null;
	String parentname = null;
	String interfaceList = null;
	Map tableData=null;
	Map keyData = null;
	String schema=null;
	
	List importPackage = new ArrayList();
	String implementsList = null;
	
	public MakePOJO(String schema,String packname,String savepath,String parentname,String interfaceList,
			Map tableData,
			Map keyData){
			this.schema=schema;
			this.packname = packname;
			this.savepath = savepath;
			this.parentname = parentname;
			this.interfaceList = interfaceList;
			this.tableData=tableData;
			this.keyData = keyData;
			
			//处理继承对象
			if(parentname!=null && !parentname.equals("")){
				if(parentname.endsWith(".class"))
					parentname = parentname.substring(0, parentname.lastIndexOf("."));
				importPackage.add(parentname);
				
				int seek = parentname.lastIndexOf(".");
				if(seek>0) this.parentname = parentname.substring(seek+1);
			}
			
			//处理接口对象
			if(interfaceList!=null){
				String[] s = interfaceList.split(",");
				for(int i=0;i<s.length;i++){
					if(s[i].length()>0){
						if(s[i].endsWith(".class"))
							s[i] = s[i].substring(0, s[i].lastIndexOf("."));
						
						importPackage.add(s[i]);
						
						int seek = s[i].lastIndexOf(".");
						if(seek>0) s[i] = s[i].substring(seek+1);
						
						if(implementsList==null) implementsList = s[i];
						else implementsList += "," + s[i];
					}
				}
			}
			
			String path = packname.replace('.', '\\');
			if(savepath.endsWith("\\")) savepath1 = savepath + path;
			else savepath1 = savepath + "\\" + path;
	}
	
	public void start() throws Exception{
		try{
			HibernateTool.setStatesLn("创建目录：" + savepath1);
			File f = new File(savepath1);
			if(!f.exists()){
				f.mkdirs();
			}else{
				if(HibernateTool.patternFlag==false){
					File[] fs = f.listFiles();
					for(int i=0;i<fs.length;i++)
						fs[i].delete();
				}
			}
			
			Set tables = tableData.keySet();
			for(Iterator it=tables.iterator();it.hasNext();){
				String tablename = (String)it.next();
				
				String pojoname = this.getEntityName(tablename);
				Vector cols=(Vector)tableData.get(tablename);
				List pkList = (List)keyData.get(tablename);
				
				makePrjo(pojoname,cols,pkList,tablename);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		if(!"".equals(error)){
			throw new Exception("创建POJO对象发生如下错误:\n\r" + error);
		}
	}
	
	public void makePrjo(String pojoname,Vector cols,List pkList,String tablename) throws Exception{
		HibernateTool.setStates("创建POJO对象" + pojoname + "和hibernate映射文件...");
		if(tablename.equals("TESTAAA")){
			System.out.println("ok");
		}
		
		PrintWriter f=new PrintWriter(new FileOutputStream(savepath1 + "\\" + pojoname + ".java"));
		PrintWriter f2=new PrintWriter(new FileOutputStream(savepath1 + "\\" + pojoname + ".hbm.xml"));
		
		//全参构造函数
		List gzList = new ArrayList();
		
		//编写pojo映射文件头
		f2.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		f2.println("<!DOCTYPE hibernate-mapping PUBLIC \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
		f2.println("	\"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">");
		f2.println("<hibernate-mapping>");
		//f2.println("    <class name=\"" + packname + "." + pojoname
		//		+ "\" table=\"" + tablename + "\" schema=\"" + schema + "\" dynamic-insert=\"true\" dynamic-update=\"true\">");
		f2.println("    <class name=\"" + packname + "." + pojoname
				+ "\" table=\"" + tablename + "\" dynamic-insert=\"true\">");
		//dynamic-update=\"true\"
		
		Set tempImport = new HashSet();
		Vector vKey = new Vector();
		Set eKey = new HashSet();
		
		String oooo="";
		Map pMap=new HashMap();
		
		//部门编码以oooo开头，如果存在ooooxxx，那么就存在xxx的部门id，这里创建一个所有部门id的静态只读属性
		//计算具体POJO对象需要引入的包，并且分离主键和普通字段
		for(int i=0;i<cols.size();i++){
			Vector v = (Vector)cols.get(i);
        	String columnType = v.get(1).toString();
        	
        	//将所有属性名就压入Map	中。
        	String columnName = v.get(0).toString().toUpperCase();
        	pMap.put(columnName,getEntityPName(columnName));
        	
        	if(classType.containsKey(columnType)){
        		ClassesType t = (ClassesType)classType.get(columnType);
        		if(t.getImportType()!=null && !t.getImportType().equals(""))
        			tempImport.add(t.getImportType());
        	}
        	
        	Boolean isKey = (Boolean)v.get(5);
        	if(isKey.booleanValue()){
        		vKey.add(v);
        		eKey.add(v.get(0).toString());
        	}
		}
		
		//计算层次码
		for(Iterator it=pMap.keySet().iterator();it.hasNext();){
			String columnName = it.next().toString();
			String pname = pMap.get(columnName).toString();
			String key = columnName.toUpperCase();
			if(key.indexOf("OOOO")==0){
				String dw = columnName.substring(4);
				if(pMap.containsKey(dw))
					oooo +=  ";" + getEntityPName(dw) + "=" + pname;
			}
		}
		
		//编写包头
		if(packname!=null && !"".equals(packname)){
			f.println("package " + packname + ";");
			f.println();
		}
		
		//编写公共import对象
		for(Iterator it=importPackage.iterator();it.hasNext();){
			String imp = it.next().toString();
			f.println("import " + imp + ";");
		}
		
		//编写POJO独立的import对象
		for(Iterator it=tempImport.iterator();it.hasNext();){
			String imp = it.next().toString();
			f.println("import " + imp + ";");
		}
		f.println();
		
		//编写JavaDoc注释
		if(HibernateTool.tableCommons.containsKey(tablename)){
			String tableCommons = HibernateTool.tableCommons.get(tablename).toString();
			f.println("/**\r\n*" + tableCommons + "\r\n*/");
		}
		
		//编写类声明
		f.print("public class " + pojoname);
		if(parentname!=null && !"".equals(parentname)) f.print(" extends " + parentname);
		if(implementsList!=null && !"".equals(implementsList)) f.print(" implements " + implementsList);
		
		f.println("{");
		
		String methodString = "";
		
		String remark = "\t*单位层次码";
		try{
			remark = new String(remark.getBytes("UTF-8"),"GBK");
		}catch(Exception e){
			;
		}
    	f.println("\t/*");
    	f.println(remark);
    	f.println("\t*/");
		//f.println("\tstatic final private String\tlayerOooo=\"" + oooo + "\";");
		
		if(vKey.size()==0)
			error += "表" + tablename + "不存在主键;";
		else if(vKey.size()>1)
			error += "表" + tablename + "存在联合主键;";
			
		for(int i=0;i<vKey.size();i++){
			Vector v = (Vector)vKey.get(i);
        	String columnName = v.get(0).toString();
        	String columnType = v.get(1).toString();
        	String datasize = v.get(2).toString();
        	String digits = v.get(3).toString();
        	//Boolean nullable = (Boolean)v.get(4);
        	//Boolean isKey = (Boolean)v.get(5);
        	
        	String javaType = null;
        	if(columnType.equals("NUMBER")){
        		if(digits==null || digits.equals("") || digits.equals("0"))
        			columnType = "LONG";
        		else
        			columnType = "DOUBLE";
        	}
        	
        	ClassesType t = (ClassesType)classType.get(columnType);
        	if(t==null){
        		new Exception("严重错误：数据类型" + columnType + "没有找到定义信息！");
        	}
        	
        	javaType = t.getJavaType();
        	
            String key = tablename + "_" + columnName;
            if(HibernateTool.mComments.containsKey(key)){
            	String commons = HibernateTool.mComments.get(key).toString();
            	f.println("\t/*");
            	f.println("\t*" + commons);
            	f.println("\t*/");
            }
            
        	String pname = getEntityPName(columnName);
        	f.println("\tprivate " + javaType + "\t" + pname + ";");
        	
        	methodString += getGetMethod(tablename,columnName,pname,javaType) + "\r\n\r\n";
        	methodString += getSetMethod(tablename,columnName,pname,javaType) + "\r\n\r\n";
        	
            f2.print("\t\t<id name=\"" + pname + "\" type=\"" + t.getHbmType() + "\">" +
            	"\r\n\t\t\t<column name=\"" + getHibernateXMLColname(columnName) + "\" length=\"" + datasize + "\" />");
            
           // if(HibernateTool.assignedSet.contains(tablename))
            	f2.print("\r\n\t\t\t<generator class=\"assigned\"></generator>");
           // else
          //  	f2.print("\r\n\t\t\t<generator class=\"uuid.hex\"></generator>");
            
            f2.println("\r\n\t\t</id>");
            
            gzList.add(javaType + "=" + pname);
		}
		
		for(int i=0;i<cols.size();i++){
			Vector v =(Vector)cols.get(i);
        	String columnName = v.get(0).toString();
        	String columnType = v.get(1).toString();
        	String datasize = v.get(2).toString();
        	String digits = v.get(3).toString();
        	Boolean nullable = (Boolean)v.get(4);
        	String defValue = v.get(6).toString();
        	
        	//如果是主键，那么不再重复创建
        	if(eKey.contains(columnName)) continue;
        	
        	//创建默认值
        	String javaType = null;
        	
        	//oracle的LONG,翻译成VARCHAR2
        	if(columnType.equals("LONG")){
        		columnType = "VARCHAR2";
        	}
        	
        	if(columnType.equals("NUMBER")){
        		if(digits==null || digits.equals("") || digits.equals("0")){
        			columnType = "LONG";
        			if(!defValue.equals("")) defValue="new Long(" + defValue + "l)";
        		}else{
        			columnType = "DOUBLE";
        			if(!defValue.equals("")) defValue="new Double(" + defValue + "d)";
        		}
        	}
        	
        	if(columnType.equals("DATE"))
        		if(defValue.trim().equals("SYSDATE")) defValue="new Date()";
        	
        	if(columnType.startsWith("VARCHAR")
        			|| columnType.startsWith("CHAR")
        			|| columnType.startsWith("NCHAR")
        			|| columnType.startsWith("NVARCHAR")){
        		if(!defValue.equals("")){
        			defValue = defValue.replaceAll("\"", "\\\"").trim();
        			if(defValue.startsWith("'")) defValue=defValue.substring(1);
        			if(defValue.endsWith("'")) defValue=defValue.substring(0,defValue.length()-1);
        			defValue = "\"" + defValue + "\"";
        		}
        	}
        	
        	ClassesType t = (ClassesType)classType.get(columnType);
        	if(t==null)
        		throw new Exception("严重错误：数据类型" + columnType + "没有找到定义信息！");
        	        	
        	javaType = t.getJavaType();
        	
        	String pname = getEntityPName(columnName);
  
            f2.print("\t\t<property name=\"" + pname + "\" type=\"" + t.getHbmType() + "\">" +
            		 "\r\n\t\t\t<column name=\"" + getHibernateXMLColname(columnName) + "\"");
            
            if(t.isLength())
            	f2.print(" length=\"" + datasize + "\"");
            
            //对于非空字段，没有默认值字段，设置强制校验
            if(!nullable.booleanValue() && (defValue==null || "".equals(defValue)))
            	f2.print(" not-null=\"true\"");
            
            f2.println(" />");
            f2.println("\t\t</property>");
        	
            String key = tablename + "_" + columnName;
            if(HibernateTool.mComments.containsKey(key)){
            	String commons = HibernateTool.mComments.get(key).toString();
            	f.println("\t/*");
            	f.println("\t*" + commons);
            	f.println("\t*/");
            }
            
            if(defValue.equals(""))
            	f.println("\tprivate " + javaType + "\t" + pname + ";");
            else
            	f.println("\tprivate " + javaType + "\t" + pname + "=" + defValue + ";");
            
        	methodString += getGetMethod(tablename,columnName,pname,javaType) + "\r\n\r\n";
        	methodString += getSetMethod(tablename,columnName,pname,javaType) + "\r\n\r\n";
        	
        	gzList.add(javaType + "=" + pname);
		}
		
		//编写空构造方法
		f.println("\r\n\tpublic " + pojoname + "(){}");
		f.println();
		
		//构造全构造函数
		f.print("\r\n\tpublic " + pojoname + "(");
		int icount=0;
		for(int i=0;i<gzList.size();i++){
			String s = gzList.get(i).toString();
			String[] ss = s.split("=");
			String itype = ss[0];
			String iname = ss[1];
			if(icount==0)
				f.print(itype + " " + iname);
			else
				f.print(",\r\n\t\t\t" + itype + " " + iname);
			
			icount ++;
		}
		f.println(")\r\n\t{");

		for(int i=0;i<gzList.size();i++){
			String s = gzList.get(i).toString();
			String[] ss = s.split("=");
			String iname = ss[1];
			
			f.println("\t\tthis." + iname + "=" + iname + ";");
		}
		
		f.println("\t}");
		f.println();
		
		f.print(methodString);
		
		//编写层次码获取方法
		//f.println("\tpublic String getLayerOooo(){\r\n\t\treturn this.layerOooo;\r\n\t}");
		f.println("\tpublic String getLayerOooo(){\r\n\t\treturn \"" + oooo + "\";\r\n\t}\r\n");
		f.println("\tpublic void setLayerOooo(String layerOoooo){\r\n\t}");
		
		//覆盖hashCode方法
		if(eKey==null){
			System.out.println("err");
		}
		
//		if(pkList==null || pkList.size()==0)
//			;
//		else{
//			String pname = (String)pkList.get(0);
//			f.println("\tpublic int hashCode(){");
//			String s1 = null;
//			for(Object s :pkList){
//				s = getEntityPName(s.toString());
//				f.println("\t\tif(" + s + "==null) return super.hashCode();");
//				if(s1==null)
//					s1 = s.toString() + " + \"\"";
//				else
//					s1 += " + \"_\" + " + s;
//			}
//			f.println("\t\treturn (" + s1 + ").hashCode();");
//			f.println("\t}");
//			
//			//覆盖equals方法
//			f.println("\tpublic boolean equals(Object obj){");
//			f.println("\t\tif(obj==null || !(obj instanceof " + pojoname + ") ) return false;");
//			f.print("\t\treturn ");
//			int i=0;
//			for(Object s:pkList){
//				s = getEntityPName(s.toString());
//				
//				if(i==0)
//					f.print("this." + s + ".equals(((" + pojoname + ")obj)." + s + ")");
//				else
//					f.print(" && this." + s + ".equals(((" + pojoname + ")obj)." + s + ")");			
//				i++;
//			}
//			f.println("\t\t;");
//			
//			f.println("\t}");
//		}
		
		f.print("}");
		
		f2.println("\t</class>");
	    f2.println("</hibernate-mapping>");
	    
		f2.flush();
		f.flush();
		
		f.close();
		f2.close();
		
		HibernateTool.setStatesLn("完成！");
	}
	
	/**
	 * 过滤关键字
	 * @param colname
	 * @return
	 */
	public String getHibernateXMLColname(String colname){
		if(keyWord.contains(colname.toUpperCase()))
			return colname = "`" + colname + "`";
		else
			return colname;
	}
	
	public String getGetMethod(String tablename,String columnName,String pname,String javaType){
		if("XTBA_SYS_ZZJG".equals(tablename) || "XTBA_SYS_ZZJY".equals(tablename)){
			if(javaType.equals("byte[]")){
				return "\tpublic " + javaType 
					+ " get" + pname.substring(0,1).toUpperCase() + pname.substring(1)
					+ "(){\r\n\t\treturn com.gnt.common.util.CommonUtil.getBlob(this,\"" + pname + "\");\r\n\t}";
			}
		}
		
		return "\tpublic " + javaType 
				+ " get" + pname.substring(0,1).toUpperCase() + pname.substring(1)
				+ "(){\r\n\t\treturn this." + pname + ";\r\n\t}";
	}
	
	public String getSetMethod(String tablename,String columnName,String pname,String javaType){
		return "\tpublic void set" + pname.substring(0,1).toUpperCase() + pname.substring(1)
				+ "(" + javaType + " " + pname + "){\r\n"
				+ "\t\tthis." +pname + "=" + pname + ";\r\n\t}";
	}
	
	public String getEntityName(String tablename){
		String s = hibernateTool.tableToClassName(new TableIdentifier(tablename));
		return s;
	}
	
	public String getEntityPName(String colname){
		String s = hibernateTool.columnToPropertyName(null, colname);
		return s;
	}
}

class ClassesType{
	String javaType = "";		//java类型
	String importType = "";		//要引入的包
	String hbmJavaType = "";	//Hibernate对应定义的数据类型
	boolean isLength = true;
	
	public ClassesType(String javaType,String importType,String hbmJavaType,boolean isLength){
		this.importType = importType;
		this.javaType = javaType;
		this.hbmJavaType = hbmJavaType;
		this.isLength = isLength;
	}
	
	public String getJavaType(){return javaType;}
	public String getImportType(){return importType;}
	public String getHbmType(){return hbmJavaType;}
	public boolean isLength(){return isLength;}
}


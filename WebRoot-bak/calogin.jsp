<%@ page import="java.lang.*, java.io.*, java.sql.*, java.util.*" contentType="text/html;charset=gb2312" %>

<%request.setCharacterEncoding("GB2312"); %>
<%@include file = "config.jsp"%>

<%String flag=request.getParameter("flag");
String url="";%>
<%@ page import="com.jit.attr.JitAcComp"%>
<%@ page import="com.jit.attr.GenGACode"%>
<%@page import="java.security.cert.X509Certificate,java.util.Vector,com.jit.attr.GAACInfo"%>
<html>


<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%  
System.out.println("PKI登录...");

    String num=null;
    String a=" ";
    String b=",";
    String c="CN=";
    String sn=null;
    String name=null;
    String myinfo = null;
    String psw=null;
   
    try{
       X509Certificate[] certs=(X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate");
       if(certs==null){
               out.println("错误！请提交证书！");
               return;
       }
       com.jit.attr.JitAcComp accomp = new com.jit.attr.JitAcComp();
       X509Certificate gaX509Cert=null;
       gaX509Cert=certs[0];
         System.out.println(gaX509Cert.getSubjectDN().toString() + ",len=" + gaX509Cert.getSubjectDN().toString().length());
         
       
     String[] s = gaX509Cert.getSubjectDN().toString().split(" ");
     for(int i=0;i<s.length;i++)
     	if(s[i].length()>=15){
     		sn = s[i];
     		sn = sn.replaceAll(",","");
     		sn = sn.replaceAll("，","");
     		break;
     	}
     	
       //sn=gaX509Cert.getSubjectDN().toString().split(" ")[1];//取身份证号
       }
     catch(Exception e){
     	e.printStackTrace();
                         out.println("错误！"+e.getMessage());//－－此处即为获取并显示统一提示信息的方法。
     }

//String sn="34240119830827269X";
//15to18开始
String sn15=null;
String sn18=null;
String kqt2=null;
String kqt1=null;
System.out.println("=============================" + sn);
if(sn.length()==18){
 kqt1=sn.substring(0,6);
 kqt2=sn.substring(8,17);
 
  sn15=kqt1+kqt2;
   sn18=sn;
    }
if(sn.length()==15){
                //String num = null;
                //num=sn;
		String[] checkCodes =  new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
		int[] mulFactors =  new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};

  
	        String id17=sn.substring(0,6)+"19"+sn.substring(6,12)+sn.substring(12,15);
			int iPtr = 0;
	    	int i=0;

	    	for (i=0; i<17; i++) {
	    		iPtr = iPtr + Integer.parseInt(id17.substring(i,i+1))*mulFactors[i];
	    	}
	    	iPtr = iPtr%11; 
	    	
	        sn18 = id17 + checkCodes[iPtr];
                sn15 = sn;
	     }
	  //结束
	  
     String Dsfz=sn18.toUpperCase();
     String Xsfz=sn18.toLowerCase();
     Connection conn = null;
     PreparedStatement ps = null;
     java.sql.Statement stmt = null;
     ResultSet rs = null;
     String password="";
     //String goto_url = CommonUtil.getEncodeURL(request.getParameter("goto_url"));
  //if(goto_url==null) goto_url="";
      String username="";
     //String username=request.getRemoteUser();
     String pki_name=sn;
try{
     
String jdbc_driverClass=SystemConfig.getJdbcConfig("qxgl.jdbc.driverClass");     
String jdbc_url=SystemConfig.getJdbcConfig("qxgl.jdbc.url");
String jdbc_user=SystemConfig.getJdbcConfig("qxgl.jdbc.user");
String jdbc_password=SystemConfig.getJdbcConfig("qxgl.jdbc.password");

		// Class.forName(jdbc_driverClass).newInstance(); 
     conn = DriverManager.getConnection(jdbc_url,jdbc_user,jdbc_password); 
    
     String strSql="select login_name,login_password from sys_user_info where idcard = '"+sn18+"' or idcard='"+sn15+"' or idcard='"+Dsfz+"' or idcard='"+Xsfz+"' and rownum=1";
     stmt = conn.createStatement();
     rs = stmt.executeQuery(strSql);
     if (rs.next()) {
        username=rs.getString("login_name");
        password=rs.getString("login_password");
        com.gnt.qxgl.service.LoginService login = (com.gnt.qxgl.service.LoginService)SpringContainer.getObject("loginService");
        login.login(username,password);
        response.sendRedirect("index.jsp");
        return;
     }
  }
catch (Exception ex)
{ex.printStackTrace();
 response.sendRedirect("login.jsp");}
finally {

           if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {ex.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {ex.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {ex.printStackTrace();
                }
            }

        }



  
 %>


	
  
 
  
 
</body>
</html>

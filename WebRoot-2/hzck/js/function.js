/*********************function description*******************************************
Fun Name: trimquotes()
Fun Desc:  ȥ���ַ������ߵ�����
creator: CW
date:
**************************************************************************************/
function trimquotes(action)
{
var newAction = action.substring(1, action.length);
newAction = newAction.substring(0, newAction.length -1);
return newAction;
}


/*********************function description*******************************************
Fun Name:
Fun Desc:����ѡ
creator: CW
Modify:
date:2004.03.
**************************************************************************************/
function singleSelect(sPath,inputId,inputName)
{

strFeatures = "dialogWidth=300px;dialogHeight=380px;center=yes;help=no";
var value = showModalDialog(sPath,"",strFeatures);
if (value.indexOf("mrCancel")>-1 || value=="")
{
   return ;
}
var pStart=value.indexOf("<id>");
var pEnd=value.indexOf("</id>");
inputId.value=value.substring(pStart+4,pEnd);
var pStart=value.indexOf("<name>");
var pEnd=value.indexOf("</name>");
inputName.value=value.substring(pStart+6,pEnd);
}


/*********************function description*******************************************
Fun Name:getValues()
Fun Desc:  ��ȡһ��Select ������value���ַ���
creator: CW
date:
**************************************************************************************/
function getValues(select)
{
   var result="";
   for (var i =0;i<select.options.length;i++)
   {
      if (i==0)
      {
           result=select.options[i].value;
      }
      else
      {
          result=result +","+select.options[i].value;
       }
   }
   return result;
}

/*********************function description*******************************************
Fun Name:getNames()
Fun Desc:  ��ȡһ��Select ������name���ַ���
creator: cw
date:
**************************************************************************************/
function getNames(select)
{
   var result="";
   for (var i =0;i<select.options.length;i++)
   {
      if (i==0)
      {
           result=select.options[i].text;
      }
      else
      {
          result=result +","+select.options[i].text;
       }
   }
   return result;
}


/*********************function description*******************************************
Fun Name:         getOptionIndex
Fun Desc:   ����code��ȡ��Select�б���е���ţ����code�����ڣ���Ϊselect��length��
creator: cw
date:
**************************************************************************************/
function getOptionIndex(code,select)
{
  var options = select.options;
  var result=options.length;
  for (var i = 0;i<options.length;i++)
  {
       if (options[i].value==code)
       {
          result=i;
          break;
       }
  }
  return result;
}

/*********************function description*******************************************
Fun Name:            selectAddOption()
Fun Desc:  ��ָ��Select ���һ��option
creator: CW
date:
**************************************************************************************/
function selectAddOption(code,name,select)
{
  var options = select.options;
  var index=getOptionIndex(code,select);
  if (index<options.length)
  {
     options[index].text=name;
  }
  else
  {
      var option = new Option();
      option.value=code;
      option.text=name;
      options[index]=option;
  }
}
/*********************function description*******************************************
Fun Name:selectRemoveOption(code)
Fun Desc:����Code ɾ��option
creator: CW
date:
**************************************************************************************/
function selectRemoveOption(code,select)
{
  var options = select.options;
  var index=getOptionIndex(code,select);
  if (index<options.length)
  {
      select.remove(index);
  }
}

/*********************function description*******************************************
Fun Name:
Fun Desc:������ϵͳ�ĵĲ˵�����¼���
creator: CW
date:2004.05.
������act,glomenu,sysCode
**************************************************************************************/
function selectFun(act,menu,sysCode)
{
menu[0]="deptmentTree.jsp";
menu[1]="menuTree.jsp";
menu[2]="*.jsp";
if(sysCode=="zfyw")
{
act="1";
}
else if(sysCode=="gzdx")
act="2";
else if(sysCode=="hcbd")
act="3";
else if(sysCode=="zhcx")
act="4";
else if(sysCode=="ywzcpt")
act="5";
else
act ="0";
selectFun(act);
}

/**
*Created by 20040429
*
*
*����ͬһ�����Ƿ�����ͬ�Ĵ�����ڡ�
*code��Ҫ��ӵĴ���
*
*/
function checkExsitCode(code)
{
    var st = new Array("");
    var para = "../common/checkCode.jsp?code="+code;
    var result = showModalDialog(para,st,"dialogWidth=0px;dialogHeight=0px;center=false;help=no;scroll=no;status=no");
	if (result == null || result[0]==null || result[0]=='')
	{
		return;
	}
    return result[0];
}




function isExist(codeName,excludeCode)
{
      var code = codeName.value;
      if (code == excludeCode)
      {
        return true;
      }
      //if (checkExsitCode('table_Name',code))        //table_NameΪ��ӦҪ��ӵļ�¼�ı���
      if (checkExsitCode(code))        //table_NameΪ��ӦҪ��ӵļ�¼�ı���
      {
        alert("�˴����Ѿ�����,��������������!");
        codeName.focus();
        return false;
      }
      return true;
}


/**
*Created by Jing Wu
*
*
*ѡ��ָ������
*
*/
function trClick(lineNo,frm)
{
    if(isNaN(parseInt(lineNo)))
        lineNo=0;
        
    var ra;
    if(frm.ID[0])
      ra = eval("frm.ID["+lineNo+"]");
    else
      ra = eval("frm.ID");
      
    ra.checked=true;
}

/**
*Created by Jing Wu
*
*
*���ѡ��
*
*/
function checkSelected(frm)
{
	var result=false;

    if(frm.ID)
    {
		if(frm.ID[0])
		{
			for(var i=0;i<frm.ID.length;i++)
			{
				if(frm.ID[i].checked)
					result = true;
			}
		}
		else
		{
			if(frm.ID.checked)
			result = true;
		}
    }


	if(!result)
	{
		alert("����ѡ��һ����¼��");
		return false;
	}
	else
		return true;
}
<!--
function findOpenerObj(theObj)
{
  var p, i, foundObj;
  var theDoc
 // if(!theDoc) 
  theDoc = window.opener.document;

  if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj];
  for (i=0; !foundObj && i < theDoc.forms.length; i++) 
    foundObj = theDoc.forms[i][theObj];
  for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++) 
    foundObj = findObj(theObj,theDoc.layers[i].document);
  if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);

  return foundObj;
}

// Example: obj = findObj("image1");
function findObj(theObj)
{
  var p, i, foundObj;
  var theDoc;
 // if(!theDoc) 
  theDoc = document;

  if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj];
  for (i=0; !foundObj && i < theDoc.forms.length; i++) 
    foundObj = theDoc.forms[i][theObj];
  for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++) 
    foundObj = findObj(theObj,theDoc.layers[i].document);
  if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);

  return foundObj;
}

// * Dependencies * 
// this function requires the following snippets:
// JavaScript/readable_MM_functions/findObj
//
// Accepts a variable number of arguments, in triplets as follows:
// arg 1: simple name of a layer object, such as "Layer1"
// arg 2: ignored (for backward compatibility)
// arg 3: 'hide' or 'show'
// repeat...
//
// Example: showHideLayers(Layer2,'','show',Layer3,'','hide');
function showHideLayers()
{ 

  var i, visStr, obj, args = showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3)
  {
    if ((obj = findObj(args[i])) != null)
    {
      visStr = args[i+2];
      if (obj.style)
      {
        obj = obj.style;
        if(visStr == 'show') visStr = 'visible';
        else if(visStr == 'hidden') visStr = 'hidden';
      }
      obj.visibility = visStr;

    }
  }
}

// * Dependencies * 
// this function requires the following snippet:
// JavaScript/readable_MM_functions/findObj
function setColor(objName, fg, bg)
{
  obj = findObj(objName);
  if (obj.style)
  {
    obj.style.color = fg;
    obj.style.backgroundColor = bg;
  }
}


function setHight(objName, myheight)
{
  obj = findObj(objName);
  if (obj.style)
  {
    obj.style.height = myheight;
  }
}

function switchLab(iFlag,labnums,labno){
    var LabNums=7;//标签数
    if(switchLab.arguments.length>=2)
        LabNums=labnums;
    if(switchLab.arguments.length==3)
        LabNo=labno; 
    else LabNo=iFlag;           
    //alert(LabNums);
            
    //showHideLayers("Layer1,'','show',Layer2,'','hide');
    showHideLayers('Layer'+iFlag,'','show');
    
    for(i=1;i<=LabNums;i++){
        //SET LAYER
        if(i==iFlag){
            showHideLayers('Layer'+i,'','show');
        }else{
            showHideLayers('Layer'+i,'','hidden');
        }
        //SET LAB
        if(i==LabNo){
            setColor('Lab'+i, '', '#83B5E6');
        }else{
            setColor('Lab'+i, '', '#EFF6FE');
        }
    }    
}
/*
公安业务下,初始化lab
iFlag 当前被选中的标签号
LabNums 有效的标签总数
*/
function initGaywLab(iFlag,LabNums){
	var divstrtemp="<div id=\"Layer1\" class=\"tabLayer\" ></div>";
	var ifrstrtemp ="<iframe src=\"\" width=\"100%\" height=\"100%\"";
	ifrstrtemp +=" frameborder=\"0\" id=\"Iframe1\" ></iframe>";
	//SET LAYER
	var firstobj = document.createElement(divstrtemp);
	var ifrobj = document.createElement(ifrstrtemp);
	firstobj.appendChild(ifrobj);
	document.body.appendChild(firstobj);//增加第一个节点
	for(i=2;i<=LabNums;i++){
        	var tempobj = firstobj.cloneNode(true);
		tempobj.id="Layer"+i;
		document.body.appendChild(tempobj);
		tempobj.all.Iframe1.id="Iframe"+i;
    	}
    	for(var j=1;j<=LabNums;j++){
    		var labtemp =findObj("Lab"+j);
    		labclass = labtemp.className;
    		var warning = labtemp.warning;
    		if(warning==null||warning==""){
    			warning="报告未审批或审批不通过";
    		}
    		if("normal"==labclass||"active"==labclass){
    			labtemp.onclick=new Function("switGaywLab("+j+","+LabNums+");");
    		}else	
    		if("disabled"==labclass){
    			labtemp.onclick=new Function("alert('"+warning+"');");
    		}
    	}
    	switGaywLab(iFlag,LabNums);    	
}
/*
公安业务下,实现lab切换,当相关的lab数据更新后要刷新lab
iFlag 当前标签号
LabNums//标签数
*/
var currentGaywLabNO =0;//当前lab页
var currentGaywLabNum =0;//当前页面的lab总数
function switGaywLab(iFlag,LabNums){
	currentGaywLabNO = iFlag;
	currentGaywLabNum = LabNums;
    for(i=1;i<=LabNums;i++){
        //SET LAYER
        var framesrc;
        var refr; //单次刷新标志
        var isrefr; //是否允许单次刷新
        var alwrefr; //每次都刷新
        var labobj = findObj('Lab'+i);
        if(i==iFlag){//显示div
            showHideGaywLayers('Layer'+i,'show');
            framesrc = labobj.iframesrc;
            refr = labobj.refre;
            isrefr = labobj.isrefre;
            alwrefr = labobj.alwrefr;
            //给iframe设置url
            if(framesrc!=null&&framesrc!=""){
            	var iframeobj = findObj('Iframe'+i);
            	if(iframeobj&&""==iframeobj.src){
				iframeobj.src = framesrc;
		}else{
			if(refr=='1'&&isrefr=='1'||alwrefr=='1'){
            		//if(confirm("相关数据已经更新,是否重新加载?")){	
				//iframeobj.document.location.reload();	
				iframeobj.src = framesrc;
			}
		}
		labobj.refre="0";
            	//setGaywiframeUrl('Iframe'+i,framesrc);	
            }
            //改变lab颜色
            labobj.className="active";
            
        }else{//隐藏div
            showHideGaywLayers('Layer'+i,'hidden');
            if("active"==labobj.className){
            	labobj.className="normal";
            }
        }
    }    
}
/*
显示隐藏div,返回div中iframe的url参数值
第一个参数为div的名称,第二个为show和hidden  
*/
function showHideGaywLayers(){ 
  args = showHideGaywLayers.arguments;
  var obj;
  var visStr;
  //obj = findObj(args[0]);
  obj = document.getElementById(args[0]);
  if (obj){
      visStr = args[1];
      if (obj.style){
        //obj = obj.style;
        if(visStr == 'show'){
        	 //visStr = 'visible';
        	 obj.style.display = "block";
        }else 
        if(visStr == 'hidden'){
        	 //visStr = 'hidden';
        	 obj.style.display = "none";
        }
      }
      //obj.visibility = visStr;
  }
}
/*
设置iframe的url
*/
function setGaywiframeUrl(iframename,iframesrc){
	var obj = findObj(iframename);	
	if(obj&&""==obj.src){
		obj.src = iframesrc;
	}
}

/*
设置指定关联页面刷新
*/
function setLabRefresh(LabName){
	var obj = findObj(LabName);
	obj.refre="1";		
}
/*
自动设置页面刷新
本页面和Lab1不刷新,其它也都刷新.
flag : 1文书作废 
*/
function autoLabRefre(flag){
	if(currentGaywLabNO!=0&&currentGaywLabNum!=0){
		for(i=1;i<=currentGaywLabNum;i++){
			if(i!=currentGaywLabNO){
				var obj = findObj('Lab'+i);
				obj.refre="1";	
			}
		}
	}
	try{
		if(typeof(autoRunFuntion)!='undefined')
			autoRunFuntion(flag);//打印完或其它Lab页面来调用
	}catch(E){}
}

function bak_switchLab(iFlag,labnums){
    var LabNums=7;//标签数
    if(switchLab.arguments.length==2)
        LabNums=labnums; 
    //alert(LabNums);
            
    //showHideLayers("Layer1,'','show',Layer2,'','hide');
    showHideLayers('Layer'+iFlag,'','show');
    
    for(i=1;i<=LabNums;i++){
        if(i==iFlag){
            showHideLayers('Layer'+i,'','show');
            setColor('Lab'+i, '', '#83B5E6');
			setHight('Layer'+i,'400px');
			//height:400px;
        }else{
            showHideLayers('Layer'+i,'','hidden');    
            setColor('Lab'+i, '', '#EFF6FE');
			setHight('Layer'+i,'0px');
        }
    }    
}


var GL_Flag="01";
function showGLZK(selObj){

    
    var myValue=selObj.options[selObj.selectedIndex].value;
    //alert(myValue);
    if(myValue==GL_Flag){
        showHideLayers('LabTitle_GLZK','','show');
        showHideLayers('LabTitle_XSBX','','show');
    }else{
        showHideLayers('LabTitle_GLZK','','hidden');
        showHideLayers('LabTitle_XSBX','','hidden');
    }
    
}

function showGLZKByValue(myValue){    
    
    //alert(myValue);
    if(myValue==GL_Flag){
        showHideLayers('LabTitle_GLZK','','show');
        showHideLayers('LabTitle_XSBX','','show');
    }else{
        showHideLayers('LabTitle_GLZK','','hidden');    
        showHideLayers('LabTitle_XSBX','','hidden');
        
    }
}

function showGLZK_Update(selObj,selObj_hidden){    
    var myValue=selObj.options[selObj.selectedIndex].value;
    
    var myValue_hidden=selObj_hidden.value;
    //alert(myValue_hidden);
    
    //alert(myValue);
    
    if((myValue_hidden==GL_Flag)&&(myValue!=GL_Flag)){
           
        alert("警告：重点人口转为非重点人口时，该工作对象的管理状况信息将被系统删除!!!");
    }
    
    if(myValue==GL_Flag){
        showHideLayers('LabTitle_GLZK','','show');
        showHideLayers('LabTitle_XSBX','','show');
        
    }else{
        showHideLayers('LabTitle_GLZK','','hidden');    
        showHideLayers('LabTitle_XSBX','','hidden');
    }
}

//-->
//@desc    load a page(some html) via xmlhttp,and display on a container
//@param   url          the url of the page will load,such as "index.php"
//@param   request      request string to be sent,such as "action=1&name=surfchen"
//@param   method       POST or GET
//@param   container          the container object,the loaded page will display in container.innerHTML
//@usage 
//         ajaxLoadPage('index.php','action=1&name=surfchen','POST',document.getElementById('my_home'))
//         suppose there is a html element of "my_home" id,such as "<span id='my_home'></span>" 
//@author  SurfChen <surfchen@gmail.com>
//@url     http://www.surfchen.org/
//@license http://www.gnu.org/licenses/gpl.html GPL
function ajaxLoadPage(url,request,method,container,fun)
{
	method=method.toUpperCase();
	var loading_msg='Loading...';//the text shows on the container on loading.
	var loader=false;
	 if(window.XMLHttpRequest) {
    	try {
			loader = new XMLHttpRequest();
        } catch(e) {
			loader = false;
        }
    // branch for IE/Windows ActiveX version
    } else if(window.ActiveXObject) {
       	try {
        	loader = new ActiveXObject("Msxml2.XMLHTTP");
      	} catch(e) {
        	try {
          		loader = new ActiveXObject("Microsoft.XMLHTTP");
        	} catch(e) {
          		loader = false;
        	}
		}
    }
	if (method=='GET')
	{
		urls=url.split("?");
		if (urls[1]=='' || typeof urls[1]=='undefined')
		{
			url=urls[0]+"?"+request;
		}
		else
		{
			url=urls[0]+"?"+urls[1]+"&"+request;
		}
		
		request=null;//for GET method,loader should send NULL
	}
	loader.open(method,url,true);
	if (method=="POST")
	{
		loader.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}
	loader.onreadystatechange=function(){
		if (loader.readyState==1)
		{
			container.innerHTML=loading_msg;
			
		}
		if (loader.readyState==4)
		{
			container.innerHTML=loader.responseText;
			if(fun)window[fun](loader);
		}
	}
	loader.send(request);
}
//@desc    transform the elements of a form object and their values into request string( such as "action=1&name=surfchen")
//@param   form_obj          the form object
//@usage   formToRequestString(document.form1)
//@notice  this function can not be used to upload a file.if there is a file input element,the func will take it as a text input.
//         as I know,because of the security,in most of the browsers,we can not upload a file via xmlhttp.
//         a solution is iframe.
//@author  SurfChen <surfchen@gmail.com>
//@url     http://www.surfchen.org/
//@license http://www.gnu.org/licenses/gpl.html GPL
function formToRequestString(form_obj)
{
	var query_string='';
	var and='';
	//alert(form_obj.length);
	for (i=0;i<form_obj.length ;i++ )
	{
		e=form_obj[i];
		if (e.name!='')
		{
			if (e.type=='select-one')
			{
				element_value=e.options[e.selectedIndex].value;
			}
			else if (e.type=='checkbox' || e.type=='radio')
			{
				if (e.checked==false)
				{
					break;	
				}
				element_value=e.value;
			}
			else
			{
				element_value=e.value;
			}
			query_string+=and+e.name+'='+element_value.replace(/\&/g,"%26");
			and="&"
		}
		
	}
	return query_string;
}

//@desc    no refresh submit(ajax) by using ajaxLoadPage and formToRequestString
//@param   form_obj          the form object
//@param   container          the container object,the loaded page will display in container.innerHTML
//@usage   ajaxFormSubmit(document.form1,document.getElementById('my_home'))
//@author  SurfChen <surfchen@gmail.com>
//@url     http://www.surfchen.org/
//@license http://www.gnu.org/licenses/gpl.html GPL
function ajaxFormSubmit(form_obj,container,fun)
{
	ajaxLoadPage(form_obj.getAttributeNode("action").value,formToRequestString(form_obj),form_obj.method,container,fun)
}
function $() {//相当于document.getElementById("")或getElementsByName
  var es = new Array();
  for (var i = 0; i < arguments.length; i++) {
    var e = arguments[i];
    if (typeof(e) == 'string'){
		if(document.getElementById(e)){
           e = document.getElementById(e);
		}
		else
		{e = document.getElementsByName(e);}
    if (arguments.length == 1)
		{return e;}
	}
    es.push(e);
  }
  return es;
}


//创建 http_request 对象
function makeRequest(url) {
	http_request = false;
	if (window.XMLHttpRequest) { // Mozilla, Safari,...
		try{
			http_request = new XMLHttpRequest();
		}
		catch(e){
			return false;
		}
	} 
	else if (window.ActiveXObject) { // IE
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} 
		catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} 
			catch (e) {
				return false;
			}
		}
	}

	if (!http_request) {
		alert('Giving up :( Cannot create an XMLHTTP instance');
		return false;
	}

	if (http_request.overrideMimeType) {
		http_request.overrideMimeType('text/xml');
	}

	http_request.onreadystatechange = complete;
	http_request.open('GET', url, false);
	http_request.send(null);
}

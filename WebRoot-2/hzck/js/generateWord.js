//此脚本用于文书生成，主要是跟据数据库中存的Word模板文件生成所需文书
function GenerateWord(template,destdoc){
	/*Word Application对象*/
	var wordApplication;
  /*Word Document对象*/
	var wordDcoument;

	/*模板路径可是如下格式http://localhost:8080/zfyw/printBG/readaaa.jsp?templateId=123*/
	this.template = template;

	/*生的目标文件地址*/
	this.destdoc = destdoc;
	
	/*初始化程序所必须数据*/
	this.init = function(){
		try{
			wordApplication =new ActiveXObject("word.Application"); 	
			wp = wordApplication;
			wordDocument = wordApplication.documents.open(this.template);
			wordDocument.Activate();
			//wordApplication.visible=true;
		} catch(er) {			
			window.prompt("请尝试用ie打开下面的链接,在ie提示打开时,选择打开,之后再点击编辑按钮!",this.template);			
			return;
		}
	}
	this.checkexist = function(){
		try{
		  //alert(wordApplication.Version);
	    var WV = wordApplication.Version;
	    return true;
	   }catch(errq){
	    return false;
	   }
	}	
	this.visible=function(visible)
	{		
		if(visible) 
			wordApplication.visible=true;
		else
			wordApplication.visible=false;
	}
	/*替换文档中的所有对应文本*/
	this.replaceText = function (key,values) {
		try{
			wordDocument.Content.Select();
			this.replacement(key,values);
			}catch(ex) {
				wordApplication.quit();
				return;
			}
	}

	/*替换文本框内的内容*/
	this.replaceTextFrame = function(key,values) {
		try {
			for(var i=1;i<=wordDocument.shapes.count;i++){
				if(wordDocument.shapes(i).type==1){
					wordDocument.shapes(i).textFrame.textRange.Select();
					this.replacement(key,values);
				}
			}
		} catch(ex) {
			wordApplication.quit();
			return;
		}
	}

	/*替换书签内容*/
	this.replaceBookMark = function(key,values) {
		try{
			if(wordDocument.bookmarks.exists(key) == true) {
				wordDocument.bookmarks(key).range.select();
				wordApplication.selection.text=values;
				return;
			}
		}catch(ex){
			wordApplication.quit();
			return;
		}
	}
	/*替换超连接*/
	this.replaceHypeLink = function(index,dispName,address){
		if(index<=0) return;
		try {
			wordDocument.hyperLinks(index).Address=address;
			wordDocument.hyperLinks(index).TextToDisplay=dispName;
		} catch(ee)
		{
			window.alert(ee.name+":"+ee.message);
			return;
		}
	}
	
	/*插入行表示在表前面或后面插入*/
	this.insertLine = function(tbl,updown) {
		if(tbl==0)
			return;
		var rowId=0;
		if(updown == 'top')
			rowId=1;
		if(updown == 'bottom')
			rowId=wordDocument.tables(tbl).rows.count;
		wordDocument.tables(tbl).rows.add(wordDocument.tables(tbl).rows(rowId));
	}
	
   /*
	*插入图像
	*/
	this.insertImage = function(fileName,left,top,widt,heigh) {
		try {
			var canvas = wordDocument.shapes.addPicture(fileName,true,true,left,top,widt,heigh);
			
			}catch(ex) {
				wordApplication.quit();
				return;
			}
	}
	
	
	/*执行替换操作*/
	this.replacement= function(key,values) {
		try{
		with(wordApplication.selection) {
			moveStart();
			with(find) {
				forward = true;
				format = true;
				matchCase= true;
				matchWholeWord =true;
				wrap = 1;
			}
			find.text = key;
			while(find.execute()== true) {
				text=values
				moveRight();
			}
		}
		}catch(ex){
			window.alert(ex.message);
		}		    
	}
	
   /*
	*替换所有的文本
	*/
	this.replaceAll = function(keys,values) {
		for(var i=0;i<keys.length;i++) {
			var kv=keys[i];
			var vv=values[kv];
			this.replaceText(kv,vv);
			this.replaceTextFrame(kv,vv);
			this.replaceText(kv,vv);
		}
		wordApplication.visible = true; 
		
	}

	this.insertFile = function(path,mark) {
		try{
		with(wordApplication.selection) {
			moveStart();
			with(find) {
				forward = true;
				format = true;
				matchCase= true;
				matchWholeWord =true;
				wrap = 1;
			}
			find.text = mark;
			if(find.execute()== true) {
				text=" ";
				insertFile(path);
			}
		}
		}catch(ex){
			window.alert(ex.message);
		}		    
	}
	/*保存文档*/
	this.save = function() {
		try{
			wordDocument.saveAs(this.destdoc);
		}catch(ee) {
			//window.alert("文档不能保存!!"+ee.message);
			return;
		}
	}

	
	/*关闭文档有及word应用*/
	this.close = function() {
		try{
			wordDocument.close();
			wordApplication.quit();
		}catch(ee) {
			//window.alert("word无法关闭!!"+ee.message);
			wordApplication.quit();
			return;
		} 
	}	
}


function newDocument()
{
	var wordApp ;
	var wordDoc ;
	try{
			wordApp =new ActiveXObject("word.Application"); 	
			
			return wordApp;
		} catch(er) {			
			window.alert("生成Word应用对象或文档对象有错!"+er.message);
			wordApp.quit();
			return;
		}
}

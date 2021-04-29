//�˽ű������������ɣ���Ҫ�Ǹ������ݿ��д��Wordģ���ļ�������������
function GenerateWord(template,destdoc){
	/*Word Application����*/
	var wordApplication;
  /*Word Document����*/
	var wordDcoument;

	/*ģ��·���������¸�ʽhttp://localhost:8080/zfyw/printBG/readaaa.jsp?templateId=123*/
	this.template = template;

	/*����Ŀ���ļ���ַ*/
	this.destdoc = destdoc;
	
	/*��ʼ����������������*/
	this.init = function(){
		try{
			wordApplication =new ActiveXObject("word.Application"); 	
			wp = wordApplication;
			wordDocument = wordApplication.documents.open(this.template);
			wordDocument.Activate();
			//wordApplication.visible=true;
		} catch(er) {			
			window.prompt("�볢����ie�����������,��ie��ʾ��ʱ,ѡ���,֮���ٵ���༭��ť!",this.template);			
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
	/*�滻�ĵ��е����ж�Ӧ�ı�*/
	this.replaceText = function (key,values) {
		try{
			wordDocument.Content.Select();
			this.replacement(key,values);
			}catch(ex) {
				wordApplication.quit();
				return;
			}
	}

	/*�滻�ı����ڵ�����*/
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

	/*�滻��ǩ����*/
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
	/*�滻������*/
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
	
	/*�����б�ʾ�ڱ�ǰ���������*/
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
	*����ͼ��
	*/
	this.insertImage = function(fileName,left,top,widt,heigh) {
		try {
			var canvas = wordDocument.shapes.addPicture(fileName,true,true,left,top,widt,heigh);
			
			}catch(ex) {
				wordApplication.quit();
				return;
			}
	}
	
	
	/*ִ���滻����*/
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
	*�滻���е��ı�
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
	/*�����ĵ�*/
	this.save = function() {
		try{
			wordDocument.saveAs(this.destdoc);
		}catch(ee) {
			//window.alert("�ĵ����ܱ���!!"+ee.message);
			return;
		}
	}

	
	/*�ر��ĵ��м�wordӦ��*/
	this.close = function() {
		try{
			wordDocument.close();
			wordApplication.quit();
		}catch(ee) {
			//window.alert("word�޷��ر�!!"+ee.message);
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
			window.alert("����WordӦ�ö�����ĵ������д�!"+er.message);
			wordApp.quit();
			return;
		}
}

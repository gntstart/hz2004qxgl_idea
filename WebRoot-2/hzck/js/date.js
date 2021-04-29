var _dropdown_parentwindow=null;
var _dropdown_parentbox=null;
var _dropdown_box=null;
var _date_dropdown_box=null;

var _calendarControl=null;

function initDropDownBox(dropDown_mode){
	_document_loading=true;

	_dropdown_parentwindow=window;
	_dropdown_parentbox=_dropdown_parentwindow._dropdown_box;
	_dropdown_parentwindow._dropdown_window=window;
	sizeDropDownBox();
	if (_dropdown_parentbox.filters.blendTrans.status!=2 && !(getIEVersion()<"5.5"))
		_dropdown_parentbox.filters.blendTrans.play();

	_dropdown_parentbox.prepared=true;
	var editor=_dropdown_parentbox.editor;
	if (editor) dropDownLocate();
	_document_loading=false;
}

function sizeDropDownBox(){
	function _sizeDropDownBox(new_width, new_height){
		with (_dropdown_box){
			var editor=_dropdown_box.editor;
			var maxHeight=parseInt(editor.getAttribute("dropdown_height"));
			if (isNaN(maxHeight) || maxHeight<20) maxHeight=220;

			var pos=getAbsPosition(editor, document.body);
			if (editor.getAttribute("attrib")=="dockeditor")
				var _posLeft=pos[0]+2;
			else
				var _posLeft=pos[0]+1;
			var _posTop=pos[1]+editor.offsetHeight+1;

			if (new_height>maxHeight &&
				!(editor.getAttribute("dropdown_mode")=="data" && getInt(editor.getAttribute("dropDown_pageSize"))>0)){
				new_height=maxHeight;
				new_width+=16;
				if (!(getIEVersion()<"5.5"))
					style.overflowY="scroll";
				else
					style.overflowY="visible";
			}
			else{
				style.overflowY="hidden";
			}			

			var document_width=document.body.clientWidth + document.body.scrollLeft;
			var document_height=document.body.clientHeight + document.body.scrollTop;

			if (_posLeft+new_width>document_width && document_width>new_width) _posLeft=document_width-new_width;
			if (_posTop+new_height>document_height && pos[1]>new_height) _posTop=pos[1]-new_height-1;
			style.posLeft=_posLeft;
			style.posTop=_posTop;
			style.posHeight=new_height;
			if (new_width>style.posWidth) style.posWidth=new_width;
		}
	}

	if (!isDropdownBoxVisible()) return;

	try{
		var _width, _height;
		_width=CalendarTable.offsetWidth;
		_height=CalendarTable.offsetHeight;
		_sizeDropDownBox(_width, _height);
	}
	catch(e){
		//do nothing
	}
}

function canDropDown(editor){
	return (editor.getAttribute("dropDown_mode") &&
		!compareText(editor.type, "checkbox"));
}

function getDropDownBox(editor){
	var needCreate=true;

	if (editor.getAttribute("dropDown_mode")=="date"){
		needCreate=false;
		_dropdown_box=_date_dropdown_box;
	}
	if (needCreate || !_dropdown_box){
		_dropdown_box=document.createElement("<DIV id=_calendar_div style=\"z-index:99;overflow-X: hidden; position: absolute; visibility: hidden; filter: blendTrans(duration=0.3)\"></DIV>");
		document.body.appendChild(_dropdown_box);
	}
}

function getDropDownBtn(){
	if  (typeof(_dropdown_btn)=="undefined"){
		obj=document.createElement("<INPUT id=_dropdown_btn type=button tabindex=-1 value=6 hidefocus=true"+
			" style=\"position: absolute; visibility: hidden; border: #333333 1px solid; font-family: Marlett; font-size: 10px; cursor: hand; z-index: 9999\""+
			" LANGUAGE=javascript onmousedown=\"return _dropdown_btn_onmousedown(this)\" onfocus=\"return _dropdown_btn_onfocus(this)\" "+
			" onmouseover=\"return _button_onmouseover()\" onmouseout=\"return _button_onmouseout()\">");
		document.body.appendChild(obj);
		return obj;
	}
	else{
		return _dropdown_btn;
	}
}

function showDropDownBox(_editor){
	try{
		if (!canDropDown(_editor)) {
		    return;
		}
		if (!isDropdownBoxVisible()){
			getDropDownBox(_editor);
			_dropdown_box.prepared=false;
			if (_dropdown_box.filters.blendTrans.status==2) return;

			with (_dropdown_box){
				style.overflowY="hidden";
				setAttribute("editor", _editor);

				var dropDown_mode=_editor.getAttribute("dropDown_mode");
				setAttribute("dropDown_mode", dropDown_mode);

				switch (dropDown_mode){
					default:{
						if (filters.blendTrans.status!=2) {
							if (!(getIEVersion()<"5.5")) filters.blendTrans.apply();
							style.visibility="visible";
						}
						break;
					}
				}
				
				switch (dropDown_mode){
					case "date":{
						createCalendar(_dropdown_box);
						initDropDownBox(dropDown_mode);
						_dropdown_box.onkeydown=_calendar_onkeydown;
						break;
					}
				}
			}
			_editor.dropDown_visible=true;
			if  (typeof(_dropdown_btn)!="undefined") _dropdown_btn.value="5";
		}
	} catch(e){
		processException(e);
	}
}

function hideDropDownBox(){
	if (!_dropdown_box) return;
	if (isDropdownBoxVisible()){
		_skip_activeChanged=true;
		var editor=_dropdown_box.editor;
		_date_dropdown_box=_dropdown_box;

		if (getIEVersion()<"5.5"){
			for (var i=0; i<_dropdown_box.children.length; i++){
				_dropdown_box.children[i].style.visibility="hidden"
			}
		}
		_dropdown_box.style.visibility="hidden";
		_dropdown_window=null;

		editor.dropDown_visible=false;
		if  (typeof(_dropdown_btn)!="undefined") _dropdown_btn.value="6";
	}
}

function isDropDownBtnVisible(){
	if  (typeof(_dropdown_btn)!="undefined")
		return (_dropdown_btn.style.visibility=="visible")
	else
		return false;
}

function sizeDropDownBtn(_editor){
	if (!isDropDownBtnVisible()) return;
	with (_dropdown_btn){
		var pos=getAbsPosition(_editor);

		style.height=_editor.offsetHeight;
		style.width=16;
		style.posLeft=pos[0]+_editor.offsetWidth-offsetWidth;
		style.posTop=pos[1];
	}
}

function showDropDownBtn(_editor){
	
	if(document.all["_calendar_div"])
		document.all["_calendar_div"].style.display = "block";
	
	if (!canDropDown(_editor)) return;
	getDropDownBtn();
	if (typeof(_dropdown_btn)=="undefined") return;

	with (_dropdown_btn){
		if (!isDropDownBtnVisible()){
			setAttribute("editor", _editor);
			style.visibility="visible";
			sizeDropDownBtn(_editor);

			var oldWidth=_editor.offsetWidth;
			_editor.style.borderRightWidth=16;
			_editor.style.width=oldWidth;
		}
	}
}

function hideDropDownBtn(){
	
	if(document.all["_calendar_div"])
		document.all["_calendar_div"].style.display = "none";
	
	if  (typeof(_dropdown_btn)=="undefined") return;

	if (isDropDownBtnVisible()){
		var _editor=_dropdown_btn.editor;
		if (_editor){
			var oldWidth=_editor.offsetWidth;
			_editor.style.borderRightWidth=1;
			_editor.style.width=oldWidth;
		}
		_dropdown_btn.style.visibility="hidden";
		_dropdown_btn.editor=null;
	}
}

function _dropdown_btn_onmousedown(button){
	var obj=button.editor;
	if (!isDropdownBoxVisible()){
		if (obj) showDropDownBox(obj);
	}
	else
		hideDropDownBox();
}

function _dropdown_btn_onfocus(button){
	var obj=button.editor;
	if (obj) obj.focus();
}


function dropDownLocate(){
	var editor=_dropdown_parentbox.editor;
	var _date=new Date(editor.value);
	if (!isNaN(_date)) setCalendarDate(_date);

}

function hideDropDown() {
	var editor=_dropdown_parentbox.editor;
	_dropdown_parentwindow.hideDropDownBox();
	editor.focus();
}

function processDropDownKeyDown(keycode) {
	switch(keycode){
		//Enter
		case 13:{
			dropDownSelected();
			break;
		}
		//ESC
		case 27:{
			hideDropDown();
			break;
		}
		//F2
		case 113:{
			hideDropDown();
			break;
		}
		//F7
		case 118:{
			hideDropDown();
			break;
		}
		default:{
			var editor=_dropdown_parentbox.editor;
			switch (editor.getAttribute("dropDown_mode")){
				case "date":{
					_calendar_onkeydown();
					break;
				}
				default:{
					if (typeof(dropDown_onKeyDown)!="undefined") dropDown_onKeyDown(keycode);
					break;
				}
			}
		}
	}
}

function dropDownSelected(){

    var value = new Date(_calendarControl.year, _calendarControl.month, _calendarControl.day,
    document.all.button_hour.value,document.all.button_Minutes.value);

    setElementValue(_dropdown_parentbox.editor,
					formatDateTime(value, _dropdown_parentbox.editor.getAttribute("dataType")));    
	hideDropDown();
}

function _dropdown_onkeydown(){
	processDropDownKeyDown(event.keyCode);
}

function _dropdown_onclick(){
	dropDownSelected();
	event.cancelBubble=true;
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

var _calendar_months, _calendar_days;

function createCalendar(parent_element){

	function calendar(){
	 	var today=new Date()
	 	this.todayDay=today.getDate();
		this.todayMonth=today.getMonth();
		this.todayYear=today.getFullYear();
	 	this.activeCellIndex=0;
	}

	_calendar_months=new Array(constJanuary, constFebrary, constMarch, constApril, constMay, constJune, constJuly, constAugust, constSeptember, constOctober, constNovember, constDecember);
	_calendar_days=new Array(constSunday, constMonday, constTuesday, constWednesday, constThursday, constFriday, constSaturday);
	_calendarControl=new calendar();

	var tmpHTML="";
	tmpHTML+="<TABLE id=\"CalendarTable\" border=1 bordercolor=silver rule=all width=260px cellspacing=0 cellpadding=2>";

	tmpHTML+="<TR class=calendar_title valign=top>";
	tmpHTML+="<TD>";
	tmpHTML+="<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=0 style=\"FONT-SIZE: 9pt; FONT-WEIGHT: bold\">";
	tmpHTML+="<TR>";
	tmpHTML+="<TD WIDTH=20% align=left>";
	tmpHTML+="<INPUT type=button attrib=button value=3 title=\""+constLastMonth+"\" style=\"FONT-SIZE:8;FONT-FAMILY: webdings\" onclick=\"changeCalendarDate(_calendarControl.preYear,_calendarControl.preMonth)\">";
	tmpHTML+="</TD>";
	tmpHTML+="<TD WIDTH=25% align=right id=\"monthValue\" nowrap>";
	tmpHTML+="</TD>";
	tmpHTML+="<TD WIDTH=10% id=\"yearValue\" nowrap>";
	tmpHTML+="</TD>";
	tmpHTML+="<TD WIDTH=25 align=center>";
	tmpHTML+="<TABLE CELLSPACING=0 CELLPADDING=0>";
	tmpHTML+="<TR>";
	tmpHTML+="<TD valign=bottom>";
	tmpHTML+="<INPUT type=button attrib=button value=5 title=\""+constLastYear+"\" style=\"HEIGHT: 10;FONT-SIZE:7;FONT-FAMILY: webdings\" onclick=\"changeCalendarDate(_calendarControl.year-1,_calendarControl.month)\">";
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";
	tmpHTML+="<TR>";
	tmpHTML+="<TD valign=top>";
	tmpHTML+="<INPUT type=button attrib=button value=6 title=\""+constNextYear+"\" style=\"HEIGHT: 10;FONT-SIZE: 7;FONT-FAMILY: webdings\" onclick=\"changeCalendarDate(_calendarControl.year+1,_calendarControl.month)\">";
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";
	tmpHTML+="</TABLE>";
	tmpHTML+="</TD>";
	tmpHTML+="<TD WIDTH=20% align=right>";
	tmpHTML+="<INPUT type=button attrib=button value=4 title=\""+constNextMonth+"\" style=\"FONT-SIZE: 8;FONT-FAMILY: webdings\" onclick=\"changeCalendarDate(_calendarControl.nextYear,_calendarControl.nextMonth)\">";
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";
	tmpHTML+="</TABLE>";
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";
	tmpHTML+="<TR class=calendar_week>";
	tmpHTML+="<TD>";
	tmpHTML+="<TABLE WIDTH=100% HEIGHT=5% CELLSPACING=0 CELLPADDING=0 id=\"calendarWeek\" style=\"FONT-SIZE: 9pt\">";
	tmpHTML+="<TR>";
	for (var i=0;i<=6;i++){
		tmpHTML+="<TD width=14% align=center>"+_calendar_days[i]+"</TD>";
	}
	tmpHTML+="</TR>";
	tmpHTML+="</TABLE>";
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";

	tmpHTML+="<TR class=calendar_data>";
	tmpHTML+="<TD>";
	tmpHTML+="<TABLE HEIGHT=30% id=\"calendarData\" HEIGHT=100% WIDTH=100% CELLSPACING=0 CELLPADDING=0 style=\"PADDING-TOP: 0px; FONT-SIZE: 9pt; CURSOR: hand\"";
	tmpHTML+="onclick=\"_calendar_cell_onclick(event.srcElement)\">";

	for(var i=0;i<=5;i++){
		tmpHTML+="<TR HEIGHT=10%>";
		for(var j=0;j<=6;j++){
			tmpHTML+="<TD align=center></TD>";
		}
		tmpHTML+="</TR>";
	}
	tmpHTML+="</TABLE>";
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";

	tmpHTML+="<TR class=calendar_footer>";
	tmpHTML+="<TD align=right>"; 
	
	tmpHTML+="<INPUT attrib=text type=button id=\"button_today\" value=\""+constToday+" "+_calendarControl.todayYear+"-"+(_calendarControl.todayMonth+1)+"-"+_calendarControl.todayDay+"\" onclick=\"_calendar_today_onclick()\" ";
	tmpHTML+="style=\"height: 16\">";
	
	tmpHTML+="  时间<INPUT attrib=text type=text id=\"button_hour\" value='"+new Date().getHours()+"' ";
	tmpHTML+="style=\"height: 16 ;width:24\">  :  ";
	
	tmpHTML+="<INPUT attrib=text type=text id=\"button_Minutes\" value='"+new Date().getMinutes()+"'";
	tmpHTML+="style=\"height:16; width:24 \">";
	
	
	tmpHTML+="</TD>";
	tmpHTML+="</TR>";
	tmpHTML+='</TABLE><iframe src="javascript:false" style="position:absolute; visibility:inherit; top:0px; left:0px; width:260px; height:160px; z-index:-1;filter=progid:DXImageTransform.Microsoft.Alpha(style=1,opacity=1);"></iframe>';
	if (parent_element)
		parent_element.innerHTML=tmpHTML;
	else
		document.body.innerHTML=tmpHTML;

	initElements(CalendarTable);
	changeCalendarDate(_calendarControl.todayYear,_calendarControl.todayMonth,_calendarControl.todayDay)
}

function setCalendarDate(date){
	changeCalendarDate(date.getFullYear(),date.getMonth(),date.getDate());
}

function changeCalendarDate(year, month, day){
	if (_calendarControl.year==year && _calendarControl.month==month && (!day || _calendarControl.day==day)) return;

	if (_calendarControl.year!=year || _calendarControl.month!=month){
		_calendarControl.year=year;
		_calendarControl.month=month;

		if (month==0){
			 _calendarControl.preMonth=11
			 _calendarControl.preYear=_calendarControl.year-1
		}else{
			 _calendarControl.preMonth=_calendarControl.month-1
			 _calendarControl.preYear=_calendarControl.year
		}
		if (month==11){
			_calendarControl.nextMonth=0
			_calendarControl.nextYear=_calendarControl.year+1
		}else{
			_calendarControl.nextMonth=_calendarControl.month+1
			_calendarControl.nextYear=_calendarControl.year

		}
		_calendarControl.startday=(new Date(year,month,1)).getDay()
		if (_calendarControl.startday==0) _calendarControl.startday=7
		var curNumdays=getNumberOfDays(_calendarControl.month,_calendarControl.year)
		var preNumdays=getNumberOfDays(_calendarControl.preMonth,_calendarControl.preYear)
		var nextNumdays=getNumberOfDays(_calendarControl.nextMonth,_calendarControl.nextYear)
		var startDate=preNumdays-_calendarControl.startday+1
		var endDate=42-curNumdays-_calendarControl.startday

		monthValue.innerText=_calendar_months[_calendarControl.month]+", "
		yearValue.innerText=_calendarControl.year

		var datenum=0
		for (var i=startDate;i<=preNumdays;i++){
			calendarData.cells[datenum].monthAttribute="pre";
			calendarData.cells[datenum].style.color="gray";
			calendarData.cells[datenum].innerText=i;
			datenum++;
		}
		for (var i=1;i<=curNumdays;i++){
			calendarData.cells[datenum].monthAttribute="cur";
			calendarData.cells[datenum].style.color="black";
			calendarData.cells[datenum].innerText=i;
			datenum++;
		}
		for (var i=1;i<=endDate;i++){
			calendarData.cells[datenum].monthAttribute="next";
			calendarData.cells[datenum].style.color="gray";
			calendarData.cells[datenum].innerText=i;
			datenum++;
		}
	}

	if (day) _calendarControl.day=day;
	setCalendarActiveCell(calendarData.cells[_calendarControl.day+_calendarControl.startday-1]);
}

function setCalendarActiveCell(cell){

	function setActiveCell(cellIndex){
		calendarData.cells[_calendarControl.activeCellIndex].style.backgroundColor="";
		calendarData.cells[cellIndex].style.backgroundColor="#ffebcd";
		_calendarControl.activeCellIndex=cellIndex;
		activeCell=_calendarControl.activeCellIndex%7
		activeRow=Math.floor(_calendarControl.activeCellIndex/7)
	}

	if (cell.tagName.toLowerCase()!="td") return;
	var _activeCellIndex=cell.parentElement.rowIndex*7+cell.cellIndex;

	with(_calendarControl){
		if (activeCellIndex==_activeCellIndex) return;

		var monthAttribute=cell.monthAttribute;
		switch (monthAttribute){
			case "pre":{
				changeCalendarDate(preYear,preMonth,getNumberOfDays(preMonth,preYear)-startday+_activeCellIndex+1);
				setActiveCell(startday+day-1);
				break
			}
			case "cur":{
				changeCalendarDate(year,month,_activeCellIndex-startday+1);
				setActiveCell(_activeCellIndex);
				break
			}
			case "next":{
				changeCalendarDate(nextYear,nextMonth,_activeCellIndex-getNumberOfDays(month,year)-startday+1);
				setActiveCell(startday+day-1);
				break
			}
		}
	}
}

function _calendar_cell_onclick(cell){
	setCalendarActiveCell(cell)
	dropDownSelected()
}

function _calendar_onkeydown(){
	switch(event.keyCode){
		case 33:{//PgUp
			if (event.ctrlKey){
				changeCalendarDate(_calendarControl.year-1,_calendarControl.month)
			}else{
				changeCalendarDate(_calendarControl.preYear,_calendarControl.preMonth)
			}
			break
		}
		case 34:{//PgDn
			if (event.ctrlKey){
				 changeCalendarDate(_calendarControl.year+1,_calendarControl.month)
			}else{
				 changeCalendarDate(_calendarControl.nextYear,_calendarControl.nextMonth)
			}
			break
		}
		case 35:{//End
		    	var index=getNumberOfDays(_calendarControl.month,_calendarControl.year) +_calendarControl.startday-1
			setCalendarActiveCell(calendarData.cells[index])
			break
		}
		case 36:{//Home
			setCalendarActiveCell(calendarData.cells[_calendarControl.startday])
			break
		}
		case 37:{//<--
			var index=_calendarControl.activeCellIndex-1;
			if (index<0) index=0;
			setCalendarActiveCell(calendarData.cells[index])
			break
		}
		case 38:{//上箭头
			if (_calendarControl.activeCellIndex<7){
				var day=getNumberOfDays(_calendarControl.preMonth,_calendarControl.preYear)+_calendarControl.day-7;
				setCalendarDate(new Date(_calendarControl.preYear, _calendarControl.preMonth, day));
			}
			else{
				var index=_calendarControl.activeCellIndex-7;
				setCalendarActiveCell(calendarData.cells[index]);
			}
			break
		}
		case 39:{//-->
			var index=_calendarControl.activeCellIndex+1;
			if (index>=calendarData.cells.length) index=calendarData.cells.length-1;
			setCalendarActiveCell(calendarData.cells[index])
			break
		}
		case 40:{//下箭头
			if (_calendarControl.activeCellIndex>34){
				var day=7-(getNumberOfDays(_calendarControl.month,_calendarControl.year)-_calendarControl.day);
				setCalendarDate(new Date(_calendarControl.nextYear, _calendarControl.nextMonth, day));
			}
			else{
				var index=_calendarControl.activeCellIndex+7;
				setCalendarActiveCell(calendarData.cells[index]);
			}
			break
		}
	}
}

function _calendar_today_onclick(){
	changeCalendarDate(_calendarControl.todayYear,_calendarControl.todayMonth,_calendarControl.todayDay)
	var index=_calendarControl.todayDay+_calendarControl.startday-1;
	setCalendarActiveCell(calendarData.cells[index]);
	dropDownSelected();
}

function getNumberOfDays(month,year){
	var numDays=new Array(31,28,31,30,31,30,31,31,30,31,30,31)
	n=numDays[month]
	if (month==1 && (year%4==0 && year%100!=0 || year%400==0)) n++
	return n
}  
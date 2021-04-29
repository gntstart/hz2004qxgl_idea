// Const
var mmenucolor				='#deefff';
var mmenubarcolor			='#deefff';
var mfontcolor				='MenuText';
var mmenuoutcolor			='#B5BED6';
var mmenuincolor			='#B5BED6';
var mmenuoutbordercolor			='#000084';
var mmenuinbordercolor			='#000084';
var outmmenuoutbordercolor		='#636563';
var outmmenuinbordercolor		='#636563';
var mmidoutcolor			='#808080';
var mmidincolor				='#808080';
var mmenuovercolor			='MenuText';
var mitemedge				='0';
var msubedge				='1';
var mmenuunitwidth			=80;
var mmenuitemwidth			=160;
var mmenuheight				=25;
var mmenuwidth				='100%';
var mmenuadjust				=0;
var mmenuadjustV			=-4;
var mfonts				='font-family: Verdana; font-size: 8pt; color: MenuText; ';
var mcursor				='default';

var _menu_table_array			= null;		// all the menu table model


// MenuTable Class
function MenuBarModel(id, view) {
	this.id = id;

	this.items = new Vector();
	if (typeof(view) == "string") {
		this.view = document.all[view];
	} else {
		this.view = view;
	}
	
	// handle items in the default behaviours
	if ((this.view.items != "undefined") && (this.view.items != "")) {
		var confs = this.view.items.split(";");
		for (var i=0; i< confs.length; i++) {
			var conf = confs[i].split(",");
				for (var j=0; j<conf.length; j++) {
					conf[j] = getDecodeStr(conf[j]);
				}
			var tempMenuModel = new MenuModel(conf[0], conf[1],conf[2],conf[3],conf[4],
						conf[5], conf[6],conf[7],conf[8],conf[9], conf[10], conf[11]);
			Vector_insert(this.items,"end",null,tempMenuModel);				
		}	
	}

	this.view.style.cursor = mcursor;
	this.view.style.zIndex = 100;
	this.view.onselectstart='event.returnValue=false';
	
	// Must associated this MenuBarModel object with the DIV object since they are one-to-one Model-View pattern
	this.view.model = this;
        	
	this.init 		= _menuBarModel_init;
	this.refresh		= _menuBarModel_refresh;
	this.getMenuModel		= _menuBarModel_getMenuModel;
	
	this.view.show		= _menuBar_show;
	this.view.hide		= _menuBar_hide; 	
}

function _menuBarModel_init() {
	var mwb = 1;
	var temp = '<table  border=0 cellpadding=1 cellspacing=1 width='+mmenuwidth+' height='+mmenuheight+' bgcolor='+mmenubarcolor+
     	' onselectstart="event.returnValue=false"'+
     	' style="cursor:'+mcursor+';'+mfonts+
 	
		' padding:0px"><tr>';
		
	var unit = this.items.firstUnit;
	while (unit != null) {
		var imgSize = "";
       	if(unit.sizeX!="0"||unit.sizeY!="0") {
       		imgsize=" width="+unit.sizeX+" height="+unit.sizeY;
       	}
       	
       	var space="";
       	if(unit.caption!="") {
       		space="&nbsp;";
       	}
		if (unit.caption != "-") { // if the menu is separator menu
			temp += "<td nowrap attrib=menu id=" + unit.id + " class=menu style='border: "+mitemedge+"px solid "+mmenucolor+
     			"' width="+mmenuunitwidth+"px onmouseover=_menuBar_menu_over(this) onmouseout=_menuBar_menu_out(this) onmousedown=_menuBar_menu_down(this) onmouseup=_menuBar_menu_up(this)";
     	    if(unit.pos=="left"){
     	       	temp += " align=center><img align=absmiddle src='"+unit.img+"'"+imgsize+">"+unit.caption+"</td>";	
     	    }else if(unit.pos=="right"){
     	       	temp += " align=center>"+unit.caption+"<img align=absmiddle src='"+unit.img+"'"+imgsize+"></td>";	
     	    }else if(unit.pos=="background"){
     	      	temp += " align=center background='"+unit.img+"'>"+unit.caption+"</td>";	
     	    }else{
     	       	temp += " align=center>"+unit.caption+"</td>";
     	    }
		} else { // Separator menu
			temp+='<td width="5"> <img height="1" width="1" src="none.gif" border="0"></td>';			
		}			
		unit = unit.nextUnit;
   	}
   	temp+="<td width=*>&nbsp;</td></tr></table>";
	this.view.innerHTML = temp;
	
	// Initialze menu view objects
	unit = this.items.firstUnit;
	while (unit != null) {
		view = document.all[unit.id];
		if (view != null) {
			view.dockMenu = this.view;
			view.model = unit;
			unit.view = view;
		
			// Check if the menu has a loop dock menu problem
			if (unit.isSubMenuLoop(unit.subMenu) == true) {
				throw constErrLoopMenu + "\n" + "DOCKMENU ID: " + this.id + "\n" + "MENU ID: " + unit.subMenu.id;
			}
		}
		unit = unit.nextUnit;
	}	
}

function _menuBarModel_refresh() {
	this.view.innerHTML="";
	this.init();	
}

function _menuBarModel_getMenuModel(menu_id) {
	var result = null;
	
	var unit = this.items.firstUnit;
	while (unit != null) {
		if (unit.id == menuId) {
			result = unit;
			break;
		}
		unit.nextUnit;	
	}
	return result;	
}

function _menuBar_show() {
	this.visibility = "visible"	
	// Active the menu bar
//	this.focus();	
}

function _menuBar_hide() {
	this.visibility = "hidden"	
}


// menu -- view object
function _menuBar_menu_over(menu){
	if (isTrue(menu.model.disable)) {
		return;
	}
	
	// Handle previous active menu
	if (menu.dockMenu.activeMenu != null){
		if (menu.dockMenu.activeMenu.model.subMenu != null) {
			// The menu has sub menu
			if (menu.id != menu.dockMenu.activeMenu.id) {
				if (menu.dockMenu.activeMenu.model.subMenu.style.visibility == "visible") {
					menu.dockMenu.activeMenu.model.subMenu.hide();
					if (menu.model.subMenu != null) {
						menu.model.subMenu.show(menu, "bottom");
					}
				}
			}
		}
		mnochange(menu.dockMenu.activeMenu);		
	}
	
	// Handle current active menu
	mtoin(menu);
	
	menu.dockMenu.activeMenu = menu;
//	menu.focus();
}

function _menuBar_menu_out(menu) {
	if (isTrue(menu.model.disable)) {
		return;
	}
	if (menu.model.subMenu != null) {
		if (menu.model.subMenu.style.visibility != "visible"){
			mnochange(menu);
		}
	} else {
		mnochange(menu);
	}
}

function _menuBar_menu_down(menu){
	if (isTrue(menu.model.disable)) {
		return;
	}
	
	if (menu.model.subMenu != null) {
		// Current menu has sub menu
		if (menu.model.subMenu.style.visibility == "visible"){
			menu.model.subMenu.hide();
			
		} else {
			menu.model.subMenu.show(menu,"bottom");
		}
	}
	else{
		 _menu_up(menu);
		alert("menu_down");
	}
}

function _menuBar_menu_up(menu) {
	if (isTrue(menu.model.disable)) {
		return;
	}
	mtoin(menu);	
}

function hideMenus() {
	var menus = document.all.tags("div");
	for (i=0; i<menus.length; i++) {
		switch (menus[i].attrib){
			case "dockmenu": {
				menus[i].hide();
				break;
			}
			case "menubar": {
				if (menus[i].activeMenu) {
					mnochange(menus[i].activeMenu);
				}
				break;
			}
		}
	}
}


// DockMenu class
// DockMenu is alwasy bound to a DIV object
// id -- DockMenu id
// view -- Attaching DockMenu View object
function DockMenuModel(id, view) {
	this.id = id;

	this.items = new Vector();
	if (typeof(view) == "string") {
		this.view = document.all[view];
	} else {
		this.view = view;
	}
		
	// handle items in the default behaviours
	if ((this.view.items != "undefined") && (this.view.items != "")) {
		var confs = this.view.items.split(";");
		for (var i=0; i< confs.length; i++) {
			var conf = confs[i].split(",");
						for (var j=0; j<conf.length; j++) {
							conf[j] = getDecodeStr(conf[j]);
						}
			var tempMenuModel = new MenuModel(conf[0], conf[1],conf[2],conf[3],conf[4],
						conf[5], conf[6],conf[7],conf[8],conf[9], conf[10], conf[11]);
			Vector_insert(this.items,"end",null,tempMenuModel);				
		}	
	}

	this.view.style.cursor = mcursor;
	this.view.style.position = 'absolute';
	this.view.style.width = mmenuitemwidth+'px';
	this.view.style.zIndex = 100;
    this.view.style.borderRight = '1px solid ';
    this.view.style.borderBottom = '1px solid ';	
    this.view.style.visibility = 'hidden';
	this.view.onselectstart='event.returnValue=false';
	
	// Must associated this DockMenu object with the DIV object since they are one-to-one Model-View pattern
	this.view.model = this;
        	
	this.init 		= _dockMenuModel_init;
	this.refresh		= _dockMenuModel_refresh;
	this.getMenuModel		= _dockMenuModel_getMenuModel;
	
	this.view.show		= _dockMenu_show;
	this.view.hide		= _dockMenu_hide; 
}

function _dockMenuModel_init() {
    var temp = '<table background="' + 'image/xpbg.gif" width="100%" border="0" height="100%" align="center" cellpadding="0" cellspacing="2" '+
	'style="'+mfonts+' border-left: 1px solid '+mmenuoutbordercolor;
	if(mmenuinbordercolor!=mmenuoutbordercolor&&msubedge=="0"){
				temp +=';border-right: 1px solid '+mmidincolor+	';border-bottom: 1px solid '+mmidincolor;
	}
	temp +=';border-top: 1px solid '+mmenuoutbordercolor+
		';padding: 4px " bgcolor='+mmenucolor+'>\n';
	
	var unit = this.items.firstUnit;
	var menuWidth=0;
	while (unit != null) {
		var imgSize = "";
        	if(unit.sizeX!="0"||unit.sizeY!="0") {
        		imgsize=" width="+unit.sizeX+" height="+unit.sizeY;
        	}
        	
        	var space="";
        	if(unit.caption!="") {
        		space="&nbsp;";
        	}

		if (unit.subMenu != null) { // The menu is docked a sub menu list
			temp += "<tr><td attrib=menu id=" +unit.id + " class=menu style='border: "+mitemedge+
				"px solid "+mmenucolor+	"' width=100% height=15px " + 
				"onmouseover=_menu_over(this) onmousedown=_menu_down(this)"+
				"><table cellspacing='0' cellpadding='0' border='0' width='100%' style='"+
				mfonts+"'><tr><td ";
	  		if(unit.pos=="left"){
            			temp += "><img align=absmiddle src='"+unit.img+"'"+imgsize+">"+space+unit.caption+"</td><td";	
          		}else if(unit.pos=="right"){
            			temp += ">"+unit.caption+space+"<img align=absmiddle src='"+unit.img+"'"+imgsize+"></td><td";
          		}else if(unit.pos=="background"){
            			temp += "background='"+unit.img+"'>"+unit.caption+"</td><td background='"+unit.img+"'";	
          		}else{
            			temp += ">&nbsp;&nbsp;&nbsp;&nbsp;"+space+unit.caption+"</td><td";
          		}
	  		temp += " align=right width='1'><font face='Webdings' style='font-size: 6pt'>4</font></td></tr></table></td></tr>\n";        	
			        	
		} else if (unit.caption != "-") { // if the menu is separator menu
			temp += "<tr><td attrib=menu id=" + unit.id + " class=menu style='border: "+mitemedge+
				"px solid "+mmenucolor+ "' width=100% height=15px " + 
				"onmouseover=_menu_over(this) onmousedown=_menu_down(this) onmouseup=_menu_up(this)";
	  		if(unit.pos=="left"){
            			temp += "><img align=absmiddle src='"+unit.img+"'"+imgsize+">"+space+unit.caption+"</td></tr>";	
          		}else if(unit.pos=="right"){
            			temp += ">"+unit.caption+ifspace+"<img align=absmiddle src='"+unit.img+"'"+imgsize+"></td></tr>";	
          		}else if(unit.pos=="background"){
            			temp += "background='"+unit.img+"'>"+space+unit.caption+"</td></tr>";	
          		}else{
            			temp += ">&nbsp;&nbsp;&nbsp;&nbsp;"+space+unit.caption+"</td></tr>";
          		}		
		} else { // Separator menu
			temp+='<tr><td  height="1" background="image/hr.gif" ><img height="1" width="1" src="none.gif" border="0"></td></tr>\n';			
		}
	
       	// last statement
		unit = unit.nextUnit;	
		menuWidth+=30;
	}
	temp+='</table><iframe src="javascript:false" style="position:absolute; visibility:inherit; top:0px; left:0px; width:160px; height:'+menuWidth+'px; z-index:-1;filter=progid:DXImageTransform.Microsoft.Alpha(style=1,opacity=1);"></iframe>';
	this.view.innerHTML = temp;
	
	// Initialze menu view objects
	unit = this.items.firstUnit;
	while (unit != null) {
		view = document.all[unit.id];
		if (view != null) {
			view.dockMenu = this.view;
			view.model = unit;
			unit.view = view;
			
			// Check if the menu has a loop dock menu problem
			if (unit.isSubMenuLoop(unit.subMenu) == true) {
				throw constErrLoopMenu + "\n" + "DOCKMENU ID: " + this.id + "\n" + "MENU ID: " + unit.subMenu.id;
			}
		}
		unit = unit.nextUnit;
	}
}

function _dockMenuModel_refresh() {
	this.view.innerHTML="";
	this.init();
}

// menuId menu model id
function _dockMenuModel_getMenuModel(menuId) {
	var result = null;
	
	var unit = this.items.firstUnit;
	while (unit != null) {
		if (unit.id == menuId) {
			result = unit;
			break;
		}
		unit.nextUnit;	
	}
	return result;
}

// placeHolder -- Place Holder if placeHolder is null, the docked menu will display in current cursor and ignore the pos parameter 
// pos -- Relative position associated with placeHolder. "left", "right", "top", "bottom"
function _dockMenu_show(placeHolder, pos) {
	if (placeHolder){
		var offsetLeft=0;
		var offsetTop=0;
	
		if (pos == "left") {
			offsetLeft-=this.offsetWidth;
			offsetTop-=placeHolder.offsetHeight;
		} else if (pos == "right") {
			offsetLeft=placeHolder.offsetWidth;
			offsetTop-=placeHolder.offsetHeight;	
		} else if (pos == "top") {
			offsetLeft-=this.offsetHeight;
			offsetTop-=placeHolder.offsetHeight;
		}
		
		var pos=getAbsPosition(placeHolder, document.body);
		pos[0]+=offsetLeft;
		pos[1]+=offsetTop;
		if (pos[0]<0) {
			pos[0]=0;
		} 
		
		if (pos[1]<0) {
			pos[1]=0;
		}
		
		if (pos[0]+placeHolder.offsetWidth+this.offsetWidth>document.body.clientWidth-2) {
			this.style.posLeft=pos[0]+placeHolder.offsetWidth-this.offsetWidth-2;
		} else {
			this.style.posLeft=pos[0];
		}

		if (pos[1]+placeHolder.offsetHeight+this.offsetHeight>document.body.clientHeight-2) {
			this.style.posTop=pos[1]+ placeHolder.offsetHeight-this.offsetHeight - 2;
		} else {
			this.style.posTop=pos[1]+placeHolder.offsetHeight+1;
		}
	} else{
		var tmp_left, tmp_top;
		if (event.x+this.offsetWidth>document.body.clientWidth-2)
			tmp_left=event.x-this.offsetWidth-5;
		else
			tmp_left=event.x-5;

		if (event.y+this.offsetHeight>document.body.clientHeight-2)
			tmp_top=event.y-this.offsetHeight-5;
		else
			tmp_top=event.y-5;

		this.style.posLeft=tmp_left+document.body.scrollLeft;
		this.style.posTop=tmp_top+document.body.scrollTop;
	}
	// Before the dock menu is showed, all its sub dock menu should be hidden
	var useFilter=true;
	if (this.style.visibility=="visible"){
		this.hide();
		useFilter=false;
	}	

	if (this.activeMenu != null) {
		mnochange(this.activeMenu);
	}
	this.style.visibility="visible";

}

function _dockMenu_hide() {
	// Hidden sub menu attached to its menu if any
	var unit = this.model.items.firstUnit;
	
	while (unit) {
		if (unit.subMenu) {
			if (unit.subMenu.style.visibility == "visible") {
				unit.subMenu.hide();
			}
		}
		unit = unit.nextUnit;
	}
	
	this.style.visibility = "hidden";
}

// Menu Class
// id -- Menu ID
// caption -- Menu display name. If the caption is '-', the menu is a special menu style, called separator menu
// linkable -- If the menu is hyper-linked
// linkUrl	-- Hyperlink URL, valid only if linkable is set true & dockMenu is null
// target -- Hyperlink URL target, valid only if linkable is set true & dockMenu is null
// disable -- If the menu is disable
// img -- Image URL
// sizeX -- Image width
// sizeY -- Image height
// pos -- image's position. "left" "rigth" "background"
// subMenu -- Associated sub menu view object. If the subMenu is not null, will display the subMenu when the menu is clicked
// view -- the menu view object
function MenuModel(id, caption, linkable, linkUrl, target, disable, img, sizeX, sizeY, pos, subMenu, view) {
	this.id 		= id;
	this.caption 		= caption;
	this.linkable 		= linkable;
	this.linkUrl 		= linkUrl;
	this.target		= target;
	this.disable		= disable;
	this.img		= img;
	this.sizeX		= sizeX;
	this.sizeY		= sizeY;
	this.pos		= pos;
	
	if (typeof(subMenu) == "string") {
		 this.subMenu = document.all[subMenu];
	} else {
		this.subMenu = subMenu;
	}
	
	if (typeof(view) == "string") {
		this.view = document.all[view];
	} else {
		this.view = view;
	}
	
	this.isSubMenuLoop 	= _menuModel_isSubMenuLoop;
	this.setSubMenu 	= _menuModel_setSubMenu;	
	this.setDisable		= _menuModel_setDisable;
}

// Check if the submenu is the same as current menu's dock menu holder to avoid self-loop
function _menuModel_isSubMenuLoop(subMenu) {
	var result=false;
	
	if (typeof(subMenu) == "string") {
		tmp = document.all[subMenu];
		if (tmp != null) {
			if (this.view.dockMenu.id == subMenu.id) {
				result = true;
			}				
		}
	} else if (typeof(subMenu) == "object") {
		if (this.view.dockMenu.id == subMenu.id) {
			result = true;
		}				
	}
	return result;
}

function _menuModel_setSubMenu(subMenu) {
	if (this.isSubMenuLoop(subMenu)) {
		throw constErrLoopMenu;
	}

	if (typeof(subMenu) == "string") {
		this.subMenu = document.all[subMenu];
	} else {
		this.subMenu = subMenu;
	}

}

function _menuModel_setDisable(flag) {
	this.disable = isTrue(flag);
}

function mtoout(src){
	src.style.border='solid 1';
	src.style.borderLeftColor=mmenuoutbordercolor;
	src.style.borderRightColor=mmenuinbordercolor;
	src.style.borderTopColor=mmenuoutbordercolor;
	src.style.borderBottomColor=mmenuinbordercolor;
	src.style.backgroundColor=mmenuoutcolor;
	src.style.color=mmenuovercolor;
}

function mtoin(src){
	src.style.border='solid 1';
	src.style.borderLeftColor=mmenuinbordercolor;
	src.style.borderRightColor=mmenuoutbordercolor;
	src.style.borderTopColor=mmenuinbordercolor;
	src.style.borderBottomColor=mmenuoutbordercolor;
	src.style.backgroundColor=mmenuincolor;
	src.style.color=mmenuovercolor;
}
function mnochange(src){
	src.style.borderLeftColor=mmenucolor;
	src.style.borderRightColor=mmenucolor;
	src.style.borderTopColor=mmenucolor;
	src.style.borderBottomColor=mmenucolor;
	src.style.backgroundColor='';
	src.style.color=mfontcolor;
	src.style.border='solid 0';
}

// menu -- view object
function _menu_over(menu){
	if (isTrue(menu.model.disable)) {
		return;
	}

	// Handle previous active menu
	if (menu.dockMenu.activeMenu != null){
		if (menu.dockMenu.activeMenu.model.subMenu != null) {
			// The menu has sub menu
			if (menu.dockMenu.activeMenu.model.subMenu.style.visibility == "visible") {
				menu.dockMenu.activeMenu.model.subMenu.hide();
			}
		}
		mnochange(menu.dockMenu.activeMenu);		
	}
	
	// Handle current active menu
	mtoin(menu);
	
	menu.dockMenu.activeMenu = menu;
	if (menu.model.subMenu != null) {
		// Current menu has sub menu
		menu.model.subMenu.show(menu,"right");
	}
}

function _menu_down(menu){
	if (isTrue(menu.model.disable)) {
		return;
	}
}

function _menu_up(menu){
	if (isTrue(menu.model.disable)) {
		return;
	}
		
	if (isTrue(menu.model.linkable)){
		if (menu.model.subMenu == null) {
			if (menu.model.target == "") {
				cmd = "window.open('" + menu.model.linkUrl + "')";
			} else {
				cmd = menu.model.target + ".location=\"" +menu.model.linkUrl + "\"";
			}
			hideMenus();
			eval(cmd);		
		}
	} else {
		if (menu.model.subMenu == null){
			hideMenus();
		}
	}
}

function getReal(el, type, value) {
	var temp = el;
	while ((temp != null) && (temp.tagName != "BODY")) {
		if (eval("temp." + type) == value) {
			el = temp;
			return el;
		}
		temp = temp.parentElement;
	}
	return el;
}



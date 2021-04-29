function SysCode(text,va,ischeck,key,parentKey,isLeaf,isAdd,nodes,checkall) { //创建节点数据对象
	this.text = text;
	this.va = va;
	this.ischeck=ischeck;
	this.key = key;
	this.parentKey = parentKey;
	this.isLeaf = isLeaf;
	this.isAdd = isAdd;
	this.nodes = nodes;	
	this.checkall = new String("check");
}

var parentKeys = "";

function createNodeDown(key) {//单击某节点时展开此节点并增加子节点,只产生一级节点
	
	
	var nodesT = nodeData[key].nodes;
	var node = tree1.nodes[key];
	if((node != null) && (nodesT != null)) {
		if(onlyDept=='false'){
			for(var i=0;i<nodesT.length;i++) {
				if((nodesT[i].isLeaf == 'leaf') && (nodesT[i].isAdd =='')) {
					tree1.addChkNode(node,nodesT[i].text,'default','','','',nodesT[i].va,nodesT[i].ischeck,nodesT[i].key);
					nodesT[i].isAdd="add";
				}
				if((nodesT[i].isLeaf == 'node') && (nodesT[i].isAdd =='')) {	
					var nodeA = tree1.addChkNode(node,nodesT[i].text,'folderclose','','','',nodesT[i].va,nodesT[i].ischeck,nodesT[i].key);
					nodesT[i].isAdd="add";
				}
			}
		}
	}
}


function getParentKey(key) {
	
	parentKeys = parentKeys + key+"@";
	var node = tree1.nodes[key];
	if((node == null))  {
		var sysCode = nodeData[key];
		getParentKey(sysCode.parentKey);
	}  else {
		return key;
	}
}
function createNodeUp(keys) { //由找到的key值生成一颗节点树
	var nodeArray = keys.split('@');
	nodeArray.reverse();
	
	for(var i=0;i<nodeArray.length-1;i++) {
		
		var nodesT = nodeData[nodeArray[i]].nodes;
		var node = tree1.nodes[nodeArray[i]];
		if(nodesT == null) {
			return;
		}else {
			node.expand(true);
			for(var j=0;j<nodesT.length;j++) {
				if(((onlyDept=='true') && (nodeData[nodeArray[i]].va==onlyNodekey))||((onlyDept=='false'))){
					if((nodesT[j].isLeaf == 'leaf') && (nodesT[j].isAdd =='')) {
						tree1.addChkNode(node,nodesT[j].text,'default','','','',nodesT[j].va,nodesT[j].ischeck,nodesT[j].key);
						nodesT[j].isAdd="add";
					}
				}
				if((nodesT[j].isLeaf == 'node') && (nodesT[j].isAdd =='')) {	
					var nodeA = tree1.addChkNode(node,nodesT[j].text,'folderclose','','','',nodesT[j].va,nodesT[j].ischeck,nodesT[j].key);
					nodesT[j].isAdd="add";
				}
				
			}
		}	
	}
}


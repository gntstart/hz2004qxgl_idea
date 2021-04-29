<!--
// Example: obj = findObj("image1");
function findObj(theObj)
{
  var p, i, foundObj;
  var theDoc
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
        else if(visStr == 'hide') visStr = 'hidden';
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


function switchLab(iFlag){
    var LabNums=5;//БъЧЉЪ§
            
    //showHideLayers("Layer1,'','show',Layer2,'','hide');
    showHideLayers('Layer'+iFlag,'','show');
    
    for(i=1;i<=LabNums;i++){
        if(i==iFlag){
            showHideLayers('Layer'+i,'','show');
            setColor('Lab'+i, '', '#D9ECFB');
			setHight('Layer'+i,'400px');
			//height:400px;
        }else{
            showHideLayers('Layer'+i,'','hidden');    
            setColor('Lab'+i, '', '#EFF6FE');
			setHight('Layer'+i,'0px');
        }
    }
}
//-->
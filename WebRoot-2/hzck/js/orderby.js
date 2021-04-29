function mouseover(img,item,imgpath)
  {
  switch (item)
    {
    case "asc" :
     // window.status = "";
      img.src = imgpath+"image/asc2.gif";
      break;

    case "desc" :
      //window.status = "";
      img.src = imgpath+"image/desc2.gif";
      break;
  }
}

function mouseout(img,item,imgpath)
  {
  switch (item)
    {
    case "asc" :
      //window.status = "";
      img.src = imgpath+"image/asc.gif";
      break;

    case "desc" :
     // window.status = "";
      img.src = imgpath+"image/desc.gif";
      break;
  }
}
/*
	包括整数、数值金额转换成为大写的函数
*/
var HanDigiStr = Array("零","壹","贰","叁","肆","伍","陆","柒","捌","玖");
var HanDigiStrSimple = Array("零","一","二","三","四","五","六","七","八","九");
var HanDiviStr = Array("","拾","佰","仟","万","拾","佰","仟","亿",	"拾","佰","仟","万","拾","佰","仟","亿",	"拾","佰","仟","万","拾","佰","仟" );
var HanDiviStrSimple = Array("","十","百","千","万","十","百","千","亿",	"十","百","千","万","十","百","千","亿",	"十","百","千","万","十","百","千" );

/*
	转换正整数为大写方式，支持负数，浮点数自动截去小数部分，非法数值自动转换为0
	isFanTi=true/false，是否使用繁体字
*/
function PositiveIntegerToHanStr(sNum, isFanTi)
{
	// 输入字符串必须正整数，只允许前导空格(必须右对齐)，不宜有前导零
	var RMBStr = "";
	var lastzero = false;
	var hasvalue= false;       // 亿、万进位前有数值标记
	var len=0, n=0;
	var nNum = parseInt(sNum);
	if(isNaN(nNum))
		nNum = 0;
	NumStr = ""+nNum;
	len = NumStr.length;
	if( len > 15 ) return "数值过大!";
	for(var i=len-1;i>=0;i--)
	{
		if( NumStr.charAt(len-i-1)=='-' )
		{
			RMBStr += "负";
			continue;
		}
		//if( NumStr.charAt(len-i-1)=='.' )
		//	return RMBStr;
		//if( NumStr.charAt(len-i-1)==' ' || NumStr.charAt(len-i-1)>'9' || NumStr.charAt(len-i-1) <'0' ) 
		//	continue;
		n = NumStr.charAt(len-i-1) - '0';
		if( n<0 || n>9 ) return "输入含非数字字符!";

		if( n!=0 ) 
		{
			if( lastzero )
			{
				if(isFanTi)
					RMBStr += HanDigiStr[0];  // 若干零后若跟非零值，只显示一个零
				else
					RMBStr += HanDigiStrSimple[0];  // 若干零后若跟非零值，只显示一个零
			}
			// 除了亿万前的零不带到后面
			//if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) )    // 如十进位前有零也不发壹音用此行
			if( !( n==1 && (i%4)==1 && i==len-1 ) )     // 十进位处于第一位不发壹音
			{
				if(isFanTi)
					RMBStr += HanDigiStr[n];
				else
					RMBStr += HanDigiStrSimple[n];
			}
			if(isFanTi)
				RMBStr += HanDiviStr[i];    // 非零值后加进位，个位为空
			else
				RMBStr += HanDiviStrSimple[i];    // 非零值后加进位，个位为空
			hasvalue = true;                                    // 置万进位前有值标记

		}
		else
		{
			if( (i%8)==0 || ((i%8)==4 && hasvalue) )  // 亿万之间必须有非零值方显示万
			{
				if(isFanTi)
					RMBStr += HanDiviStr[i];   // “亿”或“万”
				else
					RMBStr += HanDiviStrSimple[i];   // “亿”或“万”
			}
		}
		if( i%8==0 ) hasvalue = false ;      // 万进位前有值标记逢亿复位
		lastzero = (n==0) && (i%4!=0);
	}

	if( RMBStr.length==0 )
		return HanDigiStrSimple[0];         // 输入空字符或"0"，返回"零"
	return RMBStr;
}

/*
	转换数值金额为大写
	isFanTi=true/false，是否使用繁体字
*/
function NumToRMBStr(sVal, isFanTi)
{
	var SignStr ="" ;
	var TailStr ="";
	var  fraction, integer;
	var jiao,fen;

	var val = parseFloat(sVal);
	if(isNaN(val))
		val=0;
	
	if( val<0 ) {
		val = -val;
		SignStr = "负";
	}
	if(val > 99999999999999.999 || val <-99999999999999.999 ) return "数值位数过大!";
	// 四舍五入到分
	var temp = Math.round(val*100);
	integer = Math.floor(temp/100);
	fraction = temp%100;
	//jiao = (int)fraction/10;
	//fen = (int)fraction%10;
	jiao = Math.floor(fraction/10);
	fen = Math.floor(fraction%10);
	if( jiao==0 && fen==0 ) 
	{
		if(integer==0)
			TailStr = "零元";
		else
			TailStr = "整";
	}
	else 
	{
		if(isFanTi)
			TailStr = HanDigiStr[jiao];
		else
			TailStr = HanDigiStrSimple[jiao];
		if( jiao!=0 )
			TailStr += "角";
		if( integer==0 && jiao==0 )                // 零元后不写零几分
			TailStr = "";
		if( fen!=0 )
			TailStr += HanDigiStrSimple[fen] + "分";
	}

	// 下一行可用于非正规金融场合，0.03只显示“叁分”而不是“零元叁分”
	if( !integer ) return  SignStr+TailStr;

	//return "￥"+SignStr+PositiveIntegerToHanStr(""+integer,isFanTi)+"元"+TailStr;
	return SignStr+PositiveIntegerToHanStr(""+integer,isFanTi)+"元"+TailStr;
}

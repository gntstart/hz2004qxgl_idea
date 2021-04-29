/*
	������������ֵ���ת����Ϊ��д�ĺ���
*/
var HanDigiStr = Array("��","Ҽ","��","��","��","��","½","��","��","��");
var HanDigiStrSimple = Array("��","һ","��","��","��","��","��","��","��","��");
var HanDiviStr = Array("","ʰ","��","Ǫ","��","ʰ","��","Ǫ","��",	"ʰ","��","Ǫ","��","ʰ","��","Ǫ","��",	"ʰ","��","Ǫ","��","ʰ","��","Ǫ" );
var HanDiviStrSimple = Array("","ʮ","��","ǧ","��","ʮ","��","ǧ","��",	"ʮ","��","ǧ","��","ʮ","��","ǧ","��",	"ʮ","��","ǧ","��","ʮ","��","ǧ" );

/*
	ת��������Ϊ��д��ʽ��֧�ָ������������Զ���ȥС�����֣��Ƿ���ֵ�Զ�ת��Ϊ0
	isFanTi=true/false���Ƿ�ʹ�÷�����
*/
function PositiveIntegerToHanStr(sNum, isFanTi)
{
	// �����ַ���������������ֻ����ǰ���ո�(�����Ҷ���)��������ǰ����
	var RMBStr = "";
	var lastzero = false;
	var hasvalue= false;       // �ڡ����λǰ����ֵ���
	var len=0, n=0;
	var nNum = parseInt(sNum);
	if(isNaN(nNum))
		nNum = 0;
	NumStr = ""+nNum;
	len = NumStr.length;
	if( len > 15 ) return "��ֵ����!";
	for(var i=len-1;i>=0;i--)
	{
		if( NumStr.charAt(len-i-1)=='-' )
		{
			RMBStr += "��";
			continue;
		}
		//if( NumStr.charAt(len-i-1)=='.' )
		//	return RMBStr;
		//if( NumStr.charAt(len-i-1)==' ' || NumStr.charAt(len-i-1)>'9' || NumStr.charAt(len-i-1) <'0' ) 
		//	continue;
		n = NumStr.charAt(len-i-1) - '0';
		if( n<0 || n>9 ) return "���뺬�������ַ�!";

		if( n!=0 ) 
		{
			if( lastzero )
			{
				if(isFanTi)
					RMBStr += HanDigiStr[0];  // ���������������ֵ��ֻ��ʾһ����
				else
					RMBStr += HanDigiStrSimple[0];  // ���������������ֵ��ֻ��ʾһ����
			}
			// ��������ǰ���㲻��������
			//if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) )    // ��ʮ��λǰ����Ҳ����Ҽ���ô���
			if( !( n==1 && (i%4)==1 && i==len-1 ) )     // ʮ��λ���ڵ�һλ����Ҽ��
			{
				if(isFanTi)
					RMBStr += HanDigiStr[n];
				else
					RMBStr += HanDigiStrSimple[n];
			}
			if(isFanTi)
				RMBStr += HanDiviStr[i];    // ����ֵ��ӽ�λ����λΪ��
			else
				RMBStr += HanDiviStrSimple[i];    // ����ֵ��ӽ�λ����λΪ��
			hasvalue = true;                                    // �����λǰ��ֵ���

		}
		else
		{
			if( (i%8)==0 || ((i%8)==4 && hasvalue) )  // ����֮������з���ֵ����ʾ��
			{
				if(isFanTi)
					RMBStr += HanDiviStr[i];   // ���ڡ�����
				else
					RMBStr += HanDiviStrSimple[i];   // ���ڡ�����
			}
		}
		if( i%8==0 ) hasvalue = false ;      // ���λǰ��ֵ��Ƿ��ڸ�λ
		lastzero = (n==0) && (i%4!=0);
	}

	if( RMBStr.length==0 )
		return HanDigiStrSimple[0];         // ������ַ���"0"������"��"
	return RMBStr;
}

/*
	ת����ֵ���Ϊ��д
	isFanTi=true/false���Ƿ�ʹ�÷�����
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
		SignStr = "��";
	}
	if(val > 99999999999999.999 || val <-99999999999999.999 ) return "��ֵλ������!";
	// �������뵽��
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
			TailStr = "��Ԫ";
		else
			TailStr = "��";
	}
	else 
	{
		if(isFanTi)
			TailStr = HanDigiStr[jiao];
		else
			TailStr = HanDigiStrSimple[jiao];
		if( jiao!=0 )
			TailStr += "��";
		if( integer==0 && jiao==0 )                // ��Ԫ��д�㼸��
			TailStr = "";
		if( fen!=0 )
			TailStr += HanDigiStrSimple[fen] + "��";
	}

	// ��һ�п����ڷ�������ڳ��ϣ�0.03ֻ��ʾ�����֡������ǡ���Ԫ���֡�
	if( !integer ) return  SignStr+TailStr;

	//return "��"+SignStr+PositiveIntegerToHanStr(""+integer,isFanTi)+"Ԫ"+TailStr;
	return SignStr+PositiveIntegerToHanStr(""+integer,isFanTi)+"Ԫ"+TailStr;
}

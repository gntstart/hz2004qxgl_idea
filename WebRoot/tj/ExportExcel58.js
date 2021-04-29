var Base64 = (function() {
	// Private property
	var keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

	// 局部方法中文编码
	function utf8Encode(string) {
		string = string.replace(/\r\n/g, "\n");
		var utftext = "";
		for ( var n = 0; n < string.length; n++) {
			var c = string.charCodeAt(n);
			if (c < 128) {
				utftext += String.fromCharCode(c);
			} else if ((c > 127) && (c < 2048)) {
				utftext += String.fromCharCode((c >> 6) | 192);
				utftext += String.fromCharCode((c & 63) | 128);
			} else {
				utftext += String.fromCharCode((c >> 12) | 224);
				utftext += String.fromCharCode(((c >> 6) & 63) | 128);
				utftext += String.fromCharCode((c & 63) | 128);
			}
		}
		return utftext;
	}

	// 公共方法
	return {
		encode : (typeof btoa == 'function') ? function(input) {
			return btoa(utf8Encode(input));
		} : function(input) {
			var output = "";
			var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
			var i = 0;
			input = utf8Encode(input);
			while (i < input.length) {
				chr1 = input.charCodeAt(i++);
				chr2 = input.charCodeAt(i++);
				chr3 = input.charCodeAt(i++);
				enc1 = chr1 >> 2;
				enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
				enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
				enc4 = chr3 & 63;
				if (isNaN(chr2)) {
					enc3 = enc4 = 64;
				} else if (isNaN(chr3)) {
					enc4 = 64;
				}
				output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
						+ keyStr.charAt(enc3) + keyStr.charAt(enc4);
			}
			return output;
		}
	};
})();
// 设置xml文件格式
Ext.override(Ext.grid.GridPanel, {
					getExcelXml : function(includeHidden) {
						var worksheet = this.createWorksheet(includeHidden);
						var totalWidth = this.getColumnModel().getTotalWidth(includeHidden);
						return '<xml version="1.0" encoding="utf-8">'
								+ '<ss:Workbook xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:o="urn:schemas-microsoft-com:office:office">'
								+ '<o:DocumentProperties>' 
									+ '<o:Title>'
										+ this.title
									+ '</o:Title>' 
								+ '</o:DocumentProperties>'
								+ '<ss:ExcelWorkbook>'
									+ '<ss:WindowHeight>'
										+ worksheet.height
									+ '</ss:WindowHeight>'
									+ '<ss:WindowWidth>'
										+ worksheet.width
									+ '</ss:WindowWidth>'
									+ '<ss:ProtectStructure>False</ss:ProtectStructure>'
									+ '<ss:ProtectWindows>False</ss:ProtectWindows>'
								+ '</ss:ExcelWorkbook>'
								+ '<ss:Styles>'
									+ '<ss:Style ss:ID="Default">'
										+ '<ss:Alignment ss:Vertical="Top" ss:WrapText="1" />'
										+ '<ss:Font ss:FontName="arial" ss:Size="10" />'
										+ '<ss:Borders>'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Top" />'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Bottom" />'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Left" />'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Right" />'
										+ '</ss:Borders>'
										+ '<ss:Interior />'
										+ '<ss:NumberFormat />'
										+ '<ss:Protection />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="title">'
									+ '<ss:Borders />'
									+ '<ss:Font />'
									+ '<ss:Alignment ss:WrapText="1" ss:Vertical="Center" ss:Horizontal="Center" />'
									+ '<ss:NumberFormat ss:Format="@" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="headercell">'
									+ '<ss:Font ss:Bold="1" ss:Size="10" />'
									+ '<ss:Alignment ss:WrapText="1" ss:Horizontal="Center" />'
									+ '<ss:Interior ss:Pattern="Solid" ss:Color="#FFFFFF" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="even">'
									+ '<ss:Interior ss:Pattern="Solid" ss:Color="#FFFFFF" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:Parent="even" ss:ID="evendate">'
									+ '<ss:NumberFormat ss:Format="yyyy-mm-dd" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:Parent="even" ss:ID="evenint">'
									+ '<ss:NumberFormat ss:Format="0" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:Parent="even" ss:ID="evenfloat">'
									+ '<ss:NumberFormat ss:Format="0.00" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="odd">'
									+ '<ss:Interior ss:Pattern="Solid" ss:Color="#FFFFFF" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:Parent="odd" ss:ID="odddate">'
									+ '<ss:NumberFormat ss:Format="yyyy-mm-dd" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:Parent="odd" ss:ID="oddint">'
									+ '<ss:NumberFormat ss:Format="0" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s51">'
										+ '<ss:Alignment ss:Horizontal="Left" ss:WrapText="1" />'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s57">'
										+ '<ss:Alignment ss:Horizontal="Left" ss:WrapText="1" />'
										+ '<ss:Borders>'
											+ '<ss:Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
										+ '</ss:Borders>'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />'
										+ '<ss:Interior />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s61">'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />'
										+ '<ss:Borders>'
											+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
										+ '</ss:Borders>'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />'
										+ '<ss:Interior />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s69">'
										+ '<ss:Alignment ss:Vertical="Bottom" />'
										+ '<ss:Font ss:FontName="Arial" x:CharSet="1" ss:Size="10" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s70">'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="18" ss:Color="#000000" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s71">'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s79">'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />'
										+ '<ss:Borders>'
											+ '<ss:Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
										+ '</ss:Borders>'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />'
										+ '<ss:Interior />'
									+ '</ss:Style>'
									+ '<ss:Style ss:ID="s95">'
										+ '<ss:Alignment ss:Horizontal="Left" ss:WrapText="1" />'
										+ '<ss:Borders>'
											+ '<ss:Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
											+ '<ss:Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />'
										+ '</ss:Borders>'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />'
									+ '</ss:Style>'
									+ '<ss:Style ss:Parent="odd" ss:ID="oddfloat">'
									+ '<ss:NumberFormat ss:Format="0.00" />'
									+ '</ss:Style>'
								+ '</ss:Styles>'
									+ worksheet.xml 
								+ '</ss:Workbook>';
					},
					// 增加Excel工作表
					createWorksheet : function(includeHidden,values) {
						// Calculate cell data types and extra class names which
						// affect formatting
						var cellType = [];
						var cellTypeClass = [];
						var cm = this.getColumnModel();
						var totalWidthInPixels = 0;
						var colXml = '';
						var headerXml = '';
						var visibleColumnCountReduction = 0;
						var colCount = cm.getColumnCount();
						for ( var i = 0; i < colCount; i++) {
							if ((cm.getDataIndex(i) != '') && (includeHidden || !cm.isHidden(i))) {
								var w = cm.getColumnWidth(i)
								totalWidthInPixels += w;
								if (cm.getColumnHeader(i) === "") {
									cellType.push("None");
									cellTypeClass.push("");
									++visibleColumnCountReduction;
								} else {
									/*
									colXml += '<ss:Column ss:AutoFitWidth="1" ss:Width="' + w + '" />';
									*//**
										设置列名
									 *//*
									headerXml += '<ss:Cell ss:StyleID="headercell">'
													+ '<ss:Data ss:Type="String">'
														+ cm.getColumnHeader(i)
													+ '</ss:Data>'
													+ '<ss:NamedCell ss:Name="Print_Titles" />'
												+ '</ss:Cell>';
									*/
									var fld = this.store.recordType.prototype.fields.get(cm.getDataIndex(i));
									switch (fld.type) {
									case "int":
										cellType.push("Number");
										cellTypeClass.push("int");
										break;
									case "float":
										cellType.push("Number");
										cellTypeClass.push("float");
										break;
									case "bool":
									case "boolean":
										cellType.push("String");
										cellTypeClass.push("");
										break;
									case "date":
										cellType.push("DateTime");
										cellTypeClass.push("date");
										break;
									default:
										cellType.push("String");
										cellTypeClass.push("");
										break;
									}
								}
							}
						}
						var visibleColumnCount = cellType.length - visibleColumnCountReduction;

						var result = {
							height : 9000,
							width : Math.floor(totalWidthInPixels * 30) + 50
						};

						// Generate worksheet header details.
						var t = '<ss:Worksheet ss:Name="sheet1">'
								+ '<ss:Names>'
									+ '<ss:NamedRange ss:Name="Print_Titles" ss:RefersTo="=\'' + this.title + '\'!R1:R2" />' 
								+ '</ss:Names>'
								+ '<ss:Table x:FullRows="1" x:FullColumns="1"'
								+ 'ss:ExpandedColumnCount="' + (visibleColumnCount + 2)+ '" ' 
								+ 'ss:ExpandedRowCount="' + (this.store.getCount() + 2) + '" ' 
								+ 'ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5" >' 
//								+ colXml
								
								+ '<ss:Column ss:Index="1" ss:StyleID="Default" ss:AutoFitWidth="0" ss:Width="103.5" />'
								
								+ '<ss:Row ss:Height="22.5" >' 
									+ '<ss:Cell ss:StyleID="s70" ss:MergeAcross="28" >'
										+ '<ss:Data ss:Type="String">'
											+ '城 镇 人 口 增 减 情 况 统 计 年 报 表'
										+ '</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >' ;
									for ( var i = 0; i < 25; i++) {
										t += '<ss:Cell />';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="3" >'
											+ '<ss:Data ss:Type="String">'
												+ '表    号：公    业   58   表'
											+ '</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >';
									for ( var i = 0; i < 13; i++) {
										t += '<ss:Cell />';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="6" >'
										+ '<ss:Data ss:Type="String">'
											+ '统计时段：' //+ values.startDate + ' 至 ' + values.endDate
										+ '</ss:Data>'
									+ '</ss:Cell>';
									for ( var i = 0; i < 4; i++) {
										t += '<ss:Cell />';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="3" >'
										+ '<ss:Data ss:Type="String">'
											+ '文    号：公办〔201x〕xx  号'
										+ '</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >' ;
									for ( var i = 0; i < 25; i++) {
										t += '<ss:Cell />';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="3" >'
										+ '<ss:Data ss:Type="String">'
											+ '制表机关：公      安      部'
										+ '</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >' 
									+ '<ss:Cell ss:StyleID="s71" ss:MergeAcross="1" >'
										+ '<ss:Data ss:Type="String">'
											+ '填报单位：安徽省'
										+ '</ss:Data>'
									+ '</ss:Cell>';
									for ( var i = 0; i < 23; i++) {
										t += '<ss:Cell />';
									}
								t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="3" >'
										+ '<ss:Data ss:Type="String">'
											+ '备案机关：国  家  统  计  局'
										+ '</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >' 
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="9">'
										+ '<ss:Data ss:Type="String">填报单位</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="9">'
										+ '<ss:Data ss:Type="String">年末城镇人口数</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="20">'
										+ '<ss:Data ss:Type="String">增 加 情 况</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="5">'
										+ '<ss:Data ss:Type="String">减 少 情 况</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >' 
									+ '<ss:Cell ss:Index="3" ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">合计</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">出生</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">退出现役</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">港澳台人员和华侨回内地（回国）定居及外国人、无国籍人入籍</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="1">'
										+ '<ss:Data ss:Type="String">城镇人口迁入</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="13">'
										+ '<ss:Data ss:Type="String">农    业    转    移    人    口    落    户    城    镇</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">其他</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">合计</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">死亡</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">服现役</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">赴港澳台和国外定居及加入外国籍</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">城镇人口迁出</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="8">'
										+ '<ss:Data ss:Type="String">其他</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row ss:Height="14.25" >' 
									+ '<ss:Cell ss:Index="7" ss:StyleID="s79" ss:MergeDown="7">'
										+ '<ss:Data ss:Type="String">省内迁入</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="7">'
										+ '<ss:Data ss:Type="String">省外迁入</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="7">'
										+ '<ss:Data ss:Type="String">小计</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="2">'
										+ '<ss:Data ss:Type="String">来自地区</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="9">'
										+ '<ss:Data ss:Type="String">增 加 原 因</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>'
								+ '<ss:Row >' 
									+ '<ss:Cell ss:Index="10" ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">本市(地)</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">本省外市 (地)</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">外省</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">大中专院校招生</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">录(聘)用</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">务工经商</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">投资 (创业)</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">购(租)房</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">投靠亲属</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">移民搬迁</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">城中村改造</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">城乡属性调整</ss:Data>'
									+ '</ss:Cell>'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">'
										+ '<ss:Data ss:Type="String">其他</ss:Data>'
									+ '</ss:Cell>'
								+ '</ss:Row>';
								for ( var i = 0; i < 6; i++) {
									t += '<ss:Row />';
								}
							t += '<ss:Row ss:Height="14.25" >' 
									+ '<ss:Cell ss:StyleID="s57">'
										+ '<ss:Data ss:Type="String">甲</ss:Data>'
									+ '</ss:Cell>';
									for ( var i = 1; i <= 28; i++) {
										t += '<ss:Cell ss:StyleID="s79">'
												+ '<ss:Data ss:Type="Number">'+i+'</ss:Data>'
											+ '</ss:Cell>';
									}
								t += '</ss:Row>';

						// Generate the data rows from the data in the Store
						for ( var i = 0, it = this.store.data.items, l = it.length; i < l; i++) {
							t += '<ss:Row>';
							var cellClass = (i & 1) ? 'odd' : 'even';
							r = it[i].data;
							var k = 0;
							for ( var j = 0; j < colCount; j++) {
								if ((cm.getDataIndex(j) != '') && (includeHidden || !cm.isHidden(j))) {
									var v = r[cm.getDataIndex(j)];
									/**
										需要特殊处理一下
										将超链接标签移除
									 */
									if(v != null){
										if(v.lastIndexOf("<a") == -1){
											
										}else{
											v = v.substr(v.indexOf("\" >")+3,(v.lastIndexOf("<a") - 3 - v.indexOf("\" >")));
										}
									}
										if (cm.config[j].dict != null && cm.config[j].dict != 'undefinded' && v != null) {
											var name = getGridCodeName(this.id, v);
											if (name != null) {
												v = name;
											}
										}
										if (cellType[k] !== "None") {
											if(j == 0){
												t += '<ss:Cell ss:StyleID="s57">' ;
											}else{
												t += '<ss:Cell ss:StyleID="s79">' ;
											}
											t += '<ss:Data ss:Type="' + cellType[k] + '">';
											
											if(v != null){
												if (cellType[k] == 'DateTime') {
													t += v.format('Y-m-d');
												} else {
													t += v;
												}
											}else{
												t += "";
											}
											t += '</ss:Data></ss:Cell>';
										}
									k++;
								}
							}
							t += '</ss:Row>';
						}
						
							t += '<ss:Row ss:Height="14.25">' 
								+ '<ss:Cell ss:StyleID="s79">'
									+ '<ss:Data ss:Type="String">备注：</ss:Data>'
								+ '</ss:Cell>'
								+ '<ss:Cell ss:StyleID="s57" ss:MergeAcross="27" >'
									+ '<ss:Data ss:Type="String">'
									/*+ '一、在“农业转移人口落户城镇”中，农村籍大中专院校毕业生6748人,在城镇就业和居住五年以上的农业转移人口20785人，举家迁徙的农业转移人口15384人，农村籍退出现役人员1742人。' 
									+ '二、在“城镇人口迁入”和“农业转移人口落户城镇”中，具有专业技术职称的1565人，具有技能等级的1256人。'*/
									+ '</ss:Data>'
								+ '</ss:Cell>'
							+ '</ss:Row>'
							+ '<ss:Row ss:Height="14.25">' 
								+ '<ss:Cell ss:StyleID="s61">'
									+ '<ss:Data ss:Type="String">审核人：</ss:Data>'
								+ '</ss:Cell>'
								+ '<ss:Cell ss:StyleID="s61" ss:MergeAcross="1" />';
								for ( var i = 1; i <= 13; i++) {
									t += '<ss:Cell ss:StyleID="s61" />';
								}
							t += '<ss:Cell ss:StyleID="s61">'
									+ '<ss:Data ss:Type="String">填表人：</ss:Data>'
								+ '</ss:Cell>'
								+ '<ss:Cell ss:StyleID="s61" ss:MergeAcross="1">'
									+ '<ss:Data ss:Type="String">安徽省</ss:Data>'
								+ '</ss:Cell>'
								+ '<ss:Cell ss:StyleID="s61" />'
								+ '<ss:Cell ss:StyleID="s61" />'
								+ '<ss:Cell ss:StyleID="s61" />'
								+ '<ss:Cell ss:StyleID="s61" />'
								+ '<ss:Cell ss:StyleID="s61" />'
								+ '<ss:Cell ss:StyleID="s61" />'
								+ '<ss:Cell ss:StyleID="s61" ss:MergeAcross="2">'
									+ '<ss:Data ss:Type="String">' 
										
										+ '201x年xx月xx日' 
									+ '</ss:Data>'
								+ '</ss:Cell>'
								+ '<ss:Cell ss:StyleID="s61">'
									+ '<ss:Data ss:Type="String">填</ss:Data>'
								+ '</ss:Cell>'
							+ '</ss:Row>'
							;
						
						result.xml = t
								+ '</ss:Table>'
								+ '<x:WorksheetOptions>'
								+ '<x:PageSetup>'
								+ '<x:Layout x:CenterHorizontal="1" x:Orientation="Landscape" />'
								+ '<x:Footer x:Data="Page &amp;P of &amp;N" x:Margin="0.5" />'
								+ '<x:PageMargins x:Top="0.5" x:Right="0.5" x:Left="0.5" x:Bottom="0.8" />'
								+ '</x:PageSetup>'
								+ '<x:FitToPage />'
								+ '<x:Print>'
								+ '<x:PrintErrors>Blank</x:PrintErrors>'
								+ '<x:FitWidth>1</x:FitWidth>'
								+ '<x:FitHeight>32767</x:FitHeight>'
								+ '<x:ValidPrinterInfo />'
								+ '<x:VerticalResolution>600</x:VerticalResolution>'
								+ '</x:Print>'
								+ '<x:Selected />'
								+ '<x:DoNotDisplayGridlines />'
								+ '<x:ProtectObjects>False</x:ProtectObjects>'
								+ '<x:ProtectScenarios>False</x:ProtectScenarios>'
								+ '</x:WorksheetOptions>' + '</ss:Worksheet>';
						return result;
					}
				});

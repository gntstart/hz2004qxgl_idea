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
						var worksheet = this.createWorksheet(includeHidden,null);
						var totalWidth = this.getColumnModel().getTotalWidth(includeHidden);
						return '<xml version="1.0" encoding="utf-8">\n\r'
								+ '<ss:Workbook xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:o="urn:schemas-microsoft-com:office:office">\n\r'
								+ '<o:DocumentProperties>\n\r' 
									+ '<o:Title>\n\r'
										+ this.title + '\n\r'
									+ '</o:Title>\n\r' 
								+ '</o:DocumentProperties>\n\r'
								+ '<ss:ExcelWorkbook>\n\r'
									+ '<ss:WindowHeight>\n\r'
										+ worksheet.height + '\n\r'
									+ '</ss:WindowHeight>\n\r'
									+ '<ss:WindowWidth>\n\r'
										+ worksheet.width + '\n\r'
									+ '</ss:WindowWidth>\n\r'
									+ '<ss:ProtectStructure>False</ss:ProtectStructure>\n\r'
									+ '<ss:ProtectWindows>False</ss:ProtectWindows>\n\r'
								+ '</ss:ExcelWorkbook>\n\r'
								+ '<ss:Styles>\n\r'
									+ '<ss:Style ss:ID="Default">\n\r'
										+ '<ss:Alignment ss:Vertical="Top" ss:WrapText="1" />\n\r'
										+ '<ss:Font ss:FontName="arial" ss:Size="10" />\n\r'
										+ '<ss:Borders>\n\r'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Top" />\n\r'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Bottom" />\n\r'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Left" />\n\r'
											+ '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Right" />\n\r'
										+ '</ss:Borders>\n\r'
										+ '<ss:Interior />\n\r'
										+ '<ss:NumberFormat />\n\r'
										+ '<ss:Protection />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="title">\n\r'
									+ '<ss:Borders />\n\r'
									+ '<ss:Font />\n\r'
									+ '<ss:Alignment ss:WrapText="1" ss:Vertical="Center" ss:Horizontal="Center" />\n\r'
									+ '<ss:NumberFormat ss:Format="@" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="headercell">\n\r'
									+ '<ss:Font ss:Bold="1" ss:Size="10" />\n\r'
									+ '<ss:Alignment ss:WrapText="1" ss:Horizontal="Center" />\n\r'
									+ '<ss:Interior ss:Pattern="Solid" ss:Color="#FFFFFF" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="even">\n\r'
									+ '<ss:Interior ss:Pattern="Solid" ss:Color="#FFFFFF" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:Parent="even" ss:ID="evendate">\n\r'
									+ '<ss:NumberFormat ss:Format="yyyy-mm-dd" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:Parent="even" ss:ID="evenint">\n\r'
									+ '<ss:NumberFormat ss:Format="0" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:Parent="even" ss:ID="evenfloat">\n\r'
									+ '<ss:NumberFormat ss:Format="0.00" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="odd">\n\r'
									+ '<ss:Interior ss:Pattern="Solid" ss:Color="#FFFFFF" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:Parent="odd" ss:ID="odddate">\n\r'
									+ '<ss:NumberFormat ss:Format="yyyy-mm-dd" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:Parent="odd" ss:ID="oddint">\n\r'
									+ '<ss:NumberFormat ss:Format="0" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s51">\n\r'
										+ '<ss:Alignment ss:Horizontal="Left" ss:WrapText="1" />\n\r'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s57">\n\r'
										+ '<ss:Alignment ss:Horizontal="Left" ss:WrapText="1" />\n\r'
										+ '<ss:Borders>\n\r'
											+ '<ss:Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '<ss:Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '<ss:Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
										+ '</ss:Borders>\n\r'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />\n\r'
										+ '<ss:Interior />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s61">\n\r'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />\n\r'
										+ '<ss:Borders>\n\r'
											+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
										+ '</ss:Borders>\n\r'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />\n\r'
										+ '<ss:Interior />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s69">\n\r'
										+ '<ss:Alignment ss:Vertical="Bottom" />\n\r'
										+ '<ss:Font ss:FontName="Arial" x:CharSet="1" ss:Size="10" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s70">\n\r'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />\n\r'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="18" ss:Color="#000000" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s71">\n\r'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />\n\r'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s79">\n\r'
										+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" />\n\r'
										+ '<ss:Borders>\n\r'
											+ '<ss:Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '<ss:Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '<ss:Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
											+ '</ss:Borders>\n\r'
										+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />\n\r'
										+ '<ss:Interior />\n\r'
									+ '</ss:Style>\n\r'
									+ '<ss:Style ss:ID="s80">\n\r'
									+ '<ss:Alignment ss:Horizontal="Center" ss:WrapText="1" ss:Rotate="90" />\n\r'
									+ '<ss:Borders>\n\r'
										+ '<ss:Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
										+ '<ss:Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
										+ '<ss:Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
										+ '<ss:Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1" ss:Color="#000000" />\n\r'
										+ '</ss:Borders>\n\r'
									+ '<ss:Font ss:FontName="宋体" x:CharSet="134" ss:Size="12" ss:Color="#000000" />\n\r'
									+ '<ss:Interior />\n\r'
								+ '</ss:Style>\n\r'
									+ '<ss:Style ss:Parent="odd" ss:ID="oddfloat">\n\r'
									+ '<ss:NumberFormat ss:Format="0.00" />\n\r'
									+ '</ss:Style>\n\r'
								+ '</ss:Styles>\n\r';
								/*	+ worksheet.xml + '\n\r'
								+ '</ss:Workbook>\n\r';*/
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
						var t = '<ss:Worksheet ss:Name="sheet1">\n\r'
								+ '<ss:Names>\n\r'
									+ '<ss:NamedRange ss:Name="Print_Titles" ss:RefersTo="' + this.title + '" />\n\r' 
								+ '</ss:Names>\n\r'
								+ '<ss:Table x:FullRows="2" x:FullColumns="1"'
								+ ' ss:ExpandedColumnCount="' + (visibleColumnCount + 2)+ '" ' 
								+ ' ss:ExpandedRowCount="' + (this.store.getCount() + 2) + '" ' 
								+ ' ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5" >\n\r' 
//								+ colXml
								
								+ '<ss:Column ss:Index="1" ss:StyleID="Default" ss:AutoFitWidth="0" ss:Width="126.75" />\n\r'
								+ '<ss:Column ss:Index="22" ss:StyleID="s69" ss:Width="42.45" />\n\r'
								+ '<ss:Column ss:StyleID="s69" ss:Width="34.6" />\n\r'
								+ '<ss:Column ss:StyleID="s69" ss:Width="30.65" ss:Span="1" />\n\r'
								
								+ '<ss:Row ss:Height="22.5" >\n\r' 
									+ '<ss:Cell ss:StyleID="s70" ss:MergeAcross="20" >\n\r'
										+ '<ss:Data ss:Type="String">\n\r'
											+ '人 口 及 其 变 动 情 况 统 计 年 报 表'
										+ '</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
								+ '</ss:Row>\n\r'
								+ '<ss:Row ss:Height="14.25" >\n\r' ;
									for ( var i = 0; i < 16; i++) {
										t += '<ss:Cell />\n\r';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="4" >\n\r'
											+ '<ss:Data ss:Type="String">\n\r'
												+ '表    号：公    业   57   表'
											+ '</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
								+ '</ss:Row>\n\r'
								+ '<ss:Row ss:Height="14.25" >\n\r';
									for ( var i = 0; i < 6; i++) {
										t += '<ss:Cell />\n\r';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="6" >\n\r'
										+ '<ss:Data ss:Type="String">\n\r'
											+ '统计时段：' //+ values.startDate + ' 至 ' + values.endDate
										+ '</ss:Data>\n\r'
									+ '</ss:Cell>\n\r';
									for ( var i = 0; i < 3; i++) {
										t += '<ss:Cell />\n\r';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="4" >\n\r'
										+ '<ss:Data ss:Type="String">\n\r'
											+ '文    号：公办〔201x〕xx  号'
										+ '</ss:Data>\n\r'
									+ '</ss:Cell>\n\r';
							t += '</ss:Row>\n\r'
								+ '<ss:Row ss:Height="14.25" >\n\r' ;
									for ( var i = 0; i < 16; i++) {
										t += '<ss:Cell />\n\r';
									}
									t += '<ss:Cell ss:StyleID="s71" ss:MergeAcross="4" >\n\r'
										+ '<ss:Data ss:Type="String">\n\r'
											+ '制表机关：公      安      部'
										+ '</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="6">\n\r'
										+ '<ss:Data ss:Type="String">填报单位</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s80" ss:MergeDown="6">\n\r'
										+ '<ss:Data ss:Type="String">年末总户数︵户︶</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="8" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">年 末 总 人 口</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="9" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">本 年 度 人 口 变 动</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell /><ss:Cell /><ss:Cell /><ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:Index="22" />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:Index="3" ss:StyleID="s79" ss:MergeDown="4">\n\r'
										+ '<ss:Data ss:Type="String">合计</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="4">\n\r'
										+ '<ss:Data ss:Type="String">城镇人口</ss:Data>\n\r'
									+'</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="4">\n\r'
										+ '<ss:Data ss:Type="String">乡村人口</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="1" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">性 别</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="3" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">年 龄</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="2" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">出 生</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="2" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">死 亡</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="1" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">迁 入</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeAcross="1" ss:MergeDown="1">\n\r'
										+ '<ss:Data ss:Type="String">迁 出</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:Index="22" />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:Index="6" ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">男</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">女</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">0-17岁</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">18-34岁</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">35-59岁</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">60岁及以上</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">合计</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">男</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">女</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">合计</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">男</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">女</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">省内迁入</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">省外迁入</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">迁往省内</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell ss:StyleID="s79" ss:MergeDown="2">\n\r'
										+ '<ss:Data ss:Type="String">迁往省外</ss:Data>\n\r'
									+ '</ss:Cell>\n\r'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:Index="22" />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row >\n\r' 
									+ '<ss:Cell ss:Index="22" />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r'
								+ '<ss:Row ss:Height="14.25" >\n\r' 
									+ '<ss:Cell ss:StyleID="s57">\n\r'
										+ '<ss:Data ss:Type="String">甲</ss:Data>\n\r'
									+ '</ss:Cell>\n\r';
									for ( var i = 1; i < 20; i++) {
										t += '<ss:Cell ss:StyleID="s79">\n\r'
										+ '<ss:Data ss:Type="Number">' + i + '</ss:Data>\n\r'
										+ '</ss:Cell>\n\r';
									}
									t += '<ss:Cell ss:Index="22" />\n\r'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
									+ '<ss:Cell />'
								+ '</ss:Row>\n\r' ;

						// Generate the data rows from the data in the Store
						for ( var i = 0, it = this.store.data.items, l = it.length; i < l; i++) {
							t += '<ss:Row>\n\r';
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
											t += '<ss:Cell ss:StyleID="s57">\n\r' ;
										}else{
											t += '<ss:Cell ss:StyleID="s79">\n\r' ;
										}
											t += '<ss:Data ss:Type="' + cellType[k] + '">\n\r';
										if(v != null){
											if (cellType[k] == 'DateTime') {
												t += v.format('Y-m-d');
											} else {
												t += v;
											}
										}else{
											t += "";
										}
										t += '</ss:Data>\n\r</ss:Cell>\n\r';
									}
									k++;
								}
							}
							t += '</ss:Row>\n\r';
						}
						
						var myDate = new Date();
						
						t += '<ss:Row ss:Height="14.25">\n\r' 
							+ '<ss:Cell ss:StyleID="s61">\n\r'
								+ '<ss:Data ss:Type="String">审核人：</ss:Data>\n\r'
							+ '</ss:Cell>\n\r'
							+ '<ss:Cell ss:StyleID="s61" ss:MergeAcross="1" />\n\r'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61">\n\r'
								+ '<ss:Data ss:Type="String">填表人：</ss:Data>\n\r'
							+ '</ss:Cell>\n\r'
							+ '<ss:Cell ss:StyleID="s61" ss:MergeAcross="1">\n\r'
								+ '<ss:Data ss:Type="String">安徽省</ss:Data>\n\r'
							+ '</ss:Cell>\n\r'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" />'
							+ '<ss:Cell ss:StyleID="s61" ss:MergeAcross="1">\n\r'
								+ '<ss:Data ss:Type="String">'
									+ myDate.getFullYear() + '年' + (myDate.getMonth() + 1) + '月' + myDate.getDate() + '日'
								+ '</ss:Data>\n\r'
							+ '</ss:Cell>\n\r'
							+ '<ss:Cell ss:StyleID="s61">\n\r'
								+ '<ss:Data ss:Type="String">填</ss:Data>\n\r'
							+ '</ss:Cell>\n\r'
						+ '</ss:Row>\n\r'
						;
						
						result.xml = t
								+ '</ss:Table>\n\r'
								+ '<x:WorksheetOptions>\n\r'
								+ '<x:PageSetup>\n\r'
								+ '<x:Layout x:CenterHorizontal="1" x:Orientation="Landscape" />\n\r'
								+ '<x:Footer x:Data="Page &amp;P of &amp;N" x:Margin="0.5" />\n\r'
								+ '<x:PageMargins x:Top="0.5" x:Right="0.5" x:Left="0.5" x:Bottom="0.8" />\n\r'
								+ '</x:PageSetup>\n\r'
								+ '<x:FitToPage />\n\r'
								+ '<x:Print>\n\r'
								+ '<x:PrintErrors>Blank</x:PrintErrors>\n\r'
								+ '<x:FitWidth>1</x:FitWidth>\n\r'
								+ '<x:FitHeight>32767</x:FitHeight>\n\r'
								+ '<x:ValidPrinterInfo />\n\r'
								+ '<x:VerticalResolution>600</x:VerticalResolution>\n\r'
								+ '</x:Print>\n\r'
								+ '<x:Selected />\n\r'
								+ '<x:DoNotDisplayGridlines />\n\r'
								+ '<x:ProtectObjects>False</x:ProtectObjects>\n\r'
								+ '<x:ProtectScenarios>False</x:ProtectScenarios>\n\r'
								+ '</x:WorksheetOptions>\n\r' 
								+ '</ss:Worksheet>\n\r'
								+ '</ss:Workbook>\n\r'
						;
						
						return result;
					}
				});

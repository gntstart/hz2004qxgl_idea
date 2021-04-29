Ext.ns("Msp.Component");

//config = {
//    fileName : "净值及头寸核对",
//    exportDate : "2014-01-20",
//    dataSource : [
//        {grid : grid1, param : param1, showType : true},
//        {grid : grid2, param : param2, showType : false}
//    ],
//    hiddenColumnArr : ["assetName"],
//    isMail : true,
//    filePath : "C:\\mspMail\\"
//}

Msp.Component.PageToExcel = function(config){
	
    this.initialConfig = config;
    this.excel = null;
    this.workBook = null;
    this.sheet = null;
    
    //是否发送邮件
    this.isMail = false;
    //如果是发送邮件，生成excel附件的存放目录
    this.filePath = "C:\\mspMail\\";
    //导出日期，默认为当天
    this.exportDate = null;
    //getCurrentDate();
    //定时执行垃圾回收的标识
    this.idTmr = "";
    this.dataSource = [];
    
    //this.dataSource = config.dataSource;
    
    
    //过滤自定义不显示的列
    //this.hiddenColumnArr = ['checked','checkerId','checkTime'];
    Ext.apply(this,config);
};

Msp.Component.PageToExcel.prototype = {
    
    /**
     * 创建excel对象
     */
    createExcel : function(){
        try{
            this.excel = new ActiveXObject("Excel.Application");
            //控制execl是否打开  true 打开  ,false  不打开
            this.excel.Visible = false;
            this.workBook = this.excel.Workbooks.Add();
            this.sheet = null;
        }catch(e){
            sofa.alert("请确认安装了非绿色版本的excel！"+e.description);
        }
    },
    
    /**
     * 关闭excle对象
     */
    closeExcel : function(){
        if(this.workBook != null){
            this.workBook.Close(SaveChanges=false);
        }
        if(this.excel != null){
            this.excel.Quit();
        }
        this.workBook = null;
        this.sheet = null;
        //EXCEL.EXE进程清理
        this.idTmr = window.setInterval(this.cleanup,1);
    },
    
    /**
     * EXCEL.EXE进程清理
     */
    cleanup : function(){
        window.clearInterval(this.idTmr);
          window.CollectGarbage();
    },
    
    /**
     * 默认的sheet不够用时，添加额外的sheet
     */
    addSheetsExt : function(){
        //默认的sheet数量，经测试win7默认3个sheet，xp默认1个sheet
        var defaultSheetNum = this.workBook.Sheets.count,
            count = 0;//需要sheet的个数
        for(var i = 0; i < this.dataSource.length; i++){
            //判断是否需要生成新的sheet，如果默认的sheet不够用则生成新的sheet
            if(this.dataSource[i].showType){
                count++;
                if(count > defaultSheetNum){
                    this.workBook.Sheets.add;
                }
            }
        }    
    },
    
    /**
     * 生成一个excel文件
     */
    handleExcel : function(){
    	
        if(this.dataSource && this.dataSource.length > 0){
            var layerNum = 0,//sheet的层数
                rowIndex = 0;//行索引
            
            this.addSheetsExt();
            
            for(var i = 0; i < this.dataSource.length; i++){
                if(this.dataSource[i].showType){
                    layerNum ++;
                    this.sheet = this.workBook.Worksheets(layerNum);
                    this.sheet.name = "第【"+layerNum+"】层";
                    
                    //行索引归零
                    rowIndex = 0;
                }
                //生成数据到sheet，并返回当前grid的总记录数
                var totalRecords = this.changeGridToExcel(this.dataSource[i].grid,this.dataSource[i].param,this.sheet,rowIndex);
                //保存grid查询出来的总记录数，方便以后统计异常记录数
                this.dataSource[i].total = totalRecords;
                if(totalRecords > 0){
                    rowIndex = rowIndex + totalRecords + 3;
                }
            }
        }
            
    },
    
    /**
     * 构建工作表的标题
     * @param {} sheet 工作表
     * @param {} rowIndex 行索引
     * @param {} colNum 总列数
     * @param {} titleName 标题名称
     */
    buildTitle : function(sheet, rowIndex, colNum, titleName){
        /***************************************标题开始***********************************************/
        //合并标题单元格
        sheet.Range("A"+(rowIndex+1),sheet.Cells(rowIndex+1,colNum)).MergeCells=true;
        //居中显示
        sheet.Cells(rowIndex+1,1).HorizontalAlignment=3;
        //设置粗体
        sheet.Cells(rowIndex+1,1).Font.Bold=true;
        //字体大小
        sheet.Cells(rowIndex+1,1).Font.Size=15;
        //字体颜色
        sheet.Cells(rowIndex+1,1).Font.ColorIndex=10;
        //模块名称
        sheet.Cells(rowIndex+1,1).value = titleName;
        /***************************************标题结束***********************************************/
        
        /***************************************导出日期开始*******************************************/
        //合并时间单元格
        sheet.Range("A"+(rowIndex+2),sheet.Cells(rowIndex+2,colNum)).MergeCells=true;
        //居左显示
        sheet.Cells(rowIndex+2,1).HorizontalAlignment=2;
        //导出日期
        sheet.Cells(rowIndex+2,1).value = this.exportDate;
        /***************************************导出日期结束*******************************************/
    },
    
    /**
     * 构建工作表的内容
     * @param {} sheet 工作表
     * @param {} rowArr 行数组
     * @param {} columnArr 列数组
     * @param {} rowIndex 行索引
     * @return {} 工作表的列数
     */
    buildContent : function(sheet, rowArr, columnArr, rowIndex){
        //标题行、日期行、表头行占三行
        var startIndex = rowIndex + 3;
        /***************************************内容设置开始***********************************************/
        for (var i = 0;i< rowArr.length; i++){ 
            var count = 1;
            for(var j = 0;j< columnArr.length;j++){
                //列出不隐藏的列
                if(columnArr[j].hidden == undefined && !Ext.isEmpty(columnArr[j].dataIndex) ){
                    //过滤自定义不显示的列
                    if(this.hiddenColumnArr && this.hiddenColumnArr.indexOf(columnArr[j].dataIndex) > -1){
                        continue;
                    }    
                    //居中显示
                    sheet.Cells(startIndex+1+i,count).HorizontalAlignment=3;
                    //边框样式
                    sheet.Cells(startIndex+1+i,count).Borders.LineStyle=1;
                    //单元格边框颜色
                    sheet.Cells(startIndex+1+i,count).Borders.ColorIndex=10;
                    //将单元置为文本，避免非数字列被自动变成科学计数法和丢失前缀的0
                    sheet.Cells(startIndex+1+i,count).NumberFormat = "@";
                    
                    var viewValue = rowArr[i][columnArr[j].dataIndex];
                    if(columnArr[j].renderer != undefined && !Ext.isEmpty(viewValue)){
                        //页面渲染时需要使用当前行的数据作为判断条件
                        var rdata = {};
                        rdata.data = rowArr[i];
                        viewValue = columnArr[j].renderer(viewValue,null,rdata);
                    }
                    if(viewValue == undefined){
                        viewValue = '';
                    }
                    if(viewValue != null){
                        viewValue = Ext.util.Format.trim(viewValue.toString());//去空格
                    }
                    //viewValue 前面加空格是为了处理 2/2的数据格式，cells默认会理解为日期
                    sheet.Cells(startIndex+1+i,count).value = " "+viewValue;
                    count++;
                }
            } 
        }
        /***************************************内容设置结束***********************************************/
        return count - 1;
    },
    
    /**
     * 构建工作表的列头
     * @param {} sheet 工作表
     * @param {} columnArr 列头数组
     * @param {} rowIndex 行索引
     */
    buildHeader : function(sheet, columnArr, rowIndex){
        /***************************************列头设置开始***********************************************/
        //标题行、日期行、表头行占三行
        var startIndex = rowIndex + 3;
        var count = 1;
        for (var i = 0 ;i < columnArr.length; i++){
            //列出不隐藏的列头项并排除序号列和复选框列
            if(!columnArr[i].hidden && 
               (columnArr[i].header && columnArr[i].header.length>0 && columnArr[i].header != '序号') &&
                columnArr[i].id != 'checker'){
                //过滤自定义不显示的列
                if(this.hiddenColumnArr && this.hiddenColumnArr.indexOf(columnArr[i].dataIndex) > -1){
                    continue;
                }    
                //居中显示
                sheet.Cells(startIndex,count).HorizontalAlignment=3;
                //设置粗体
                sheet.Cells(startIndex,count).Font.Bold=true;
                //列头名称
                sheet.Cells(startIndex,count).value = columnArr[i].header;
                //边框样式
                sheet.Cells(startIndex,count).Borders.LineStyle=1;
                //单元格边框颜色
                sheet.Cells(startIndex,count).Borders.ColorIndex=10;
                //单元格底色
                sheet.Cells(startIndex,count).Interior.ColorIndex=2;
                count++;
            }
        }
        /***************************************列头设置结束***********************************************/
    },
    
    /**
     * 将grid的数据写入到sheet中
     * @param {} grid 表格
     * @param {} param 查询参数
     * @param {} sheet 当前工作表
     * @param {} rowIndex 行索引，记录写入行的起始位置
     * @return {} 总记录数
     */
    changeGridToExcel : function(grid, param, sheet,rowIndex){
        var totalRecords = 0;
        sofa.api.request({
              url:grid.url,
              params : param,
              method:'post',
              async:false,
              success: function(response){
                  var rowArr = null;//行数组
                  if(typeof response.responseText == 'string'){
                      rowArr = Ext.decode(response.responseText);
                  }
                  if(rowArr == null || rowArr.length == 0){
                      return 0;
                  }
                  var columnArr = grid.getColumnModel().config;//列数组
                try{
                    //生成内容
                    var colNum = this.buildContent(sheet, rowArr, columnArr, rowIndex);
                    //生成列头
                    this.buildHeader(sheet, columnArr, rowIndex);
                    //标题
                    var titleName = (sheet.name == '第【1】层' ? this.fileName : rowArr[0]['bizName']);
                    //生成标题
                    this.buildTitle(sheet, rowIndex, colNum,titleName);
                    //列自增长
                    sheet.Columns.AutoFit();
                    totalRecords = rowArr.length;
                }catch(e){
                }
            },
            scope:this
        });
        return totalRecords;
    },
    
    /**
     * 保存
     */
    saveExcel :function(){
        var savePath = null;
        //导出发送邮件用的excel文件
        if(this.isMail){
            //无异常记录不保存
            if(this.dataSource[0].total != 0){
                savePath = this.filePath+this.fileName+".xls";
                if(!Ext.isEmpty(savePath)){
                    this.sheet.SaveAs(savePath);
                }
            }
        //默认的excel导出
        }else{
            savePath = this.excel.Application.GetSaveAsFilename(this.fileName+".xls","Excel Spreadshsheets (*.xls),*.xls,(*.xlsx),*.xlsx");
            if(!Ext.isEmpty(savePath)){
                this.sheet.SaveAs(savePath);
            }
        }
    },
    
    /**
     * excel导出
     */
    exportExcel : function(){
    	
        try{
            this.createExcel();
            this.handleExcel();
            this.saveExcel();
        }catch(e){
        	alert("导出出错！");
        }finally{
            this.closeExcel();
        }
    }
};
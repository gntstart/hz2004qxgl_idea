package com.gnt.qxgl.service.impl;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.base.ServiceImpl;
import com.gnt.qxgl.base.util.MyHeaderFooter;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.base.util.Watermark;
import com.gnt.qxgl.bean.SimpleJson;
import com.gnt.qxgl.common.*;
import com.gnt.qxgl.common.base.Config;
import com.gnt.qxgl.common.base.sql.SqlParam;
import com.gnt.qxgl.common.base.sql.SqlParse;
import com.gnt.qxgl.common.dict.bean.Code;
import com.gnt.qxgl.common.exception.ServiceException;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbFjcl;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbLgApiLog;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXkzApi;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXx;
import com.gnt.qxgl.service.YwtbService;
import com.gnt.qxgl.service.yw.DQDictService;
import com.gnt.qxgl.webservice.bean.YwtbFjclVo;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hibernate.Session;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <功能概述>
 * 长三角“一网通办”户籍事项证明服务 功能实现类
 *
 * @author: 杨冬冬
 * @className: YwtbServiceImpl
 * @package: com.gnt.qxgl.service.impl
 * @description: 介绍
 * @date: 2020-05-19 11:09
 */
public class YwtbServiceImpl extends ServiceImpl implements YwtbService {

    /**
     * 查询一网通授权商户
     *
     * @param pcsbm 编码
     * @param sbh   未用到
     * @return
     */
    @Override
    public YwtbXkzApi getXkzApi(String pcsbm, String sbh) {
        return (YwtbXkzApi) super.getObject("from YwtbXkzApi where lgbm='" + pcsbm + "' ", null);
    }

    /**
     * 根据唯一标识查询一网通办信息
     *
     * @param applyno 编码
     * @return
     */
    @Override
    public YwtbXx getYwtbXx(String applyno) {
        return (YwtbXx) super.getObject("from YwtbXx where applyno='" + applyno + "'", null);
    }
    /**
     * 过滤数据
     */
    @Override
    public YwtbXx getYwtbXx2(String applyno, String isstatus) {
        return (YwtbXx) super.getObject("from YwtbXx where applyno='" + applyno + "' and isstatus!='"+isstatus+"' and bljg='' and isstatus!='3'", null);
    }

    /**
     * 保存一网通接口调用日志
     *
     * @param log
     */
    @Override
    public void saveLog2(YwtbLgApiLog log) {
        super.create(log);
    }

    /**
     * 保存一网通办的json信息
     *
     * @param ywtbXx
     */
    @Override
    public void saveYwtbXx(YwtbXx ywtbXx) {
        super.create(ywtbXx);
    }


    /**
     * 修改一网通办的json信息
     *
     * @param ywtbXx
     */
    @Override
    public void updateYwtbXx(YwtbXx ywtbXx) {
        super.update(ywtbXx);
    }

    /**
     * 修改一网通办的json信息
     *
     * @param map
     */
    @Override
    public void updateYwtbXx(Map<String, Object> map) {
        /* 必须 */
        String applyno = (String) map.get("applyno");
        if (applyno != null) {
            YwtbXx ywtbXx = getYwtbXx(applyno);

            //必须
            String content = (String) map.get("content");
            if (content != null) {
                ywtbXx.setContent(content);
            }
            /* 必须 */
            String bljg = (String) map.get("bljg");
            if (bljg != null) {
                ywtbXx.setBljg(bljg);
                //当办理结果为不通过时，保存未查证事项
                String btgsx_one = (String) map.get("btgsx_one");
                String btgsx_two = (String) map.get("btgsx_two");
                String btgsx_three = (String) map.get("btgsx_three");
                String btgsx_four = (String) map.get("btgsx_four");
                if("1".equals(bljg)){
                    if( btgsx_one!= null){
                        ywtbXx.setBtgsx_one("1");
                    }
                    if(btgsx_two != null){
                        ywtbXx.setBtgsx_two("1");
                    }
                    if(btgsx_three != null){
                        ywtbXx.setBtgsx_three("1");
                        String btgsx_three_info = (String) map.get("btgsx_three_info");
                        if( btgsx_three_info!= null){
                            ywtbXx.setBtgsx_three_info(btgsx_three_info);
                        }
                    }else {
                        ywtbXx.setBtgsx_three("0");
                        ywtbXx.setBtgsx_three_info(null);
                    }
                    if(btgsx_four != null){
                        ywtbXx.setBtgsx_four("1");
                    }
                }else {
                    ywtbXx.setBtgsx_one("0");
                    ywtbXx.setBtgsx_two("0");
                    ywtbXx.setBtgsx_three("0");
                    ywtbXx.setBtgsx_three_info("0");
                    ywtbXx.setBtgsx_four("0");
                }

            }
            //必须
            String blyj = (String) map.get("blyj");
            if (blyj != null) {
                ywtbXx.setBlyj(blyj);
            }
            ywtbXx.setIsstatus("2");//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
            ywtbXx.setXgsj(new Date());
            super.update(ywtbXx);
        }


    }

    /**
     * 保存一网通办的附件材料信息
     *
     * @param ywtbFjcl
     */
    @Override
    public void saveYwtbFjcl(YwtbFjcl ywtbFjcl) {
        super.create(ywtbFjcl);
    }

    /**
     * 分页查询一网通的信息
     * 根据登录账号的所属单位数据范围
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @param user
     * @return
     */
    @Override
    public Page queryYwtbXx(Map<String, Object> map, int pageIndex, int pageSize, BaseUser user) {
        String dwdm = "";
        boolean admin = user.isAdmin();

//        if (!admin) {
//            String sjfw = user.getSjfw();
//            if (null != sjfw) {
//                String[] split = sjfw.split("\\|");
//                for (int i = 0; i < split.length; i++) {
//                    if (i == 0) {
//                        if (split[i].length() > 9) {
//                            dwdm += " a.sldwcode like '" + split[i].substring(0, 9) + "%'";
//                        } else {
//                            dwdm += " a.sldwcode like '" + split[i] + "%'";
//                        }
//                    } else {
//                        if (split[i].length() > 9) {
//                            dwdm += " or a.sldwcode like '" + split[i].substring(0, 9) + "%'";
//                        } else {
//                            dwdm += " or a.sldwcode like '" + split[i] + "%'";
//                        }
//
//                    }
//
//                }
//            }
//        }
//        if ("" != dwdm) {
//            map.put("sldwcode", "(" + dwdm + ")");
//        } else {
//            String dwdm1 = user.getUser().getSsdwjgdm();
//            dwdm += " a.sldwcode like '" + dwdm1.substring(0, 9) + "%'";
//            map.put("sldwcode", "(" + dwdm + ")");
//        }

        if(user.getUser().getDlm().equals("HZADMIN3400")) {
            System.out.println("用户名为HZADMIN3400查询全部数据！");
        }else {
            if (user.getOtherParams() == null) {
                String dwdmStr = " sldwcode like '" + user.getUser().getSsdwjgdm().substring(0, 4) + "%'";
                map.put("sldwcode", dwdmStr);
                System.out.println("根据数据范围查询ywtb_xx"+ dwdmStr);
            } else {
                String sjfw = user.getSjfw();
                if (CommonUtil.isNotEmpty(sjfw)) {
                    System.out.println("数据范围"+ sjfw);
                    String[] sjfwStr = sjfw.split("\\|");
                    String dwdmStr = " (";
                    int i = 0;
                    for (String sjfw1 : sjfwStr) {
                        if (sjfw1 == null || sjfw1.equals(""))
                            continue;
                        if (i != 0) dwdmStr += " or ";
                        dwdmStr += " sldwcode like '" + sjfw1 + "%'";
                        i++;
                    }
                    dwdmStr += ") ";
                    map.put("sldwcode", dwdmStr);

                }
            }
        }

        SqlParse sqlParse = new SqlParse(Config.getSql("queryYwtbXx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    /**
     * 查询一网通信息
     * 并且修改数据推送状态
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page queryYwtbXxJob(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryYwtbXxJob"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);

        return pageRecords;
    }

    /**
     * 根据登录账号的单位
     * 进行查询常口人员信息
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page queryCzrkxx(Map<String, Object> map, int pageIndex, int pageSize) {
        //必须
        String dwdm = (String) map.get("dwdm");

        SqlParse sqlParse = new SqlParse(Config.getSql("queryCzrkxx"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        List objectList = null;
        //Transaction tran = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0, 4)).openSession();
            //tran =
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            //tran.commit();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        Page pageRecords = new Page();
        pageRecords.setList(objectList);
        return pageRecords;
    }


    /**
     * 根据登录账号的单位
     * 根据身份证查询改人员的变更信息
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page queryBggzxxb(Map<String, Object> map, int pageIndex, int pageSize) {
        //必须
        String dwdm = (String) map.get("dwdm");

        SqlParse sqlParse = new SqlParse(Config.getSql("queryBggzxxb"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        List objectList = null;
        //Transaction tran = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0, 4)).openSession();
            //tran =
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            //tran.commit();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        Page pageRecords = new Page();
        pageRecords.setList(objectList);
        return pageRecords;
    }

    /**
     * 根据登录账号的单位
     * 根据身份证查询改人员的死亡注销信息
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page querySwzxZm(Map<String, Object> map, int pageIndex, int pageSize) {
        //必须
        String dwdm = (String) map.get("dwdm");

        SqlParse sqlParse = new SqlParse(Config.getSql("querySwzxZm"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        List objectList = null;
        //Transaction tran = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0, 4)).openSession();
            //tran =
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            //tran.commit();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        Page pageRecords = new Page();
        pageRecords.setList(objectList);
        return pageRecords;
    }

    /**
     * 根据登录账号的单位
     * 根据身份证查询改人员的迁出注销信息
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page queryQczxZm(Map<String, Object> map, int pageIndex, int pageSize) {
        //必须
        String dwdm = (String) map.get("dwdm");

        SqlParse sqlParse = new SqlParse(Config.getSql("queryQczxZm"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();

        Session session = null;
        List objectList = null;
        //Transaction tran = null;
        try {
            session = HibernateUtil.getSystemSessionFactory(dwdm.substring(0, 4)).openSession();
            //tran =
            objectList = HibernateUtil.getObjectList(session, sqlParam.getSql(), sqlParam.getParams().toArray());
            //tran.commit();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        Page pageRecords = new Page();
        pageRecords.setList(objectList);
        return pageRecords;
    }

    /**
     * 查询一网通信息的附件材料
     * 并且查询出完结之后上传的出具证明
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page queryYwtbFjcl(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryYwtbFjcl"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        List<YwtbFjcl> list = pageRecords.getList();
        List<YwtbFjclVo> voList = new ArrayList<YwtbFjclVo>();
        for (int i = 0; i < list.size(); i++) {
            YwtbFjcl ywtbFjcl = list.get(i);
            YwtbFjclVo vo = new YwtbFjclVo();
            String str2 = new String(ywtbFjcl.getStufffile());
            vo.setStufffile(str2);
            vo.setFilename(ywtbFjcl.getFilename());
            voList.add(vo);
        }
        SqlParse sqlParse1 = new SqlParse(Config.getSql("queryYwtbXx"));
        sqlParse1.bind(map);
        SqlParam sqlParam1 = sqlParse1.parse();
        Page pageRecords1 = super.getPageRecords(sqlParam1.getSql(), sqlParam1.getParams(), pageIndex, pageSize);
        List<YwtbXx> listYwtbXx = pageRecords1.getList();
        for (int i = 0; i < listYwtbXx.size(); i++) {
            YwtbXx ywtbXx = listYwtbXx.get(0);
            if (null != ywtbXx.getBlFile()) {
                YwtbFjclVo vo = new YwtbFjclVo();
                BASE64Encoder encoder = new BASE64Encoder();
                //返回Base64编码过的字节数组字符串
                String base64 = encoder.encode(ywtbXx.getBlFile());
//                String str2 = new String(ywtbXx.getBlFile());
                vo.setStufffile(base64);
                vo.setFilename("出具证明");
                voList.add(vo);
            }
        }
        Page pageRecord = new Page();
        pageRecord.setList(voList);
        return pageRecord;
    }


    /**
     * 查询一网通信息的附件材料
     *
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page queryYwtbFjclGa(Map<String, Object> map, int pageIndex, int pageSize) {
        SqlParse sqlParse = new SqlParse(Config.getSql("queryYwtbFjcl"));
        sqlParse.bind(map);
        SqlParam sqlParam = sqlParse.parse();
        Page pageRecords = super.getPageRecords(sqlParam.getSql(), sqlParam.getParams(), pageIndex, pageSize);
        return pageRecords;
    }

    /**
     * 对一网通办信息完结之后
     * 进行数据报送
     * 报送成功之后修改状态
     *
     * @param map
     * @param user
     */
    @Override
    public void sendPostYwtb(Map<String, Object> map, BaseUser user) {
        SimpleJson s = new SimpleJson();
        // 请求url
        String ywtbUrl = SystemConfig.getSystemConfig("ywtbUrl");
        HttpPost post = new HttpPost(ywtbUrl);

        String applyno = (String) map.get("applyno");
        if (applyno == null) {
            throw new ServiceException("主键唯一applyno为null，无法推送");
        }

        YwtbXx ywtbXx = getYwtbXx(applyno);
        //封装参数
        String requestDate = sendYwtbJson(ywtbXx, user);
        try {
            StringEntity stringEntity = new StringEntity(requestDate, "UTF-8");
            post.setEntity(stringEntity);
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response1 = httpClient.execute(post);
            StringBuilder responstContent = new StringBuilder();
            if (response1 != null) {
                InputStream inputStream = response1.getEntity().getContent();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    responstContent.append(line);
                    String property = System.getProperty("line.separator");
                    responstContent.append(property);
                }
                String s1 = responstContent.toString();
                System.out.println(s1);
                s.setSuccess(true);
                s.setMessage("数据推送成功!");
                ywtbXx.setIsstatus("1");
                updateYwtbXx(ywtbXx);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            s.setSuccess(false);
            s.setMessage("数据推送失败!" + e.getMessage());
            ywtbXx.setIsstatus("2");
            updateYwtbXx(ywtbXx);
        }
    }

    /**
     * 上传出具证明
     *
     * @param parm
     * @param req
     * @return
     */
    @Override
    public SimpleJson saveYwtbfj(Map parm, HttpServletRequest req) {
        //获取主建applyno
        String applyno = (String) parm.get("applyno");
        //获取照片
        FileItem logoFile = (FileItem) parm.get("logoFile");
        //根据主建 查询YwtbXx
        YwtbXx ywtbXx = getYwtbXx(applyno);
        InputStream inputzp = null;
        SimpleJson s = new SimpleJson();
        try {
            if (logoFile != null && logoFile.getSize() > 0) {
                String fname = logoFile.getName();

                if (fname.indexOf(".") > 0) {
                    fname = fname.substring(fname.lastIndexOf(".") + 1);
                }

                if ("jpg,jpeg,gif,png,bmp,JPG,JPEG,GIF,PNG,BMP".indexOf(fname) < 0) {
                    throw new ServiceException("上传的照片必须为图片文件！");
                }
                inputzp = new BufferedInputStream(logoFile.getInputStream());
                byte[] bytes = IOUtils.toByteArray(inputzp);
                //对字节数组Base64编码
//                BASE64Encoder encoder = new BASE64Encoder();
                //返回Base64编码过的字节数组字符串
//                String base64 = encoder.encode(bytes);
//                Blob zpimage = Hibernate.createBlob(inputzp, inputzp.available());

                ywtbXx.setXgsj(new Date());
                ywtbXx.setBlFile(bytes);

                BaseUser baseUser = BaseContext.getBaseUser();
                if (baseUser == null) {
                    throw new ServiceException("未登录,或者登陆已失效！");
                }
                String dwdm = baseUser.getUser().getSsdwjgdm().substring(0, 9);
                DQDictService dQDictService = (DQDictService) SpringContainer.getObject("dQDictService");
                ExtMap<String, Object> map = new ExtMap<String, Object>();
                map.put("visiontype", "DWXXB");
                map.put("search_code", dwdm);
                map.put("optype", "eq");
                Page page = dQDictService.searchXxb(baseUser, map);
                List<Code> list = page.getList();
                ywtbXx.setBlBmcode(dwdm);
                ywtbXx.setBlBmName(list.get(0).getName());
            }
            super.update(ywtbXx);
            s.setSuccess(true);
            s.setMessage("上传图片成功!");
        } catch (Exception e) {
            e.printStackTrace();
            s.setSuccess(false);
            s.setMessage("上传图片失败!");
        }
        return s;
    }

    /**
     * 报送数据 参数封装
     *
     * @param ywtbXx
     * @param user
     * @return
     */
    private String sendYwtbJson(YwtbXx ywtbXx, BaseUser user) {
        JSONObject jsonObj = new JSONObject();
        if (ywtbXx != null) {
            jsonObj.put("applyno", ywtbXx.getApplyno());
            String bljg = ywtbXx.getBljg();
            if (bljg == null) {
                throw new ServiceException("未对一网通数据进行处理，无法推送");
            }
            byte[] blFile = ywtbXx.getBlFile();
            if (blFile == null) {
                throw new ServiceException("未对一网通数据进行,出具证明上传，无法推送");
            }
            // 0 通过 、1 不通过
            if ("0".equals(bljg)) {
                jsonObj.put("result", "通过");
                jsonObj.put("documentType", "1");
            } else {
                jsonObj.put("result", "不通过");
                jsonObj.put("documentType", "2");
            }
            String suggestion = ywtbXx.getBlyj();
            jsonObj.put("suggestion", suggestion);
            jsonObj.put("opDepartCode", ywtbXx.getBlBmcode());

            jsonObj.put("opDepartName", ywtbXx.getBlBmName());
            jsonObj.put("receiveApplyTime", ywtbXx.getCjsj());
            jsonObj.put("finishtime", new Date());


            jsonObj.put("file", Base64.encode(ywtbXx.getBlFile()));

            return jsonObj.toString();
        }
        return null;

    }

    // main测试
    public static void main(String[] args) throws Exception {
        try {
            // 1.新建document对象
            Document document = new Document(PageSize.A4);// 建立一个Document对象
 
            // 2.建立一个书写器(Writer)与document对象关联
            File file = new File("D:\\PDFDemo.pdf");
            file.createNewFile();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            writer.setPageEvent(new Watermark("HELLO ITEXTPDF"));// 水印
			writer.setPageEvent(new MyHeaderFooter());// 页眉/页脚
 
            // 3.打开文档
            document.open();
			document.addTitle("Title@PDF-Java");// 标题
			document.addAuthor("Author@umiz");// 作者
			document.addSubject("Subject@iText pdf sample");// 主题
			document.addKeywords("Keywords@iTextpdf");// 关键字
			document.addCreator("Creator@umiz`s");// 创建者
 
            // 4.向文档中添加内容
            //new YwtbServiceImpl().generatePDF(document);
 
            // 5.关闭文档
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // 定义全局的字体静态变量
 	private static Font titlefont;
 	private static Font headfont;
 	private static Font keyfont;
 	private static Font textfont;
     // 最大宽度
 	private static int maxWidth = 520;
 	// 静态代码块
     static {
         try {
             // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
//             BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//             titlefont = new Font(bfChinese, 16, Font.BOLD);
//             headfont = new Font(bfChinese, 14, Font.BOLD);
//             keyfont = new Font(bfChinese, 10, Font.BOLD);
//             textfont = new Font(bfChinese, 10, Font.NORMAL);
  
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
  
     // 生成PDF文件
 	public void generatePDF(Document document) throws Exception {
  
     	// 段落
 		Paragraph paragraph = new Paragraph("美好的一天从早起开始！", titlefont);
 		paragraph.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
 		paragraph.setIndentationLeft(12); //设置左缩进
 		paragraph.setIndentationRight(12); //设置右缩进
 		paragraph.setFirstLineIndent(24); //设置首行缩进
 		paragraph.setLeading(20f); //行间距
 		paragraph.setSpacingBefore(5f); //设置段落上空白
 		paragraph.setSpacingAfter(10f); //设置段落下空白
  
 		// 直线
 		Paragraph p1 = new Paragraph();
 		p1.add(new Chunk(new LineSeparator()));
  
 		// 点线
 		Paragraph p2 = new Paragraph();
 		p2.add(new Chunk(new DottedLineSeparator()));
  
 		// 超链接
 		Anchor anchor = new Anchor("baidu");
 		anchor.setReference("www.baidu.com");
  
 		// 定位
 		Anchor gotoP = new Anchor("goto");
 		gotoP.setReference("#top");
  
 		// 添加图片
 		Image image = Image.getInstance("https://img-blog.csdn.net/20180801174617455?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNzg0ODcxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
 		image.setAlignment(Image.ALIGN_CENTER);
 		image.scalePercent(40); //依照比例缩放
  
 		// 表格
 		PdfPTable table = createTable(new float[] { 40, 120, 120, 120, 80, 80 });
 		table.addCell(createCell("美好的一天", headfont, Element.ALIGN_LEFT, 6, false));
 		table.addCell(createCell("早上9:00", keyfont, Element.ALIGN_CENTER));
 		table.addCell(createCell("中午11:00", keyfont, Element.ALIGN_CENTER));
 		table.addCell(createCell("中午13:00", keyfont, Element.ALIGN_CENTER));
 		table.addCell(createCell("下午15:00", keyfont, Element.ALIGN_CENTER));
 		table.addCell(createCell("下午17:00", keyfont, Element.ALIGN_CENTER));
 		table.addCell(createCell("晚上19:00", keyfont, Element.ALIGN_CENTER));
 		Integer totalQuantity = 0;
 		for (int i = 0; i < 5; i++) {
 			table.addCell(createCell("起床", textfont));
 			table.addCell(createCell("吃午饭", textfont));
 			table.addCell(createCell("午休", textfont));
 			table.addCell(createCell("下午茶", textfont));
 			table.addCell(createCell("回家", textfont));
 			table.addCell(createCell("吃晚饭", textfont));
 			totalQuantity ++;
 		}
 		table.addCell(createCell("总计", keyfont));
 		table.addCell(createCell("", textfont));
 		table.addCell(createCell("", textfont));
 		table.addCell(createCell("", textfont));
 		table.addCell(createCell(String.valueOf(totalQuantity) + "件事", textfont));
 		table.addCell(createCell("", textfont));
  
 		document.add(paragraph);
 		document.add(anchor);
 		document.add(p2);
 		document.add(gotoP);
 		document.add(p1);
 		document.add(table);
 		document.add(image);
 	}
  
  
 /**------------------------创建表格单元格的方法start----------------------------*/
     /**
      * 创建单元格(指定字体)
      * @param value
      * @param font
      * @return
      */
     public PdfPCell createCell(String value, Font font) {
         PdfPCell cell = new PdfPCell();
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setPhrase(new Phrase(value, font));
         return cell;
     }
     /**
      * 创建单元格（指定字体、水平..）
      * @param value
      * @param font
      * @param align
      * @return
      */
 	public PdfPCell createCell(String value, Font font, int align) {
 		PdfPCell cell = new PdfPCell();
 		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
 		cell.setHorizontalAlignment(align);
 		cell.setPhrase(new Phrase(value, font));
 		return cell;
 	}
     /**
      * 创建单元格（指定字体、水平居..、单元格跨x列合并）
      * @param value
      * @param font
      * @param align
      * @param colspan
      * @return
      */
     public PdfPCell createCell(String value, Font font, int align, int colspan) {
         PdfPCell cell = new PdfPCell();
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(align);
         cell.setColspan(colspan);
         cell.setPhrase(new Phrase(value, font));
         return cell;
     }
     /**
      * 创建单元格（指定字体、水平居..、单元格跨x列合并、设置单元格内边距）
      * @param value
      * @param font
      * @param align
      * @param colspan
      * @param boderFlag
      * @return
      */
     public PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
         PdfPCell cell = new PdfPCell();
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(align);
         cell.setColspan(colspan);
         cell.setPhrase(new Phrase(value, font));
         cell.setPadding(3.0f);
         if (!boderFlag) {
             cell.setBorder(0);
             cell.setPaddingTop(15.0f);
             cell.setPaddingBottom(8.0f);
         } else if (boderFlag) {
             cell.setBorder(0);
             cell.setPaddingTop(0.0f);
             cell.setPaddingBottom(15.0f);
         }
         return cell;
     }
     /**
      * 创建单元格（指定字体、水平..、边框宽度：0表示无边框、内边距）
      * @param value
      * @param font
      * @param align
      * @param borderWidth
      * @param paddingSize
      * @param flag
      * @return
      */
 	public PdfPCell createCell(String value, Font font, int align, float[] borderWidth, float[] paddingSize, boolean flag) {
 		PdfPCell cell = new PdfPCell();
 		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
 		cell.setHorizontalAlignment(align);
 		cell.setPhrase(new Phrase(value, font));
 		cell.setBorderWidthLeft(borderWidth[0]);
 		cell.setBorderWidthRight(borderWidth[1]);
 		cell.setBorderWidthTop(borderWidth[2]);
 		cell.setBorderWidthBottom(borderWidth[3]);
 		cell.setPaddingTop(paddingSize[0]);
 		cell.setPaddingBottom(paddingSize[1]);
 		if (flag) {
 			cell.setColspan(2);
 		}
 		return cell;
 	}
 /**------------------------创建表格单元格的方法end----------------------------*/
  
  
 /**--------------------------创建表格的方法start------------------- ---------*/
     /**
      * 创建默认列宽，指定列数、水平(居中、右、左)的表格
      * @param colNumber
      * @param align
      * @return
      */
 	public PdfPTable createTable(int colNumber, int align) {
 		PdfPTable table = new PdfPTable(colNumber);
 		try {
 			table.setTotalWidth(maxWidth);
 			table.setLockedWidth(true);
 			table.setHorizontalAlignment(align);
 			table.getDefaultCell().setBorder(1);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return table;
 	}
     /**
      * 创建指定列宽、列数的表格
      * @param widths
      * @return
      */
 	public PdfPTable createTable(float[] widths) {
 		PdfPTable table = new PdfPTable(widths);
 		try {
 			table.setTotalWidth(maxWidth);
 			table.setLockedWidth(true);
 			table.setHorizontalAlignment(Element.ALIGN_CENTER);
 			table.getDefaultCell().setBorder(1);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return table;
 	}
     /**
      * 创建空白的表格
      * @return
      */
 	public PdfPTable createBlankTable() {
 		PdfPTable table = new PdfPTable(1);
 		table.getDefaultCell().setBorder(0);
 		table.addCell(createCell("", keyfont));
 		table.setSpacingAfter(20.0f);
 		table.setSpacingBefore(20.0f);
 		return table;
 	}
 /**--------------------------创建表格的方法end------------------- ---------*/


}

package com.hzjc.wsstruts.common.xml;

import org.dom4j.*;
import org.dom4j.io.*;
import java.io.*;
import org.apache.commons.logging.*;
import java.net.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

/**
 * XML���ô�����
 * <p>Title: Hz2004</p>
 * <p>Description: ��ס�˿ڹ���ϵͳHz2004��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: �㽭�����¼������޹�˾</p>
 * @author kgb_hz@126.com,kgb@primetech.com.cn
 * @version 1.0
 */

public class XmlUtils {
  //��־����
  private static Log _log = LogFactory.getLog(XmlUtils.class);

  /**
   *
   */
  private XmlUtils() {
  }

  /**
   * ��XML�ĵ���ĳ�ֱ��뷽ʽ����
   * @param aDoc             - DOCUMENT XML �ĵ�
   * @param strEncodingName - ���뷽ʽ
   * @return
   */
  public static String toXML(Document aDoc, String strEncodingName) throws
      Exception {
    String strXml = "";
    if (aDoc != null) {
      try {
        //1������һ��
        //return _doc.asXML();
        //2����������
        /*
         ISO-8859-1 8859_1 ISO8859_1 US-ASCII ASCII UTF-8 UTF8
         ISO-10646-UCS-2 UTF-16 UTF-16BE UTF-16LE ISO-10646-UCS-4 UTF-16BE
         UTF-16LE UTF-16 ISO-10646-UCS-2
         */
        //���صĸ�ʽ�ܱ�׼���������������ʽ
        OutputFormat outFormat = new OutputFormat().createPrettyPrint();
        //���صĸ�ʽ�ȽϽ���
        //OutputFormat outFormat = new OutputFormat().createCompactFormat();
        //��������XML�ļ�����
        if (!"".equals(strEncodingName)) {
          outFormat.setEncoding(strEncodingName);
        }
        StringWriter writer = new StringWriter();
        XMLWriter out = new XMLWriter(writer, outFormat);
        //д������
        out.write(aDoc);
        strXml = writer.toString();
        /*
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 XMLWriter out = new XMLWriter(baos, outFormat);
                 out.write(aDoc);
                 strXml = baos.toString(strEncodingName);
         */
        out.close();
      }
      catch (IOException ex) {
        throw ex;
      }
    }
    return strXml;
  }

  /**
   * ��XML���ݼ��ص�DCUMENT��
   * @param aXmlData  - XML����
   * @return
   */
  public static Document fromXML(String aXmlData) throws Exception {
    Document doc = null;
    try {
      SAXReader reader = new SAXReader();
      /**
       * ˵����1������xml�ļ�ʱ��xml�к��������ַ������xml��encoding="gb2312"ʱ��1��3û�����⣻
       *   ���encoding="utf-8"ʱ��1��3�����⣬�������쳣��
       * 2��
       * ���������1���ͻ��ˣ�delphi���������á�gb2312����GBK��
       * 2���޸�dom4j��ԭ����
       */
      //1���÷���û����
      //doc = reader.read(new ByteArrayInputStream(aXmlData.getBytes()));
      //2���÷������ַ����Ķ��������⣨������κα���������⣩
      //doc = reader.read(new StringBufferInputStream(aXmlData));
      //3���÷���û������
      doc = reader.read(new StringReader(aXmlData));
      //4��ֱ����sax��inputsource(������)
      //doc = reader.read(new InputSource(aXmlData));
      //5��������
      //doc = reader.read(new InputStreamReader(new StringBufferInputStream(aXmlData),"UTF-8"));
      if (doc == null) {
        _log.info("��������XML�쳣:LoadFromXml Document is null!");

      }
    }
    catch (DocumentException ex) {
      throw ex;
    }
    return doc;
  }

  /**
   * ��XML������ĳ�ֱ��뷽ʽ������
   * @param aXmlData         - XML����
   * @param strEncodingName  - ���뷽ʽ
   * @return
   * @throws java.lang.Exception
   */
  public static Document fromXML(String aXmlData, String strEncodingName) throws
      Exception {
    Document doc = null;
    try {
      SAXReader reader = new SAXReader();
      //doc = reader.read(new ByteArrayInputStream(aXmlData.
      //                                         getBytes(strEncodingName)));
      doc = reader.read(new InputStreamReader(new StringBufferInputStream(
          aXmlData), strEncodingName));
      if (doc == null) {
        _log.info("��������XML�쳣:LoadFromXml Document is null!");
      }
    }
    catch (DocumentException ex) {
      throw ex;
    }
    return doc;
  }

  /**
   * ��XML��Դ�ļ����ص���������
   * @param strXmlResource - XML��Դ�ļ�·��
   * @return
   * @throws java.lang.Exception
   */
  public static InputStream getResourceAsStream(String strXmlResource) throws
      Exception {
    InputStream is = null;
    if (strXmlResource != null) {
      ///////////////////////////////////////////////////////////////
      //�жϿ�ʼ�ַ���Ȼ�����
      if (strXmlResource.startsWith("/")) { //"/"��Ϊ��ʼ�ַ�
        is = XmlUtils.class.getResourceAsStream(strXmlResource);
      }
      else { //�����ַ�Ϊ��ʼ�ַ�
        //Thread.currentThread().getContextClassLoader();
        is = XmlUtils.class.getClassLoader().getResourceAsStream(
            strXmlResource);
      }
    }
    return is;
  }

  /**
   * �õ�XML��Դ�ļ���ʵ������·��
   * @param strXmlResource  - XML��Դ����
   * @return
   */
  public static String getResourcePhysicPath(String strXmlResource) {
    String strPhysicPath = null;
    if (strXmlResource != null) {
      if (strXmlResource.startsWith("/")) {
        strPhysicPath = XmlUtils.class.getResource(strXmlResource).getPath();
      }
      else {
        strPhysicPath = XmlUtils.class.getClassLoader().getResource(
            strXmlResource).getPath();
      }
    }
    return strPhysicPath;
  }

  public static void main(String[] args) {
    try {
      SAXReader reader = new SAXReader();
      InputStreamReader isr = new InputStreamReader(new FileInputStream(
          "c:/Request.xml"), "UTF-16");
      Document doc = reader.read(isr);
      _log.info(toXML(doc, XmlEncode.ENCODING_NAME_ISO_10646_UCS_4));
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * ͨ����ʽ��ת��XML
   * @param document    - XML�ĵ�
   * @param stylesheet  - ��ʽ��dtd
   * @return
   * @throws java.lang.Exception
   */
  public static Document styleDocument(
      Document document,
      String stylesheet
      ) throws Exception {

    Document transformedDoc = null;
    try {
      // load the transformer using JAXP
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer transformer = factory.newTransformer(new StreamSource(
          stylesheet)
          );

      // now lets style the given document
      DocumentSource source = new DocumentSource(document);
      DocumentResult result = new DocumentResult();
      transformer.transform(source, result);

      // return the transformed document
      transformedDoc = result.getDocument();
    }
    catch (TransformerException ex) {
      throw ex;
    }
    catch (TransformerFactoryConfigurationError ex) {
      throw ex;
    }
    return transformedDoc;
  }

}
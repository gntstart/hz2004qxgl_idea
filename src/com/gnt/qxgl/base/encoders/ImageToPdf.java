package com.gnt.qxgl.base.encoders;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.clipper.Paths;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.tools.ant.types.resources.Files;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * <功能概述>
 *
 * @author: 杨冬冬
 * @className: ImageToPdf
 * @package: com.gnt.qxgl.base.encoders
 * @description: 介绍
 * @date: 2020-07-14 17:06
 */
public class ImageToPdf {
    public static void main(String[] args) {
        try {
            //图片转pdf
            FileInputStream inputStream = new FileInputStream("F:/test/test.jpg");
            ImageToPdf.imageToPDF(inputStream, "F:/test/test.pdf");
            //pdf转图片
//            pdf2img("F:/test/test.pdf", "F:/test/2019.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据路径找到图片流
     * 将图片转位pdf 并且保存到本地
     * @param input
     * @param pdfPath
     */
    public static void imageToPDF(InputStream input, String pdfPath) {
        Document doc = null;
        try {
            FileOutputStream fos = new FileOutputStream(pdfPath);
            doc = new Document(PageSize.A4);
            byte[] bytes = read(input);
            Image image = Image.getInstance(bytes);
            float scalePercentage = (100 / 300f) * 100.0f;
            //这里调整图片大小
            image.scalePercent(scalePercentage, scalePercentage);
            PdfWriter.getInstance(doc, fos);
            doc.open();
            doc.add(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    public static byte[] read(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int num = inputStream.read(buffer);
            while (num != -1) {
                baos.write(buffer, 0, num);
                num = inputStream.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }


    /**
     * pdf转图片
     * @param pdfPath  pdf文件的路径
     * @param savePath 图片保存的地址
     */
    public static void pdf2img(String pdfPath, String savePath) {
        InputStream is = null;
        PDDocument pdDocument = null;
        try {
            is = new BufferedInputStream(new FileInputStream(pdfPath));
            PDFParser parser = new PDFParser(is);
            parser.parse();
            pdDocument = parser.getPDDocument();
            PDPage page = (PDPage) pdDocument.getDocumentCatalog().getAllPages().get(0);
            pdfPage2Img(page, savePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pdDocument != null) {
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void pdfPage2Img(PDPage page, String savePath) {
        BufferedImage bufferedImage = null;
        ImageOutputStream imageout = null;
        try {
            OutputStream outputStream = new FileOutputStream(savePath);
            bufferedImage = page.convertToImage();
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (imageout != null) {
                try {
                    imageout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * pdf转图片
     * @param pdfPath  byte 文件流
     * @param
     */
    public static byte[] pdf2img(byte[] pdfPath) {
        InputStream is = null;
        PDDocument pdDocument = null;
        byte[] bytes = null;
        try {
            is = new ByteArrayInputStream(pdfPath);
            PDFParser parser = new PDFParser(is);
            parser.parse();
            pdDocument = parser.getPDDocument();
            PDPage page = (PDPage) pdDocument.getDocumentCatalog().getAllPages().get(0);
            bytes = pdfPage2Img(page);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pdDocument != null) {
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }


    public static byte[] pdfPage2Img(PDPage page) {
        BufferedImage bufferedImage = null;
        ImageOutputStream imageout = null;
        ByteArrayOutputStream outputStream = null;
        try {
             outputStream = new ByteArrayOutputStream();
            bufferedImage = page.convertToImage();
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (imageout != null) {
                try {
                    imageout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return outputStream.toByteArray();
    }




    /**
     * 将图片byte[]数组 转位 为 pdf 的byte[]流
     */
    public static byte[] generatePDF(byte[] bytes) {
        //构建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document doc = null;

        try {
            doc = new Document(new Rectangle(PageSize.A4));
            // 可配其余4个参数，如（rectPageSize，60,60,60,60）页面边距
            Image image = Image.getInstance(bytes);
            float scalePercentage = (100 / 300f) * 100.0f;
            //这里调整图片大小
            image.scalePercent(scalePercentage, scalePercentage);

            //将PDF文档对象写入到流
            PdfWriter.getInstance(doc, baos);
            doc.open();
            doc.add(image);
            if (doc != null) {
                doc.close();
            }
        } catch (Exception e) {
            System.out.println("PDF异常" + e);
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    System.out.println("PDF异常" + e);
                }
            }
        }
        //pdf字节数组
        byte[] b = baos.toByteArray();
        System.out.println("baos.toByteArray().length:" + baos.toByteArray().length);
        return b;
    }


    /**
     * byte 转文件 下载到本地
     *
     * @param fileName
     * @param
     */
    public static String conserveFile(String fileName, byte[] bytes) {
        String rootPath = "F://test//test1.pdf";

        String tempPath = "Files";
        // 相对路径
        OutputStream os = null;
        try {
            os = new FileOutputStream(rootPath);
            os.write(bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                os.flush();
                os.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return null;
    }
}

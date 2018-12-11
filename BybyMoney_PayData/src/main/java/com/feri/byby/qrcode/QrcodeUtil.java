package com.feri.byby.qrcode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
/**
 *@Author feri
 *@Date Created in 2018/12/11 09:37
 */
public class QrcodeUtil {
    public static void main(String[] args) throws Exception {
        //createCode("Java1805美女帅哥比较多");
        //createQrCode("醒醒",FileUtils.readFileToByteArray(new File("favicon.ico")),new File("1805.png"));
        createQrCode("醒醒",new File("log.png"),new File("1805.png"));
    }
    public static final String IMAGESUF="png";
    //生成二维码 普通  存储到本地文件中
    public static void createCode(String msg){
        try {
            Map param=new HashMap();
            param.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            param.put(EncodeHintType.MARGIN,5);
            param.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
            //生成二维码
            BitMatrix bitMatrix=new MultiFormatWriter().encode(msg,BarcodeFormat.QR_CODE,200,200,param);
            //基于NIO创建路径对象
            File file=new File("mt.png");
            Path path=file.toPath();
            //保存到指定路径
            MatrixToImageWriter.writeToPath(bitMatrix,IMAGESUF,path);
            System.out.println(file.getAbsolutePath());
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //生成二维码 普通  存储到本地文件中
    public static void createCode(String msg,File desfile){
        try {
            Map param=new HashMap();
            param.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            param.put(EncodeHintType.MARGIN,5);
            param.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
            //生成二维码
            BitMatrix bitMatrix=new MultiFormatWriter().encode(msg,BarcodeFormat.QR_CODE,200,200,param);
            //基于NIO创建路径对象
            Path path=desfile.toPath();
            //保存到指定路径
            MatrixToImageWriter.writeToPath(bitMatrix,IMAGESUF,path);
            System.out.println(desfile.getAbsolutePath());
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //生成二维码 普通  存储到本地文件中
    public static void createCode(String msg, OutputStream os){
        try {
            Map param=new HashMap();
            param.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            param.put(EncodeHintType.MARGIN,5);
            param.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
            //生成二维码
            BitMatrix bitMatrix=new MultiFormatWriter().encode(msg,BarcodeFormat.QR_CODE,200,200,param);

            //保存到指定输出流
            MatrixToImageWriter.writeToStream(bitMatrix,IMAGESUF,os);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建二维码，带图片的
    public static void createQrCode(String msg,File images,File defFile) throws Exception {
        //1、二维码参数设置
        Map param=new HashMap();
        param.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        param.put(EncodeHintType.MARGIN,1);
        param.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
        //2、生成二维码
        BitMatrix bitMatrix=new MultiFormatWriter().encode(msg,BarcodeFormat.QR_CODE,300,300,param);
        int cw=bitMatrix.getWidth();
        int ch=bitMatrix.getHeight();
        //3、创建要生成图片

        BufferedImage image=new BufferedImage(bitMatrix.getWidth(),bitMatrix.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
        //4、复制内容
        for(int x=0;x<cw;x++){
            for(int y=0;y<ch;y++){
             image.setRGB(x,y,bitMatrix.get(x,y)?0xFF000000:0xFFFFFFFF);
            }
        }
        //4、压缩处理传入的图片
        //原来的
        Image viewImage=ImageIO.read(images);
        //获取原来大小
        int w=viewImage.getWidth(null);
        int h=viewImage.getHeight(null);
        if(w>cw/2){
            w=cw/2;
        }
        if(h>ch/2){
            h=ch/2;
        }
        //获取裁剪后的图片
        Image src=viewImage.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        BufferedImage desImg=new BufferedImage(w,h,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics=desImg.getGraphics();
        graphics.drawImage(src,0,0,null);
        graphics.dispose();

        //5、合成图片
        Graphics2D graphics2D=image.createGraphics();
        int x=(cw-w)/2;
        int y=(ch-h)/2;
        graphics2D.drawImage(viewImage,x,y,w,h,null);
        Shape shape=new RoundRectangle2D.Float(x,y,w,h,6,6);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.draw(shape);
        graphics2D.dispose();
        ImageIO.write(image,IMAGESUF,defFile);
    }


}

package com.ms.service;

import com.swetake.util.Qrcode;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

/**
 * Created by lenovo on 2019/5/23.
 */
public class ImageHandler {

    private static String imageSavePath = "";
    private static String imagePath = "";
    private static String inviteUrl="";

    static {
        Properties pro = new Properties();
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/image_config.properties");
            if(is!=null){
                pro.load(is);
                imageSavePath = pro.getProperty("imageSavePath");
                imagePath = pro.getProperty("imagePath");
                inviteUrl = pro.getProperty("inviteUrl");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;

    }
    //377 561
    public static void drawString(Graphics2D gs,String name,int x,int y){

        Font f = new Font("思源黑",Font.BOLD,36);
        Color mycolor = new Color(254, 226, 192);//new Color(0, 0, 255);
        gs.setColor(mycolor);
        gs.setFont(f);
        gs.drawString(name,x-(getWordWidth(f, name)/2),y);
        gs.dispose();
    }

    public static BufferedImage createQRCode(String url,int width,int height) throws Exception{
        int n = 12;
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('H');//纠错等级（分为L、M、H三个等级）
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
        qrcode.setQrcodeVersion(n);//版本
        //生成二维码中要存储的信息
        String qrData = url;
        width = 67 + 12*(n-1);
        height = 67 + 12*(n-1);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘图
        Graphics2D gs = bufferedImage.createGraphics();
        gs.setBackground(new Color(254, 226, 192));

        gs.setColor(Color.BLACK);//new Color(254,226,192)

        gs.clearRect(0, 0, width, height);//清除下画板内容

        //设置下偏移量,如果不加偏移量，有时会导致出错。
        int pixoff = 2;

        byte[] d = qrData.getBytes("gb2312");
        if(d.length > 0 && d.length <300){
            boolean[][] s = qrcode.calQrcode(d);
            for(int i=0;i<s.length;i++){
                for(int j=0;j<s.length;j++){
                    if(s[j][i]){
                        gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
                    }
                }
            }
        }
        gs.dispose();
        bufferedImage.flush();
        return bufferedImage;


    }
    /**
     * 头像圆形处理，背景透明
     * @param filePath
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage headImage(String filePath,int width,int height) throws Exception{
        BufferedImage pic  = getBufferedImage(filePath); //原图

        int boder = 1; //留一个像素的白圈

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); //透明的背景图

        Graphics2D g2 = image.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D.Double shape = new Ellipse2D.Double(boder, boder, width-2*boder, height-2*boder);


        // 需要保留
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2.setClip(shape);
        g2.drawImage(pic, boder, boder, width-2*boder, height-2*boder,null);
        g2.dispose();

        //新创建一个graphics，这样画的圆不会有锯齿
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int border1 = 3;
        //画笔是4.5个像素，BasicStroke的使用可以查看下面的参考文档
        //使画笔时基本会像外延伸一定像素，具体可以自己使用的时候测试
        Stroke s = new BasicStroke(4.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(s);
        g2.setColor(Color.WHITE);
        g2.drawOval(border1, border1, width - border1 * 2, height - border1 * 2);
        g2.dispose();

        return image;
    }

    public static BufferedImage getBufferedImage(String filePath) throws Exception{
        if(filePath!=null && filePath.startsWith("http")){
            return getRemoteBufferedImage(filePath);
        }else{
            return ImageIO.read(new File(filePath));
        }
    }


    public static BufferedImage getRemoteBufferedImage(String imageURL) {
        URL url = null;
        InputStream is = null;
        BufferedImage bufferedImage = null;
        try {
            url = new URL(imageURL);
            is = url.openStream();
            bufferedImage = ImageIO.read(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return bufferedImage;
    }



    public static String genPlaybill(int uid,String nickName,String openId,String thirdId,String headPic) throws Exception{

        File file = new File(imageSavePath + uid + ".png");

        if(file.exists()){
            return imagePath + uid + ".png";
        }

        Random ra =new Random();
        int num = ra.nextInt(5) + 1;

        //如果多个改成随机数
        BufferedImage hb  = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("playbill/"+num+".png")); //原图

        Graphics2D g2 = hb.createGraphics();

        g2.drawImage(headImage(headPic, 108, 108), 318, 422, null);//322, 422

        String url = inviteUrl + "?inviteOpenId=" + openId + "&inviteUserId=" + thirdId;

        System.out.println(url);

        g2.drawImage(createQRCode(url, 115, 115), 302, 808, 144, 143, null);//291, 797, 166, 165,

        //logo
        BufferedImage logo  = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("playbill/logo.png"));
        g2.drawImage(logo, 355, 862, null);


        drawString(g2,nickName,375,575);//375*575

        try {
            // 输出图地址
            file = new File(imageSavePath);
            if(!file.exists()){
                file.mkdirs();
            }
            ImageIO.write(hb, "PNG", new File(imageSavePath + uid + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath + uid + ".png";
    }


    public static String getInviteUrl() {
        return inviteUrl;
    }

    public static void main(String[] args) throws Exception{

        genPlaybill(1,"111","oraXTwrUF56x7p6C3EHq-ip-ufdg","oraXTwrUF56x7p6C3EHq-ip-ufdg","d:\\2.jpg");

//        QRCode code = new QRCode()
//
//        QRCode.from("http://www.baidu.com").withSize(250, 250).withColor(30, 90)




//        BufferedImage avatarImage = ImageIO.read(new File("d:\\2.jpg"));
//        int width = 120;//如果剪切出来的图片画质模糊，请将width 调大点.
//        // 透明底的图片
//        BufferedImage formatAvatarImage = new BufferedImage(width, width, BufferedImage.TYPE_4BYTE_ABGR);
//        Graphics2D graphics = formatAvatarImage.createGraphics();
//        //把图片切成一个圓
//
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        //留一个像素的空白区域，这个很重要，画圆的时候把这个覆盖
//        int border = 1;
//        //图片是一个圆型
//        Ellipse2D.Double shape = new Ellipse2D.Double(border, border, width - border * 2, width - border * 2);
//        //需要保留的区域
//        graphics.setClip(shape);
//        graphics.drawImage(avatarImage, border, border, width - border * 2, width - border * 2, null);
//        graphics.dispose();
//
//        //在圆图外面再画一个圆
//
//        //新创建一个graphics，这样画的圆不会有锯齿
//        graphics = formatAvatarImage.createGraphics();
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int border1 = 3;
//        //画笔是4.5个像素，BasicStroke的使用可以查看下面的参考文档
//        //使画笔时基本会像外延伸一定像素，具体可以自己使用的时候测试
//        Stroke s = new BasicStroke(4.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
//        graphics.setStroke(s);
//        graphics.setColor(Color.WHITE);
//        graphics.drawOval(border1, border1, width - border1 * 2, width - border1 * 2);
//        graphics.dispose();
//
//        OutputStream os = new FileOutputStream("d:\\2_1.png");//发布项目时，如：Tomcat 他会在服务器本地tomcat webapps文件下创建此文件名
//        ImageIO.write(formatAvatarImage, "PNG", os);













    }

}

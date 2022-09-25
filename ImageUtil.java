import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

//调用saveCodeImage方法  传入一个图片存储地址
public class ImageUtil {

	public static String sRand="";

	//调用saveCodeImage方法  传入一个图片存储地址
	public static String saveCodeImage(String url) {
		url=url+"\\验证码.png";
		File file=new File(url);
		sRand="";
		try{
			BufferedImage p_w_picpath= creatImage();
			ImageOutputStream p_w_picpathIo=ImageIO.createImageOutputStream(file);
			ImageIO.write(p_w_picpath, "jpg", p_w_picpathIo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sRand;
	}

	public static Color getRandColor(int fc,int bc){//??????Χ?????????
		Random random = new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
	}
	public static BufferedImage creatImage(){


		int width=100, height=50;
		BufferedImage p_w_picpath = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		Graphics g = p_w_picpath.getGraphics();


		Random random = new Random();


		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);


		g.setFont(new Font("????",Font.BOLD,35));


		g.setColor(getRandColor(160,200));
		for (int i=0;i<155;i++)
		{
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x,y,x+xl,y+yl);
		}


		String strcode = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
		for (int i=0;i<4;i++){
			String code = strcode.charAt(random.nextInt(strcode.length()))+"";
			sRand += code;

			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));// ???ú??????????????????????????????????????????????????
			g.drawString(code,23*i+6,35);
		}

		g.dispose();

		return p_w_picpath;
	}
	public static byte[] getImg() {
		String url = "F:\\垃圾桶\\yzm.jpg";
		InputStream is;
		byte[] bs=null;
		try {
			is = new FileInputStream(url);
			bs = new byte[is.available()];
			is.read(bs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bs;
	}
	
}


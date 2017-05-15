package tess4.tess_4j;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * 官方样例
 * 
 * @author thinkpad
 *
 */
public class TesseractExample {

	public static void main(String[] args) {

		String imgPath = "F:\\pic\\tesseract_test\\tess-train\\2017-5-10\\eng.jpg";
//		 File imageFile = new File("eurotext.tif");
//		 File("F://pic//tesseract_test//printscreen//test2.jpg");
//		 File imageFile = new File("F://pic//tesseract_test//printscreen//tess4j//photo_basic4_1.jpg");
//		 File imageFile = new File("F:\\pic\\tesseract_test\\tess-train\\train_2017-5-8\\pic_old\\invoice_all.jpg");
		File imageFile = new File(imgPath);
		 
//		 File imageFile = new File("E:\\resources\\发票\\票样\\定额票\\subway.jpg");
//		File imageFile = new File("F://pic//tesseract_test//printscreen//tess4j//num_chi_0.png");

		ITesseract instance = new Tesseract(); // JNA Interface Mapping
//		instance.setLanguage("eng");
//		instance.setLanguage("chi_sim");
//		instance.setLanguage("invoice_all");
		instance.setLanguage("area+eng");

		System.out.println("\n-------application is running --------------");
		long startTime = System.currentTimeMillis();
		
		
		Rectangle rect = new Rectangle(790, 20, 300, 120);
		
		try {
			
			BufferedImage image = ImageIO.read(imageFile);
			
			FileInputStream in = new FileInputStream(imgPath);
			FileChannel channel = in.getChannel();
			
			String result = instance.doOCR(imageFile, rect);
			
			MappedByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
//			String result = instance.doOCR(imageFile);
//			instance.doOCR(0, 0, map, rect, 24);
			System.out.println(result);
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		long endTime = System.currentTimeMillis();
		System.out.println("\n"+(endTime-startTime)+"mm\n-------end------------" + "\n lasted time =  "
				+ (endTime - startTime) / 1000 + "s," + (endTime - startTime)
				% 1000 + " mm");
	}
}

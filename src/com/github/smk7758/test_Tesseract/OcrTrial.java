package com.github.smk7758.test_Tesseract;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OcrTrial {
	public static void main(String[] args) throws IOException, TesseractException {
		// 画像を読み込む
		File file = new File("C:\\work\\INPUT.JPG");
		BufferedImage img = ImageIO.read(file);

		ITesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:\\work"); // 言語ファイル（jpn.traineddata））の場所を指定
		tesseract.setLanguage("jpn"); // 解析言語は「日本語」を指定

		// 解析
		String str = tesseract.doOCR(img);

		// 結果
		System.out.println(str);
	}
}

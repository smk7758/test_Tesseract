package com.github.smk7758.test_Tesseract;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class HandwritingRecognize {
	// Tesseract

	public static Optional<String> recognize(Mat inputImage) {
		// ref: https://qiita.com/ohwer/items/4199cee2bc7fed6072ed

		// 画像を読み込む
		BufferedImage img = null;
		try {
			img = convertMatToBufferedImage(inputImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ITesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:\\SOFT_Files\\Tesseract-OCR-lang"); // 言語ファイル(jpn.traineddata)の場所を指定
		tesseract.setLanguage("jpn"); // 解析言語は「日本語」を指定
		tesseract.setTessVariable("user_defined_dpi", "70"); // よくわからないけど、dpiが画像情報に含まれていないとエラーが出るため。

		// 解析
		try {
			final String text = tesseract.doOCR(img);
			// 結果
			System.out.println(text);

			return Optional.of(text);
		} catch (TesseractException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public static BufferedImage convertMatToBufferedImage(Mat image) throws IOException {
		// ref: https://stackoverflow.com/a/46196408
		MatOfByte mob = new MatOfByte();
		Imgcodecs.imencode(".bmp", image, mob); // Speed: BMP > PNG >> JPG?
		return ImageIO.read(new ByteArrayInputStream(mob.toArray()));
	}
}

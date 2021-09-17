package com.github.smk7758.test_Tesseract;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HRMain {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("START");
	}

	public static void main(String[] args) {
		Mat image = Imgcodecs.imread("C:\\Programming\\Tessoract-OCR\\2021-09-12\\test_data.jpg");
		HandwritingRecognize.recognize(image);
		log();
	}

	private static void log() {
		// Loggerのテスト(SLF4Jを加えないとTesseractがエラーを吐くというのもあるため)
		Logger logger = LoggerFactory.getLogger(HRMain.class);
		logger.info("TEST INFO LOG!!  Logger Class=" + logger.getClass());
	}
}

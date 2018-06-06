package capstone.sejong.util.OCR;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class EdgeDetection {

	final private static String FILE_PATH = "c:/utill/modified.jpg";
	String getName;

	public EdgeDetection(String get) {
		this.getName = get;
	}

	public String main() throws Exception {

		try {
			// opencv 라이브러리 호출 (maven 전용)
			nu.pattern.OpenCV.loadShared();
			System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// 파일을 opencv 전용으로 읽어 들인다.
		Mat color = Imgcodecs.imread(getName);
		Mat gray = new Mat();
		Mat draw = new Mat();
		Mat wide = new Mat();
		Mat mor = new Mat();
		Mat erd = new Mat();
		Mat kernel = new Mat();

		Imgproc.cvtColor(color, gray, Imgproc.COLOR_BGR2GRAY);
		Imgproc.resize(gray, gray, new Size(gray.width() * 4, gray.height() * 4));

		Imgproc.GaussianBlur(gray, gray, new Size(5, 5), 1);
		Imgproc.pyrDown(gray, gray);

		Imgproc.bilateralFilter(gray, mor, 20, 50, 0);

		if (Imgcodecs.imwrite(FILE_PATH, mor)) {
			System.out.println("Edge is detected......");
		} else {
			// 저장이 안된경우 예외발생
			throw new Exception("File not saved");
		}

		return FILE_PATH;

	}

}
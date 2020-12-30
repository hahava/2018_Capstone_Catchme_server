package capstone.sejong.ocr;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;

@Component
public class EdgeDetector {

    final private static String MODIFIED = "_modified";

    public String getDetectedImagePath(String filePath) {

        Mat color = Imgcodecs.imread(filePath);
        Mat gray = new Mat();
        Mat mor = new Mat();

        Imgproc.cvtColor(color, gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.resize(gray, gray, new Size(gray.width() * 4, gray.height() * 4));
        Imgproc.GaussianBlur(gray, gray, new Size(5, 5), 1);
        Imgproc.pyrDown(gray, gray);
        Imgproc.bilateralFilter(gray, mor, 20, 50, 0);

        String newPath = filePath + MODIFIED + ".png";

        Imgcodecs.imwrite(newPath, mor);

        return newPath;
    }
}
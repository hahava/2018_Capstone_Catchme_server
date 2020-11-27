package capstone.sejong.util.OCR;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;

@Component
public class EdgeDetector {

    final private static String MODIFIED = "_modified";
    final private static Mat GRAY = new Mat();

    public String detect(String filePath) throws Exception {

        Mat color = Imgcodecs.imread(filePath);

        Imgproc.cvtColor(color, GRAY, Imgproc.COLOR_BGR2GRAY);
        Imgproc.resize(GRAY, GRAY, new Size(GRAY.width() * 4, GRAY.height() * 4));
        Imgproc.GaussianBlur(GRAY, GRAY, new Size(5, 5), 1);
        Imgproc.pyrDown(GRAY, GRAY);
        Imgproc.bilateralFilter(GRAY, GRAY, 20, 50, 0);

        String newPath = filePath + MODIFIED;

        if (Imgcodecs.imwrite(newPath, GRAY) == false) {
            throw new Exception("File not saved");
        }

        return newPath;
    }
}
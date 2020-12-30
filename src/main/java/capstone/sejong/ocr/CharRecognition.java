package capstone.sejong.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharRecognition {

    @Autowired
    private EdgeDetector edgeDetector;

    @Autowired
    private Tesseract tesseract;

    @Autowired
    private Ngram ngram;

    public List<String> process(String filePath) throws TesseractException {
        String preprocessedImageFilePath = edgeDetector.getDetectedImagePath(filePath);
        File preProcessedImageFile = new File(preprocessedImageFilePath);
        String result = tesseract.doOCR(preProcessedImageFile);
        List<String> results = changeAmbiguousWords(result.split("[,.′]"));
        return results;
    }

    private List<String> changeAmbiguousWords(String[] chars) {
        List<String> reList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i].replaceAll("\\p{Z}", "");

            if (chars[i].indexOf('|') != -1) {
                chars[i] = chars[i].replace('|', 'ㅣ');
                continue;
            }

            if (chars[i].indexOf('l') != -1) {
                if (chars[i].indexOf('0') != -1) {
                    chars[i] = chars[i].replace('0', 'ㅇ');
                    continue;
                }
            }
            if (chars[i].indexOf('o') != -1) {
                if (chars[i].indexOf('’') != -1) {
                    chars[i] = chars[i].replace('’', ' ');
                    continue;
                }
            }

            if (chars[i].isEmpty()) {
                continue;
            }

            reList.add(chars[i]);
        }
        return reList;
    }
}

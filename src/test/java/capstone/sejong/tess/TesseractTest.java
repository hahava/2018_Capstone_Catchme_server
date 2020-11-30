package capstone.sejong.tess;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TesseractTest {

    @Test
    public void doOCRTest() throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(getClass().getResource("/darwin/tessdata").getPath());
        String result = tesseract.doOCR(new File(getClass().getResource("/images/google.png").getFile()));
        Assert.assertEquals(result.trim(), "Google");
    }

}

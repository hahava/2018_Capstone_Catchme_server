package capstone.sejong.imageprocess;

import capstone.sejong.BaseTest;
import net.sourceforge.tess4j.Tesseract;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ImageProcessControllerTest extends BaseTest {

    /*
     * Open cv 를 사용하기 위해서 반드시 static 블록으로 linking 작업이 필요
     * 실제 운영에서는 capstone.sejong.config.WebInitializer 에서 호출
     */
    static {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Tesseract tesseract;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        tesseract.setDatapath(getClass().getResource("/darwin/tessdata").getPath());
    }

    @Test
    public void productImageUploadTest() throws Exception {
        File productImage = new File(getClass().getResource("/images/google.png").getFile());
        MockMultipartFile multipartFile = new MockMultipartFile("productImage", "google", MediaType.APPLICATION_JSON_VALUE, new FileInputStream(productImage));

        mockMvc
                .perform(fileUpload("/image/recognition").file(multipartFile))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

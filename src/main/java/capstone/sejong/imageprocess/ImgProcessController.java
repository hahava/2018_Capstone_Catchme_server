package capstone.sejong.imageprocess;

import capstone.sejong.ocr.CharRecognition;
import capstone.sejong.ocr.Main;
import capstone.sejong.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.valueOf;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@RestController
@RequestMapping("/image")
public class ImgProcessController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CharRecognition charRecognition;

    @Autowired
    private Main main;

    @Value("${spring.datasource.password}")
    private String fileSavePath;

    private String saveInstanceToFile(MultipartFile multipartFile) throws Exception {
        File file = Paths.get(fileSavePath, multipartFile.getOriginalFilename()).toFile();
        multipartFile.transferTo(file);
        return file.getAbsolutePath();
    }

    @RequestMapping(value = "/recognition", method = POST, produces = APPLICATION_JSON_VALUE)
    public HttpEntity<List<String>> getImage(@RequestParam("productImage") MultipartFile multipartFile) throws Exception {
        String savedFilePath = saveInstanceToFile(multipartFile);

        List<String> extractedWords = charRecognition.process(savedFilePath);

        List<String> productNames = productService.getAllProducts();

        // 이미지에서 해석된 결과 리스트
        List<String> resultList = new ArrayList<>();

        for (String extractedWord : extractedWords) {
            resultList.add(main.main(extractedWord, productNames));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(valueOf(APPLICATION_JSON_VALUE));

        return new ResponseEntity(resultList, headers, OK);
    }

    @RequestMapping(value = "getingradientimage", method = POST, produces = "application/json")
    public HttpEntity getProductImage(HttpServletRequest request) throws Exception {

//        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//        MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
//        if (!multipartFile.isEmpty()) {
//            try {
//                byte[] bytes = multipartFile.getBytes();
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(new File(FILE_SAVE_PATH + multipartFile.getOriginalFilename())));
//                stream.write(bytes);
//                stream.close();
//            } catch (Exception e) {
//                // 정상적으로 이미지 파일이 업로드 되지 않을 경우
//                System.out.println(e.getMessage());
//            }
//        }
//        String originalFilename = multipartFile.getOriginalFilename();
//        String onlyFileName = originalFilename.substring(0, originalFilename.indexOf("."));
//        String extension = originalFilename.substring(originalFilename.indexOf("."));
//        String rename = onlyFileName + extension;
//        String fullPath = FILE_SAVE_PATH + "\\" + rename;
//        // 이미지에서 추출된 글자 리스트
//        List<String> temp = charRecognition.process(fullPath);
//
//        // 제품의 리스트를 가져온다.
//        List<String> productList = service.getIngredient();
//
//        // 이미지에서 해석된 결과 리스트
//        List<String> resultList = new ArrayList<>();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
//        for (int i = 0; i < temp.size(); i++) {
//            resultList.add(main.main(temp.get(i), productList));
//        }
//        HashMap<String, String> map = new HashMap();
//        for (int i = 0; i < resultList.size(); i++) {
//            map.put(String.valueOf(i), resultList.get(i));
//        }
//        return new ResponseEntity(map, headers, OK);
        return null;
    }
}

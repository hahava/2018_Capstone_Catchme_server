package capstone.sejong.imgupload;

import capstone.sejong.util.OCR.FindOCR;
import capstone.sejong.util.OCR.GlobalAttr;
import capstone.sejong.util.OCR.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@RequestMapping("/uploadimage")
@RestController
public class ImgController {

	private static final String fileSavePath = "C:\\utill\\";

	@Autowired
	ImgService service;

	// 제품명 이미지 업로드 요청
	@RequestMapping(value = "/product", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity uploadFile(@RequestParam("imgFile") MultipartFile multipartFile, HttpServletRequest request)
			throws Exception {

		String savePath = GlobalAttr.filePath;
		String originalFilename = multipartFile.getOriginalFilename();
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf("."));
		String extension = originalFilename.substring(originalFilename.indexOf("."));
		String rename = onlyFileName + extension;
		String fullPath = savePath + "\\" + rename;

		if (!multipartFile.isEmpty()) {
			try {
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				// 정상적으로 이미지 파일이 업로드 되지 않을 경우
				return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
			}
		}

		System.out.println(fullPath);

		// 이미지에서 추출된 글자 리스트
		List<String> temp = FindOCR.process(fullPath, "eng");

		// 제품의 리스트를 가져온다.
		List<String> productList = service.getProductList();

		// 이미지에서 해석된 결과 리스트
		List<String> resultList = new ArrayList<>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		for (int i = 0; i < temp.size(); i++) {
			resultList.add(Main.main(temp.get(i), productList));
		}

		return new ResponseEntity(resultList, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "imageUpload.do", method = RequestMethod.POST, produces = "application/json")
	public HttpEntity getImage(HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
		if (!multipartFile.isEmpty()) {
			try {
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(fileSavePath + multipartFile.getOriginalFilename())));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				// 정상적으로 이미지 파일이 업로드 되지 않을 경우
				System.out.println(e.getMessage());
			}
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf("."));
		String extension = originalFilename.substring(originalFilename.indexOf("."));
		String rename = onlyFileName + extension;
		String fullPath = GlobalAttr.filePath + "\\" + rename;
		// 이미지에서 추출된 글자 리스트
		List<String> temp = FindOCR.process(fullPath, "eng");

		// 제품의 리스트를 가져온다.
		List<String> productList = service.getProductList();

		// 이미지에서 해석된 결과 리스트
		List<String> resultList = new ArrayList<>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		for (int i = 0; i < temp.size(); i++) {
			resultList.add(Main.main(temp.get(i), productList));
		}

		// json타입으로 만들기 위한 hashmap
		Map<String, String> result = new HashMap<>();
		for (int i = 0; i < resultList.size(); i++) {
			result.put(String.valueOf(i), resultList.get(i));
		}
		return new ResponseEntity(result, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "getingradientimage", method = RequestMethod.POST, produces = "application/json")
	public HttpEntity getProductImage(HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
		if (!multipartFile.isEmpty()) {
			try {
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(fileSavePath + multipartFile.getOriginalFilename())));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				// 정상적으로 이미지 파일이 업로드 되지 않을 경우
				System.out.println(e.getMessage());
			}
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf("."));
		String extension = originalFilename.substring(originalFilename.indexOf("."));
		String rename = onlyFileName + extension;
		String fullPath = GlobalAttr.filePath + "\\" + rename;
		// 이미지에서 추출된 글자 리스트
		List<String> temp = FindOCR.process(fullPath, "kor");

		// 제품의 리스트를 가져온다.
		List<String> productList = service.getIngradient();

		// 이미지에서 해석된 결과 리스트
		List<String> resultList = new ArrayList<>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
		for (int i = 0; i < temp.size(); i++) {
			resultList.add(Main.main(temp.get(i), productList));
		}
		HashMap<String, String> map = new HashMap();
		for (int i = 0; i < resultList.size(); i++) {
			map.put(String.valueOf(i), resultList.get(i));
		}
		return new ResponseEntity(map, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "getingradientimage/korean", method = RequestMethod.POST, produces = "application/json")
	public HttpEntity getProductImagekorea(HttpServletRequest request) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
		if (!multipartFile.isEmpty()) {
			try {
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(fileSavePath + multipartFile.getOriginalFilename())));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				// 정상적으로 이미지 파일이 업로드 되지 않을 경우
				System.out.println(e.getMessage());
			}
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf("."));
		String extension = originalFilename.substring(originalFilename.indexOf("."));
		String rename = onlyFileName + extension;
		String fullPath = GlobalAttr.filePath + "\\" + rename;
		// 이미지에서 추출된 글자 리스트
		List<String> temp = FindOCR.process(fullPath, "kor");

		// 제품의 리스트를 가져온다.
		List<String> productList = service.getIngradientkorean();

		// 이미지에서 해석된 결과 리스트
		List<String> resultList = new ArrayList<>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		for (int i = 0; i < temp.size(); i++) {
			resultList.add(Main.main(temp.get(i), productList));
		}
		System.out.println(resultList.get(0));
		return new ResponseEntity(resultList, headers, HttpStatus.OK);
	}
}

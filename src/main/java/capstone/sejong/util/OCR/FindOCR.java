package capstone.sejong.util.OCR;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;

// OCR을 이용해서 단어를 검출한다. 여러개 존재시 List에 담아서 반환한다.

public class FindOCR {

	public static List<String> process(String fullPath) throws Exception {

		// OCR을 하기위해 이미지 전처리
		EdgeDetection detection = new EdgeDetection(fullPath);
		List<String> reList = new ArrayList<>();

		// opencv 전처리된 이미지 경로
		String modifyFilePath = detection.main();

		// 구글 tesseract 설정 파일 path 설정
		Tesseract instance = new Tesseract();
		instance.setDatapath("C:\\utill\\tessdata");
		instance.setLanguage("kor");
		// instance.setLanguage("eng");

		File file = new File(modifyFilePath);
		String result = "";
		try {
			result = instance.doOCR(file);
			String[] reArray = result.split("\\,|\\.|\\′");

			for (int i = 0; i < reArray.length; i++) {
				reArray[i] = reArray[i].replaceAll("\\p{Z}", "");
				if (reArray[i].indexOf('|') != -1)
					reArray[i] = reArray[i].replace('|', 'ㅣ');
				if (reArray[i].indexOf('l') != -1)
					// reArray[i] = reArray[i].replace('l', 'ㅣ');
					if (reArray[i].indexOf('0') != -1)
						reArray[i] = reArray[i].replace('0', 'ㅇ');
				if (reArray[i].indexOf('o') != -1)
					// reArray[i] = reArray[i].replace('o', 'ㅇ');
					if (reArray[i].indexOf('’') != -1)
						reArray[i] = reArray[i].replace('’', ' ');
				if (reArray[i].isEmpty()) {
					continue;
				}
				System.out.println("--------------------------------------찾아 바꾸기 진행...----------");

				reList.add(reArray[i]);
				System.out.println(reArray[i]);
			}
			// System.out.println(result);
			System.out.println(reArray.length + "개의 단어 검출");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reList;
	}

}

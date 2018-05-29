package capstone.sejong.util.OCR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.wcohen.ss.JaroWinkler;
import com.wcohen.ss.api.StringDistance;

public class Main {

	public static String main(String args, List<String> wordList) {
		List<String> save_item = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("::::성분명 입력 :::: " + args);
		String word = args;
		String result = "";

		// 단어 거리 알고리즘 maven-> secondString 추가
		JaroWinkler jaro = new JaroWinkler();

		for (int i = 0; i < wordList.size(); i++) {
			System.out.println(wordList.get(i));
		}

		List<Node> nodeList = new ArrayList<>();
		for (int i = 0; i < wordList.size(); i++) {
			nodeList.add(new Node(wordList.get(i)));
		}

		StringDistance distanceChecker = jaro.getDistance();
		Node minnode = Ngram.findNgramAccu(nodeList, word);

		// ngram을 사용하기 위해 node의 글자를 자.모음 단위로 분리한다.
		for (int i = 0; i < nodeList.size(); i++) {
			nodeList.get(i).word = UniKorean.getUniKorean(nodeList.get(i).word);
		}
		word = UniKorean.getUniKorean(word);
		minnode = Ngram.findNgramAccu(nodeList, word);

		if (minnode.accu > 0.42) {// 제품 검색용 조건문
			System.out.println("---------------------------------------------");
			System.out.printf("%s 와 가장 유사한 값은 %s \t n gram 수치는 %.4f\n %s", word, minnode.word, minnode.accu, minnode.orginWord);
			save_item.add(minnode.orginWord);
			HashSet<String> distinctData = new HashSet<String>(save_item);
			save_item = new ArrayList<String>(distinctData);
		}
		result = save_item.get(0);
		return result;
	}
}

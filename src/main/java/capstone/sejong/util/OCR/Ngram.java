package capstone.sejong.util.OCR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import com.wcohen.ss.JaroWinkler;
import com.wcohen.ss.api.StringDistance;

public class Ngram {

	public static Node findNgramAccu(List<Node> list, String word) {
		Node temp = new Node("");
		JaroWinkler jaro = new JaroWinkler();
		StringDistance distanceChecker = jaro.getDistance();

		temp.accu = Double.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			list.get(i).accu = calNode(list.get(i).word, word) * 0.20
					+ distanceChecker.score(UniKorean.getUniKorean(word), list.get(i).word)
							* 0.8;
			if (list.get(i).accu > temp.accu) {
				temp = list.get(i);
			}
		}
		return temp;
	}

	public static double calNode(String node, String word) {

		String dataSplit[] = spliter(node);
		String wordSplit[] = spliter(word);
		// 문자 길이에 대한 가중치 조절
		int dataLen = dataSplit.length;
		int wordLen = wordSplit.length;

		int lenWeight = Math.abs(dataLen - wordLen);
		// System.out.println(dataLen);
		// System.out.println(wordLen);

		double count = 0;
		for (int i = 0; i < dataSplit.length; i++) {
			for (int j = 0; j < wordSplit.length; j++) {
				if (dataSplit[i].equals(wordSplit[j])) {
					// count++;
					// 자모음에 따른 가중치 조절
					count += UniKorean.compareWord(wordSplit[j]);
				}
			}
		}
		return count - (0.1 * lenWeight);
	}

	// binary 형태로 글자를 분리한다.
	public static String[] spliter(String node) {

		String[] arr = new String[node.length() - 1];
		for (int i = 1; i <= arr.length; i++) {
			arr[i - 1] = node.substring(i - 1, i + 1);
		}

		return arr;
	}

}

package capstone.sejong.ocr;

import com.wcohen.ss.JaroWinkler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Ngram {

    @Autowired
    private JaroWinkler jaroWinkler;

    public Node findNgramAccu(List<Node> nodes, String word) {
        Node maximumNode = new Node("");

        maximumNode.accurate = Double.MIN_VALUE;

        for (Node node : nodes) {
            node.accurate = calNode(node.word, word) * 0.20 + jaroWinkler.getDistance().score(MorphemeUtil.getUniKorean(word), node.word) * 0.8;
            if (node.accurate > maximumNode.accurate) {
                maximumNode = node;
            }
        }

        return maximumNode;
    }

    public double calNode(String node, String word) {
        String dataSplit[] = splitter(node);
        String wordSplit[] = splitter(word);

        int dataLen = dataSplit.length;
        int wordLen = wordSplit.length;

        int lenWeight = Math.abs(dataLen - wordLen);

        double count = 0;
        for (int i = 0; i < dataSplit.length; i++) {
            for (int j = 0; j < wordSplit.length; j++) {
                if (dataSplit[i].equals(wordSplit[j])) {
                    // count++;
                    // 자모음에 따른 가중치 조절
                    count += MorphemeUtil.compareWord(wordSplit[j]);
                }
            }
        }
        return count - (0.1 * lenWeight);
    }

    // binary 형태로 글자를 분리한다.
    public static String[] splitter(String node) {

        String[] arr = new String[node.length() - 1];
        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = node.substring(i - 1, i + 1);
        }

        return arr;
    }

}

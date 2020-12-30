package capstone.sejong.ocr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class Main {

    private static final double ACCURATE = 0.42;

    @Autowired
    private Ngram ngram;

    public String main(String word, List<String> words) {
        List<String> savedItems = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        for (String s : words) {
            nodes.add(new Node(s));
        }

        // ngram을 사용하기 위해 node의 글자를 자.모음 단위로 분리한다.
        for (Node node : nodes) {
            node.word = MorphemeUtil.getUniKorean(node.word);
        }
        word = MorphemeUtil.getUniKorean(word);

        Node minNode = ngram.findNgramAccu(nodes, word);

        if (minNode.accurate > ACCURATE) {
            savedItems.add(minNode.originWord);
            HashSet<String> distinctData = new HashSet<>(savedItems);
            savedItems = new ArrayList<>(distinctData);
        }

        return savedItems.get(0);
    }
}

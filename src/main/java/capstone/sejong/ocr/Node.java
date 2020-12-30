package capstone.sejong.ocr;

public class Node {

    public Node(String word) {
        this.word = word;
        this.originWord = word;
    }

    public String word;
    public double accurate;
    public String originWord;
}
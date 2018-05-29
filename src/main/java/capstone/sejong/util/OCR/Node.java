package capstone.sejong.util.OCR;

public class Node {

	public Node(String word) {
		this.word = word;
		this.orginWord = word;
	}

	public String word;
	public double accu;
	public double distance;
	public String orginWord;
}
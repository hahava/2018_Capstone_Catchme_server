package capstone.sejong.inquiry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InquiryDTO {
	private String email;
	private String title;
	private String content;
	private String type;
}

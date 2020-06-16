package capstone.sejong.inquiry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class InquiryDTO {
	@NotNull(message = "Email must be included")
	private String email;

	@NotNull(message = "Title must be included")
	@Size(max = 100, message = "Title must be under 100 chars")
	private String title;

	@NotNull
	@Size(max = 500, message = "Content must be under 100 chars")
	private String content;

	@NotNull(message = "Type must be included")
	private String type;
}

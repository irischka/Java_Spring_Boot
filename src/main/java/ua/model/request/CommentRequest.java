package ua.model.request;

import org.hibernate.validator.constraints.NotBlank;
import ua.entity.Comment;

import java.util.List;

public class CommentRequest {

	private List<Comment> comments;
	
	@NotBlank(message = "Поле не може бути пустим")
	private String comment;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}

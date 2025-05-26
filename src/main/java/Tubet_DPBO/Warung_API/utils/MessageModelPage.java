package Tubet_DPBO.Warung_API.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModelPage {

	private String message;
	private Object data;
	private Integer currentPage;
	private Integer totalItems;
	private Integer totalPages;
	private Integer numberOfElement;
}

package me.sisyphusj.community.app.post.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDetailResDTO {

	// 게시글 고유 ID
	private int postId;

	// 작성자
	private String author;

	// 제목
	private String title;

	// 본문
	private String content;

	// 조회 수
	private int views;

	// 생성일
	private Date createdDate;

	// 최종 수정일
	private Date updatedDate;

	public static PostDetailResDTO of(PostDetailVO postDetailVO) {
		return PostDetailResDTO.builder()
			.postId(postDetailVO.getPostId())
			.author(postDetailVO.getAuthor())
			.title(postDetailVO.getTitle())
			.content(postDetailVO.getContent())
			.views(postDetailVO.getViews())
			.createdDate(postDetailVO.getCreatedDate())
			.updatedDate(postDetailVO.getUpdatedDate())
			.build();
	}
}
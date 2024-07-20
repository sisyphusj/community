package me.sisyphusj.community.app.comment.domain;

import java.util.Date;

import lombok.Getter;

@Getter
public class CommentDetailVO {

	private long commentId; // 댓글 고유 ID

	private long userId; // 작성자 고유 ID

	private Long parentId; // 부모 댓글 고유 ID

	private long postId; // 게시글 고유 ID

	private String author; // 작성자 이름

	private String content; // 댓글 내용

	private HasChild hasChild; // 자식 댓글 보유 유무

	private Date createdDate; // 댓글 생성일

	private Date updatedDate; // 댓글 수정일

}
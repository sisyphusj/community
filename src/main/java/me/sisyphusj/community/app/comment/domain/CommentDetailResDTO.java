package me.sisyphusj.community.app.comment.domain;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import me.sisyphusj.community.app.image.domain.CommentImageResDTO;

@Getter
@Builder
public class CommentDetailResDTO {

	private long commentId; // 댓글 고유 ID

	private long userId; // 작성자 고유 ID

	private Long parentId; // 부모 댓글 고유 ID

	private long postId; // 게시글 고유 ID

	private String name; // 작성자 이름

	private String content; // 댓글 내용

	private Date createdAt; // 댓글 생성일

	private Date updatedAt; // 댓글 수정일

	private List<CommentImageResDTO> images; // 첨부 이미지 리스트

	public static CommentDetailResDTO of(CommentVO commentVO) {
		return CommentDetailResDTO.builder()
			.commentId(commentVO.getCommentId())
			.userId(commentVO.getUserId())
			.parentId(commentVO.getParentId())
			.postId(commentVO.getPostId())
			.name(commentVO.getName())
			.content(commentVO.getContent())
			.createdAt(commentVO.getCreatedAt())
			.updatedAt(commentVO.getUpdatedAt())
			.images(commentVO.getImages().stream()
				.map(CommentImageResDTO::of)
				.toList())
			.build();
	}
}

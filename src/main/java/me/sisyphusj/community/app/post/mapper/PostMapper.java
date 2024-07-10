package me.sisyphusj.community.app.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.sisyphusj.community.app.post.domain.PostThumbnailVO;
import me.sisyphusj.community.app.post.domain.PostVO;

@Mapper
public interface PostMapper {

	void insertPost(PostVO postVO);

	List<PostThumbnailVO> selectPostThumbnailList(int amount, int offset);

}

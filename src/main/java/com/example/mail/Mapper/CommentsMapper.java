package com.example.mail.Mapper;

import com.example.mail.Pojo.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CommentsMapper {

    int selectIdMaxComments();

    void addComments(int id, Date datetime, String content, int orderbuyID, int ordercarID, String userID);

    List<Comments> queryCommentsList();

    List<Comments> queryCommentsListByorderbuyID(int id);

    void updateComments(int id, Date datetime, String content, int orderbuyID, int ordercarID, String userID);

    void deleteComments(int id);

    List<Integer> getUidByOid(int id);

    List<Integer> getOidByUid(int userID);
}

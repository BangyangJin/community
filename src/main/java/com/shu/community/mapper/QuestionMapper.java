package com.shu.community.mapper;

import com.shu.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuestionMapper {
    @Insert("insert into question (title,description,tag,gmt_create,gmt_modified,creator) values(#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{creator})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,
                        @Param(value = "size") Integer size);

    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId,
                                @Param(value = "offset") Integer offset,
                                @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

}

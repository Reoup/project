package com.example.boardapitwo.mapper;


import com.example.boardapitwo.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
     List<BoardDTO> boardList();
     BoardDTO getOneBoard(int seq);
     void updateBoard(BoardDTO board);
     void createBoard(BoardDTO board);
     void deleteBoard(int seq);
}

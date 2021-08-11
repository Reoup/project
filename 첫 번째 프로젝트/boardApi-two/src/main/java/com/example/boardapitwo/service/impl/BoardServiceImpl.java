package com.example.boardapitwo.service.impl;

import com.example.boardapitwo.dto.BoardDTO;
import com.example.boardapitwo.mapper.BoardMapper;
import com.example.boardapitwo.service.BoardService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<BoardDTO> boardList(int page, int pageSize){
        List<BoardDTO> result = null;
        try{
            PageHelper.startPage(page, pageSize);
            result = boardMapper.boardList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}

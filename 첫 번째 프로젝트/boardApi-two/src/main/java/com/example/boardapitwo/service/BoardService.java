package com.example.boardapitwo.service;

import com.example.boardapitwo.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    List<BoardDTO> boardList(int page, int pageSize);



}
package com.example.boardapitwo.controller;

import com.example.boardapitwo.dto.BoardDTO;
import com.example.boardapitwo.mapper.BoardMapper;
import com.example.boardapitwo.service.BoardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600) //CrossOrigin 어노테이션을 사용하면 global하게 설정할 수 있습니다.(origins, methods, maxAge, allowedHeaders)
@RestController // Spirng MVC Controller에 @ResponseBodt가 추가됨 RestController의 주용도는 Json 형태로 객체 데이터를 반환하는 것 //@Controller는 주로 View를 반환하기 위해 사용, Data를 반환해야 하는 경우도 있지만 @ResponseBody 어노테이션을 활용함
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public PageInfo<BoardDTO> boardList(
            @RequestParam(value="p_num", required = false, defaultValue = "1") int page) {
        List<BoardDTO> result = boardService.boardList(page, 5);
        PageInfo<BoardDTO> pi = new PageInfo<BoardDTO>(result);

        return pi;
    }

    @Autowired
    BoardMapper boardMapper;

    @PostMapping("/board")
    void createBoard(@RequestBody BoardDTO board){
        boardMapper.createBoard(board);
        System.out.println("보드 DB 저장 성공");
    }

    @GetMapping("/board/{seq}")
    public BoardDTO getOneBoard(@PathVariable int seq){
        System.out.println(boardMapper.getOneBoard(seq));
        BoardDTO board = boardMapper.getOneBoard(seq);
        return board;
    }

    @PutMapping("/board/{seq}")
    public void updateBoard(@PathVariable int seq,  @RequestBody BoardDTO board){
        BoardDTO updateBoard = board;
        updateBoard.setSeq(seq);
        System.out.println("업데이트보드 => " + updateBoard);

        updateBoard.setTitle(board.getTitle());
        updateBoard.setContent(board.getContent());

        boardMapper.updateBoard(updateBoard);
    }

    @DeleteMapping("/board/{seq}")
    public void deleteBoard(@PathVariable int seq){
        boardMapper.deleteBoard(seq);
        System.out.println("보드 삭제, 성공적");
    }
}

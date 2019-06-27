package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {
	
	void writeMemo(MemoDto memoDto);
	List<MemoDto> listMemo(Map<String, String> parameter);
	void modifyMemo(MemoDto memoDto);
	void deleteMemo(int mseq);
}

package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.MemoDto;
import com.kitri.cafe.board.model.ReboardDto;


public interface ReboardService {
	
	int writeArticle(ReboardDto reboardDto);
	List<ReboardDto> listArticle(Map<String, String> parameter);
	ReboardDto viewArticle(int seq);
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
}

package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.BbsDto;
public interface BbsService {
	
	int writeArticle(BbsDto bbsDto);
	List<BbsDto> listArticle(Map<String, String> parameter);
	BbsDto viewArticle(int seq);
	int modifyArticle(BbsDto bbsDto);
	void deleteArticle(int seq);
}

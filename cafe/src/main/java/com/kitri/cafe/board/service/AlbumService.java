package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.AlbumDto;

public interface AlbumService {
	
	int writeArticle(AlbumDto albumDto);
	List<AlbumDto> listArticle(Map<String, String> parameter);
	AlbumDto viewArticle(int seq);
	int modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
}

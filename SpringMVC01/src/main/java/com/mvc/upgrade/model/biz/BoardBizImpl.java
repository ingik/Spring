package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz{
	
	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardDto> selectList() {
		return null;
	}

	@Override
	public BoardDto selectOne(int myno) {
		return null;
	}

	@Override
	public int insert(BoardDto dto) {
		return 0;
	}

	@Override
	public int update(BoardDto dto) {
		return 0;
	}

	@Override
	public int delete(int myno) {
		return 0;
	}

}

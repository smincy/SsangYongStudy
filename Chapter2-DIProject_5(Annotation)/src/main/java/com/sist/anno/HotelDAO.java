package com.sist.anno;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDAO {
	@Autowired
	private HotelMapper mapper;

	public List<HotelVO> hotelListData() {
		return mapper.hotelListData();
	}
}
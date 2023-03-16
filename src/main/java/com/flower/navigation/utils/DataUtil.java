package com.flower.navigation.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flower.navigation.entity.BookmarkEntity;

public class DataUtil {
	
	public static Map<String, List<BookmarkEntity>> dataTransferred(List<BookmarkEntity> data){
		 Map<String, List<BookmarkEntity>>  res = new HashMap<String, List<BookmarkEntity>>();
		if(data.size() >0) {
			for(BookmarkEntity book :data) {
				String key = book.getLabelid()+"_"+book.getLabelname();
				List<BookmarkEntity> orDefault = res.getOrDefault(key, new ArrayList<BookmarkEntity>());
				orDefault.add(book);
				res.put(key, orDefault);
			}
			return res;
				
		}
		
		
		return null;
		
	}

}

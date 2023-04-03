package com.flower.navigation.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flower.navigation.entity.BookmarkEntity;
import com.flower.navigation.entity.BookmarkLabelEntity;

public class DataUtil {
	
	public static Map<String, List<BookmarkEntity>> dataTransferred(List<BookmarkEntity> data, List<BookmarkLabelEntity> label){
		 Map<String, List<BookmarkEntity>>  res = new HashMap<String, List<BookmarkEntity>>();
		 Map<Integer, BookmarkLabelEntity> data2 = DataUtil.data(label);
		if(data.size() >0) {
			for(BookmarkEntity book :data) {
				String key = book.getLabelid()+"_"+book.getLabelname()+"_"+data2.get(Integer.parseInt(book.getLabelid())).getLabelbgcolor()+"_"+data2.get(Integer.parseInt(book.getLabelid())).getLabelfontcolor();
				List<BookmarkEntity> orDefault = res.getOrDefault(key, new ArrayList<BookmarkEntity>());
				orDefault.add(book);
				res.put(key, orDefault);
			}
			return res;
				
		}
		
		
		return null;
	}

	public static Map<Integer, BookmarkLabelEntity> data(List<BookmarkLabelEntity> data){
		Map<Integer, BookmarkLabelEntity> res = new HashMap<Integer, BookmarkLabelEntity>();
		for(BookmarkLabelEntity entity:data) {
			res.put(entity.getId(), entity);
		}
		return res;
	}
}

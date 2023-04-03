package com.flower.navigation.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.flower.navigation.entity.BookmarkEntity;

@Repository
@Transactional
public interface BookMarkDao extends PagingAndSortingRepository<BookmarkEntity, Integer>, JpaSpecificationExecutor<BookmarkEntity>{

	List<BookmarkEntity>  findAll();

}

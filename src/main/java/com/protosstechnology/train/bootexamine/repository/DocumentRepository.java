package com.protosstechnology.train.bootexamine.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.protosstechnology.train.bootexamine.entity.Document;

public interface DocumentRepository extends PagingAndSortingRepository<Document,Long>{

}

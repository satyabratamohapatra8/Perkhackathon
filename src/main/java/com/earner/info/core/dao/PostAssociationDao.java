package com.earner.info.core.dao;

import java.util.List;

import com.earner.info.core.model.PostAssociation;

public interface PostAssociationDao {
	public void saveOrUpdatePostAssociation(PostAssociation postAssociation);
	public List<PostAssociation> getAllAssocationForUser(long uid);
	public List<PostAssociation> getAllAssociationForQuestionPostById(long qpostId);
}

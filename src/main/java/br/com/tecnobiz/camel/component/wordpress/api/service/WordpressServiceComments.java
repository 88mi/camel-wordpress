package br.com.tecnobiz.camel.component.wordpress.api.service;

import java.util.List;

import br.com.tecnobiz.camel.component.wordpress.api.model.Comment;
import br.com.tecnobiz.camel.component.wordpress.api.model.CommentSearchCriteria;
import br.com.tecnobiz.camel.component.wordpress.api.model.Context;

public interface WordpressServiceComments extends WordpressService {

    Comment create(Comment category);

    void delete(int categoryId, boolean force);

    List<Comment> list(CommentSearchCriteria criteria);

    Comment retrieve(int categoryId, Context context);

    Comment update(int categoryId, Comment category);

}

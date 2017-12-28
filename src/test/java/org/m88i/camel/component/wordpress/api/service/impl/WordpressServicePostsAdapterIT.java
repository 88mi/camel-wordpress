package org.m88i.camel.component.wordpress.api.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.m88i.camel.component.wordpress.WordpressTestConstants;
import org.m88i.camel.component.wordpress.api.model.Post;
import org.m88i.camel.component.wordpress.api.model.PostSearchCriteria;
import org.m88i.camel.component.wordpress.api.service.WordpressServicePosts;
import org.m88i.camel.component.wordpress.proxy.WordpressServiceProvider;

public class WordpressServicePostsAdapterIT {

    private static WordpressServicePosts servicePosts;

    @BeforeClass
    public static void before() {
        final WordpressServiceProvider serviceProvider = WordpressServiceProvider.getInstance();
        serviceProvider.init(WordpressTestConstants.WORDPRESS_DEMO_URL);
        servicePosts = serviceProvider.getService(WordpressServicePosts.class);
    }

    @Test
    public void testRetrievePost() {
        final Post post = servicePosts.retrieve(1);
        assertThat(post, not(nullValue()));
        assertThat(post.getId(), is(1));
    }
    
    @Test
    public void testListPosts() {
        final PostSearchCriteria criteria = new PostSearchCriteria();
        criteria.setPage(1);
        criteria.setPerPage(5);
        final List<Post> posts = servicePosts.list(criteria);
        assertThat(posts, is(not(emptyCollectionOf(Post.class))));
        assertThat(posts.size(), is(5));
    }
}
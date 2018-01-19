package org.m88i.camel.component.wordpress;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.apache.camel.CamelContext;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wordpress4j.model.PostOrderBy;
import org.wordpress4j.model.PostSearchCriteria;

public class WordpressComponentTest {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(WordpressComponentTest.class);

    @Test
    public void testParseUriPropertiesCriteria() throws Exception {
        final WordpressComponent component = new WordpressComponent(Mockito.mock(CamelContext.class));
        final WordpressEndpoint endpoint = (WordpressEndpoint)component
            .createEndpoint("wordpress:post?apiVersion=2&url=http://mysite.com/&criteria.search=test&criteria.page=1&criteria.perPage=10&criteria.orderBy=author&criteria.categories=camel,dozer,json");

        assertThat(endpoint.getConfiguration().getSearchCriteria(), instanceOf(PostSearchCriteria.class));
        assertNotNull(endpoint.getConfiguration().getSearchCriteria());
        assertThat(endpoint.getConfiguration().getSearchCriteria().getPage(), is(1));
        assertThat(endpoint.getConfiguration().getSearchCriteria().getPerPage(), is(10));
        assertThat(endpoint.getConfiguration().getSearchCriteria().getSearch(), is("test"));
        assertThat(((PostSearchCriteria)endpoint.getConfiguration().getSearchCriteria()).getOrderBy(), is(PostOrderBy.author));
        assertThat(((PostSearchCriteria)endpoint.getConfiguration().getSearchCriteria()).getCategories(), notNullValue());
        assertThat(((PostSearchCriteria)endpoint.getConfiguration().getSearchCriteria()).getCategories(), not(emptyCollectionOf(String.class)));

        LOGGER.info("Categories are {}", ((PostSearchCriteria)endpoint.getConfiguration().getSearchCriteria()).getCategories());
    }

}

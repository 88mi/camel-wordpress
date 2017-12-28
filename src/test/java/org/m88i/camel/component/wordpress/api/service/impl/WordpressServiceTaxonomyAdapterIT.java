package org.m88i.camel.component.wordpress.api.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.m88i.camel.component.wordpress.WordpressTestConstants;
import org.m88i.camel.component.wordpress.api.model.Taxonomy;
import org.m88i.camel.component.wordpress.api.service.WordpressServiceTaxonomy;
import org.m88i.camel.component.wordpress.proxy.WordpressServiceProvider;

public class WordpressServiceTaxonomyAdapterIT {

    private static WordpressServiceTaxonomy serviceTaxonomy;

    @BeforeClass
    public static void before() {
        final WordpressServiceProvider serviceProvider = WordpressServiceProvider.getInstance();
        serviceProvider.init(WordpressTestConstants.WORDPRESS_DEMO_URL);
        serviceTaxonomy = serviceProvider.getService(WordpressServiceTaxonomy.class);
    }

    @Test
    public void testRetrieve() {
        final Taxonomy taxonomy = serviceTaxonomy.retrieve(null, "category");
        assertThat(taxonomy, not(nullValue()));
        assertThat(taxonomy.getName(), not(isEmptyOrNullString()));
    }

    @Test
    public void testList() {
        final Map<String, Taxonomy> taxs = serviceTaxonomy.list(null, null);
        assertThat(taxs, is(not(nullValue())));
        assertThat(taxs.size(), is(2));
    }
}
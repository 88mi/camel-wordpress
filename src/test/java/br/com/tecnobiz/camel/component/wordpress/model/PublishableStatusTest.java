package br.com.tecnobiz.camel.component.wordpress.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.tecnobiz.camel.component.wordpress.api.model.PublishableStatus;

public class PublishableStatusTest {

    @Test
    public void testFromString() {
        final String input1 = "PRIVATE";
        final String input2 = "private";

        assertThat(PublishableStatus.fromString(input1), is(PublishableStatus.private_));
        assertThat(PublishableStatus.fromString(input2), is(PublishableStatus.private_));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromStringEmpty() {
        final String input3 = "";

        assertThat(PublishableStatus.fromString(input3), is(PublishableStatus.private_));
    }

    @Test(expected = NullPointerException.class)
    public void testFromStringNull() {
        final String input4 = null;

        assertThat(PublishableStatus.fromString(input4), is(PublishableStatus.private_));
    }

}

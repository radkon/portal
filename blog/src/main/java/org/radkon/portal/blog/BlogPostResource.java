package org.radkon.portal.blog;

import javax.inject.Inject;

public class BlogPostResource {

    @Inject
    BlogPostService blogPostService;

    public BlogPost create(BlogPost blogPost) {
        return blogPostService.create(blogPost);
    }

    public BlogPost readById(String blogPostId) {
        return blogPostService.readById(blogPostId);
    }

}

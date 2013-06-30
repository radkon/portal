package org.radkon.portal.blog;

import javax.ejb.NoSuchEntityException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlogPostService {

    final Map<String, BlogPost> blogPostStore = new HashMap<>();

    public BlogPost create(BlogPost blogPost) {
        blogPostStore.put(blogPost.getId(), blogPost);
        return blogPost;
    }

    public List<BlogPost> readBlogPosts(Blog blog) {
        final List<BlogPost> result = new LinkedList<>();
        for (BlogPost blogPost : blogPostStore.values()) {
            if (blog.equals(blogPost.getBlog())) {
                result.add(blogPost);
            }
        }
        return result;
    }

    public BlogPost readById(String blogPostId) {
        final BlogPost blogPost = blogPostStore.get(blogPostId);
        if (blogPost == null) {
            throw new NoSuchEntityException("BlogPost with ID '" + blogPostId + "' was not found.");
        }
        return blogPost;
    }
}

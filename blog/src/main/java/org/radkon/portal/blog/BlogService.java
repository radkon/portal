package org.radkon.portal.blog;

import javax.ejb.NoSuchEntityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogService {

    final Map<String, Blog> blogStore = new HashMap<>();

    public Blog create(Blog blog) {
        blogStore.put(blog.getId(), blog);
        return blog;
    }

    public Blog readById(String uuid) {
        final Blog blog = blogStore.get(uuid);
        if (blog == null) {
            throw new NoSuchEntityException("Blog for UUID " + uuid + " was not found.");
        }
        return blog;
    }

    public Blog update(Blog blog) {
        final Blog existingBlog = readById(blog.getId());
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setOwner(blog.getOwner());
        return existingBlog;
    }

    public void delete(Blog blog) {
        blogStore.remove(blog.getId());
    }

    public List<Blog> readAll() {
        return new ArrayList<>(blogStore.values());
    }
}

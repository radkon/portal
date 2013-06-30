package org.radkon.portal.blog;

import org.radkon.portal.persistence.PersistentObject;

import java.util.Date;

public class BlogPost extends PersistentObject {

    private static final long serialVersionUID = 6757917532187198315L;

    private Blog blog;

    private String caption;

    private String content;

    private Date creationDate;

    private BlogPost() {
        // ok
    }

    public BlogPost(Blog blog, String caption, String content, Date creationDate) {
        setCaption(caption);
        setContent(content);
        setCreationDate(creationDate);
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

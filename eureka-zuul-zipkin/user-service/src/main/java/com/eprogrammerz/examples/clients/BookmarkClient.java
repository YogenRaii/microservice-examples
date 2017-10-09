package com.eprogrammerz.examples.clients;

import com.eprogrammerz.examples.clients.impl.BookmarkClientImpl;
import com.eprogrammerz.examples.models.Bookmark;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Yogen on 9/26/2017.
 */
@FeignClient(name = "bookmark-service", fallback = BookmarkClientImpl.class)
public interface BookmarkClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/bookmarks")
    List<Bookmark> getBookmarks(@PathVariable("userId") String userId);
}

package com.pillarglobal.sitemap.news.manager.api.controllers;

import com.pillarglobal.sitemap.news.manager.api.models.Image;
import com.pillarglobal.sitemap.news.manager.api.models.News;
import com.pillarglobal.sitemap.news.manager.api.models.Publication;
import com.pillarglobal.sitemap.news.manager.api.models.Url;
import com.pillarglobal.sitemap.news.manager.api.services.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ArticleService articleService;

    @Test
    public void testGetArticleEndpoint() throws Exception{
        String loc = "string";
        Url article = new Url("string", "string", "string", "string", new News(new Publication(1L, "string", "string"), "string", "string", "string"), Arrays.asList(new Image(1L, "string", "string"), new Image(2L, "string", "string")));
        when(articleService.getArticle(any())).thenReturn(article);
        mockMvc.perform(get("/getArticle").param("loc", loc)).andExpect(status().isOk()).andExpect(content().string(containsString("{\"loc\":\"string\",\"lastmod\":\"string\",\"changefreq\":\"string\",\"priority\":\"string\",\"news\":{\"publication\":{\"name\":\"string\",\"language\":\"string\"},\"publicationDate\":\"string\",\"title\":\"string\",\"keywords\":\"string\"},\"images\":[{\"loc\":\"string\",\"caption\":\"string\"},{\"loc\":\"string\",\"caption\":\"string\"}]}")));

    }

    @Test
    public void testAddArticleEndpoint() throws Exception{
        Url article = new Url("string", "string", "string", "string", new News(new Publication(null, "string", "string"), "string", "string", "string"), Arrays.asList(new Image(null, "string", "string")));
        mockMvc.perform(post("/addArticle").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "  \"loc\": \"string\",\n" +
                "  \"lastmod\": \"string\",\n" +
                "  \"changefreq\": \"string\",\n" +
                "  \"priority\": \"string\",\n" +
                "  \"news\": {\n" +
                "    \"publication\": {\n" +
                "      \"name\": \"string\",\n" +
                "      \"language\": \"string\"\n" +
                "    },\n" +
                "    \"publicationDate\": \"string\",\n" +
                "    \"title\": \"string\",\n" +
                "    \"keywords\": \"string\"\n" +
                "  },\n" +
                "  \"images\": [\n" +
                "    {\n" +
                "      \"loc\": \"string\",\n" +
                "      \"caption\": \"string\"\n" +
                "    }\n" +
                "  ]\n" +
                "}")).andExpect(status().isOk());
        verify(articleService, times(1)).addArticle(article);
    }

    @Test
    public void testUpdateArticleEndpoint() throws Exception{
        Url article = new Url("string", "string", "string", "string", new News(new Publication(null, "string", "string"), "string", "string", "string"), Arrays.asList(new Image(null, "string", "string")));
        mockMvc.perform(put("/updateArticle").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "  \"loc\": \"string\",\n" +
                "  \"lastmod\": \"string\",\n" +
                "  \"changefreq\": \"string\",\n" +
                "  \"priority\": \"string\",\n" +
                "  \"news\": {\n" +
                "    \"publication\": {\n" +
                "      \"name\": \"string\",\n" +
                "      \"language\": \"string\"\n" +
                "    },\n" +
                "    \"publicationDate\": \"string\",\n" +
                "    \"title\": \"string\",\n" +
                "    \"keywords\": \"string\"\n" +
                "  },\n" +
                "  \"images\": [\n" +
                "    {\n" +
                "      \"loc\": \"string\",\n" +
                "      \"caption\": \"string\"\n" +
                "    }\n" +
                "  ]\n" +
                "}")).andExpect(status().isOk());
        verify(articleService, times(1)).updateArticle(article);
    }

    @Test
    public void testDeleteArticleEndpoint() throws Exception{
        Url article = new Url("string", "string", "string", "string", new News(new Publication(1L, "string", "string"), "string", "string", "string"), Arrays.asList(new Image(1L, "string", "string"), new Image(2L, "string", "string")));
        String loc = article.getLoc();
        mockMvc.perform(delete("/deleteArticle").contentType(MediaType.APPLICATION_JSON).content(loc)).andExpect(status().isOk());
        verify(articleService, times(1)).deleteArticle(loc);
    }

    @Test
    public void testGetSitemapNewsEndpoint() throws Exception{
        List<Url> urlList = Arrays.asList(new Url("string", "string", "string", "string", new News(new Publication(1L, "string", "string"), "string", "string", "string"), Arrays.asList(new Image(1L, "string", "string"), new Image(2L, "string", "string"))));
        when(articleService.getSitemapNews()).thenReturn(urlList);
        mockMvc.perform(get("/getSitemapNews")).andExpect(content().string(containsString("[{\"loc\":\"string\",\"lastmod\":\"string\",\"changefreq\":\"string\",\"priority\":\"string\",\"news\":{\"publication\":{\"name\":\"string\",\"language\":\"string\"},\"publicationDate\":\"string\",\"title\":\"string\",\"keywords\":\"string\"},\"images\":[{\"loc\":\"string\",\"caption\":\"string\"},{\"loc\":\"string\",\"caption\":\"string\"}]}]")));
    }

    @Test
    public void testTriggerSitemapNewsMappingEndpoint() throws Exception{
        mockMvc.perform(post("/triggerSitemapNewsMapping")).andExpect(content().string(containsString("Sitemap news mapping has been started."))).andExpect(status().isOk());
        verify(articleService, times(1)).startSitemapNewsMapping();
    }

}

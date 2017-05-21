package com.weixin.media;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.weixin.common.WeiXinContext;

public class MediaKit {
    public static void postMedia(String path, String type) {
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;

        try {
            client = HttpClients.createDefault();

            String url = WeiXinContext.MEDIA_URL;
            url = url.replace("ACCESS_TOKEN", "B-or98cUUnkquWtevhcMJPSzqv2LqwuP-RQzvQ1zAboe5cDlEQW-Yk5ggoWAAd9464pt4vOssdFjeBzQTwJqmnjD9EK65Zh_NEe7jSVsB2tJLU2AJ3OBb-H04D-AuS9mVYIjABADGQ").replace("TYPE", type);
            HttpPost post = new HttpPost(url);
            FileBody fileBody = new FileBody(new File(path));
            HttpEntity entity = MultipartEntityBuilder.create().addPart("media", fileBody).build();
            post.setEntity(entity);
            resp = client.execute(post);
            int sc = resp.getStatusLine().getStatusCode();
            if (sc >= 200 && sc < 300) {
                String json = EntityUtils.toString(resp.getEntity());
                System.out.println(json);
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (client != null)
                    client.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (resp != null)
                    resp.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

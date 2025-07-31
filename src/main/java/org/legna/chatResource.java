package org.legna;

import java.io.IOException;

import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/ia")
public class chatResource {
    @Inject
    Template chat;

    @Inject
    iaService iaService;

    @GET
    @Path("/chat")
    @Produces(MediaType.TEXT_HTML)
    public String getChatPage() {
        return chat.render();
    }

    @POST
    @Path("/chat")
    @Produces(MediaType.TEXT_PLAIN)
    public String chat(@QueryParam("message") String message) {
        return iaService.processMessage(message);
    }

    @POST
    @Path("/knowledge")
    public void addKnowledge(@QueryParam("text") String text) throws IOException {
        iaService.addToKnowledgeBase(text);
    }
}

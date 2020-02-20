package com.aal;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.jupiter.api.Test;

public class TestServlets {
    @Test
    public void run() throws Exception {
        BasicConfigurator.configure(); // todo configure log4j and add log4j.properties
        final Server server = new Server();
        final ServerConnector c = new ServerConnector(server);
        c.setIdleTimeout(30000);
        c.setAcceptQueueSize(10);
        c.setPort(8081);
        c.setHost("localhost");
        final String root = TestServlets.class.getClassLoader().getResource(".").toString();
        final WebAppContext webapp = new WebAppContext(root + "../../src/main/webapp", "/");
        server.setHandler(webapp);
        server.addConnector(c);
        server.start();
        server.join();
    }
}

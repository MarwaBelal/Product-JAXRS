package org.eclipse.jakarta.hello;

import jakarta.ejb.Singleton;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("rest")
@Singleton
public class HelloApplication extends Application {

}

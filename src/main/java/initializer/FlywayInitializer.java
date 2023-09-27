package initializer;

import org.flywaydb.core.Flyway;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class FlywayInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialize Flyway
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5455/mock" , "user", "pass").baselineOnMigrate(true).load();
        
        // Start the migration
        flyway.migrate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup or perform actions when the application is shut down.
    }
}

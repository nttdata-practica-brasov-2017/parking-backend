package ro.nttdata.bv.parking;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ro.nttdata.bv.parking.security.WebSecurityConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebSecurityConfig.class, AppConfig.class, WebAppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }
}

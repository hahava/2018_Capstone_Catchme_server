package capstone.sejong.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        loadOpenCVLib();
    }

    public void loadOpenCVLib() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

}

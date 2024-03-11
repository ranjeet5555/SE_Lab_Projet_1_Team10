package com.cfp;

import com.cfp.controller.DocumentController;
import com.cfp.entity.FileEntity;
import com.cfp.repository.FileRepository;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DocumentControllerTest {

    @Mock
    private FileRepository fileRepository;

    @Mock
    private Model model;

    @Mock
    private HttpSession session;

    @InjectMocks
    private DocumentController documentController;

    @Test
    public void testUploadPage() {
        // Setup
        FileEntity file = new FileEntity();
        when(model.addAttribute(any(String.class), any())).thenReturn(model);

        // Execute
        Object result = documentController.UploadPage(model);

        // Verify
        assertEquals("uploadedDoc", ((ModelAndView) result).getViewName());
    }

    @Test
    public void testUploadedPaper() {
        // Setup
        FileEntity file = new FileEntity();
        when(fileRepository.save(file)).thenReturn(file);
        ModelAndView expectedModelAndView = new ModelAndView("redirect:/dashboard");

        // Execute
        ModelAndView result = documentController.UploadedPaper(file, session);

        // Verify
        assertEquals(expectedModelAndView.getViewName(), result.getViewName());
    }
}

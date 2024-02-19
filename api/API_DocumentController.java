package com.cfp.controller;

import com.cfp.entity.Document;
import com.cfp.repository.DocumentRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


/**
 * Controller class for handling document-related operations.
 */
public class DocumentController {

    @Autowired
    private DocumentRepository repo;

    /**
     * Retrieves a list of uploaded documents and adds them to the model.
     *
     * @param model Model for adding attributes to the view.
     * @return The name of the home view template.
     */
    @GetMapping("/myUploads")
    public String uploadDocument(@NotNull Model model) {
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs", listDocs);
        return "home";
    }

    /**
     * Handles file uploads, saves the document to the database, and adds a flash attribute for a success message.
     *
     * @param multipartFile The uploaded file (MultipartFile).
     * @param ra            RedirectAttributes for adding flash attributes.
     * @return Redirects to the home page.
     * @throws IOException If an I/O error occurs.
     */
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("document") @NotNull MultipartFile multipartFile,
                             @NotNull RedirectAttributes ra) throws IOException {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        Document document = new Document();
        document.setName(filename);
        document.setContent(multipartFile.getBytes());
        document.setSize(multipartFile.getSize());
        repo.save(document);
        ra.addFlashAttribute("message", "The file has been uploaded successfully");
        return "redirect:/";
    }

    /**
     * Downloads a specific document by ID.
     *
     * @param id       Document ID (Path Variable).
     * @param response HttpServletResponse for handling the response.
     * @throws Exception If the document with the given ID is not found.
     */
    public void downloadFile(@Param("id") Long id, HttpServletResponse response) throws Exception {
        Optional<Document> result = repo.findById(id);
        if (result.isEmpty()) {
            throw new Exception("Could not find document with ID: " + id);
        }
        Document document = result.get();
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=" + document.getName();
        response.setHeader(headerKey, headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(document.getContent());
        outputStream.close();
    }
}

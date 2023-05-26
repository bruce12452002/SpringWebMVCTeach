package home.bruce.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RequestMapping("lesson3")
@Controller
public class L3Controller {
    @PostMapping("/upload")
    public String u1(@RequestBody MultipartFile file) throws IOException {
        System.out.println(file);

        try (InputStream in = file.getInputStream();
             OutputStream out = new FileOutputStream("/Users/bruce/" + file.getOriginalFilename())
        ) {
            IOUtils.copy(in, out);
            System.out.println("finish");
        }
        return "/index.jsp";
    }

}
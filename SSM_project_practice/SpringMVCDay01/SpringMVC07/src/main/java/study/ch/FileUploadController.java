package study.ch;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-02-16-17:47
 */
@Controller
public class FileUploadController {
    /**
     * 处理文件上传
     * @RequestParam(value = "username",required = false) String username
     * 获取请求参数为username，默认可以不带
     * @param model
     * @return
     */
    @RequestMapping("/upload")
    public String upload(
            @RequestParam(value = "username",required = false) String username,
            //如果要上传多个，将MultipartFile改为数组类型就行
            @RequestParam("headerIMG") MultipartFile file,
            Model model){
        System.out.println("上传的文件信息");
        System.out.println("文件项的name"+file.getName());
        System.out.println("文件的名字"+file.getOriginalFilename());

        //文件保存
        try {
            file.transferTo(new File("F:\\java\\"+file.getOriginalFilename()));
            model.addAttribute("msg","文件上传成功了！");
        } catch (Exception e) {
            model.addAttribute("msg","文件上传失败了！"+e.getMessage());
        }
        return "forward:/index.jsp";
    }
}

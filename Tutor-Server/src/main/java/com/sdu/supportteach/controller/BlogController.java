package com.sdu.supportteach.controller;
import com.sdu.supportteach.entity.Blog;
import com.sdu.supportteach.request.BIDRequest;
import com.sdu.supportteach.request.UIDRequest;
import com.sdu.supportteach.service.BlogService;
import com.sdu.supportteach.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzyu
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/api/blog")
public class BlogController {


    @Autowired
    BlogService blogService;

    @PostMapping("/briefInf")
    public Result getBriefInformation(@Validated @RequestBody UIDRequest user){
        System.out.println("User id:" + user.getUserId());
        return Result.success(blogService.getByUserId(user.getUserId()));
    }

    @GetMapping("/get")
    public Result detail(@RequestParam(name = "id") Long id) {
        System.out.println("Blog Id" + id);
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");
        //blog.setUsername(user.getUsername());
        return Result.success(blog);
    }

    @PostMapping("/pget")
    public Result postGet(@Validated @RequestBody BIDRequest bidRequest) {
        System.out.println("P_Blog Id" + bidRequest.getBlogId());
        Blog blog = blogService.getById(bidRequest.getBlogId());
        Assert.notNull(blog, "该博客已被删除");
        //blog.setUsername(user.getUsername());
        return Result.success(blog);
    }


    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Blog blogSERequest) {
        Blog temp = null;
        if(blogSERequest.getId() != null) {
            temp = blogService.getById(blogSERequest.getId());
            if (temp.getUserId()!=blogSERequest.getUserId()){
                return Result.fail("Can only edit your own blog!");
            }
        } else {
            temp = new Blog();
            temp.setUserId(blogSERequest.getUserId());
            temp.setCreated(LocalDateTime.now());
        }
        temp.setContent(blogSERequest.getContent());
        temp.setDescription(blogSERequest.getDescription());
        temp.setTitle(blogSERequest.getTitle());
        temp.setCtype(blogSERequest.getCtype());
        blogService.saveOrUpdate(temp);
        return Result.success("成功保存");
    }
    @PostMapping("/delete")
    public Result delete(@Validated @RequestBody BIDRequest bidRequest){
        Blog blog = blogService.getById(bidRequest.getBlogId());
        System.out.println("删除文章");
        if(blog.getUserId() != bidRequest.getUserId()){
            return Result.fail("不能删除他人博客！");
        }
        blogService.removeById(bidRequest.getBlogId());
        return Result.success("成功删除");
    }

    @GetMapping("/getType")
    public Result getType0(@RequestParam("type") int type){
        System.out.println("获取类型"+type+"文章");
        List<Blog> blogList =  blogService.getByType(type);
        blogList.sort(new Comparator<Blog>() {
            @Override
            public int compare(Blog o1, Blog o2) {
                return (o2.getId() - o1.getId());
            }
        });
        return Result.success(blogList);
    }
}